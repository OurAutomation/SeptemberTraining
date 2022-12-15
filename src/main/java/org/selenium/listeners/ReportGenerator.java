package org.selenium.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.utils.ExceptionUtil;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.selenium.utils.Base;
import org.selenium.utils.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.Locale;

public class ReportGenerator implements ITestListener {
    public final static String PROJECT_HOME = System.getProperty("user.dir");
    private static String EXTENT_REPORT_FILE = PROJECT_HOME + File.separator + "NewExtentReports" + File.separator
            + "CompleteReport.html";
    private String EXTENT_REPORT_PATH = PROJECT_HOME + File.separator + "NewExtentReports" + File.separator
            + "SuiteWiseReports" + File.separator;
    private Logger log = LoggerFactory.getLogger(this.getClass().getSimpleName());
    public String filename;
    private static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(EXTENT_REPORT_FILE);
    private static ExtentHtmlReporter moduleWiseHTMLReporter;
    private ExtentReports extent = new ExtentReports();
    private ExtentReports moduleWiseExtent;
    public static ExtentTest logger;
    public static ExtentTest moduleWiseLogger;
    private String suiteName;
    private String methodParameters = "";
    Date startTime, endTime;
    private static boolean didOnTestStartGotExecuted = false;
    File failedScreenShotsFolder = new File(Constants.PROJECT_HOME + File.separator + "FailedScreenshots" + File.separator);

