package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import java.io.File;
import java.io.IOException;

public class ExtentReportConfig  extends DriverHelper {



    String path =  getPath();

    public ExtentReportConfig(WebDriver webdriver) {
        super(webdriver);
    }


    public void configureExtentReportBeforeTest(String testCaseName, String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter(System.getProperty("user.dir") + "/output/" + testCaseName + "_" + mobileOrDesktop + "_" + shop + "_" + environment + ".html");
        spark.config().setTheme(Theme.DARK);
//        spark.loadXMLConfig(new File(System.getProperty("user.dir") + "//src//main//java//com//config//spark-config.xml"));
//        spark.loadXMLConfig(new File(System.getProperty("user.dir") + "/src/main/java/com/config/spark-config.xml"));
//        spark.loadXMLConfig(new File(path + "//src//main//java//com//config//spark-config.xml"));
        spark.loadXMLConfig(new File(System.getProperty("user.dir") + "//src//main//java//com//config//spark-config.xml"));
        spark.config().setDocumentTitle("Extent Report Document Title");
        spark.config().setReportName("Test Automation Report");
        extent.attachReporter(spark);

        test = extent.createTest(testCaseName).assignAuthor("Oussama Benmahmoud").assignDevice(mobileOrDesktop + " " + deviceName);
    }

    public void configureExtentReportActualResultExpectedResult(String expectedResult, String actualResult) {

        test.info("Expected Result : " + expectedResult).info("Actual Result : " + actualResult);


    }

    public void configureExtentReportTestInfo(String testInfo) {

        test.info(testInfo);

    }


    public void configureExtentReportAfterTest(ITestResult result, String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException {


        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail("Test Failed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
            test.pass("Test Passed", MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64()).build());
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
            test.pass("Test Skipped");
        }

    }


    public void configureExtentReportTearDown() {

        extent.flush();

    }


    public String getBase64()
    {
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
    }

    public String getPath()
    {
        String path ="";
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
        return path;
    }



}
