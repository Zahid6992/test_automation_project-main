package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Anmeldung_im_Checkout_nach_Hfuenf extends DriverTestCase {



    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "Anmeldung_im_Checkout_nach_Hfuenf"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        String urlPLP = null;
        urlPLP = productListPage.URLDamenSchuhe(shop, environment);
        System.out.println(urlPLP);
        driver.get(urlPLP);
        loginPage.closeNewsletterAbonnierenPopup();
        homePage.produktAuswahlenPLP(shop);

    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, false);
        homePage.clickOnCookiesOkayButton();
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);
        Thread.sleep(1000);

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest", retryAnalyzer = com.utils.RetryAnalyzer.class)
    public void AnmeldenImCheckout(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertEquals(loginPage.anmeldenImCheckoutHfuenf(shop), true);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "AnmeldenImCheckout", invocationCount = 1)
    public void CheckoutVersandart(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        if (!shop.equalsIgnoreCase("DOS"))
        {
            Thread.sleep(5000);
            versandArtPage.setLiefermethodeAngemeldet(shop);
            versandArtPage.clickVersandArtVerwendenAnegmeldet(shop);
        }

    }



    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "CheckoutVersandart", invocationCount = 1)
    public void ZahlungsPflichtigBestellen(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(2000);


        switch (shop)
        {
            case "DSD":
                System.out.println("payment schon gesetzt");
                break;

            case "DHU":
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
                break;

            case "DOS":
                System.out.println("payment schon gesetzt");
                break;

            case "VHS":
                System.out.println("payment schon gesetzt");
                break;
            case "VBE":
                System.out.println("payment schon gesetzt");
                break;
            default:
                zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
                Thread.sleep(2000);
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
        }


        Thread.sleep(5000);


        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String hausnummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");

        checkoutSummaryPage.lieferadresseAdresseCheck(vorname, nachname, strasse, stadt, hausnummer, shop);
        Thread.sleep(5000);
        checkoutSummaryPage.rechnungsAdresseCheck(vorname, nachname, strasse, stadt, hausnummer, shop);



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
