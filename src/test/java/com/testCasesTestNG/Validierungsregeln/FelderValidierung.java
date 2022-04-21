package com.testCasesTestNG.Validierungsregeln;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class FelderValidierung extends DriverTestCase {
    String actualResult;
    String expectedResult;


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void Validierung(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF03_Validierungregeln_von_Formularen";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.mouseHoverOnRegisterIcon();
        // registrationPage.clickONOK();
        Thread.sleep(20000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();

//        loginPage.closeNotificationBlackWeek();
        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(2000);
        formularLieferadresse.postalCode(shop);
        Thread.sleep(500);
        formularLieferadresse.clearFelds();
        Thread.sleep(500);
        registrationPage.selectPolicy(shop, "false");
        Thread.sleep(500);
        registrationPage.ClickOnRegister(shop);
        Thread.sleep(1000);
        registrationPage.RoteFelderwait(shop);
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
