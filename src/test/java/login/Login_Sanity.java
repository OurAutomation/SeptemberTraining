package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Sanity extends Base {
    static final String invalidCredentialsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @BeforeMethod
    public void beforeMethod() {
        loadApplication();
    }

    @Test(priority = 0)
    public void loginWithValidCredentials() throws InterruptedException {
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("valid.username"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("password"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
//        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        boolean isMenuBarDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.menuButton")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
//        Assert.assertEquals(isMenuBarDisplayed,true,"");
        Assert.assertTrue(isMenuBarDisplayed, "The menu bar is not displayed");
        String isProductLogoString = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.logo")).getText();
        System.out.println("Products image text :: " + isProductLogoString);
        Assert.assertEquals(isProductLogoString, TestDataUtils.getTestData("productsLogo.text"), "The product logo is not displayed");
        boolean isCheckoutButtonDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.shoppingCartLink")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
        Assert.assertTrue(isCheckoutButtonDisplayed, "The checkout button is not displayed");
    }

    @Test(priority = 1)
    public void loginWithInValidValidCredentials() throws InterruptedException {
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("valid.username"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("invalid.password"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
        WebElement errorMessage = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.errorMessage"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        System.out.println("Error message is displayed or not :: " + isErrorMessageDisplayed);
        Assert.assertTrue(isErrorMessageDisplayed, "The error message is not displayed");
        String errorText = errorMessage.getText();
        System.out.println(errorText);
        Assert.assertEquals(errorText, invalidCredentialsErrorMessage, "The error message is not matching");
        /*if(errorText.equals(invalidCredentialsErrorMessage)) {
            System.out.println("Error message text is matching");
        } else {
            System.out.println("Error message text is not matching");
        }*/
    }
}
