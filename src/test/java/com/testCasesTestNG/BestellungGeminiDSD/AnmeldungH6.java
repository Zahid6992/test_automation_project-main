package com.testCasesTestNG.BestellungGeminiDSD;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class AnmeldungH6 extends DriverTestCase  {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void anmelden(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "Anmelden"   + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(3000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.anmeldenH6(shop, mobileOrDesktop);
        Thread.sleep(4000);
        loginPage.meinBestellungen();


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