package org.selenium.utils;

import org.openqa.selenium.By;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;
import java.util.Properties;

public class ObjectRepositoryUtils {
    static Properties properties = new Properties();

    public static void loadProperties(String environment) {
        File propertyFile = new File(Constants.OBJECT_REPOSITORY_PATH + environment + File.separator + "locator.properties");
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(propertyFile);
            properties.load(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static By getLocator(String key) {
        String[] locators = properties.getProperty(key).split(":", 2);
        String locatorType = locators[0];
        String locatorValue = locators[1];
        switch (locatorType.toLowerCase(Locale.ROOT)) {
            case "id":
                return By.id(locatorValue);
            case "class":
            case "classname":
                return By.className(locatorValue);
            case "name":
                return By.name(locatorValue);
            case "tag":
            case "tagname":
                return By.tagName(locatorValue);
            case "linktext":
                return By.linkText(locatorValue);
            case "partiallinktext":
                return By.partialLinkText(locatorValue);
            case "css":
            case "cssselector":
                return By.cssSelector(locatorValue);
            case "xpath":
                return By.xpath(locatorValue);
        }
        return null;
    }

}
