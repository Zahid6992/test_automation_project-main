package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegistrierungAlsGastImCheckoutNewsletter extends DriverTestCase {
    String actualResult;
    String expectedResult;

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TFXX_RegistrierungAlsGast_im_Checkout_Newsletter";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        String urlPLP = null;
        urlPLP = productListPage.URLDamenSchuhe(shop, environment);
        System.out.println(urlPLP);
        driver.get(urlPLP);
        loginPage.closeNewsletterAbonnierenPopup();
        homePage.clickOnCookiesOkayButton();
        loginPage.closeNotificationBlackWeek();
        homePage.produktAuswahlenPLP(shop);

        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        Thread.sleep(5000);
        loginPage.closeNotificationRabatt();
        homePage.clickOnCookiesOkayButton();
        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, false);
        homePage.clickOnCookiesOkayButton();
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);
        Thread.sleep(1000);
        registrationPage.alsGastClick(mobileOrDesktop);

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest")
    public void GastAdressFormular(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        registrationPage.selectGenderFrau();

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.de";
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password =  "null";
        formularLieferadresse.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);

        registrationPage.kontoAnlegen(shop);
        formularLieferadresse.enterPasswordAlsGast("Test@123");
        registrationPage.selectPolicy(shop, "true");
        Thread.sleep(1000) ;
        registrationPage.selectNewsletter();
        Thread.sleep(1000) ;
        registrationPage.WeiterZurLiefermethode(shop);


    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "GastAdressFormular", invocationCount = 1)
    public void CheckoutVersandart(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        Thread.sleep(5000);
        versandArtPage.setLiefermethode(shop);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "CheckoutVersandart", invocationCount = 1)
    public void CheckoutPayment(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
       //homePage.clickOnCookiesOkayButton();
        zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);
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
