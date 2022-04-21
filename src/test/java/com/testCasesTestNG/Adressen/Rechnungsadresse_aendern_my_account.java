package com.testCasesTestNG.Adressen;

import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;

public class Rechnungsadresse_aendern_my_account extends DriverTestCase {

    String actualResult = "";
    String expectedResult = "";

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public  void RechnungsadresseAendern(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF19_Rechnungsadresse_aendern";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        Random rand = new Random();
        int upperbound = 25;
        //generate random values from 0-24
        int hausnummer = rand.nextInt(upperbound) + 1;
        String vorname=randomString(10);
        String nachname=randomString(10);
        String strasse=randomString(10);
        String stadt=randomString(10);

        long min = 100000000 ;
        long max = 999999999;
        long random_number = (int)Math.floor(Math.random()*(max-min+1)+min);
        String random_phone = String.valueOf(random_number);

        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(4000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(2000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(500);
        loginPage.closeNotificationBlackWeek();
        Thread.sleep(500);
        loginPage.anmelden(shop, mobileOrDesktop);
        Thread.sleep(2000);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(2000);
        registrationPage.meinAdressenZeigen(mobileOrDesktop);
        Thread.sleep(2000);

        System.out.println(random_number);
        Thread.sleep(2000);
        refactorFormularLieferAdresseAendern.rechnungsAdresseAendernMeinKonto(vorname, nachname, strasse, stadt, hausnummer, random_phone, shop);
        Thread.sleep(3000);
        Assert.assertEquals(true, refactorFormularLieferAdresseAendern.rechnungsadressePruefen(vorname, nachname, strasse, stadt, hausnummer, random_phone, shop));
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