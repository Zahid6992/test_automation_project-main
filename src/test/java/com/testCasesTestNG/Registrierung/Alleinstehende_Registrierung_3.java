package com.testCasesTestNG.Registrierung;

import com.utils.DriverTestCase;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Alleinstehende_Registrierung_3 extends DriverTestCase {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void createAccountTest(ITestContext context, String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {


        loginPage.mouseHoverOnRegisterIcon();
        loginPage.mouseHoverOnRegisterIcon();

        registrationPage.clickOnNewAccount(shop);
        registrationPage.selectGenderFrau();
        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = "TesterVorname";
        String nachname = "TesterNachname";
        String strasse = "Berlinerstrassse";
        String haunummer = "10";
        String stadt = "Berlin";
        String password = "Test1234";
        formularLieferadresse.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);
        registrationPage.selectPolicy(shop, "false");
        registrationPage.ClickOnRegister(shop);
        Thread.sleep(2000);


    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "createAccountTest")
    public void logout(ITestContext context, String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        loginPage.mouseHoverOnRegisterIcon();
        loginPage.mouseHoverOnRegisterIcon();

        registrationPage.clickOnNewAccount(shop);
        registrationPage.selectGenderFrau();

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = "TesterVorname";
        String nachname = "TesterNachname";
        String strasse = "Berlinerstrassse";
        String haunummer = "10";
        String stadt = "Berlin";
        String password = "Test1234";
        formularLieferadresse.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);
        registrationPage.selectPolicy(shop, "false");
        registrationPage.ClickOnRegister(shop);
        Thread.sleep(2000);

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