package com.testCasesTestNG.Fehlerseiten;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Search_Zufaelligebuchstaben_Fehlerseiten_Tests extends DriverTestCase {

    String actualResult;
    String expectedResult;
    String calledURL;

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void Test_Step_01_search_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + search_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;

        extentReportConfig.configureExtentReportBeforeTest("TF04 - Fehlerseiten Tests - Search-Zufaellige Buchstaben", mobileOrDesktop, deviceName, shop, environment);
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportTestInfo("Test Step 1: Check URL");
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "Test_Step_01_search_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void Test_Step_02_search_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        extentReportConfig.configureExtentReportTestInfo("-----------------------------------------");
        extentReportConfig.configureExtentReportTestInfo("Test Step 2: Check Not Found Message");
        loginPage.clickOnCookiesOkayButton(shop, environment);
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "Test_Step_02_search_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void Test_Step_03_search_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        extentReportConfig.configureExtentReportTestInfo("-----------------------------------------");
        extentReportConfig.configureExtentReportTestInfo("Test Step 3: Check Response Code 404");
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + search_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();

        extentReportConfig.configureExtentReportTestInfo("HTTP Request Methode: GET");
        extentReportConfig.configureExtentReportTestInfo("HTTP Request URL: " +  calledURL);
        extentReportConfig.configureExtentReportTestInfo("HTTP Request Headers: Accept: application/json, text/plain, */*");
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code http 404", "Response Code http " + actualResponseCode);
        extentReportConfig.configureExtentReportTestInfo("HTTP Response Body: " +  errorPage.checkBody());
        Assert.assertEquals(actualResponseCode, "404");
    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "Test_Step_03_search_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void Test_Step_04_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        extentReportConfig.configureExtentReportTestInfo("-----------------------------------------");
        extentReportConfig.configureExtentReportTestInfo("Test Step 4: Check Response Code 404");
        calledURL = urlMap.get(shop + " " + environment) + "/"  + search_zufaelligeBuchstabenUrlMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();

        extentReportConfig.configureExtentReportTestInfo("HTTP Request Methode: GET");
        extentReportConfig.configureExtentReportTestInfo("HTTP Request URL: " +  calledURL);
        extentReportConfig.configureExtentReportTestInfo("HTTP Request Headers: Accept: application/json, text/plain, */*");
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code http 404", "Response Code http " + actualResponseCode);
//        extentReportConfig.configureExtentReportTestInfo("HTTP Response Body: " +  errorPage.checkBody());
        Assert.assertEquals(actualResponseCode, "404");
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
