package testCases;

import dataProvider.DataProviderUtils;
import driver.DriverManager;
import listeners.RetryAnalyzer;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest1;
import reporter.Reporter;

import java.util.Map;

public class RegressionTest extends BaseTest1 {

	@Test(description = "Regression test", dataProvider = "testData", dataProviderClass = DataProviderUtils.class)
	public void sampleRegressionTest(Map<String, String> data) throws InterruptedException {

		String testDescription = data.get("TestDescription");
		String title = data.get("Title");

		WebDriver driver = DriverManager.getDriver();
		Thread.sleep(5000);
		Reporter.info("Regression test started");
		driver.get("https://www.google.com/");
		Reporter.info("Test title is : " + title);
//        Assert.assertEquals("123","234");

	}
}
