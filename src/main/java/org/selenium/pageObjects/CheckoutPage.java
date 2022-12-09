package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;

public class CheckoutPage extends SeleniumUtils {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTheProductNameAdded() {
        return getText(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
    }
}
