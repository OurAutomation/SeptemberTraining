package org.selenium.pageObjects;

import org.openqa.selenium.WebDriver;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.logging.LogManager;

public class CheckoutPage extends SeleniumUtils {
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    public String getTheProductNameAdded() {
        log.info("Getting the first product names");
        String text = getText(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        log.info("The product name is :: " + text);
        return text;
    }
}
