package com.testCasesTestNG.Fehlerseiten.old;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;


public class Fehlerseiten_Zufaelligebuchstaben extends DriverTestCase {




    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void zufaelligeBuchstaben(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "Fehlerseiten_Zufaelligebuchstaben"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        SoftAssert softAssert = new SoftAssert();

        //Check 404 URL
        driver.get(urlMap.get(shop + " " + environment) + "/zueflligebuchstaben");
        Thread.sleep(3000);
        softAssert.assertEquals(driver.getCurrentUrl(), urlMap.get(shop + " " + environment) + "/page-not-found");
        softAssert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
        //Initialization
        driver.get(urlDamenSchuheMap.get(shop + " " + environment));
        Thread.sleep(3000);
        softAssert.assertEquals(driver.getCurrentUrl(), urlDamenSchuheMap.get(shop + " " + environment));
        softAssert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), false);
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
