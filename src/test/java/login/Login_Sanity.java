package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.utils.Base;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_Sanity extends Base {
    static final String invalidCredentialsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @BeforeMethod
    public void beforeMethod() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 0)
    public void loginWithValidCredentials() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("#user-name"));
        element.click();
        element.sendKeys("standard_user");
        element = driver.findElement(By.cssSelector("[name='password']"));
        element.click();
        element.sendKeys("secret_sauce");
        element = driver.findElement(By.cssSelector(".submit-button"));
        element.click();
//        driver.findElement(By.className("shopping_cart_link")).click();
        Thread.sleep(1000);
        boolean isMenuBarDisplayed = driver.findElement(By.cssSelector("[id='react-burger-menu-btn']")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
//        Assert.assertEquals(isMenuBarDisplayed,true,"");
        Assert.assertTrue(isMenuBarDisplayed, "The menu bar is not displayed");
        String isProductLogoString = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Products image text :: " + isProductLogoString);
        Assert.assertEquals(isProductLogoString, "PRODUCTS", "The product logo is not displayed");
        boolean isCheckoutButtonDisplayed = driver.findElement(By.cssSelector("[class='shopping_cart_link']")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
        Assert.assertTrue(isCheckoutButtonDisplayed, "The checkout button is not displayed");
    }

    @Test(priority = 1)
    public void loginWithInValidValidCredentials() throws InterruptedException {
        WebElement element = driver.findElement(By.cssSelector("#user-name"));
        element.click();
        element.sendKeys("standard_user");
        element = driver.findElement(By.cssSelector("[name='password']"));
        element.click();
        element.sendKeys("secret_sauc");
        element = driver.findElement(By.cssSelector(".submit-button"));
        element.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
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
