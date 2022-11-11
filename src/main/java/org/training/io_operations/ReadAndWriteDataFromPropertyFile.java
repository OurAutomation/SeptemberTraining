package org.training.io_operations;

import java.io.*;
import java.util.Properties;

public class ReadAndWriteDataFromPropertyFile {
    public static void main(String[] args) throws IOException {
        File propertyFile = new File(FileUtilsData.PROJECT_HOME + File.separator + "Data.properties");
        Properties properties = new Properties();
        FileInputStream inStream = new FileInputStream(propertyFile);
        properties.load(inStream);
        System.out.println(properties.getProperty("firstname"));
        System.out.println(properties.getProperty("number"));
        System.out.println(properties.getProperty("address"));
        inStream.close();
        properties.setProperty("testing", "12222");
        properties.setProperty("main", "122");
        properties.setProperty("abcd", "abcd1223");
        FileOutputStream fileOutputStream = new FileOutputStream(FileUtilsData.PROJECT_HOME + File.separator + "Data.properties");
        properties.store(fileOutputStream, "");
        fileOutputStream.close();
    }
}
