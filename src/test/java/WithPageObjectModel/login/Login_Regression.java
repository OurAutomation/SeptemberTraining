package WithPageObjectModel.login;

import org.openqa.selenium.WebElement;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class Login_Regression extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeTest
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        loadApplication();
    }

    @Test(priority = 0, description = "Here i am going to validate placeholders of all the fields")
    public void validateAllThePlaceHolders() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(loginPage.getUsernameInputBoxPlaceHolder(), "Username", "Placeholder is not matching");
        softAssert.assertEquals(loginPage.getPasswordInputBoxPlaceHolder(), "Password", "Placeholder is not matching");
        softAssert.assertEquals(loginPage.getTextDisplayedOnTheSubmitButton(), "Login", "Button text is not matching");
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "I am validating if the password is getting masked or not")
    public void validateIfThePasswordIsGettingMasked() {
        Assert.assertTrue(loginPage.isPasswordGettingMasked(), "Password is not getting masked");
    }

    @Test(priority = 2, dataProvider = "validUsernames", description = "I am validating login functionality for all valid usernames")
    public void validateLoginForValidData(String username, String password) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToTheApplication(username, password);
        softAssert.assertTrue(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
        softAssert.assertTrue(dashboardPage.isProductLogoDisplayed(), "The product logo is not displayed");
        softAssert.assertTrue(dashboardPage.isCheckoutIconDisplayed(), "The checkout button is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 3, dataProvider = "inValidUsernamesOrPasswords", description = "I am validating login functionality for all invalid data")
    public void validateLoginForInValidData(String username, String password, String expectedErrorMessage) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        loginPage.loginToTheApplication(username, password);
        String errorText = loginPage.getTheErrorMessage();
        System.out.println(errorText);
        softAssert.assertEquals(errorText, expectedErrorMessage, "The error message is not matching");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] validUsernames() {
        String[][] validUsernames = new String[3][2];
        validUsernames[0][0] = TestDataUtils.getTestData("performance.username");
        validUsernames[0][1] = TestDataUtils.getTestData("password");
        validUsernames[1][0] = TestDataUtils.getTestData("problem.username");
        validUsernames[1][1] = TestDataUtils.getTestData("password");
        validUsernames[2][0] = TestDataUtils.getTestData("valid.username");
        validUsernames[2][1] = TestDataUtils.getTestData("password");
        return validUsernames;
    }

    @DataProvider
    public Object[][] inValidUsernamesOrPasswords() {
        String[][] invalidData = new String[7][3];
        invalidData[0][0] = TestDataUtils.getTestData("performance.username");
        invalidData[0][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[0][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[1][0] = TestDataUtils.getTestData("problem.username");
        invalidData[1][1] = "";
        invalidData[1][2] = TestDataUtils.getTestData("passwordRequired.errorMessage");
        invalidData[2][0] = TestDataUtils.getTestData("valid.username");
        invalidData[2][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[2][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[3][0] = TestDataUtils.getTestData("invalid.username");
        invalidData[3][1] = TestDataUtils.getTestData("invalid.password");
        invalidData[3][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[4][0] = TestDataUtils.getTestData("invalid.password");
        invalidData[4][1] = TestDataUtils.getTestData("password");
        invalidData[4][2] = TestDataUtils.getTestData("invalidCredentials.errorMessage");
        invalidData[5][0] = "";
        invalidData[5][1] = TestDataUtils.getTestData("password");
        invalidData[5][2] = TestDataUtils.getTestData("usernameRequired.errorMessage");
        invalidData[6][0] = TestDataUtils.getTestData("locked.username");
        invalidData[6][1] = TestDataUtils.getTestData("password");
        invalidData[6][2] = TestDataUtils.getTestData("userLockedOut.errorMessage");
        return invalidData;
    }
}
