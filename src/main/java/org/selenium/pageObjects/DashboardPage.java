package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.selenium.utils.TestDataUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends SeleniumUtils {
    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public boolean isProductLogoDisplayed() {
        String text = getText(ObjectRepositoryUtils.getLocator("homePage.logo"));
        log.info("The text present on the logo is :: " + text);
        return doesBothTheTextsMatches(text,
                TestDataUtils.getTestData("productsLogo.text"));
    }

    public boolean isCheckoutIconDisplayed() {

        boolean displayed = isDisplayed(ObjectRepositoryUtils.getLocator("homePage.shoppingCartLink"));
        log.info("The shopping cart con is displayed or not :: " + displayed);
        return displayed;
    }

    public int getNumberOfProductsAvailable() {
        int size = getSize(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        log.info("The number of products displayed are :: " + size);
        return size;
    }

    public List<String> getProductTitlesAvailable() {
        List<String> text = getText(findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames")));
        log.info("The title of the products are :: " + text);
        return text;
    }

    public void clickOnMenuButton() {
        log.info("Clicking on menu button in home page");
        click(ObjectRepositoryUtils.getLocator("homePage.menuButton"));
    }

    public List<String> getMenuItemsAvailable() {
        List<String> text = getText(findElements(ObjectRepositoryUtils.getLocator("dashboardPage.menuItems")));
        log.info("The elements available in the menu page are :: " + text);
        return text;
    }

    public void clickOnMenuCloseButton() {
        log.info("Clicking on menu close button");
        click(ObjectRepositoryUtils.getLocator("dashboardPage.menuCloseButton"));
    }

    public void addProductToCheckout(String productName) {
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button";
        log.info("Clicking on add to cart button of the product with xpath :: " + xpath);
        click(By.xpath(xpath.replace("${PRODUCT}",productName)));
    }

    public String getNumberOfProductsAdded() {
        String text = getText(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink"));
        log.info("The number of products added are :: " + text);
        return text;
    }

    public void clickOnShoppingCartIcon() {
        log.info("Clicking on shopping cart link");
       click(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink"));
    }

    public boolean isAddToCartButtonDisplayedForGivenProductName(String productName) {
        hardWait(1);
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button";
        boolean displayed = isDisplayed(By.xpath(xpath.replace("${PRODUCT}", productName)));
        log.info("Is add to cart button displayed or not :: " + displayed);
        return displayed;
    }

    public boolean isRemoveFromCartButtonDisplayedForGivenProductName(String productName) {
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button[text()='Remove']";
        boolean displayed = isDisplayed(By.xpath(xpath.replace("${PRODUCT}", productName)));
        log.info("Is remove from the cart button displayed or not :: " + displayed);
        return displayed;
    }
}
