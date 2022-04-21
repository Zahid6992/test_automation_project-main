package com.testCasesTestNG.Anmeldung;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Alleinstehende_Anmeldung extends DriverTestCase  {
    public String actualResult = "actual result";
    public String expectedResult = "expected result";
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void anmelden(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF06_Anmelden";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(20000);
//        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
//        loginPage.closeNotificationBlackWeek();
        loginPage.anmelden(shop, mobileOrDesktop);
        Thread.sleep(4000);
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @AfterMethod
    public void getResult(ITestResult result, String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException {

        extentReportConfig.configureExtentReportAfterTest(result, mobileOrDesktop, deviceName, shop, environment);
    }

    @AfterTest
    public void tearDown() {

        extentReportConfig.configureExtentReportTearDown();
    }


}