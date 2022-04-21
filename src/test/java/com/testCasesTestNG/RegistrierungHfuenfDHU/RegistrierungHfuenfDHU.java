package com.testCasesTestNG.RegistrierungHfuenfDHU;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.utils.DriverTestCase;
import org.joda.time.DateTime;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class RegistrierungHfuenfDHU extends DriverTestCase {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        String testCaseName = "Registrierung_Hfuenf_DHU"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;


        registrationPageHfuenfDHU.clickOnCookiesOkayButton();


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


        System.out.println("The random mail is " + randomEmail);
        String username = propertyReader.readApplicationFileUsers("Username");
        System.out.println("The old username is " + username);
        propertyReader.writeApplicationFile("Username", randomEmail);
        String usernameNew = propertyReader.readApplicationFileUsers("Username");
        System.out.println("The new username is " + usernameNew);

        registrationPageHfuenfDHU.lieferadresseAusfuellen(randomEmail, shop, vorname, nachname, strasse, haunummer, stadt, password);
        registrationPageHfuenfDHU.selectPolicy();
        Thread.sleep(10000) ;
        registrationPageHfuenfDHU.ClickOnRegister();
        Thread.sleep(2000) ;
        Assert.assertEquals(true, registrationPageHfuenfDHU.verifyRegister());

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
