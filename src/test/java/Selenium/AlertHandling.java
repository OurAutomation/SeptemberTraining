package Selenium;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.selenium.utils.Base;
import org.selenium.utils.SeleniumUtils;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AlertHandling extends Base {
    SeleniumUtils seleniumUtils;

    @BeforeClass
    public void navigate() {
        seleniumUtils = new SeleniumUtils(driver);
        driver.get("https://demo.automationtesting.in/Register.html");
        seleniumUtils.mouseHover(By.xpath("//a[@class=\"dropdown-toggle\" and text()=\"SwitchTo\"]"));
        seleniumUtils.findElement(By.xpath("//a[text()=\"Alerts\"]")).click();
    }

    @Test
    public void validateAlert() {
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id=\"aswift_2\"]")));
        driver.switchTo().frame("ad_iframe");
        seleniumUtils.findElement(By.xpath("//*[text()=\"Close\"]")).click();
        driver.switchTo().defaultContent();


        driver.findElement(By.cssSelector("[onclick='alertbox()']")).click();
        Alert alert = driver.switchTo().alert();
        log.info("Text displayed on the alert is :: " + alert.getText());
        alert.accept();// It will click on okay button
        //alert.dismiss();// it will click on cancel button
        //alert.sendKeys(); // It will send the string in input box

        driver.findElement(By.cssSelector("[href=\"#CancelTab\"]")).click();
        driver.findElement(By.cssSelector("[onclick=\"confirmbox()\"]")).click();

        alert = driver.switchTo().alert();
        alert.accept();
        driver.findElement(By.cssSelector("[href=\"#CancelTab\"]")).click();
        driver.findElement(By.cssSelector("[onclick=\"confirmbox()\"]")).click();
        alert = driver.switchTo().alert();
        alert.dismiss();
        seleniumUtils.findElement(By.xpath("//*[@href=\"#Textbox\"]")).click();
        seleniumUtils.findElement(By.xpath("//*[@onclick=\"promptbox()\"]")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Bharghav");
        alert.accept();
        seleniumUtils.findElement(By.xpath("//*[@href=\"#Textbox\"]")).click();
        seleniumUtils.findElement(By.xpath("//*[@onclick=\"promptbox()\"]")).click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Bharghav");
        alert.dismiss();
    }

}
