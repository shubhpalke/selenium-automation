package reporter;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.Assert;
import utils.Screenshotutils;

public class Reporter {

    private Reporter() {}

    /* ---------- INFO ---------- */

    public static void info(String step) {
        logInfo(step, false);
    }

    public static void info(String step, boolean screenshot) {
        logInfo(step, screenshot);
    }

    private static void logInfo(String step, boolean screenshot) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) return;

        if (screenshot) {
            String path = Screenshotutils.takeScreenshot(step);
            test.info(step,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build());
        } else {
            test.info(step);
        }
    }

    /* ---------- VERIFY EQUALS ---------- */

    public static void verify(Object actual,
                              Object expected,
                              String step) {
        verify(actual, expected, step, false);
    }

    public static void verify(Object actual,
                              Object expected,
                              String step,
                              boolean screenshot) {

        ExtentTest test = ExtentTestManager.getTest();

        try {
            Assert.assertEquals(actual, expected);
            logPass(step, screenshot);

        } catch (AssertionError e) {
            logFail(step, screenshot);
            throw e;
        }
    }

    /* ---------- VERIFY TRUE ---------- */

    public static void verifyTrue(boolean condition, String step) {
        verifyTrue(condition, step, false);
    }

    public static void verifyTrue(boolean condition,
                                  String step,
                                  boolean screenshot) {

        ExtentTest test = ExtentTestManager.getTest();

        try {
            Assert.assertTrue(condition);
            logPass(step, screenshot);

        } catch (AssertionError e) {
            logFail(step, screenshot);
            throw e;
        }
    }

    /* ---------- INTERNAL HELPERS ---------- */

    private static void logPass(String step, boolean screenshot) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) return;

        if (screenshot) {
            String path = Screenshotutils.takeScreenshot(step);
            test.pass(step,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build());
        } else {
            test.pass(step);
        }
    }

    private static void logFail(String step, boolean screenshot) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test == null) return;

        if (screenshot) {
            String path = Screenshotutils.takeScreenshot(step);
            test.fail(step,
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(path)
                            .build());
        } else {
            test.fail(step);
        }
    }
}
