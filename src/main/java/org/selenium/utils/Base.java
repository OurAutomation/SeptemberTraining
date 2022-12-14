package org.selenium.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;

public class Base {
    public WebDriver driver;

    //    @BeforeSuite(groups = {"sanity","regression","smoke"})
    @BeforeSuite(alwaysRun = true)
    @Parameters(value = {"environment", "browser"})
    public void beforeSuite(@Optional("QA") String environment, @Optional("chrome") String browser) {
        ObjectRepositoryUtils.loadProperties(environment);
        TestDataUtils.loadTestData(environment);
        EnvironmentUtils.loadEnvironmentData(environment);
    }

    @Parameters(value = {"browser"})
    @BeforeTest(alwaysRun = true)
    public void launchDriver(String browser) {
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

    @AfterTest(alwaysRun = true)
    public void shutDown() {
        driver.quit(); // to close the complete browser
        //driver.close(); // to close only one window
    }

    public void loadApplication() {
        driver.manage().deleteAllCookies();
        driver.get(EnvironmentUtils.getEnvironmentData("url"));
        driver.manage().deleteAllCookies();
    }
}
