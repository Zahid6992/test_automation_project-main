package com.testCasesTestNG.Registrierung;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class CheckoutProzess extends DriverTestCase {
    String actualResult = "";
    String expectedResult = "";
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF10_Warenkorb_Kasse"   + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        productListPage.URLDamenSchuhe(shop, environment);
        Thread.sleep(1000);
        homePage.closeNotificationRabatt();
        loginPage.closeNewsletterAbonnierenPopup();
        Thread.sleep(1000);
        homePage.produktAuswahlenPLP(shop);
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest")
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        homePage.produktAuswahlenPDP(shop, mobileOrDesktop, false);
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);
        Thread.sleep(1000);

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest")
    public void GastAdressFormular(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {


        registrationPage.alsGastClick(mobileOrDesktop);
        registrationPage.selectGenderFrau();

        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password = "null";
        formularLieferadresse.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);

        registrationPage.kontoAnlegen(shop);
        formularLieferadresse.enterPasswordAlsGast("Test@123");



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
