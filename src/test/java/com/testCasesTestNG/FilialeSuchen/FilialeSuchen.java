package com.testCasesTestNG.FilialeSuchen;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class FilialeSuchen extends DriverTestCase {

    String actualResult;
    String expectedResult;
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void Suchen(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TF14_FilialSuche";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        loginPage.mouseHoverOnFilialeSuchen();
        Thread.sleep(1000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(8000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        filialsuchePage.stadtSuchen(shop);
        Thread.sleep(2000);
        filialsuchePage.AufSuchenKlicken(shop);
        Thread.sleep(2000);
        filialsuchePage.Ergebniss();
        Thread.sleep(2000);
      //  filialsuchePage.filialeWait();

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
