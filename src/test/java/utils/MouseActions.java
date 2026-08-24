package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static utils.WaitUtils.*;

public class MouseActions {

    private Actions actions() {
        WebDriver driver = DriverManager.getDriver();
        return new Actions(driver);
    }

    // ---------- MOUSE ACTIONS ----------

    public void hover(By locator) {
        actions().moveToElement(waitForVisible(locator)).perform();
    }

    public void doubleClick(By locator) {
        actions().doubleClick(waitForClickable(locator)).perform();
    }

    public void rightClick(By locator) {
        actions().contextClick(waitForClickable(locator)).perform();
    }

    public void clickAndHold(By locator) {
        actions().clickAndHold(waitForVisible(locator)).perform();
    }

    public void release(By locator) {
        actions().release(waitForVisible(locator)).perform();
    }

    public void dragAndDrop(By source, By target) {
        WebElement src = waitForVisible(source);
        WebElement tgt = waitForVisible(target);
        actions().dragAndDrop(src, tgt).perform();
    }

    // ---------- KEYBOARD ACTIONS ----------

    public void sendKeys(Keys key) {
        actions().sendKeys(key).perform();
    }

    public void sendKeys(By locator, Keys key) {
        actions().sendKeys(waitForVisible(locator), key).perform();
    }

    public void sendKeys(By locator, String text) {
        actions().sendKeys(waitForVisible(locator), text).perform();
    }
}
