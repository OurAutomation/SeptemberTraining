package sortFunctionality;

import org.openqa.selenium.NoSuchElementException;
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

}
