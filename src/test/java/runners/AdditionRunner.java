package runners;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/Addition.feature",glue = {"stepDefinitions"})
public class AdditionRunner extends AbstractTestNGCucumberTests {

}

