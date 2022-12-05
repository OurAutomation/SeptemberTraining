package login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Login_Regression extends Base {

    @BeforeMethod
    public void beforeMethod() {
        loadApplication();
    }

    @Test(priority = 0, description = "Here i am going to validate placeholders of all the fields")
    public void validateAllThePlaceHolders() {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        String placeholder = element.getAttribute("placeholder");
        System.out.println("The placeholder value is :: " + placeholder);
        softAssert.assertEquals(placeholder, "Username", "Placeholder is not matching");
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        placeholder = element.getAttribute("placeholder");
        System.out.println("The placeholder value is :: " + placeholder);
        softAssert.assertEquals(placeholder, "Password", "Placeholder is not matching");
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        String value = element.getAttribute("value");
        System.out.println("The value is :: " + value);
        softAssert.assertEquals(value, "Login", "Button text is not matching");
        softAssert.assertAll();
    }

    @Test(priority = 1, description = "I am validating if the password is getting masked or not")
    public void validateIfThePasswordIsGettingMasked() {
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        String typeAttribute = element.getAttribute("type");
        System.out.println("The type attribute value is :: " + typeAttribute);
        Assert.assertEquals(typeAttribute, "password", "Password is not getting masked");
    }

    @Test(priority = 2, dataProvider = "validUsernames", description = "I am validating login functionality for all valid usernames")
    public void validateLoginForValidData(String username, String password) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        element.click();
        element.sendKeys(username);
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(password);
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
        Thread.sleep(1000);
        boolean isMenuBarDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.menuButton")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
        softAssert.assertTrue(isMenuBarDisplayed, "The menu bar is not displayed");
        String isProductLogoString = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.logo")).getText();
        System.out.println("Products image text :: " + isProductLogoString);
        softAssert.assertEquals(isProductLogoString, TestDataUtils.getTestData("productsLogo.text"), "The product logo is not displayed");
        boolean isCheckoutButtonDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("homePage.shoppingCartLink")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
        softAssert.assertTrue(isCheckoutButtonDisplayed, "The checkout button is not displayed");
        softAssert.assertAll();
    }

    @Test(priority = 3, dataProvider = "inValidUsernamesOrPasswords", description = "I am validating login functionality for all invalid data")
    public void validateLoginForInValidData(String username, String password, String expectedErrorMessage) throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        element.click();
        element.sendKeys(username);
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(password);
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.errorMessage"));
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
