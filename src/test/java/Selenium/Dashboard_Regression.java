package Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.pageObjects.SortPage;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
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
        WebElement element = driver.findElement(By.id("user-name"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("valid.username"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("password"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='about_sidebar_link']")));
driver.findElement(By.xpath("//*[@id='about_sidebar_link']")).click();
    }


}
