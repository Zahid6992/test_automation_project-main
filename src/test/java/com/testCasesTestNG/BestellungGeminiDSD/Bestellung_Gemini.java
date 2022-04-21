package com.testCasesTestNG.BestellungGeminiDSD;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Bestellung_Gemini extends DriverTestCase {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "Bestellung_Gemini"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        String urlPLP = null;
        urlPLP = productListPageGemini.URLDamenSchuhe(shop, environment);
        System.out.println(urlPLP);
        driver.get(urlPLP);
        //loginPageGemini.closeNewsletterAbonnierenPopup();
        loginPage.clickOnCookiesOkayButton(shop, environment);
        homePageGemini.produktAuswahlenPLP(shop);

    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
/*        Thread.sleep(2000);
        loginPage.clickOnCookiesOkayButton(shop, environment);*/
        Thread.sleep(2000);
        homePageGemini.produktAuswahlenPDP(shop, mobileOrDesktop, false, environment);
        //homePageGemini.clickOnSafelyCheckoutButton(mobileOrDesktop);
        Thread.sleep(1000);
        homePageGemini.zumWarenkorb();
        Thread.sleep(5000);
        homePageGemini.clickOnSafelyCheckoutButton(mobileOrDesktop, shop);
        Thread.sleep(2000);


        homePageGemini.selectGenderFrau();

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.de";
        String mobil = null;
        String zipCode = null;
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password =  "null";
        System.out.println("The random mail is " + randomEmail);
        String username = propertyReader.readApplicationFileUsers("Username");
        System.out.println("The old username is " + username);
        propertyReader.writeApplicationFile("Username", randomEmail);
        String usernameNew = propertyReader.readApplicationFileUsers("Username");
        System.out.println("The new username is " + usernameNew);

        switch (shop)
        {
            case "DSD":
                strasse = "Marienbader Str.";
                stadt = "Dortmund";
                mobil = "015253206641";
                zipCode = "44225";
                break;
            case "DHU":
                strasse = "Csabai kapu";
                stadt = "Budapest";
                mobil = "+36301234567";
                zipCode = "1044";
                break;

        }


        homePageGemini.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, "Test1234", mobil, zipCode);
        Thread.sleep(1000);
        homePageGemini.datenschutzBestaetigung();
        Thread.sleep(1000);
        homePageGemini.jetztRegistrieren();
        Thread.sleep(1000);
        homePageGemini.liefermethodeAuswaehlen(shop);
        Thread.sleep(1000);
        homePageGemini.zahlungsmethode(shop);
        Thread.sleep(1000);
        homePageGemini.weiterZurZusammenfassung();
        Thread.sleep(1000);
        homePageGemini.kaufen(shop);
        Thread.sleep(10000);
        homePageGemini.kaufBestaetigung(shop);
        Thread.sleep(30000);

//input[@id='paymentAddress.phone1']
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
