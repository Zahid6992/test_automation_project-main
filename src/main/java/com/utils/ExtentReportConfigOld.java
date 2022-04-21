/*
package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

public class ExtentReportConfigOld extends DriverHelper {

    ExtentHtmlReporter htmlReporter;
    ExtentReports extent;
    ExtentTest test;

    public ExtentReportConfigOld(WebDriver webdriver) {
        super(webdriver);
    }

    public void configureExtentReportBeforeTest(String testCaseName, String mobileOrDesktop, String deviceName, String shop, String environment) {
        testCaseName = testCaseName + "_" + mobileOrDesktop + "_" + shop + "_" + environment;
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/output/" + testCaseName + "_" + mobileOrDesktop + "_" + shop + "_" + environment + ".html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("mobileOrDesktop", mobileOrDesktop);
        extent.setSystemInfo("deviceName", deviceName);
        extent.setSystemInfo("shop", shop);
        extent.setSystemInfo("environment", environment);
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("Extent Report Demo");
        htmlReporter.config().setReportName("Test Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setTimeStampFormat("EEEE, MMMM dd, yyyy, hh:mm a '('zzz')'");
        test = extent.createTest(testCaseName, "Regression Test Case");
    }


    public void configureExtentReportAfterTest(ITestResult result, String mobileOrDesktop, String deviceName, String shop, String environment) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " FAILED ", ExtentColor.RED));
            test.fail(result.getThrowable());

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " PASSED ", ExtentColor.GREEN));
        } else {
            test.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " SKIPPED ", ExtentColor.ORANGE));
            test.skip(result.getThrowable());
        }

    }


    public void configureExtentReportTearDown() {

        extent.flush(*/
/**//*
);
    }


}
*/
