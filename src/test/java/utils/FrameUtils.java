package utils;

import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static utils.WaitUtils.*;

public class FrameUtils {

    //Switch to frame using locator
    public void switchToFrame(By locator) {
        WebElement frame =
                waitForPresence(locator);
        DriverManager.getDriver()
                .switchTo()
                .frame(frame);
    }

    //Switch to frame using index
    public void switchToFrame(int index) {
        DriverManager.getDriver()
                .switchTo()
                .frame(index);
    }

  //Switch to frame using name or id
    public void switchToFrame(String nameOrId) {
        DriverManager.getDriver()
                .switchTo()
                .frame(nameOrId);
    }

    //Switch to parent frame
    public void switchToParentFrame() {
        DriverManager.getDriver()
                .switchTo()
                .parentFrame();
    }

    //Switch to main page (out of all frames)
    public void switchToDefaultContent() {
        DriverManager.getDriver()
                .switchTo()
                .defaultContent();
    }

   //Check if currently inside a frame
    public boolean isInsideFrame() {
        WebDriver driver = DriverManager.getDriver();
        try {
            driver.switchTo().parentFrame();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
