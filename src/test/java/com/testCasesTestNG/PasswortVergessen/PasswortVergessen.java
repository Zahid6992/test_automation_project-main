package com.testCasesTestNG.PasswortVergessen;

import com.gmail.GmailApi;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class PasswortVergessen extends DriverTestCase{
    String actualResult;
    String expectedResult;
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public  void passvergessen(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, GeneralSecurityException, IOException {
        String testCaseName = "TF09_PasswortVergessen";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(1000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(1000);
       loginPage.closeNewsletterAbonnierenPopup();
//        loginPage.closeNotificationBlackWeek();
        registrationPage.passwortvergessen();
        registrationPage.enterPassvergessenmail("test.automation.deichmann@gmail.com");
        Thread.sleep(2000);
        registrationPage.ResetMyMail();
        Thread.sleep(20000);
        registrationPage.ResetMyMailClose();
        Thread.sleep(50000);
        GmailApi.getGmailService();
        String passwordvergessen = GmailApi.getMailBody("deichmann", shop);
        loginPage.anmeldenNachPasswordVergessen("test.automation.deichmann@gmail.com", passwordvergessen, shop, mobileOrDesktop);
        Thread.sleep(5000);
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
