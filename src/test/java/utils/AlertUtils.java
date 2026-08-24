package utils;

import driver.DriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AlertUtils {

    private static final int DEFAULT_TIMEOUT = 10;

    private Alert waitForAlert() {
        return new WebDriverWait(
                DriverManager.getDriver(),
                Duration.ofSeconds(DEFAULT_TIMEOUT)
        ).until(ExpectedConditions.alertIsPresent());
    }

    // ---------- ALERT ACTIONS ----------

    public void acceptAlert() {
        waitForAlert().accept();
    }

    public void dismissAlert() {
        waitForAlert().dismiss();
    }

    public String getAlertText() {
        return waitForAlert().getText();
    }

    public void sendKeysToAlert(String text) {
        Alert alert = waitForAlert();
        alert.sendKeys(text);
        alert.accept();
    }

    public boolean isAlertPresent() {
        try {
            waitForAlert();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
