package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateLoginWithInValidCredentials {
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
        element.sendKeys("secret_sauc");
        element = driver.findElement(By.className("submit-button"));
        element.click();
        WebElement errorMessage = driver.findElement(By.tagName("h3"));
        boolean isErrorMessageDisplayed = errorMessage.isDisplayed();
        System.out.println("Error message is displayed or not :: " + isErrorMessageDisplayed);
        String errorText = errorMessage.getText();
        System.out.println(errorText);
        if(errorText.equals(invalidCredentialsErrorMessage)) {
            System.out.println("Error message text is matching");
        } else {
            System.out.println("Error message text is not matching");
        }
        driver.quit();
    }
}
