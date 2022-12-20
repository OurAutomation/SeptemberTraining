package org.selenium.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SeleniumUtils extends StringUtils {
    WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public SeleniumUtils(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }

    public void waitUntilElementIsVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error("Unable to wait until element is visible for locator :: " + by + " due to " + e.getMessage());
            Assert.fail("Unable to wait until element is visible for locator :: " + by + " due to " + e.getMessage());
        }
    }

    public void waitUntilElementIsVisible(WebElement element) {
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error("Unable to wait until element is visible for locator :: " + element + " due to " + e.getMessage());
            Assert.fail("Unable to wait until element is visible for locator :: " + element + " due to " + e.getMessage());
        }
    }

    public void click(By by) {
        try {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            scroll(by);
            element.click();
        } catch (StaleElementReferenceException e){
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch(Exception e) {
            log.error("Unable to click on element due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to click on element due to :: " + e.getMessage() + " with locator " + by);
        }
    }

    public void clear(By by) {
        try {
            click(by);
            findElement(by).clear();
        } catch (Exception e) {
            log.error("Unable to clear on element due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to clear on element due to :: " + e.getMessage() + " with locator " + by);
        }
    }

    public void sendKeys(By by, String value) {
        try {
            clear(by);
            findElement(by).sendKeys(value);
        } catch (Exception e) {
            log.error("Unable to send keys for locator :: " + by + " due to " + e.getMessage());
            Assert.fail("Unable to send keys for locator :: " + by + " due to " + e.getMessage());
        }
    }

    public void scroll(By by) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", findElement(by));
        } catch (Exception e) {
            log.error("Unable to scroll to element due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to scroll to element due to :: " + e.getMessage() + " with locator " + by);
        }
    }

    public void scroll(WebElement element) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
        } catch (Exception e) {
            log.error("Unable to scroll to element due to :: " + e.getMessage() + " with locator " + element);
            Assert.fail("Unable to scroll to element due to :: " + e.getMessage() + " with locator " + element);
        }
    }

    public void doubleClick(By by) {
        try {
            waitUntilElementIsVisible(by);
            scroll(by);
            actions.doubleClick(findElement(by)).perform();
        } catch (Exception e) {
            log.error("Unable to double click on element due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to double click on element due to :: " + e.getMessage() + " with locator " + by);
        }
    }

    public void rightClick(By by) {
        try {
            waitUntilElementIsVisible(by);
            scroll(by);
            actions.contextClick(findElement(by)).perform();
        } catch (Exception e) {
            log.error("Unable to right click on element due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to right click on element due to :: " + e.getMessage() + " with locator " + by);
        }
    }

    public String getAttribute(By locator, String attributeName) {
        try {
            return findElement(locator).getAttribute(attributeName);
        } catch (Exception e) {
            log.error("Unable to get attribute :: " + attributeName + " of the element :: " + locator + " due to :: " + e.getMessage() + " with locator " + locator);
            Assert.fail("Unable to get attribute :: " + attributeName + " of the element :: " + locator + " due to :: " + e.getMessage() + " with locator " + locator);
        }
        return null;
    }

    public String getAttribute(WebElement element, String attributeName) {
        try {
            return element.getAttribute(attributeName);
        } catch (Exception e) {
            log.error("Unable to get attribute :: " + attributeName + " of the element :: " + element + " due to :: " + e.getMessage() + " with locator " + element);
            Assert.fail("Unable to get attribute :: " + attributeName + " of the element :: " + element + " due to :: " + e.getMessage() + " with locator " + element);
        }
        return null;
    }

    public String getText(By by) {
        try {
            waitUntilElementIsVisible(by);
            scroll(by);
            return findElement(by).getText();
        } catch (Exception e) {
            log.error("Unable to get the text of the element :: " + by + " due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to get the text of the element :: " + by + " due to :: " + e.getMessage() + " with locator " + by);
        }
        return null;
    }

    public String getTextOfTheButton(By by) {
        try {
            return getAttribute(by, "value");
        } catch (Exception e) {
            log.error("Unable to get the text of the button :: " + by + " due to :: " + e.getMessage() + " with locator " + by);
            Assert.fail("Unable to get the text of the button :: " + by + " due to :: " + e.getMessage() + " with locator " + by);
        }
        return null;
    }

    public String getText(WebElement element) {
        try {
            waitUntilElementIsVisible(element);
            scroll(element);
            return element.getText();
        } catch (Exception e) {
            log.error("Unable to get the text of the element :: " + element + " due to :: " + e.getMessage() + " with locator " + element);
            Assert.fail("Unable to get the text of the element :: " + element + " due to :: " + e.getMessage() + " with locator " + element);
        }
        return null;
    }

    public List<String> getText(List<WebElement> elements) {
        try {
            List<String> allTexts = new ArrayList<>();
            for (WebElement element : elements) {
                waitUntilElementIsVisible(element);
                scroll(element);
                allTexts.add(element.getText());
            }
            return allTexts;
        } catch (Exception e) {
            log.error("Unable to get the text of the elements due to :: " + e.getMessage());
            Assert.fail("Unable to get the text of the elements due to :: " + e.getMessage());
        }
        return null;
    }

    public boolean isDisplayed(By by) {
        try {
            return driver.findElement(by).isDisplayed();
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            log.info("Element with locator :: " + by + " is not displayed");
            return false;
        } catch (Exception e ) {
            log.error("Unable to verify Element with locator :: " + by + " is displayed or not due to :: "+ e.getMessage());
            Assert.fail("Unable to verify Element with locator :: " + by + " is displayed or not due to :: "+ e.getMessage());
        }
        return false;
    }

    public void dragAndDrop(By source, By destination) {
        waitUntilElementIsVisible(source);
        actions.dragAndDrop(findElement(source), findElement(destination)).perform();
    }

    public void mouseHover(By by) {
        waitUntilElementIsVisible(by);
        scroll(by);
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
            log.error("We are not able to find the element with locator :: " + by.toString() + " due to " + e.getMessage());
            Assert.fail("We are not able to find the element with locator :: " + by.toString() + " due to " + e.getMessage());
        }
        return null;
    }

    public int getSize(By locator) {
        try {
            return findElements(locator).size();
        } catch (Exception e) {
            return 0;
        }
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
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

    public void select(By by, String visibleText) {
        waitUntilElementIsVisible(by);
        Select select = new Select(findElement(by));
        select.selectByVisibleText(visibleText);
    }

    public String getSelectedOption(By by) {
        waitUntilElementIsVisible(by);
        Select select = new Select(findElement(by));
        return select.getFirstSelectedOption().getText();
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

    public void switchToParentFrame() {
        driver.switchTo().parentFrame();
    }

    public void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }

    public void hardWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
