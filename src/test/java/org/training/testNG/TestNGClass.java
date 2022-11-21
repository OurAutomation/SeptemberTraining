package org.training.testNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class TestNGClass {
    WebDriver driver;

    @Test(priority = 0)
    public void openingTheBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
    }

    @Test(priority = 1)
    public void login() {
        WebElement element = driver.findElement(By.id("user-name"));
        element.click();
        element.sendKeys("standard_user");
        element = driver.findElement(By.name("password"));
        element.click();
        element.sendKeys("secret_sauce");
        element = driver.findElement(By.className("submit-button"));
        element.click();
    }

    @Test(priority = 2)
    public void validateIfUserIsLoggedIn() {
        boolean isMenuBarDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
        boolean isProductLogoDisplayed = driver.findElement(By.className("title")).isDisplayed();
        System.out.println("Products image is displayed or not :: " + isProductLogoDisplayed);
        boolean isCheckoutButtonDisplayed = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
    }

    @Test(priority = 3)
    public void validateElementsPresentInTheMenu() throws InterruptedException {
        driver.findElement(By.id("react-burger-menu-btn")).click();
        Thread.sleep(2000);
        boolean isAboutDisplayed = driver.findElement(By.linkText("ABOUT")).isDisplayed();
        System.out.println("Is About displayed :: " + isAboutDisplayed);
        boolean isLogoutDisplayed = driver.findElement(By.linkText("LOGOUT")).isDisplayed();
        System.out.println("Is logout displayed :: " + isLogoutDisplayed);
        boolean isAllItemsDisplayed = driver.findElement(By.partialLinkText("ITEMS")).isDisplayed();
        System.out.println("Is all items displayed :: " + isAllItemsDisplayed);
        boolean isResetAppStateDisplayed = driver.findElement(By.partialLinkText("APP STATE")).isDisplayed();
        System.out.println("Is reset app state displayed :: " + isResetAppStateDisplayed);
        driver.findElement(By.id("react-burger-cross-btn")).click();
    }

    @Test(priority = 4)
    public void validateNumberOfProductsDisplayedInTheDashboardPage() {
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        System.out.println("Total number of products displayed in the dashboard page :: " + products.size());
        if (products.size() == 6) {
            System.out.println("Total number of products displayed are proper");
        } else if (products.size() < 6) {
            System.out.println("Less number of products are displayed");
        } else {
            System.out.println("More number of products are displayed");
        }
    }

    @Test(priority = 5)
    public void validateProductTitlesDisplayedInTheDashboardPage() {
        String[] productsTitlesArray = ("Sauce Labs Backpack,Sauce Labs Bike Light," +
                "Sauce Labs Bolt T-Shirt,Sauce Labs Fleece Jacket," +
                "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)").split(",");
        List<String> expectedProductsTitles = Arrays.asList(productsTitlesArray);
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(expectedProductsTitles.get(i))) {
                System.out.println("Product name is matching");
            } else {
                System.out.println("Product name is not matching");
            }
        }
    }

    @Test(priority = 6)
    public void validateAddToCartFunctionality() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String shopping_cart_badge = driver.findElement(By.className("shopping_cart_badge")).getText();
        if(shopping_cart_badge.equals("1")) {
            System.out.println("Product is added");
        } else {
            System.out.println("Product is not added");
        }
        boolean isAddToCartButtonIsDisplayed;
        try {
            isAddToCartButtonIsDisplayed = driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).isDisplayed();
        } catch (NoSuchElementException e) {
            isAddToCartButtonIsDisplayed = false;
        }
        if(isAddToCartButtonIsDisplayed) {
            System.out.println("The add to cart button on click is not getting invisible");
        } else {
            System.out.println("The add to cart button is invisible");
        }
        boolean isRemoveButtonIsDisplayed = driver.findElement(By.id("remove-sauce-labs-backpack")).isDisplayed();
        if(isRemoveButtonIsDisplayed) {
            System.out.println("The remove button is visible");
        } else {
            System.out.println("The remove button is not displayed");
        }
        driver.findElement(By.className("shopping_cart_link")).click();
        String inventory_item_name = driver.findElement(By.className("inventory_item_name")).getText();
        if(inventory_item_name.equals("Sauce Labs Backpack")) {
            System.out.println("Add to cart button functionality is working fine");
        }else {
            System.out.println("Add to cart button functionality is not working fine");
        }
    }

    @Test(priority = 7)
    public void closeTheBrowser() {
        driver.quit();
    }

}
