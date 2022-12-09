package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {
    public WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        ObjectRepositoryUtils.loadProperties("QA");
        TestDataUtils.loadTestData("QA");
        EnvironmentUtils.loadEnvironmentData("QA");
    }

    @AfterTest
    public void afterSuite() {
        driver.quit();
    }

    @BeforeTest
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        loadApplication();
    }

    public void loadApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentUtils.getEnvironmentData("url"));
        driver.manage().deleteAllCookies();
    }
}
