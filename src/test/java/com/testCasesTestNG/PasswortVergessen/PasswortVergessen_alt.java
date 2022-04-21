package com.testCasesTestNG.PasswortVergessen;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class PasswortVergessen_alt extends DriverTestCase{

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public  void passvergessen(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF09_PasswortVergessen"   + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        loginPage.mouseHoverOnRegisterIcon();

        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(1000);
        loginPage.closeNewsletterAbonnierenPopup();
        registrationPage.passwortvergessen();
        String passwordVergessenEmail = propertyReader.readApplicationFile("EmailForPasswordVergessen");
        registrationPage.enterPassvergessenmail(passwordVergessenEmail);
        Thread.sleep(2000);
        registrationPage.ResetMyMail();
        Thread.sleep(2000);

        //this.driver.get("https://www.deichmann.com/de-de/login");
        Thread.sleep(20000);
        //registrationPage.waitAufErfolgreich();
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
