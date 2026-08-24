package utils;

import driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Screenshotutils {

    private Screenshotutils() {

    }

    public static String takeScreenshot(String testName){

        String screenshotDir = ExecutionContext.getReportBasePath() + "/screenshots";

        if(DriverManager.getDriver() == null){

            System.out.println(" driver is null, screenshot skipped.");
            return null;
        }

        TakesScreenshot ts = (TakesScreenshot) DriverManager.getDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);

        String fileName = testName + "_" + System.currentTimeMillis() + ".png";

        File destination = new File(screenshotDir, fileName);

        try {
            Files.createDirectories(destination.getParentFile().toPath());
            Files.copy(source.toPath(), destination.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Failed to capture screenshot", e);
        }

        // return RELATIVE path
        return "screenshots/" + fileName;
    }

}
