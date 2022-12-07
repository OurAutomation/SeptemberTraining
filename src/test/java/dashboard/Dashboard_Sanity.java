package dashboard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard_Sanity extends Base {

    @BeforeClass
    public void beforeClass() {
        WebElement element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.usernameInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("valid.username"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.passwordInputBox"));
        element.click();
        element.sendKeys(TestDataUtils.getTestData("password"));
        element = driver.findElement(ObjectRepositoryUtils.getLocator("loginPage.submitButton"));
        element.click();
    }

    @Test(priority = 0)
    public void validateTheDefaultSortSelected() {
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        String selectedOptionText = sortDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText, TestDataUtils.getTestData("sortText.AtoZ"), "The default sort selected is not Name (A to Z)");
    }

    @Test(priority = 1)
    public void validateNumberOfProductsAvailable() {
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        System.out.println("Total number of products displayed in the dashboard page :: " + products.size());
        Assert.assertEquals(products.size() + "", TestDataUtils.getTestData("dashboardPage.numberOfProducts"), "Number of products avail;able is not matching");
    }

    @Test(priority = 2)
    public void validateProductTitles() {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        List<String> actualProductTitles = new ArrayList<>();
        products.stream().forEach(e -> actualProductTitles.add(e.getText()));
        Assert.assertEquals(actualProductTitles, expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 3)
    public void validateMenuItemsAvailable() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        driver.findElement(ObjectRepositoryUtils.getLocator("homePage.menuButton")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(ObjectRepositoryUtils.getLocator("dashboardPage.menuItems")));
        List<String> expectedMenuItems = Arrays.asList(TestDataUtils.getTestData("dashboardPage.menuItems").split(","));
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.menuItems"));
        List<String> menuItems = new ArrayList<>();
        products.stream().forEach(e -> menuItems.add(e.getText()));
        Assert.assertEquals(menuItems, expectedMenuItems, "The titles of the products are not matching");
    }

    @Test(priority = 4)
    public void validateAddToCartFunctionality() {
        driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.menuCloseButton")).click();
        driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sauceLabsBackpackAddButton")).click();
        String shopping_cart_badge = driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink")).getText();
        Assert.assertEquals(shopping_cart_badge, "1", "Product is not added");
        boolean isAddToCartButtonIsDisplayed;
        try {
            isAddToCartButtonIsDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sauceLabsBackpackAddButton")).isDisplayed();
        } catch (NoSuchElementException e) {
            isAddToCartButtonIsDisplayed = false;
        }
        Assert.assertFalse(isAddToCartButtonIsDisplayed, "The add to cart button on click is not getting invisible");
        boolean isRemoveButtonIsDisplayed = driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sauceLabsBackpackRemoveButton")).isDisplayed();
        Assert.assertTrue(isRemoveButtonIsDisplayed, "The remove button is not displayed");
        driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.shoppingCartLink")).click();
        String inventory_item_name = driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.productNames")).getText();
        Assert.assertEquals(inventory_item_name, TestDataUtils.getTestData("sauceLabsBackPackText"), "Add to cart button functionality is not working fine");
    }


}
