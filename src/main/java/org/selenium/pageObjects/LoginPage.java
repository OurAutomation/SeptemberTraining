package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;

public class LoginPage extends SeleniumUtils {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToTheApplication(String username, String password) {
        sendKeys(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"), username);
        sendKeys(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"), password);
        click(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
    }

    public boolean isUserLoggedIn() {
        return isDisplayed(ObjectRepositoryUtils.getLocator("homePage.menuButton"));
    }

    public String getTheErrorMessage() {
        return getText(ObjectRepositoryUtils.getLocator("loginPage.errorMessage"));
    }

    public String getUsernameInputBoxPlaceHolder() {
        return getAttribute(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"),"placeholder");
    }

    public String getPasswordInputBoxPlaceHolder() {
        return getAttribute(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"),"placeholder");
    }

    public String getTextDisplayedOnTheSubmitButton() {
        return getTextOfTheButton(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
    }

    public boolean isPasswordGettingMasked() {
        return doesBothTheTextsMatches(getAttribute(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"),"type"),"password");
    }

}
