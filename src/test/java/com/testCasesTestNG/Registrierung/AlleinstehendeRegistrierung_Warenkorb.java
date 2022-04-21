package com.testCasesTestNG.Registrierung;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class AlleinstehendeRegistrierung_Warenkorb extends DriverTestCase {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        String testCaseName = "TF01_Alleinstehende_Registrierung"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;

        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        String urlPLP = null;
        urlPLP = productListPage.URLDamenSchuhe(shop, environment);

        driver.get(urlPLP);
        Thread.sleep(1000);
        homePage.closeNotificationRabatt();
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        homePage.produktAuswahlenPLP(shop);
        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, false);
        homePage.closeWarenkorbAnsicht(mobileOrDesktop);
        loginPage.mouseHoverOnRegisterIcon();
        loginPage.closeNewsletterAbonnierenPopup();
        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(500) ;

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
        Thread.sleep(10000) ;
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(1000) ;
        registrationPage.meinAdressenZeigen(mobileOrDesktop);
        Thread.sleep(1000);

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
