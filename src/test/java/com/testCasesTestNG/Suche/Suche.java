package com.testCasesTestNG.Suche;

import com.utils.DriverTestCase;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Suche extends DriverTestCase {
    String loginUserName;
    String loginPassword;

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test
    public void loginIntoApplication(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        loginUserName = propertyReader.readApplicationFile("QAUserName");
        loginPassword = propertyReader.readApplicationFile("QAPassword");
        loginPage = loginPage.loginIntoPlatformQA(loginUserName, loginPassword);
        loginPage.clickOnCookiesOkayButton(shop, environment);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "loginIntoApplication")
    public void searchTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        homePage.enterSearchCriteriaAndChooseResult("Schwarze lauf");
        Thread.sleep(3000);
    }




}
