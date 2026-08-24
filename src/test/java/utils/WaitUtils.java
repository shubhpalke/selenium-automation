package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int DEFAULT_TIMEOUT = 30;

    private WaitUtils() {}

    private static WebDriverWait waits() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        );
    }

    public static WebElement waitForVisible(By locator) {
        return waits().until(
                ExpectedConditions.visibilityOfElementLocated(locator)
        );
    }

    public static WebElement waitForClickable(By locator) {
        return waits().until(
                ExpectedConditions.elementToBeClickable(locator)
        );
    }

    public static WebElement waitForPresence(By locator) {
        return waits().until(
                ExpectedConditions.presenceOfElementLocated(locator)
        );
    }

    public static boolean waitForInvisibility(By locator) {
        return waits().until(
                ExpectedConditions.invisibilityOfElementLocated(locator)
        );
    }
}
