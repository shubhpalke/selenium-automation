package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    private static Properties properties = new Properties();

    private ConfigReader(){}

    static {
        loadProperties();
    }

    private static void loadProperties(){
        try{
            //load config
            FileInputStream baseConfig = new FileInputStream("src/test/resources/configs/config.properties");
            properties.load(baseConfig);

            //decide environment
//            String env = System.getProperty("env",properties.getProperty("env"));
            String env = null;
              if (System.getProperty("env") != null){
                  env = System.getProperty("env");
              }
              else {
                  env = properties.getProperty("env");
              }
            if (env == null) {
                throw new RuntimeException("Environment not specified in config or command line");
            }

            //load env specific config
            FileInputStream envConfig = new FileInputStream("src/test/resources/configs/" + env + ".properties");
            properties.load(envConfig);

        } catch (FileNotFoundException e) {
            throw new RuntimeException("Config file doesn't exist",e);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load configuration files",e);
        }
    }

    public static String get(String key){
        String value = System.getProperty(key, properties.getProperty(key));

        if (value == null){
            throw new RuntimeException("Key not found in config file : " + key);
        }
        return value;
    }

    public static boolean getBoolean(String key, boolean defaultValue) {

        //Command-line override
        if (System.getProperty(key) != null) {
            return Boolean.parseBoolean(System.getProperty(key));
        }

        //Config file value
        String value = properties.getProperty(key);
        if (value != null) {
            return Boolean.parseBoolean(value);
        }

        //Default
        return defaultValue;
    }
}
