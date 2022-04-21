package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;


public class Rechnungsadresse_aendern_Checkout extends DriverTestCase {
    String actualResult = "";
    String expectedResult = "";
    long min = 100000000 ;
    long max = 999999999;
    long random_number = (int)Math.floor(Math.random()*(max-min+1)+min);

    String random_phone = String.valueOf(random_number);


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TF17_Rechnungsadresse_aendern_im_Checkout";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        productListPage.URLDamenSchuhe(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
        homePage.clickOnCookiesOkayButton();
        loginPage.closeNotificationBlackWeek();
        homePage.produktAuswahlenPLP(shop);
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);

    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, false);
        homePage.clickOnCookiesOkayButton();
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);
        Thread.sleep(1000);
        loginPage.anmeldenImCheckout(shop);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest", invocationCount = 1)
    public void CheckoutVersandart(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        if (!shop.equalsIgnoreCase("DOS"))
        {
            Thread.sleep(5000);
            versandArtPage.setLiefermethodeAngemeldet(shop);
        }

    }



    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "CheckoutVersandart", invocationCount = 1)
    public void AdresseAendernImCheckout(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(2000);


        switch (shop)
        {
            case "DSD":
                System.out.println("payment schon gesetzt");
                break;

            case "DHU":
                System.out.println("payment schon gesetzt");
                break;

            case "DOS":
                System.out.println("payment schon gesetzt");
                break;

            case "VHS":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;
            case "VBE":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;
            case "DUK":
/*                versandArtPage.setLiefermethode(shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);*/
                Thread.sleep(2000);
                break;

            default:
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
        }

        Random rand = new Random();
        int upperbound = 25;
        //generate random values from 0-24
        int hausnummer = rand.nextInt(upperbound) + 1;
        String vorname=randomString(10);
        String nachname=randomString(10);
        String strasse=randomString(10);
        String stadt=randomString(10);
        Thread.sleep(2000);
/*        checkoutSummaryPage.lieferAdresseAendernCheckout(vorname, nachname, strasse, stadt, hausnummer, shop);
        Thread.sleep(5000);*/

        Assert.assertEquals(true, checkoutSummaryPage.rechnungsAdresseAendernCheckout(vorname, nachname, strasse, stadt, hausnummer, random_phone, shop));
        Thread.sleep(5000);
        //checkoutSummaryPage.rechnungsAdresseCheck(vorname, nachname, strasse, stadt, hausnummer, shop);
/*
        zahlungsMethodePage.clickZahlungsPflichtigBestellen();
        Thread.sleep(10000);
        zahlungsMethodePage.clickPaypalWeiter();
*/
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
