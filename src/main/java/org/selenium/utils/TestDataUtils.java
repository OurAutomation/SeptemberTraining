package org.selenium.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class TestDataUtils {
    static Properties properties = new Properties();

    public static void loadTestData(String environment) {
        File propertyFile = new File(Constants.TESTDATA_PATH + environment + File.separator + "testdata.properties");
        FileInputStream inStream = null;
        try {
            inStream = new FileInputStream(propertyFile);
            properties.load(inStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getTestData(String key) {
        return properties.getProperty(key);
    }
}
