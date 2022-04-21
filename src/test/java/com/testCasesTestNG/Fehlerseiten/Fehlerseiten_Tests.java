package com.testCasesTestNG.Fehlerseiten;
import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class Fehlerseiten_Tests extends DriverTestCase {

    String actualResult;
    String expectedResult;
    String calledURL;

//

    //////Test Case: URL + /zueflligebuchstaben

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void TF01_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;

        extentReportConfig.configureExtentReportBeforeTest("Fehlerseiten Tests", mobileOrDesktop, deviceName, shop, environment);
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF01_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF01_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        loginPage.clickOnCookiesOkayButton(shop, environment);
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF01_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF01_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }


    //////Test Case: URL + /c-zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF01_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF02_c_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + c_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF02_c_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF02_c_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();

        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF02_c_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF02_c_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + c_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }





    //////Test Case: URL + /p-zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF02_c_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF03_p_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + p_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF03_p_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF03_p_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();

        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF03_p_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF03_p_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + p_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }


    //////Test Case: URL + /Search/zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF03_p_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF04_search_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + search_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF04_search_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF04_search_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF04_search_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF04_zsearch_ufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + search_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }



    //////Test Case: URL + /Damen/zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF04_zsearch_ufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF05_damen_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + damen_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF05_damen_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF05_damen_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF05_damen_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF05_damen_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + damen_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        errorPage.checkResponseCode(calledURL);
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }




    //////Test Case: URL + /Damen/c-zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF05_damen_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF06_damen_c_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + damen_c_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF06_damen_c_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF06_damen_c_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF06_damen_c_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF06_damen_c_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + damen_c_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        errorPage.checkResponseCode(calledURL);
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
        Assert.assertEquals(actualResponseCode, "404");
    }





    //////Test Case: URL + /Damen/p-zueflligebuchstaben
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF06_damen_c_zufaelligeBuchstaben_check_404_Response_Code", alwaysRun=true)
    public void TF07_damen_p_zufaelligeBuchstaben_check_url(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {

        calledURL = urlMap.get(shop + " " + environment) + "/" + damen_p_zufaelligeBuchstabenUrlMap.get(shop);
        expectedResult = "The expected URL is: " + calledURL;
        driver.get(calledURL);
        Thread.sleep(3000);
        actualResult = "The actual URL is: " + driver.getCurrentUrl();
        extentReportConfig.configureExtentReportActualResultExpectedResult(expectedResult, actualResult);
        Assert.assertEquals(driver.getCurrentUrl(), calledURL);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF07_damen_p_zufaelligeBuchstaben_check_url", alwaysRun=true)
    public void TF07_damen_p_zufaelligeBuchstaben_check_not_found_message(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        Boolean result = errorPage.checkNotFoundErrorPresent(shop);
        actualResult = result.toString();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Not Found Message is shown on the page", actualResult);
        Assert.assertEquals(errorPage.checkNotFoundErrorPresent(shop), true);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "TF07_damen_p_zufaelligeBuchstaben_check_not_found_message", alwaysRun=true)
    public void TF07_damen_p_zufaelligeBuchstaben_check_404_Response_Code(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        calledURL = urlMap.get(shop + " " + environment) + "/rest/v2/" + urlCountryMarkMap.get(shop) + "/cms/pages?pageType=ContentPage&pageLabelOrId=" + damen_p_zufaelligeBuchstabenUrlMap.get(shop) + "&fields=FULL&lang=" + countryLanguageCodeMap.get(shop);
        String actualResponseCode = errorPage.checkResponseCode(calledURL);
        errorPage.checkResponseCode(calledURL);
        String actualBody = errorPage.checkBody();
        extentReportConfig.configureExtentReportActualResultExpectedResult("Response Code is http 404", "Response Code is http " + actualResponseCode);
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
