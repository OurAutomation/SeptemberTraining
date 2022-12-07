package org.selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumUtils {
    WebDriver driver;
    WebDriverWait wait;

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void waitUntilElementIsVisible(By by) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By by) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
        scroll(by);
        element.click();
    }

    public void clear(By by) {
        click(by);
        findElement(by).clear();
    }

    public void sendKeys(By by, String value) {
        clear(by);
        findElement(by).sendKeys(value);
    }

    public void scroll(By by) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", findElement(by));
    }

    public void scroll(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void doubleClick(By by) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(by);
        scroll(by);
        actions.doubleClick(findElement(by)).perform();
    }

    public void rightClick(By by) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(by);
        scroll(by);
        actions.contextClick(findElement(by)).perform();
    }

    public String getText(By by) {
        waitUntilElementIsVisible(by);
        scroll(by);
        return findElement(by).getText();
    }

    public String getText(WebElement element) {
        waitUntilElementIsVisible(element);
        scroll(element);
        return element.getText();
    }

    public List<String> getText(List<WebElement> elements) {
        List<String> allTexts = new ArrayList<>();
        for (WebElement element : elements) {
            waitUntilElementIsVisible(element);
            scroll(element);
            allTexts.add(element.getText());
        }
        return allTexts;
    }

    public boolean isDisplayed(By by) {
        try {
            return findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void dragAndDrop(By source, By destination) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(source);
        actions.dragAndDrop(findElement(source), findElement(destination)).perform();
    }

    public void mouseHover(By by) {
        Actions actions = new Actions(driver);
        waitUntilElementIsVisible(by);
        actions.moveToElement(findElement(by)).perform();
    }

    public WebElement findElement(By by) {
        try {
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("We are not able to find the element with locator :: " + by.toString() + " due to " + e.getMessage());
        }
        return null;
    }

    public List<WebElement> findElements(By by) {
        try {
            return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
        } catch (Exception e) {
            Assert.fail("We are not able to find the element with locator :: " + by.toString() + " due to " + e.getMessage());
        }
        return null;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public String getPresentWindowHandle() {
        return driver.getWindowHandle();
    }

    public Set<String> getWindowHandles() {
        return driver.getWindowHandles();
    }

    public void switchToWindow(String windowHandle) {
        driver.switchTo().window(windowHandle);
    }

    public void closeTheTab(String windowHandle) {
        switchToWindow(windowHandle);
       driver.close();
    }

    public void openNewTab() {
        driver.switchTo().newWindow(WindowType.TAB);
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void navigateBackward() {
        driver.navigate().back();
    }

    public void refresh() {
        driver.navigate().refresh();
    }

    public void navigateTo(String url) {
        driver.navigate().to(url);
    }

    public void openNewWindow() {
        driver.switchTo().newWindow(WindowType.WINDOW);
    }

    public void switchToFrame(String idOrName) {
        try {
            driver.switchTo().frame(idOrName);
        } catch (Exception e) {
            Assert.fail("Unable to switch to frame :: " + idOrName + " due to " + e.getMessage());
        }
    }

    public void switchToFrame(int index) {
        driver.switchTo().frame(index);
    }

    public void switchToFrame(WebElement element) {
        driver.switchTo().frame(element);
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void select(By by, String visibleText) {
        waitUntilElementIsVisible(by);
        Select select = new Select(findElement(by));
        select.selectByVisibleText(visibleText);
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
