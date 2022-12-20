package WithPageObjectModel.login;

import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.Base;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Login_Sanity_Bulk extends Base {
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

    @Test(priority = 0, invocationCount = 15)
    public void loginWithValidCredentials() {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
        Assert.assertTrue(loginPage.isUserLoggedIn(), "The menu bar is not displayed");
        Assert.assertTrue(dashboardPage.isProductLogoDisplayed(), "The product logo is not displayed");
        Assert.assertTrue(dashboardPage.isCheckoutIconDisplayed(), "The checkout button is not displayed");
    }
}
