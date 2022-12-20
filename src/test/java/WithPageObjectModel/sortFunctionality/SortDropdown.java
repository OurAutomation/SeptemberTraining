package WithPageObjectModel.sortFunctionality;

import org.openqa.selenium.WebElement;
import org.selenium.pageObjects.CheckoutPage;
import org.selenium.pageObjects.DashboardPage;
import org.selenium.pageObjects.LoginPage;
import org.selenium.pageObjects.SortPage;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDropdown extends Base {

    LoginPage loginPage;
    DashboardPage dashboardPage;
    SortPage sortPage;
    CheckoutPage checkoutPage;

    @BeforeTest(alwaysRun = true)
    public void init() {
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        sortPage = new SortPage(driver);
        checkoutPage = new CheckoutPage(driver);
        loadApplication();
    }

    @Test(priority = -1, groups = {"sanity", "regression"})
    public void login() {
        loginPage.loginToTheApplication(TestDataUtils.getTestData("valid.username"),
                TestDataUtils.getTestData("password"));
//                "test");
        Assert.assertTrue(loginPage.isUserLoggedIn(), "User is not logged in");

    }

    @Test(priority = 0, groups = {"sanity", "regression"}, dependsOnMethods = "login")
    public void validateTheDefaultSortSelected() {
        Assert.assertEquals(sortPage.getSelectedSortOption(), TestDataUtils.getTestData("sortText.AtoZ"), "The default sort selected is not Name (A to Z)");
    }

    @Test(priority = 1, groups = {"sanity", "regression"}, dependsOnMethods = "login")
    public void validateNumberOfSortsAvailable() {
        List<String> expectedSorts = Arrays.asList(TestDataUtils.getTestData("dashboardPage.sortOptionsAvailable").split(","));
        List<String> actualSorts = sortPage.getNumberOfSortsAvailable();
        Assert.assertEquals(actualSorts, expectedSorts, "The sorts are not matching");
    }

    @Test(priority = 2, groups = {"sanity", "regression"}, dependsOnMethods = "login")
    public void validateSortAtoZFunctionality() {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        sortPage.selectTheGivenSortByVisibleText(TestDataUtils.getTestData("sortText.AtoZ"));
        Assert.assertEquals(dashboardPage.getProductTitlesAvailable(), expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 3, groups = {"regression"}, dependsOnMethods = "login", enabled = true)
    public void validateSortZtoAFunctionality() {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        sortPage.selectTheGivenSortByVisibleText(TestDataUtils.getTestData("sortText.ZtoA"));
        Collections.reverse(expectedProductsTitles);
        Assert.assertEquals(dashboardPage.getProductTitlesAvailable(), expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 4, groups = {"regression"}, dependsOnMethods = "login")
    public void validateSortLowToHighFunctionality() {
        sortPage.selectTheGivenSortByVisibleText(TestDataUtils.getTestData("sortText.PriceLowToHigh"));
        List<WebElement> products = sortPage.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.itemPrice"));
        List<Float> actualProductPrices = new ArrayList<>();
        products.stream().forEach(e -> {
            System.out.println(e.getText());
            actualProductPrices.add(Float.parseFloat(e.getText().replace("$", "")));
        });
        List<Float> expectedProductPrices = new ArrayList<>();
        expectedProductPrices.addAll(actualProductPrices);
        Collections.sort(expectedProductPrices);
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The prices of the products are not matching");
    }

    @Test(priority = 5, groups = {"regression"}, dependsOnMethods = "login")
    public void validateSortHighToLowFunctionality() {
        sortPage.selectTheGivenSortByVisibleText(TestDataUtils.getTestData("sortText.PriceHighToLow"));
        List<WebElement> products = sortPage.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.itemPrice"));
        List<Float> actualProductPrices = new ArrayList<>();
        products.stream().forEach(e -> actualProductPrices.add(Float.parseFloat(e.getText().replace("$", ""))));
        List<Float> expectedProductPrices = new ArrayList<>();
        expectedProductPrices.addAll(actualProductPrices);
        Collections.sort(expectedProductPrices);
        Collections.reverse(expectedProductPrices);
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The prices of the products are not matching");
    }

}
