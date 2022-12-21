package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Optional;

import java.time.Duration;
import java.util.*;

public class SeleniumUtils extends StringUtils {
    static WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());

    public void waitUntilElementIsVisible(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        } catch (Exception e) {
            log.error("Unable to wait until element is visible for locator :: " + by + " due to " + e.getMessage());
            Assert.fail("Unable to wait until element is visible for locator :: " + by + " due to " + e.getMessage());
        }
    }

    public static void launchDriver(@Optional("chrome") String browser) {
        switch (browser.toLowerCase(Locale.ROOT)) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                ChromeOptions chromeOptions = new ChromeOptions();
                /*chromeOptions.addArguments("start-maximized");
                chromeOptions.addArguments("--incognito");*/
//        chromeOptions.addArguments("--user-data-dir=C:\\Users\\Sravan\\AppData\\Local\\Google\\Chrome\\User Data");
                chromeOptions.setExperimentalOption("useAutomationExtension", false);
                /*chromeOptions.setExperimentalOption("excludeSwitches",
                        Collections.singletonList("enable-automation"));*/
                chromeOptions = new ChromeOptions();
                chromeOptions.addArguments("--disable-features=EnableEphemeralFlashPermission");

                // adding basic desired capabilities of chrome
                HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
                chromePrefs.put("profile.default_content_setting_values.plugins", 1);
                chromePrefs.put("profile.content_settings.plugin_whitelist.adobe-flash-player", 1);
                chromePrefs.put("profile.content_settings.exceptions.plugins.*,*.per_resource.adobe-flash-player", 1);

                chromePrefs.put("PluginsAllowedForUrls",
                        "");

                // Enable Flash for this site

                // Disable the content related popup blocking
                chromePrefs.put("profile.default_content_settings.popups", 1);
                // enable safe browsing
                // chromePrefs.put("safebrowsing.enabled", "true");
                // setting default download directory path
//        chromePrefs.put("download.default_directory", Constants.HTTP_DOWNLOAD_PATH);
                chromePrefs.put("profile.content_settings.exceptions.automatic_downloads.*.setting", 1);
                chromePrefs.put("download.prompt_for_download", false);
                chromePrefs.put("profile.default_content_setting_values.notifications", 1);
                chromePrefs.put("webkit.webprefs.allow_running_insecure_content", 1);
                // chromePrefs.put("excludeSwitches","disable-component-update");
                // C:\Users\BHARGH~1.KON\AppData\Local\Temp\scoped_dir2672_6708\pnacl\0.57.44.2492\_platform_specific\x86_64
                // chromeOptions.addArguments("--pnacl-dir=C:\\Users\\BHARGH~1.KON\\AppData\\Local\\Temp\\scoped_dir2672_6708\\pnacl\\0.57.44.2492\\_platform_specific\\x86_64");
                chromeOptions.setExperimentalOption("prefs", chromePrefs);
       /* if (gridValue) {
            // open browser in kiosk (maximized) mode in remote machine
            chromeOptions.addArguments("--kiosk");
        }*/
//                chromeOptions.addArguments("disable-automation");
                // To disable all the certificate errors
                chromeOptions.addArguments("-test-type");
                // To open the browser in incognito mode
                chromeOptions.addArguments("--disable-notifications");
                chromeOptions.addArguments("--incognito");
                // openbrowser maximized state
                chromeOptions.addArguments("start-maximized");
                // Always allow the authorized plugins
                chromeOptions.addArguments("--always-authorize-plugins=true");
                chromeOptions.addArguments("--enable-automation");
                // enable native client
                // chromeOptions.addArguments("--enable-npapi");
                chromeOptions.addArguments("-enable-pnacl");
                // chromeOptions.addArguments("--enable-pnacl");
                // chromeOptions.addArguments("enable-pnacl");
                chromeOptions.addArguments("-enable-nacl");
                // chromeOptions.addArguments("--enable-nacl");
                // Disable popup blocking
                chromeOptions.addArguments("-disable-popup-blocking=true");
//        chromeOptions.addArguments("user-data-dir=" + Constants.USERDATA_TEMP_FOLDER_PATH + tempFolderName);
//        chromeOptions.addExtensions(new File(Constants.EXTENSION_CRX));
                // Disable all the extensions
                // chromeOptions.addArguments("chrome.switches", "--disable-extensions");
                // Don't show any infobars in the browser
                chromeOptions.addArguments("disable-infobars");
                chromeOptions.setCapability(ChromeOptions.CAPABILITY, chromeOptions);
                // always accept secure socket layer alerts
                chromeOptions.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                chromeOptions.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
//        chromeOptions.addExtensions(new File("D:\\cucumber\\JulyTraining\\AdBlockExtension.crx"));
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            case "safari":
                WebDriverManager.safaridriver().setup();
                driver = new SafariDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public void waitUntilElementIsVisible(WebElement element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            log.error("Unable to wait until element is visible for locator :: " + element + " due to " + e.getMessage());
            Assert.fail("Unable to wait until element is visible for locator :: " + element + " due to " + e.getMessage());
        }
    }

    public void click(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(by));
            scroll(by);
            element.click();
        } catch (StaleElementReferenceException e) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.elementToBeClickable(by)).click();
        } catch (Exception e) {
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

    public void loadApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentUtils.getEnvironmentData("url"));
        driver.manage().deleteAllCookies();
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
            Actions actions = new Actions(driver);
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
            Actions actions = new Actions(driver);
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
            log.info("Element with locator :: " + by + " is not displayed");
            return false;
        } catch (Exception e) {
            log.error("Unable to verify Element with locator :: " + by + " is displayed or not due to :: " + e.getMessage());
            Assert.fail("Unable to verify Element with locator :: " + by + " is displayed or not due to :: " + e.getMessage());
        }
        return false;
    }

    public void dragAndDrop(By source, By destination) {
        waitUntilElementIsVisible(source);
        Actions actions = new Actions(driver);
        actions.dragAndDrop(findElement(source), findElement(destination)).perform();
    }

    public void mouseHover(By by) {
        waitUntilElementIsVisible(by);
        scroll(by);
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).perform();
    }

    public WebElement findElement(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            return wait.until(ExpectedConditions.presenceOfElementLocated(by));
        } catch (Exception e) {
            Assert.fail("We are not able to find the element with locator :: " + by.toString() + " due to " + e.getMessage());
        }
        return null;
    }

    public List<WebElement> findElements(By by) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
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

    public static void closeDriver() {
        driver.quit();
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
