package com.testCasesTestNG.Registrierung;

import com.utils.DriverTestCase;
import com.utils.ExcelDataReader;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.IOException;


public class AlleinstehendeRegistrierung_Excel extends DriverTestCase {



    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        String testCaseName = "TF01_Alleinstehende_Registrierung_Excel"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);



        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.closeNewsletterAbonnierenPopup();
        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(500) ;

    }

    @DataProvider
    public Object[][] getRegistrationData() throws IOException {
        String excel_lo = propertyReader.readApplicationFile("Excel_location");
        Object data[][] = ExcelDataReader.getDataFromExcel(excel_lo);
        return data ;

    }


    //@Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dataProvider = "getRegistrationData", dependsOnMethods = "clicnewAccount")
    public void  creatAccountNew (String geschlescht, String vorname, String nachname,String email,String password, String strasse , String hausnummer, String postleizahl ,String stadt) throws InterruptedException, IOException {

        Thread.sleep(2000);
        this.driver.get(propertyReader.readApplicationFile("URL_DE_QA"));
        System.out.println("Nevigiert zur QA URL");
        Thread.sleep(2000);
        // loginPage.clickOnCookiesOkayButton();
        loginPage.mouseHoverOnRegisterIcon();
        System.out.println("2 musehover");
        loginPage.clickOnCookiesOkayButton("DSD", "QA");
        registrationPage.clickOnNewAccount("DSD");
        System.out.println("2 click on new account");
        Thread.sleep(2000);

/*        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        String vorname = propertyReader.readApplicationFile("Vorname");
        String nachname = propertyReader.readApplicationFile("Nachname");
        String strasse = propertyReader.readApplicationFile("Strasse");
        String haunummer = propertyReader.readApplicationFile("Hausnummer");
        String stadt = propertyReader.readApplicationFile("Stadt");
        String password = "Test1234";*/
        System.out.println(postleizahl);
        System.out.println(geschlescht);
        formularLieferadresse.lieferadresseAusfuellen(email, "DSD", vorname, nachname, strasse, hausnummer, stadt, password);
        registrationPage.selectPolicy("DSD", "false");
        Thread.sleep(2000) ;
        registrationPage.ClickOnRegister("DSD");
        Thread.sleep(2000) ;
        Assert.assertEquals(registrationPage.verifyRegister(), true);
        Thread.sleep(2000) ;
        loginPage.signOutFromApplication();





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
