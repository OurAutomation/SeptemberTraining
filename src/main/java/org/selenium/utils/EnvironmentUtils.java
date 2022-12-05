package org.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class EnvironmentUtils {
    static Properties properties = new Properties();

    public static void loadEnvironmentData(String environment) {
        File propertyFile = new File(Constants.ENVIRONMENT_PATH + environment + "environment.properties");
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(propertyFile);
            properties.load(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getEnvironmentData(String key) {
        return properties.getProperty(key);
    }
}
