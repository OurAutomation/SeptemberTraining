package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.selenium.utils.EnvironmentUtils;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.annotations.*;

@CucumberOptions(features = "src/test/resources/features/Login_Sanity", glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = ("@Sanity"),
dryRun = false,monochrome = true)
//dryrun to compile and check if there are any un-implemented steps
//monochrome it is used for printing more detailed output in console
public class SanityRunner extends AbstractTestNGCucumberTests {
    
    @BeforeSuite(alwaysRun = true)
    @Parameters(value = {"environment", "browser"})
    public void beforeSuite(@Optional("QA") String environment, @Optional("chrome") String browser) {
        ObjectRepositoryUtils.loadProperties(environment);
        TestDataUtils.loadTestData(environment);
        EnvironmentUtils.loadEnvironmentData(environment);
        SeleniumUtils.launchDriver(browser);
    }

    @AfterSuite(alwaysRun = true)
    public void shutDown() {
      SeleniumUtils.closeDriver();
    }

}

