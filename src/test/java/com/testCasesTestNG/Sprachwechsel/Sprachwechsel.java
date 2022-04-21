package com.testCasesTestNG.Sprachwechsel;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Sprachwechsel extends DriverTestCase {


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void PLPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TF04_Anmeldung_im_Checkout"  + "_"  + mobileOrDesktop + "_"  + shop + "_"  + environment ;
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        homePage.damesZielgruppeAuswaehlen(mobileOrDesktop);
        //homePage.herenZielgruppeAuswaehlen();
        Thread.sleep(5000);
        homePage.damesZielgruppeGeklickt(mobileOrDesktop);
        Thread.sleep(5000);
        homePage.damenSeitePruefen(shop, "nederlands");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www2.vanharen.be/nl-be/dames");
        homePage.spracheAuswaehlen(mobileOrDesktop);
        Thread.sleep(500);
        homePage.francaisAuswaehlen();
        Thread.sleep(500);
        homePage.sprachauswahlBastaetigen();
        Thread.sleep(500);
        homePage.damenSeitePruefen(shop, "francais");
        homePage.spracheAuswaehlen(mobileOrDesktop);
        Thread.sleep(500);
        homePage.nederlandsAuswaehlen();
        Thread.sleep(500);
        homePage.sprachauswahlBastaetigen();
        Thread.sleep(500);
        homePage.damenSeitePruefen(shop, "nederlands");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www2.vanharen.be/nl-be/dames");


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
