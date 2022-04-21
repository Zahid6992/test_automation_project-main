package com.testCasesTestNG.Kontaktformular;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Kontaktformular extends DriverTestCase {
    String actualResult = "";
    String expectedResult = "";


    String loginUserName;
    String loginPassword;
    private Kontaktformular Kontaktformular_xpath;

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void Kontaktformular(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF15_Kontaktformular_" + "_" + mobileOrDesktop + "_" + shop + "_" + environment;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        Thread.sleep(8000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(500);
        //homePage.clickOnCookiesOkayButton();
        kontaktFormular.kontaktformularAusfuellen(shop, environment, mobileOrDesktop);
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
