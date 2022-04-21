package com.testCasesTestNG.Registrierung;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class AlleinstehendeRegistrierung_Warenkorb_test extends DriverTestCase {


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        String testCaseName = "TF01_Alleinstehende_Registrierung"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        Thread.sleep(500) ;

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "clicnewAccount")
    public void  creatAccountNew (String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {


        String oldPassword = propertyReader.readApplicationFile("NewPassword");
        System.out.println("The old password is" + oldPassword);
        propertyReader.writeApplicationFile("OldPassword", "newahla");
        System.out.println("The new password is" + oldPassword);


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
