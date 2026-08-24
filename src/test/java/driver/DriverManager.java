package driver;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
    private DriverManager(){}

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static void setDriver(WebDriver driverInstance){
        driver.set(driverInstance);
    }

    public static WebDriver getDriver(){
        return driver.get();
    }

    public static void removeDriver(){
        driver.remove();
    }

}
