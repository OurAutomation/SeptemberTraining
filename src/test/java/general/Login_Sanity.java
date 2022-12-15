package general;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.utils.Base;
import org.selenium.utils.Constants;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class Login_Sanity extends Base {
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

    @Test(priority = 0)
    public void loginWithValidCredentials() throws InterruptedException, IOException {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                "Test@123");
        if(!loginPage.isUserLoggedIn()) {

            Assert.fail("Login didn't work");
        }
    }
    @Test(priority = 1)
    public void loginWithInValidCredentials() throws InterruptedException, IOException {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                "Test@123");
        if(!loginPage.isUserLoggedIn()) {
            Assert.fail("Login didn't work");
        }
    }

    @Test(priority = 2)
    public void pass() throws InterruptedException, IOException {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
        if(!loginPage.isUserLoggedIn()) {
            Assert.fail("Login didn't work");
        }
    }
}
