package WithPageObjectModel.dashboard;

import org.openqa.selenium.WindowType;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.pageObjects.SortPage;
import org.selenium.utils.Base;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class Dashboard_Regression extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SortPage sortPage;
    CheckoutPage checkoutPage;

    @BeforeTest
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        sortPage = new SortPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loadApplication();
    }

    @Test(priority = -1)
    public void login() {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");

    }

    @Test(priority = 0)
    public void validateTwitterIconFunctionality() {
        String presentWindowHandle = driver.getWindowHandle();
        dashboardPage.clickOnTwitterIcon();
        Set<String> windowHandles = driver.getWindowHandles();
        log.info("Title of the present tab is :: " + driver.getTitle());
        for (String handle : windowHandles) {
            if (!handle.equals(presentWindowHandle)) {
                // i want to switch
                driver.switchTo().window(handle);
                break;
            }
        }
        log.info("Title of the new tab is :: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(presentWindowHandle);
    }

    @Test(priority = 1)
    public void createANewWindowAndSwitchToIt() {
        String presentWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.facebook.com");
        log.info("Title of the new tab is :: " + driver.getTitle());
        driver.close();
        driver.switchTo().window(presentWindowHandle);
    }


    @Test(priority = 2)
    public void navigateToTheTabWithTitle() {
        dashboardPage.clickOnTwitterIcon();
        dashboardPage.clickOnFacebookIcon();
        dashboardPage.clickOnLinkedInIcon();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            String title = driver.getTitle();
            log.info("Present window title :: " + title);
            if (title.toLowerCase(Locale.ROOT).contains("linkedin")) {
//                driver.close();
                break;
            }
        }
    }

}
