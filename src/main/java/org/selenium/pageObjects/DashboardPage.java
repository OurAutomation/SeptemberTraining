package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.selenium.utils.TestDataUtils;

public class DashboardPage extends SeleniumUtils {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    public boolean isProductLogoDisplayed() {
        return doesBothTheTextsMatches(getText(ObjectRepositoryUtils.getLocator("homePage.logo")),
                TestDataUtils.getTestData("productsLogo.text"));
    }

    public boolean isCheckoutIconDisplayed() {
        return isDisplayed(ObjectRepositoryUtils.getLocator("homePage.shoppingCartLink"));
    }

}
