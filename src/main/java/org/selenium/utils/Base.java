package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {
    public WebDriver driver;

//    @BeforeSuite(groups = {"sanity","regression","smoke"})
    @BeforeSuite(alwaysRun = true)
    public void beforeSuite() {
        WebDriverManager.chromedriver().setup();
        ObjectRepositoryUtils.loadProperties("QA");
        TestDataUtils.loadTestData("QA");
        EnvironmentUtils.loadEnvironmentData("QA");
    }

    @AfterTest(alwaysRun = true)
    public void afterSuite() {
        driver.quit();
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTest() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        loadApplication();
    }

    public void loadApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentUtils.getEnvironmentData("url"));
        driver.manage().deleteAllCookies();
    }
}
