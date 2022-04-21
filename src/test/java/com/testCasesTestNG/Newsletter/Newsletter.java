package com.testCasesTestNG.Newsletter;

import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class Newsletter extends DriverTestCase {

    String actualResult;
    String expectedResult;
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void NewsletterAnmeldung(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        String testCaseName = "TFXX_Newsletter";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);

        String urlPLP = null;
        urlPLP = productListPage.URLNewsletter(shop, environment);
        driver.get(urlPLP);
        loginPage.clickOnCookiesOkayButton(shop, environment);

        newsletterPage.newsletterAnmelden();
        Thread.sleep(6000);
        newsletterPage.newsletterBestaetigung();
        Thread.sleep(6000);


        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
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
