package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import static utils.WaitUtils.*;

public class JSUtils {

    private JavascriptExecutor js() {
        return (JavascriptExecutor) DriverManager.getDriver();
    }

// ---------- CLICK & TYPE ----------

    public void jsClick(By locator) {
        WebElement element = waitForClickable(locator);
        js().executeScript("arguments[0].click();", element);
    }

    public void jsType(By locator, String text) {
        WebElement element = waitForVisible(locator);
        js().executeScript("arguments[0].value='';", element);
        js().executeScript("arguments[0].value=arguments[1];", element, text);
    }

    // ---------- SCROLLING ----------

    public void scrollIntoView(By locator) {
        WebElement element = waitForPresence(locator);
        js().executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void scrollToTop() {
        js().executeScript("window.scrollTo(0,0);");
    }

    public void scrollToBottom() {
        js().executeScript("window.scrollTo(0, document.body.scrollHeight);");
    }

    public void scrollBy(int x, int y) {
        js().executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    // ---------- UTILITY ----------

    public String getPageTitle() {
        return (String) js().executeScript("return document.title;");
    }

    public String getPageUrl() {
        return (String) js().executeScript("return document.URL;");
    }

    public void highlightElement(By locator) {
        WebElement element = waitForPresence(locator);
        js().executeScript(
                "arguments[0].style.border='3px solid red'", element
        );
    }
}
