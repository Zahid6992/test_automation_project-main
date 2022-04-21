package com.testCasesTestNG.Logout;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrierungLogoutLogin extends DriverTestCase {
    public String actualResult = "actual result";
    public String expectedResult = "expected result";
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void produktinwarenkorb(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF08_RegistrierungLogoutLogin";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(60000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(1000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.closeNotificationBlackWeek();
        loginPage.anmelden(shop, mobileOrDesktop);
        productListPage.URLDamenSchuhe(shop, environment);
        Thread.sleep(1000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(2000);
        homePage.closeNotificationRabatt();
        loginPage.closeNewsletterAbonnierenPopup();
        homePage.produktAuswahlenPLP(shop);
        homePage.closeNotificationRabatt();
        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, true);

        Thread.sleep(1000);
        registrationPage.warenkorbAnsehen(mobileOrDesktop);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(2000);
        registrationPage.clickOnAbmelden(mobileOrDesktop);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(5000);
        //loginPage.anmelden(shop);
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