package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CheckoutPage extends SeleniumUtils {
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public String getTheProductNameAdded() {
        log.info("Getting the first product names");
        String text = getText(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        log.info("The product name is :: " + text);
        return text;
    }
}
