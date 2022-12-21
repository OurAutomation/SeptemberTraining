package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.SeleniumUtils;
import org.testng.Assert;

public class LoginStepDefinitions extends SeleniumUtils {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @Given("^user loads the application$")
    public void user_loads_the_application() {
        loadApplication();
    }

    @When("user login with username {string} and password {string}")
    public void user_login_with_given_credentials(String username, String password) {
        loginPage.loginToTheApplication(username,password);
    }

    @Then("^user should be logged in$")
    public void user_should_be_logged_in() {
        Assert.assertTrue(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
    }

    @Then("^user should not be logged in$")
    public void user_should_not_be_logged_in() {
        Assert.assertFalse(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
    }
    @Then("^user should be able to see products logo$")
    public void user_should_be_able_to_see_products_logo() {
        Assert.assertTrue(dashboardPage.isProductLogoDisplayed(), "The product logo is not displayed");
    }
    @Then("^user should be able to see checkout button$")
    public void user_should_be_able_to_see_checkout_button() {
        Assert.assertTrue(dashboardPage.isCheckoutIconDisplayed(), "The checkout button is not displayed");
    }

    @Then("error message should be displayed as {string}")
    public void user_login_with_given_credentials(String errorMessage) {
        String errorText = loginPage.getTheErrorMessage();
        Assert.assertEquals(errorText, errorMessage, "The error message is not matching");
    }
}
