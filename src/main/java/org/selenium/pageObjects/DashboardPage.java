package org.selenium.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.SeleniumUtils;
import org.selenium.utils.TestDataUtils;

import java.util.ArrayList;
import java.util.List;

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

    public int getNumberOfProductsAvailable() {
        return getSize(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
    }

    public List<String> getProductTitlesAvailable() {
        return getText(findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames")));
    }

    public void clickOnMenuButton() {
        click(ObjectRepositoryUtils.getLocator("homePage.menuButton"));
    }

    public List<String> getMenuItemsAvailable() {
        return getText(findElements(ObjectRepositoryUtils.getLocator("dashboardPage.menuItems")));
    }

    public void clickOnMenuCloseButton() {
        click(ObjectRepositoryUtils.getLocator("dashboardPage.menuCloseButton"));
    }

    public void addProductToCheckout(String productName) {
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button";
        click(By.xpath(xpath.replace("${PRODUCT}",productName)));
    }

    public String getNumberOfProductsAdded() {
        return getText(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink"));
    }

    public void clickOnShoppingCartIcon() {
       click(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink"));
    }

    public boolean isAddToCartButtonDisplayedForGivenProductName(String productName) {
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button";
        return isDisplayed(By.xpath(xpath.replace("${PRODUCT}",productName)));
    }

    public boolean isRemoveFromCartButtonDisplayedForGivenProductName(String productName) {
        String xpath = "//*[text()='${PRODUCT}']/ancestor::div[@class='inventory_item_label']/following-sibling::div[@class='pricebar']//button[text()='Remove']";
        return isDisplayed(By.xpath(xpath.replace("${PRODUCT}",productName)));
    }
}
