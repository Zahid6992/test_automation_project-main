package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Anmeldung_im_Checkout extends DriverTestCase {

    String actualResult;
    String expectedResult;

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TF04_Anmeldung_im_Checkout";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        loginPage.clickOnCookiesOkayButton(shop, environment);
        productListPage.URLDamenSchuhe(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
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

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest", retryAnalyzer = com.utils.RetryAnalyzer.class)
    public void AnmeldenImCheckout(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(2000);
        Assert.assertEquals(loginPage.anmeldenImCheckout(shop), true);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "AnmeldenImCheckout", invocationCount = 1)
    public void CheckoutVersandart(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        if (!shop.equalsIgnoreCase("DOS"))
        {
            Thread.sleep(5000);
/*            versandArtPage.setLiefermethodeAngemeldet(shop);
            versandArtPage.clickVersandArtVerwendenAnegmeldet(shop);*/
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
                System.out.println("payment schon gesetzt");
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
                homePage.clickOnCookiesOkayButton();
                zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
        }




        Thread.sleep(5000);





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