    @Override
    public void onTestFailure(ITestResult result) {
        try {
            endTime = new Date();
            String testName = result.getName();
            String base64OfScreenShot = "";
            File screenShot = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.FILE);
            File destination = new File(failedScreenShotsFolder.getAbsolutePath()+File.separator + testName + ".png");
            FileUtils.copyFile(screenShot, destination);
            base64OfScreenShot = ((TakesScreenshot) Base.driver).getScreenshotAs(OutputType.BASE64);
            logger.log(Status.INFO, "<img height=\"195\" width=\"195\" src='data:image/png;charset=utf-8;base64,"
                    + base64OfScreenShot
                    + "'  onmouseover=\"bigImg(this)\" onmouseout=\"normalImg(this)\"> Mouse Hover Here For Screenshot </img>"
                    + "<script> function bigImg(x) { x.style.height = \"500px\"; x.style.width = \"750px\";}  function normalImg(x)"
                    + " { x.style.height = \"195px\";  x.style.width = \"195px\";}</script>");
            moduleWiseLogger.log(Status.INFO,
                    "<img height=\"195\" width=\"195\" src='data:image/png;charset=utf-8;base64," + base64OfScreenShot
                            + "'  onmouseover=\"bigImg(this)\" onmouseout=\"normalImg(this)\"> Mouse Hover Here For Screenshot </img>"
                            + "<script> function bigImg(x) { x.style.height = \"500px\"; x.style.width = \"750px\";}  function normalImg(x)"
                            + " { x.style.height = \"195px\";  x.style.width = \"195px\";}</script>");
            log.error("\n\n " + testName + methodParameters + " test has failed \n\n");
            logger.log(Status.FAIL, "<b><i> Failure Message :: </b></i>" + result.getThrowable().getMessage());
            moduleWiseLogger.log(Status.FAIL,
                    "<b><i> Failure Message :: </b></i>" + result.getThrowable().getMessage());
            logger.log(Status.FAIL, "<div><b><i> Stacktrace :: </b></i></div><div><textarea>"
                    + ExceptionUtil.getStackTrace(result.getThrowable()) + "</textarea></div>");
            moduleWiseLogger.log(Status.FAIL, "<div><b><i> Stacktrace :: </b></i></div><div><textarea>"
                    + ExceptionUtil.getStackTrace(result.getThrowable()) + "</textarea></div>");
            logger.log(Status.INFO, "Total time taken for test case to execute :: "
                    + ((endTime.getTime() - startTime.getTime()) / 1000) + " Seconds");
            moduleWiseLogger.log(Status.INFO, "Total time taken for test case to execute :: "
                    + ((endTime.getTime() - startTime.getTime()) / 1000) + " Seconds");
            extent.flush();
            moduleWiseExtent.flush();
        } catch (Exception e) {
            log.error("After test failure things are getting failed due to  :: " + e.getMessage());
        } finally {
            didOnTestStartGotExecuted = false;
        }
    }

    public void onFinish(ITestContext context) {
        log.info("----------------------------------------------------------------------------------------\n");
        log.info("****************************************************************************************\n");
    }

    @Override
    public void onTestStart(ITestResult result) {
        didOnTestStartGotExecuted = true;
        String testName = result.getName();
        Object[] params = result.getParameters();
        methodParameters = convertParametersArrayToString(params);
        log.info("\n\n" + "<< --- TestCase START --->> " + testName + methodParameters + "\n");
        logger = extent.createTest(testName + methodParameters);
        logger.assignCategory(suiteName);
        logger.log(Status.INFO, "<b><i>Test Case Name :: </b></i>\"" + testName + "\"");
        logger.log(Status.INFO,
                "<b><i>Description of the test :: </b></i> \"" + result.getMethod().getDescription() + "\"");
        moduleWiseLogger = moduleWiseExtent.createTest(testName + methodParameters);
        moduleWiseLogger.assignCategory(suiteName);
        moduleWiseLogger.log(Status.INFO, "<b><i>Test Case Name :: </b></i>\"" + testName + "\"");
        moduleWiseLogger.log(Status.INFO,
                "<b><i>Description of the test :: </b></i> \"" + result.getMethod().getDescription() + "\"");
        startTime = new Date();
        filename = testName;
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        endTime = new Date();
        String testName = result.getName();
        log.info("\n\n TestCase: " + testName + methodParameters + ": --->>> PASS \n");
        logger.log(Status.INFO, "Total time taken for test case to execute :: "
                + ((endTime.getTime() - startTime.getTime()) / 1000) + " Seconds");
        logger.log(Status.PASS, testName + methodParameters + " test has passed");
        moduleWiseLogger.log(Status.INFO, "Total time taken for test case to execute :: "
                + ((endTime.getTime() - startTime.getTime()) / 1000) + " Seconds");
        moduleWiseLogger.log(Status.PASS, testName + methodParameters + " test has passed");
        extent.flush();
        moduleWiseExtent.flush();
        didOnTestStartGotExecuted = false;
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getName();
        if (!didOnTestStartGotExecuted) {
            logger = extent.createTest(testName + methodParameters);
            logger.assignCategory(suiteName);
            moduleWiseLogger = moduleWiseExtent.createTest(testName + methodParameters);
            moduleWiseLogger.assignCategory(suiteName);
        }
        logger.log(Status.INFO,
                "<b><i>Description of the test :: </b></i>\"" + result.getMethod().getDescription() + "\"");
        logger.log(Status.SKIP, testName + methodParameters + " test skipped due to :: "
                + ExceptionUtil.getStackTrace(result.getThrowable()));
        moduleWiseLogger.log(Status.INFO,
                "<b><i>Description of the test :: </b></i>\"" + result.getMethod().getDescription() + "\"");
        moduleWiseLogger.log(Status.SKIP, testName + methodParameters + " test skipped due to :: "
                + ExceptionUtil.getStackTrace(result.getThrowable()));
        log.info("\n\n TestCase: " + testName + methodParameters + ": --->>> SKIPPED");
        extent.flush();
        moduleWiseExtent.flush();
        didOnTestStartGotExecuted = false;
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        log.info("\n\n TestCase: " + result.getName() + ": --->>> FAILED With percentage");
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("****************************************************************************************");
        log.info("                                " + context.getName() + "       ");
        log.info("----------------------------------------------------------------------------------------");
        File extentReports = new File(EXTENT_REPORT_PATH);
        if (!extentReports.exists()) {
            extentReports.mkdirs();
        }

        if (!failedScreenShotsFolder.exists()) {
            failedScreenShotsFolder.mkdirs();
        }
        extent.attachReporter(htmlReporter);
        htmlReporter.config().setDocumentTitle("Automation Report");
        htmlReporter.config().setReportName("Automation Report");
        htmlReporter.config().setTheme(Theme.DARK);
        suiteName = capitalizeTheFirstCharacterOfEveryWordInTheString(context.getName());
        moduleWiseHTMLReporter = null;
        moduleWiseExtent = null;
        moduleWiseExtent = new ExtentReports();
        moduleWiseHTMLReporter = new ExtentHtmlReporter(
                EXTENT_REPORT_PATH + File.separator + suiteName.replace(":", "") + " Report.html");
        moduleWiseExtent.attachReporter(moduleWiseHTMLReporter);
        moduleWiseHTMLReporter.config().setDocumentTitle(suiteName + " Automation Report");
        moduleWiseHTMLReporter.config().setReportName(suiteName + " Automation Report");
        moduleWiseHTMLReporter.config().setTheme(Theme.STANDARD);
    }

    public String seperateStringInCamelCase(String string) {
        try {
            return capitalizeTheFirstWord(
                    StringUtils.join(StringUtils.splitByCharacterTypeCamelCase(string), " ").trim());
        } catch (Exception e) {
            return string;
        }
    }

    public String capitalizeTheFirstWord(String name) {
        String s1 = name.substring(0, 1).toUpperCase();
        String nameCapitalized = s1 + name.substring(1);
        return nameCapitalized;
    }

    public static String imgToBase64String(final RenderedImage img, final String formatName) {
        final ByteArrayOutputStream os = new ByteArrayOutputStream();
        try {
            ImageIO.write(img, formatName, Base64.getEncoder().wrap(os));
            return os.toString(StandardCharsets.ISO_8859_1.name());
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    public static BufferedImage base64StringToImg(final String base64String) {
        try {
            return ImageIO.read(new ByteArrayInputStream(Base64.getDecoder().decode(base64String)));
        } catch (final IOException ioe) {
            throw new UncheckedIOException(ioe);
        }
    }

    public String capitalizeTheFirstCharacterOfEveryWordInTheString(String s) {
        String[] split = s.split("\\s+");
        String modifiedString = "";
        for (String s1 : split) {
            modifiedString += s1.substring(0, 1).toUpperCase(Locale.ROOT) + s1.substring(1) + " ";
        }
        return modifiedString.substring(0, modifiedString.length() - 1);
    }

    public String convertParametersArrayToString(Object[] arr) {
        if (arr.length == 0) {
            return "";
        }
        String parameters = "  Parameters( ";
        for (Object a : arr) {
            parameters += a + ", ";
        }
        return parameters.substring(0, parameters.length() - 2) + " )";
    }

}
