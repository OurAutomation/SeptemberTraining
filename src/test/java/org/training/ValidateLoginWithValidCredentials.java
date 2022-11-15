package org.training;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
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
        //To Maximize window
        driver.manage().window().maximize();
        Thread.sleep(3000);
        //To close the window
        driver.quit();
    }
}
