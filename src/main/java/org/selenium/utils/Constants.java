package org.selenium.utils;

import java.io.File;

public class Constants {
    final static String PROJECT_HOME = System.getProperty("user.dir") + File.separator;
    final static String MAIN_RESOURCES_PATH = PROJECT_HOME + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    final static String OBJECT_REPOSITORY_PATH = MAIN_RESOURCES_PATH + File.separator + "ObjectRepository" + File.separator;
    final static String TESTDATA_PATH = MAIN_RESOURCES_PATH + File.separator + "Testdata" + File.separator;
    final static String ENVIRONMENT_PATH = MAIN_RESOURCES_PATH + File.separator + "Environment" + File.separator;

}
