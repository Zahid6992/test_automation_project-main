package com.testCasesTestNG.Adressen;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class Lieferadresse_aendern_my_account extends DriverTestCase {

    String actualResult = "";
    String expectedResult = "";

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public  void LieferAdresse(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF18_Lieferadresse_aendern_mein_account";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(4000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(2000);
        loginPage.closeNotificationBlackWeek();
        Thread.sleep(6000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(500);
        loginPage.anmelden(shop, mobileOrDesktop);
        Thread.sleep(2000);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(2000);
        registrationPage.meinAdressenZeigen(mobileOrDesktop);
        Thread.sleep(2000);

        Random rand = new Random();
        int upperbound = 25;
        //generate random values from 0-24
        int hausnummer = rand.nextInt(upperbound) + 1;
        String vorname=randomString(10);
        String nachname=randomString(10);
        String strasse=randomString(10);
        String stadt=randomString(10);
        refactorFormularLieferAdresseAendern.lieferAdresseAendernMeinKonto(vorname, nachname, strasse, stadt, hausnummer, shop);
//      Thread.sleep(5000);
//      formularLieferAdresseAendern.rechnungsAdresseAendernMeinKonto(vorname, nachname, strasse, stadt, hausnummer, shop);
//      Thread.sleep(5000);
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