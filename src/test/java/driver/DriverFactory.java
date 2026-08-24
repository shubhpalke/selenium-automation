package driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utils.ConfigReader;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private DriverFactory(){}

    public static WebDriver createDriver(String browser){

        WebDriver driver = null;
        switch (browser.toLowerCase()){
            case "chrome":
                driver = createChromeDriver();
                break;
            case "firefox":
                driver = createFirefoxDriver();
                break;
            case "edge":
                driver = createEdgeDriver();
                        break;

            default:
                System.out.println("Browser is not valid..!!");

        }
        driver.manage().deleteAllCookies();
//        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver createChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);

        boolean isHeadless = ConfigReader.getBoolean("headless", true);

        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
        } else {
            options.addArguments("--start-maximized");
        }

        options.addArguments("--disable-notifications");
        options.addArguments("--disable-geolocation");
        options.addArguments("--disable-infobars");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("profile.default_content_setting_values.geolocation", 2);
        prefs.put("profile.default_content_setting_values.media_stream_camera", 2);
        prefs.put("profile.default_content_setting_values.media_stream_mic", 2);

        options.setExperimentalOption("prefs", prefs);

        return new ChromeDriver(options);
    }

    private static WebDriver createFirefoxDriver() {

        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        boolean isHeadless = ConfigReader.getBoolean("headless", true);

        if (isHeadless) {
            options.addArguments("-headless");
            options.addArguments("--width=1920");
            options.addArguments("--height=1080");
        }else {
            options.addArguments("--start-maximized");
        }

        options.addPreference("dom.webnotifications.enabled", false);
        options.addPreference("media.navigator.permission.disabled", true);
        options.addPreference("geo.enabled", false);

        WebDriver driver = new FirefoxDriver(options);

        if (!isHeadless)
            driver.manage().window().maximize();

        return driver;
    }

    private static WebDriver createEdgeDriver() {

        EdgeOptions options = new EdgeOptions();
        options.setAcceptInsecureCerts(true);

        boolean isHeadless = ConfigReader.getBoolean("headless", true);
        if (isHeadless) {
            options.addArguments("--headless=new");
            options.addArguments("--window-size=1920,1080");
        }

        options.addArguments("--disable-notifications");
        return new EdgeDriver(options);
    }
}
