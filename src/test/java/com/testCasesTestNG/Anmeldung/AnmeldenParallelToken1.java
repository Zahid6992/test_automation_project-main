package com.testCasesTestNG.Anmeldung;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

public class AnmeldenParallelToken1 extends DriverTestCase  {

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void anmelden(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF06_Anmelden"   + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        Thread.sleep(1000);
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.anmelden(shop, mobileOrDesktop);
        Date date = new Date();
        System.out.println("TC1 Start" + new Timestamp(date.getTime()));
        Thread.sleep(1320000);
        driver.navigate().refresh();
        Date date2 = new Date();
        System.out.println("TC1 End" + new Timestamp(date2.getTime()));
        Thread.sleep(6000);
//        registrationPage.meinAdressenZeigen(mobileOrDesktop);


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