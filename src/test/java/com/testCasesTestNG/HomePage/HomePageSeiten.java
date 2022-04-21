package com.testCasesTestNG.HomePage;
import com.utils.DriverTestCase;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;


public class HomePageSeiten extends DriverTestCase {
    public String actualResult = "actual result";
    public String expectedResult = "expected result";
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void  ZielGruppe (String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        String testCaseName = "TF05_Home_Page_Seiten";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);



        String herrenSeite = null;
        String damenSeite = null;
        String kinderSeite = null;

        loginPage.clickOnCookiesOkayButton(shop, environment);
        String urlPLP = null;
        switch(environment) {
            case "Prod":
                herrenSeite = propertyReader.readApplicationFile("URL_DE_Prod") + "/herren";
                damenSeite = propertyReader.readApplicationFile("URL_DE_Prod") + "/damen";
                kinderSeite = propertyReader.readApplicationFile("URL_DE_Prod") + "/kinder";
                break;
            case "QA":
                herrenSeite = propertyReader.readApplicationFile("URL_DE_QA") + "/herren";
                damenSeite = propertyReader.readApplicationFile("URL_DE_QA") + "/damen";
                kinderSeite = propertyReader.readApplicationFile("URL_DE_QA") + "/kinder";
                break;
            default:
                System.out.println("Please verify the environment variable!!");
        }

        driver.manage().deleteAllCookies();
        driver.get(herrenSeite);
        System.out.println("Herrenseite geladen");
        System.out.println("Actual XPATH:" + xpathAendernSymbolDeliveryMap.get(shop));
        Thread.sleep(2000);
        driver.get(damenSeite);
        System.out.println("Damenseite geladen");
        Thread.sleep(2000);
        driver.get(kinderSeite);
        System.out.println("KinderSeite geladen");
        Thread.sleep(2000);
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
