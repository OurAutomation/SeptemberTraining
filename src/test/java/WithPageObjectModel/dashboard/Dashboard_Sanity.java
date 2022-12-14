package WithPageObjectModel.dashboard;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.pageObjects.SortPage;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Dashboard_Sanity extends Base {
    LoginPage loginPage;
    DashboardPage dashboardPage;
    SortPage sortPage;
    CheckoutPage checkoutPage;

    @BeforeTest
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        sortPage = new SortPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @Test(priority = -1)
    public void login() {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");

    }

    @Test(priority = 0)
    public void validateTheDefaultSortSelected() {
        Assert.assertEquals(sortPage.getSelectedSortOption(), TestDataUtils.getTestData("sortText.AtoZ"), "The default sort selected is not Name (A to Z)");
    }

    @Test(priority = 1)
    public void validateNumberOfProductsAvailable() {
        Assert.assertEquals(dashboardPage.getNumberOfProductsAvailable() + "", TestDataUtils.getTestData("dashboardPage.numberOfProducts"), "Number of products avail;able is not matching");
    }

    @Test(priority = 2)
    public void validateProductTitles() {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        Assert.assertEquals(dashboardPage.getProductTitlesAvailable(), expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 3)
    public void validateMenuItemsAvailable() {
        dashboardPage.clickOnMenuButton();
        List<String> expectedMenuItems = Arrays.asList(TestDataUtils.getTestData("dashboardPage.menuItems").split(","));
        Assert.assertEquals(dashboardPage.getMenuItemsAvailable(), expectedMenuItems, "The titles of the products are not matching");
    }

    @Test(priority = 4)
    public void validateAddToCartFunctionality() {
        dashboardPage.clickOnMenuCloseButton();
        dashboardPage.addProductToCheckout(TestDataUtils.getTestData("sauceLabsBackPackText"));
        Assert.assertEquals(dashboardPage.getNumberOfProductsAdded(), "1", "Product is not added");
        Assert.assertFalse(dashboardPage.isAddToCartButtonDisplayedForGivenProductName(TestDataUtils.getTestData("sauceLabsBackPackText")), "The add to cart button on click is not getting invisible");
        Assert.assertTrue(dashboardPage.isRemoveFromCartButtonDisplayedForGivenProductName(TestDataUtils.getTestData("sauceLabsBackPackText")), "The remove button is not displayed");
        dashboardPage.clickOnShoppingCartIcon();
        Assert.assertEquals(checkoutPage.getTheProductNameAdded(), TestDataUtils.getTestData("sauceLabsBackPackText"), "Add to cart button functionality is not working fine");
    }


}
