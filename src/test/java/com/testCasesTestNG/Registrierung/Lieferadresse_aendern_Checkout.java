package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Random;


public class Lieferadresse_aendern_Checkout extends DriverTestCase {

    String actualResult = "";
    String expectedResult = "";
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TF16_Lieferadress_aendern_im_Checkout"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        productListPage.URLDamenSchuhe(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
        homePage.clickOnCookiesOkayButton();
        loginPage.closeNotificationBlackWeek();
        homePage.closeNotificationClickAndCollect();
        homePage.produktAuswahlenPLP(shop);

        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);

    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
//        loginPage.closeNewsletterAbonnierenPopup();
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
//    @Test(dependsOnMethods = "CheckoutVersandart", invocationCount = 1, retryAnalyzer = com.utils.RetryAnalyzer.class)
    @Test(dependsOnMethods = "CheckoutVersandart")
    public void AdresseAendernImCheckout(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(2000);


        switch (shop)
        {
            case "DSD":
                System.out.println("payment schon gesetzt");
                break;

            case "DHU":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                homePage.clickOnCookiesOkayButton();
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;

            case "DOS":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                homePage.clickOnCookiesOkayButton();
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;

            case "VHS":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(1000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;
            case "VBE":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(1000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;
            default:
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                homePage.clickOnCookiesOkayButton();
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
        checkoutSummaryPage.lieferAdresseAendernCheckout(vorname, nachname, strasse, stadt, hausnummer, shop);
        Thread.sleep(5000);
        versandArtPage.setLiefermethodeAngemeldet(shop);
        Thread.sleep(2000);
        zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
        Thread.sleep(1000);
        zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
        Thread.sleep(5000);
        checkoutSummaryPage.verifylieferAdresseAendernCheckout(vorname, nachname, strasse, stadt, hausnummer, shop);



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
