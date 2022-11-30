package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.utils.Base;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Regression extends Base {
    static final String invalidCredentialsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    @BeforeMethod
    public void beforeMethod() {
        loadApplication();
    }

    @Test(priority = 0, description = "Here i am going to validate placeholders of all the fields")
    public void validateAllThePlaceHolders() {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(By.cssSelector("#user-name"));
        String placeholder = element.getAttribute("placeholder");
        System.out.println("The placeholder value is :: " + placeholder);
        softAssert.assertEquals(placeholder, "Username", "Placeholder is not matching");
        element = driver.findElement(By.cssSelector("[name='password']"));
        placeholder = element.getAttribute("placeholder");
        System.out.println("The placeholder value is :: " + placeholder);
        softAssert.assertEquals(placeholder, "Password", "Placeholder is not matching");
        element = driver.findElement(By.cssSelector(".submit-button"));
        String value = element.getAttribute("value");
        System.out.println("The value is :: " + value);
        softAssert.assertEquals(value, "Login", "Button text is not matching");
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "I am validating if the password is getting masked or not")
    public void validateIfThePasswordIsGettingMasked() {
        WebElement element = driver.findElement(By.cssSelector("[name='password']"));
        String typeAttribute = element.getAttribute("type");
        System.out.println("The type attribute value is :: " + typeAttribute);
        Assert.assertEquals(typeAttribute, "password", "Password is not getting masked");
    }

    @Test(priority = 2, dataProvider = "validUsernames", description = "I am validating login functionality for all valid usernames")
    public void validateLoginForValidData(String username, String password) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(By.cssSelector("#user-name"));
        element.click();
        element.sendKeys(username);
        element = driver.findElement(By.cssSelector("[name='password']"));
        element.click();
        element.sendKeys(password);
        element = driver.findElement(By.cssSelector(".submit-button"));
        element.click();
        Thread.sleep(1000);
        boolean isMenuBarDisplayed = driver.findElement(By.cssSelector("[id='react-burger-menu-btn']")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
        softAssert.assertTrue(isMenuBarDisplayed, "The menu bar is not displayed");
        String isProductLogoString = driver.findElement(By.cssSelector(".title")).getText();
        System.out.println("Products image text :: " + isProductLogoString);
        softAssert.assertEquals(isProductLogoString, "PRODUCTS", "The product logo is not displayed");
        boolean isCheckoutButtonDisplayed = driver.findElement(By.cssSelector("[class='shopping_cart_link']")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
        softAssert.assertTrue(isCheckoutButtonDisplayed, "The checkout button is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 3, dataProvider = "inValidUsernamesOrPasswords", description = "I am validating login functionality for all invalid data")
    public void validateLoginForInValidData(String username, String password, String expectedErrorMessage) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(By.cssSelector("#user-name"));
        element.click();
        element.sendKeys(username);
        element = driver.findElement(By.cssSelector("[name='password']"));
        element.click();
        element.sendKeys(password);
        element = driver.findElement(By.cssSelector(".submit-button"));
        element.click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        System.out.println("Error message is displayed or not :: " + isErrorMessageDisplayed);
        softAssert.assertTrue(isErrorMessageDisplayed, "The error message is not displayed");
        String errorText = errorMessage.getText();
        System.out.println(errorText);
        softAssert.assertEquals(errorText, expectedErrorMessage, "The error message is not matching");
        softAssert.assertAll();
    }

    @DataProvider
    public Object[][] validUsernames() {
        String[][] validUsernames = new String[3][2];
        validUsernames[0][0] = "performance_glitch_user";
        validUsernames[0][1] = "secret_sauce";
        validUsernames[1][0] = "problem_user";
        validUsernames[1][1] = "secret_sauce";
        validUsernames[2][0] = "standard_user";
        validUsernames[2][1] = "secret_sauce";
        return validUsernames;
    }

    @DataProvider
    public Object[][] inValidUsernamesOrPasswords() {
        String[][] invalidData = new String[7][3];
        invalidData[0][0] = "performance_glitch_user";
        invalidData[0][1] = "secret_sce";
        invalidData[0][2] = invalidCredentialsErrorMessage;
        invalidData[1][0] = "problem_user";
        invalidData[1][1] = "";
        invalidData[1][2] = "Epic sadface: Password is required";
        invalidData[2][0] = "standard_user";
        invalidData[2][1] = "secret_sauce@123";
        invalidData[2][2] = invalidCredentialsErrorMessage;
        invalidData[3][0] = "Invalid";
        invalidData[3][1] = "Invalid";
        invalidData[3][2] = invalidCredentialsErrorMessage;
        invalidData[4][0] = "Test@123";
        invalidData[4][1] = "secret_sauce";
        invalidData[4][2] = invalidCredentialsErrorMessage;
        invalidData[5][0] = "";
        invalidData[5][1] = "secret_sauce";
        invalidData[5][2] = "Epic sadface: Username is required";
        invalidData[6][0] = "locked_out_user";
        invalidData[6][1] = "secret_sauce";
        invalidData[6][2] = "Epic sadface: Sorry, this user has been locked out.";
        return invalidData;
    }
}
