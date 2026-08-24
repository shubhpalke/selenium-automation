package base;

import driver.DriverFactory;
import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utils.ConfigReader;

//Test
public class BaseTest1 {

	@Parameters("browser")
	@BeforeMethod(alwaysRun = true)
	public void setUp(@Optional("chrome") String browser) {

		String browserName = System.getProperty("browser",
				(browser != null && !browser.isEmpty()) ? browser : ConfigReader.get("browser"));

		WebDriver driver = DriverFactory.createDriver(browser);
		DriverManager.setDriver(driver);
		driver.get(ConfigReader.get("baseurl"));
	}

	@AfterMethod(alwaysRun = true)
	public void tearDown() {

		WebDriver driver = DriverManager.getDriver();
		if (driver != null) {
			driver.quit();
			DriverManager.removeDriver();
		}
	}
}
