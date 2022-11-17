package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValidateProductTitlesDisplayedInTheDashboardPage {
    public static void main(String[] args) throws InterruptedException {
        String[] productsTitlesArray = ("Sauce Labs Backpack,Sauce Labs Bike Light," +
                "Sauce Labs Bolt T-Shirt,Sauce Labs Fleece Jacket," +
                "Sauce Labs Onesie,Test.allTheThings() T-Shirt (Red)").split(",");
        List<String> expectedProductsTitles = Arrays.asList(productsTitlesArray);
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
        List<WebElement> products = driver.findElements(By.className("inventory_item_name"));
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getText().equals(expectedProductsTitles.get(i))) {
                System.out.println("Product name is matching");
            } else {
                System.out.println("Product name is not matching");
            }
        }
        driver.quit();
    }
}
