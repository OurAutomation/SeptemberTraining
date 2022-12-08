package WithoutPageObjectModel.sortFunctionality;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.selenium.utils.Base;
import org.selenium.utils.ObjectRepositoryUtils;
import org.selenium.utils.TestDataUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortDropdown extends Base {

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
    public void validateTheDefaultsortSelected() {
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        String selectedOptionText = sortDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(selectedOptionText, TestDataUtils.getTestData("sortText.AtoZ"), "The default sort selected is not Name (A to Z)");
    }

    @Test(priority = 1)
    public void validateNumberOfSortsAvailable() {
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        List<WebElement> options = sortDropdown.getOptions();
        List<String> expectedSorts = Arrays.asList(TestDataUtils.getTestData("dashboardPage.sortOptionsAvailable").split(","));
        List<String> actualSorts = new ArrayList<>();
        options.stream().forEach(e -> actualSorts.add(e.getText()));
        Assert.assertEquals(actualSorts, expectedSorts, "The sorts are not matching");
    }

    @Test(priority = 2)
    public void validateSortAtoZFunctionality() throws InterruptedException {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        sortDropdown.selectByIndex(2);
        Thread.sleep(3000);
        sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        sortDropdown.selectByVisibleText(TestDataUtils.getTestData("sortText.AtoZ"));
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        List<String> actualProductTitles = new ArrayList<>();
        products.stream().forEach(e -> actualProductTitles.add(e.getText()));
        Assert.assertEquals(actualProductTitles, expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 3)
    public void validateSortZtoAFunctionality() throws InterruptedException {
        List<String> expectedProductsTitles = Arrays.asList(TestDataUtils.getTestData("productTitlesAvailable").split(","));
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        sortDropdown.selectByIndex(1);
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.productNames"));
        List<String> actualProductTitles = new ArrayList<>();
        products.stream().forEach(e -> actualProductTitles.add(e.getText()));
        Collections.reverse(expectedProductsTitles);
        Assert.assertEquals(actualProductTitles, expectedProductsTitles, "The titles of the products are not matching");
    }

    @Test(priority = 4)
    public void validateSortLowToHighFunctionality() throws InterruptedException {
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        sortDropdown.selectByValue("lohi");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.itemPrice"));
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

    @Test(priority = 5)
    public void validateSortHighToLowFunctionality() throws InterruptedException {
        Select sortDropdown = new Select(driver.findElement(ObjectRepositoryUtils.getLocator("dashboardPage.sortDropdown")));
        sortDropdown.selectByValue("hilo");
        Thread.sleep(3000);
        List<WebElement> products = driver.findElements(ObjectRepositoryUtils.getLocator("dashboardPage.itemPrice"));
        List<Float> actualProductPrices = new ArrayList<>();
        products.stream().forEach(e -> actualProductPrices.add(Float.parseFloat(e.getText().replace("$", ""))));
        List<Float> expectedProductPrices = new ArrayList<>();
        expectedProductPrices.addAll(actualProductPrices);
        Collections.sort(expectedProductPrices);
        Collections.reverse(expectedProductPrices);
        Assert.assertEquals(actualProductPrices, expectedProductPrices, "The prices of the products are not matching");
    }


}
