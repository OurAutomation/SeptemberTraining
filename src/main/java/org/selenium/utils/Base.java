package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class Base {
    public static WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        ObjectRepositoryUtils.loadProperties("QA");
        TestDataUtils.loadTestData("QA");
        EnvironmentUtils.loadEnvironmentData("QA");
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        loadApplication();
    }

    @AfterClass
    public void afterClass() {
//        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    public void loadApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentUtils.getEnvironmentData("url"));
        driver.manage().deleteAllCookies();
    }
}
