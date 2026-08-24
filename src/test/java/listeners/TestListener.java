package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import reporter.ExtentManager;
import reporter.ExtentTestManager;
import reporter.Reporter;
import utils.Screenshotutils;

import java.io.File;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = ExtentManager.getInstance()
                .createTest(
                        result.getMethod().getMethodName(),
                        result.getMethod().getDescription()
                );
        ExtentTestManager.setTest(test);
        Reporter.info("Test execution started");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTest test = ExtentTestManager.getTest();
        if (test != null) {
            test.pass("Test passed successfully");
        }
        ExtentTestManager.unload();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        ExtentTest test = ExtentTestManager.getTest();

        try {
            String path = Screenshotutils.takeScreenshot(
                    result.getMethod().getMethodName());

            if (test != null) {
                test.fail(result.getThrowable(),
                        MediaEntityBuilder
                                .createScreenCaptureFromPath(path)
                                .build());
            }
        } finally {
            ExtentTestManager.unload();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest()
                .skip("Test skipped");
        ExtentTestManager.unload();
    }

    @Override
    public void onFinish(ITestContext context) {
        ExtentManager.flushReports();
    }
}
