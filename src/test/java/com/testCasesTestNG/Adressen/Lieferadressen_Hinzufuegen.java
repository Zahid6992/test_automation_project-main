package com.testCasesTestNG.Adressen;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Lieferadressen_Hinzufuegen extends DriverTestCase {
    String actualResult;
    String expectedResult;
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public  void LieferAdresse(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF07_LieferAdressen_Hinzufuegen";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);


        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(4000);
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
//        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
//        loginPage.closeNotificationBlackWeek();
        loginPage.anmelden(shop, mobileOrDesktop);
        Thread.sleep(2000);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(2000);
        registrationPage.meinAdressenZeigen(mobileOrDesktop);
        Thread.sleep(2000);
        registrationPage.addressenhinzufuegen();
        Thread.sleep(5000);

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password = "Test1234";
        formularNeueLieferAdresseHinzufuegen.modal();
        Thread.sleep(2000);
//        formularNeueLieferAdresseHinzufuegen.genderFrau();
        formularNeueLieferAdresseHinzufuegen.formularAusfuellenNeueLieferadresse(vorname, nachname, shop, strasse, haunummer);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Thread.sleep(1000);
        formularNeueLieferAdresseHinzufuegen.AdresseSpeichernNewAdress(shop);
        Thread.sleep(14000);
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