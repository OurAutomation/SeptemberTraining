package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.selenium.utils.EnvironmentUtils;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

@CucumberOptions(features = "src/test/resources/features/Login_Sanity", glue = {"stepDefinitions"},
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        tags = ("@Smoke"),
dryRun = false,monochrome = true)
//dryrun to compile and check if there are any un-implemented steps
//monochrome it is used for printing more detailed output in console
public class SmokeRunner extends AbstractTestNGCucumberTests {
    
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

