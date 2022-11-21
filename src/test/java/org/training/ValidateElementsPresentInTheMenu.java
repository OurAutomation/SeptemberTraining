package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateElementsPresentInTheMenu {
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
        driver.quit();
    }
}
