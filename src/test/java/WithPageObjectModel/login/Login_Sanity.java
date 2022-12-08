package WithPageObjectModel.login;

import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.Base;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Sanity extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeClass
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @BeforeMethod
    public void beforeMethod() {
        loadApplication();
    }

    @Test(priority = 0)
    public void loginWithValidCredentials() throws InterruptedException {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
        Assert.assertTrue(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
        Assert.assertTrue(dashboardPage.isProductLogoDisplayed(), "The product logo is not displayed");
        Assert.assertTrue(dashboardPage.isCheckoutIconDisplayed(), "The checkout button is not displayed");
    }

    @Test(priority = 1)
    public void loginWithInValidValidCredentials() throws InterruptedException {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("invalid.password"));
        String errorText = loginPage.getTheErrorMessage();
        System.out.println(errorText);
        Assert.assertEquals(errorText, TestDataUtils.getTestData("invalidCredentials.errorMessage"), "The error message is not matching");
    }
}
