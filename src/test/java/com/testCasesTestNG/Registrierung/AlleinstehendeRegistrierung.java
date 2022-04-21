package com.testCasesTestNG.Registrierung;

import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;



public class AlleinstehendeRegistrierung extends DriverTestCase {

    String actualResult = "";
    String expectedResult = "";

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        String testCaseName = "TF01_Alleinstehende_Registrierung";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
//        loginPage.closeNotificationBlackWeek();
        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(500) ;

        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "clicnewAccount")
    public void  creatAccountNew (String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password = "Test1234";
        formularLieferadresse.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);
        registrationPage.selectPolicy(shop, "false");
        Thread.sleep(2000) ;
        registrationPage.ClickOnRegister(shop);
        Thread.sleep(6000) ;
        Assert.assertEquals(true, registrationPage.verifyRegister());

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
