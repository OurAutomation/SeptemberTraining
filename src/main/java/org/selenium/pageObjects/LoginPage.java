package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoginPage extends SeleniumUtils {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void loginToTheApplication(String username, String password) {
        log.info("Logging in to the applications with username :: " + username + ", password :: " + password);
        sendKeys(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"), username);
        sendKeys(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"), password);
        click(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        log.info("Logged in to the application");
    }

    public boolean isUserLoggedIn() {
        boolean displayed = isDisplayed(ObjectRepositoryUtils.getLocator("homePage.menuButton"));
        log.info("Is Uer logged in to the application :: " + displayed);
        return displayed;
    }

    public String getTheErrorMessage() {
        String text = getText(ObjectRepositoryUtils.getLocator("loginPage.errorMessage"));
        log.info("The error message displayed is :: " + text);
        return text;
    }

    public String getUsernameInputBoxPlaceHolder() {
        String placeholder = getAttribute(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"), "placeholder");
        log.info("The placeholder displayed for username input box is :: " + placeholder);
        return placeholder;
    }

    public String getPasswordInputBoxPlaceHolder() {
        String placeholder = getAttribute(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"), "placeholder");
        log.info("The placeholder displayed for password input box is :: " + placeholder);
        return placeholder;
    }

    public String getTextDisplayedOnTheSubmitButton() {
        String textOfTheButton = getTextOfTheButton(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        log.info("The text displayed on submit button is :: " + textOfTheButton);
        return textOfTheButton;
    }

    public boolean isPasswordGettingMasked() {
        return doesBothTheTextsMatches(getAttribute(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"), "type"), "password");
    }

}
