package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static utils.WaitUtils.*;


public class ElementActions {

    // ---------- BASIC ACTIONS ----------

    public void click(By locator) {
        waitForClickable(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = waitForVisible(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void clear(By locator) {
        waitForVisible(locator).clear();
    }

    public String getText(By locator) {
        return waitForVisible(locator).getText();
    }

    public String getAttribute(By locator, String attribute) {
        return waitForPresence(locator).getAttribute(attribute);
    }

    public boolean isDisplayed(By locator) {
        try {
            return waitForVisible(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isEnabled(By locator) {
        return waitForPresence(locator).isEnabled();
    }

    public boolean isSelected(By locator) {
        return waitForPresence(locator).isSelected();
    }


}
