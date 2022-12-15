package org.selenium.utils;

import java.io.File;

public class Constants {
    public final static String PROJECT_HOME = System.getProperty("user.dir") + File.separator;
    public final static String MAIN_RESOURCES_PATH = PROJECT_HOME + "src" + File.separator + "main" + File.separator + "resources" + File.separator;
    public final static String FAILURE_SCREENSHOT_PATH = PROJECT_HOME + "FailureScreenshotFolder" + File.separator;
    public final static String OBJECT_REPOSITORY_PATH = MAIN_RESOURCES_PATH + File.separator + "ObjectRepository" + File.separator;
    public final static String TESTDATA_PATH = MAIN_RESOURCES_PATH + File.separator + "Testdata" + File.separator;
    public final static String ENVIRONMENT_PATH = MAIN_RESOURCES_PATH + File.separator + "Environment" + File.separator;

}
