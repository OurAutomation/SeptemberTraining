package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class ValidateLoginWithValidCredentials {
    public static void main(String[] args) throws InterruptedException {
//        final String PROJECT_HOME = System.getProperty("user.dir");

        /*System.setProperty("webdriver.chrome.driver", PROJECT_HOME + File.separator + "chromedriver.exe");
        System.setProperty("webdriver.edge.driver", PROJECT_HOME + File.separator + "msedgedriver.exe");*/
        //To open the browser
        WebDriverManager.chromedriver().setup();
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new ChromeDriver();
//        driver = new FirefoxDriver();
//        driver = new EdgeDriver();
        //Open an url in the tab
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("Title of the page :: " +title);
        String url = driver.getCurrentUrl();
        System.out.println("Current URL :: " + url);
        WebElement element = driver.findElement(By.id("user-name"));
//        boolean displayed = element.isDisplayed();
        element.click();
        element.sendKeys("standard_user");
        element = driver.findElement(By.name("password"));
        element.click();
        element.sendKeys("secret_sauce");
        element = driver.findElement(By.className("submit-button"));
        element.click();
        boolean isMenuBarDisplayed = driver.findElement(By.id("react-burger-menu-btn")).isDisplayed();
        System.out.println("Menus bar is displayed or not :: " + isMenuBarDisplayed);
        boolean isProductLogoDisplayed = driver.findElement(By.className("title")).isDisplayed();
        System.out.println("Products image is displayed or not :: " + isProductLogoDisplayed);
        boolean isCheckoutButtonDisplayed = driver.findElement(By.className("shopping_cart_link")).isDisplayed();
        System.out.println("Checkout button is displayed or not :: " + isCheckoutButtonDisplayed);
        //To Maximize window
//        Thread.sleep(3000);
        //To close the window
        driver.quit();
    }
}
