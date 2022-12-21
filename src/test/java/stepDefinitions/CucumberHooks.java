package stepDefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.utils.SeleniumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class CucumberHooks {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @Before
    public void before(Scenario scenario) {
        log.info("Started executing scenario :: " + scenario.getName());
    }

    @After
    public void after(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            TakesScreenshot scrShot = ((TakesScreenshot) SeleniumUtils.getDriver());
            //Call getScreenshotAs method to create image file
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            //Move image file to new destination
            String PROJECT_HOME = System.getProperty("user.dir");
            File destFile = new File(PROJECT_HOME + File.separator
                    + "FailedScreenshots" + File.separator + scenario.getName() + ".png");
            //Copy file at destination
            FileUtils.copyFile(srcFile, destFile);
        }
    }
}
