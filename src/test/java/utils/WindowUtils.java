package utils;

import driver.DriverManager;

import java.util.Iterator;
import java.util.Set;

public class WindowUtils {

    //Switch to window by exact title
    public void switchToWindowByTitle(String expectedTitle) {
        String currentWindow = DriverManager.getDriver().getWindowHandle();
        Set<String> windows = DriverManager.getDriver().getWindowHandles();

        for (String window : windows) {
            DriverManager.getDriver().switchTo().window(window);
            if (DriverManager.getDriver().getTitle().equals(expectedTitle)) {
                return;
            }
        }

        // Switch back if not found
        DriverManager.getDriver().switchTo().window(currentWindow);
        throw new RuntimeException("Window with title not found: " + expectedTitle);
    }

    //Switch to the newest (latest opened) window/tab
    public void switchToNewWindow() {
        Set<String> windows = DriverManager.getDriver().getWindowHandles();

        if (windows.size() < 2) {
            throw new RuntimeException("No new window found to switch");
        }

        Iterator<String> iterator = windows.iterator();
        String lastWindow = null;

        while (iterator.hasNext()) {
            lastWindow = iterator.next();
        }

        DriverManager.getDriver().switchTo().window(lastWindow);
    }

    //Switch back to parent window
    public void switchToParentWindow() {
        String parent = DriverManager.getDriver().getWindowHandles().iterator().next();
        DriverManager.getDriver().switchTo().window(parent);
    }

    //Get all window handles
    public Set<String> getAllWindowHandles() {
        return DriverManager.getDriver().getWindowHandles();
    }

    //Get current window handle
    public String getCurrentWindowHandle() {
        return DriverManager.getDriver().getWindowHandle();
    }
}
