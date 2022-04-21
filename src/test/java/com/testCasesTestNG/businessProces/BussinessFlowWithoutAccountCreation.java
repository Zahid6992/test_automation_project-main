package com.testCasesTestNG.businessProces;

import com.utils.DriverTestCase;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class BussinessFlowWithoutAccountCreation extends DriverTestCase {
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
        loginPage.clickOnCookiesOkayButton(shop, environment);
        homePage.enterSearchCriteriaAndChooseResult("Schwarze lauf");
        Thread.sleep(3000);
    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "searchTest")
    public void checkFilters(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        homePage.clickOnFilter();
        filterComponent.clickOnFilterSortierenBeiRelevanz();
        filterComponent.clickOnFilterSortierenBeiPreisAufsteigend();
        homePage.clickOnFilterGroesse(shop);
        filterComponent.chooseOnFilterGroesseSiebzhenEU();
        homePage.clickOnFilterGroesseBackArrow();
        filterComponent.clickOnFilterGroesseMaxPreisFuenfzig();
        filterComponent.clickOnFilterFarbeWeiss();
        filterComponent.clickOnFilterFarbeSchwarz();
        filterComponent.clickOnFilterBrand();
        filterComponent.chooseFilterBrandNike();
        filterComponent.saveFilterBrand();
        filterComponent.clickOnFilterGeschlescht();
        filterComponent.chooseOnFilterGeschleschtMaennlich();
        filterComponent.clickOnFilterGeschleschtBackarrow();
        filterComponent.clickOnFilterErgebnisseAnzeigen();

        boolean filterddone=productListPage.isAllFilterdDisplayed();
        Assert.assertTrue(filterddone, "All filterd not displayed successfully");
        System.out.println("All Filterd are displayed successfully after applied");

        boolean ispriceSorted = productListPage.isFirstpriceIsLessorThenSecond();
        Assert.assertTrue(ispriceSorted, "product not Sorted by price in ascending order");
        System.out.println("Product Sorted by Price in ascending oder");

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "checkFilters")
    public void addArtikelToWunschList(String mobileOrDesktop, String deviceName)  {
        productListPage.addFirstArtikelToWunschList();

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
