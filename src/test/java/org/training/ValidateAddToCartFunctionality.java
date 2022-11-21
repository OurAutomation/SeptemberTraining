package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateAddToCartFunctionality {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("user-name"));
        element.click();
        element.sendKeys("standard_user");
        element = driver.findElement(By.name("password"));
        element.click();
        element.sendKeys("secret_sauce");
        element = driver.findElement(By.className("submit-button"));
        element.click();
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
        driver.quit();
    }
}
