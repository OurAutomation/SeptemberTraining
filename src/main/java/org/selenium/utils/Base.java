package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class Base {
    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    @BeforeClass
    public void beforeClass() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
        driver.manage().deleteAllCookies();
    }

    @AfterClass
    public void afterClass() {
//        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }
}
