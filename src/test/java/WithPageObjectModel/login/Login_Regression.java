package WithPageObjectModel.login;

import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.Base;
import org.selenium.utils.DataProvidersUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Regression extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    @BeforeTest
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        log.info("Loading the application");
        loadApplication();
    }

    @Test(priority = 0, description = "Here i am going to validate placeholders of all the fields")
    public void validateAllThePlaceHolders() {
        log.info("******************** Started testing validate all placeholders ********************");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getUsernameInputBoxPlaceHolder(), "Username", "Placeholder is not matching");
        softAssert.assertEquals(loginPage.getPasswordInputBoxPlaceHolder(), "Password", "Placeholder is not matching");
        softAssert.assertEquals(loginPage.getTextDisplayedOnTheSubmitButton(), "Login", "Button text is not matching");
        softAssert.assertAll();
        log.info("******************** completed testing validate all placeholders ********************");
    }

    @Test(priority = 1, description = "I am validating if the password is getting masked or not")
    public void validateIfThePasswordIsGettingMasked() {
        log.info("******************** Started testing is password getting masked ********************");
        Assert.assertTrue(loginPage.isPasswordGettingMasked(), "Password is not getting masked");
        log.info("******************** Completed testing is password getting masked ********************");
    }

    @Test(priority = 2, dataProvider = "validUsernames", dataProviderClass = DataProvidersUtils.class, description = "I am validating login functionality for all valid usernames")
    public void validateLoginForValidData(String username, String password) throws InterruptedException {
        log.info("******************** Started testing validate login for valid data. username :: " + username + " and password :: " + password + " ********************");
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToTheApplication(username, password);
        softAssert.assertTrue(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
        softAssert.assertTrue(dashboardPage.isProductLogoDisplayed(), "The product logo is not displayed");
        softAssert.assertTrue(dashboardPage.isCheckoutIconDisplayed(), "The checkout button is not displayed");
        softAssert.assertAll();
        log.info("******************** completed testing validate login for valid data. username :: " + username + " and password :: " + password + " ********************");
    }

    @Test(priority = 3, dataProvider = "inValidUsernamesOrPasswords", dataProviderClass = DataProvidersUtils.class, description = "I am validating login functionality for all invalid data")
    public void validateLoginForInValidData(String username, String password, String expectedErrorMessage) throws InterruptedException {
        log.info("******************** completed testing validate login for invalid valid data. username :: " + username + " and password :: " + password + " ********************");
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToTheApplication(username, password);
        String errorText = loginPage.getTheErrorMessage();
        log.info(errorText);
        softAssert.assertEquals(errorText, expectedErrorMessage, "The error message is not matching");
        softAssert.assertAll();
        log.info("******************** completed testing validate login for invalid data username :: " + username + " and password :: " + password + " ********************");
    }
}
