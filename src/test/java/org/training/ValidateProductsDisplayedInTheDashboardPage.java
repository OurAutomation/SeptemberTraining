package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ValidateProductsDisplayedInTheDashboardPage {
    static final String invalidCredentialsErrorMessage = "Epic sadface: Username and password do not match any user in this service";

    public static void main(String[] args) throws InterruptedException {
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
        System.out.println("Total number of products displayed in the dashboard page :: " + products.size());
        if (products.size() == 6) {
            System.out.println("Total number of products displayed are proper");
        } else if (products.size() < 6) {
            System.out.println("Less number of products are displayed");
        } else {
            System.out.println("More number of products are displayed");
        }
        driver.quit();
    }
}
