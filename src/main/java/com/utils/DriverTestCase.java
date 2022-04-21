//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.utils;

import com.pagesAndComponents.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public abstract class DriverTestCase extends Dictionary{
    public PropertyReader propertyReader;
    public LoginPage loginPage;
    public LoginPageGemini loginPageGemini;
    public HomePage homePage;
    public HomePageGemini homePageGemini;
    public ProductListPage productListPage;
    public ProductListPageGemini productListPageGemini;
    public RegistrationPage registrationPage;
    public VersandArtPage versandArtPage;
    public VersandArtPageGemini versandArtPageGemini;
    public ZahlungsMethodePage zahlungsMethodePage;
    public FilterComponent filterComponent;
    public FormularLieferadresse formularLieferadresse;
    public FormularRechnungsadresse formularRechnungsadresse;
    public KontaktFormular kontaktFormular;
    public FilialsuchePage filialsuchePage;
    public NewsletterPage newsletterPage;
    public FormularNeueLieferAdresseHinzufuegen formularNeueLieferAdresseHinzufuegen;
    public CheckoutSummaryPage checkoutSummaryPage;
    public Refactor_FormularLieferAdresseAendern refactorFormularLieferAdresseAendern;
    public RegistrationPageHfuenfDHU registrationPageHfuenfDHU;
    public ErrorPage errorPage;
    public JsonComparePage jsonComparePage;
    public JSONCompareSearchPage jsonCompareSearchPage;
    public JSONCompareSearchPage1 jsonCompareSearchPage1;
    public JSONCompareSearchPage2 jsonCompareSearchPage2;
    public ExtentReportConfig extentReportConfig;
    public InfluxDBComponent influxDBComponent;
    public WebDriver driver;



    public DriverTestCase() {
    }
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @BeforeClass
    public void setUp(ITestContext ctx, String mobileOrDesktop, String deviceName, String shop, String environment) throws MalformedURLException, InterruptedException {

        String loginUserName;
        String loginPassword;
        propertyReader = new PropertyReader();
        String applicationUrl = "";
        String host = "localhost";

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        String browser = propertyReader.readApplicationFile("BROWSER");
        if (browser.equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        String testName = ctx.getCurrentXmlTest().getName();

        String completeUrl = "http://" + host + ":4444/wd/hub";

        //mobileOrDesktop = propertyReader.readApplicationFile("MobileOrDesktop");
        //deviceName = propertyReader.readApplicationFile("DeviceName");

        if (mobileOrDesktop.equalsIgnoreCase("Mobile")) {
            HashMap<String, String> mobileEmulation  = new HashMap<>();
            mobileEmulation.put("deviceName",deviceName);
            Map<String, Object> chromeOptions = new HashMap<>();
            chromeOptions.put("mobileEmulation",mobileEmulation);
            dc.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        }

        dc.setCapability("name", testName);

        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);


        //Set HashMaps
        setPlzMap(plzMap);
        setUrlCountryMarkMap(urlCountryMarkMap);
        setPlzMap(urlMap);
        setCountryLanguageCodeMap(countryLanguageCodeMap);
        seturlDamenSchuheMap(urlDamenSchuheMap);
        setxpathAendernSymbolDelivery(xpathAendernSymbolDeliveryMap);
        setXpathAendernSymbolPaymentMap(xpathAendernSymbolPaymentMap);
        setcountryMap(countryMap);
        setTelefonnummerMap(telefonnummerMap);
        set_damen_c_zufaelligeBuchstabenUrlMap(damen_c_zufaelligeBuchstabenUrlMap);
        set_damen_p_zufaelligeBuchstabenUrlMap(damen_p_zufaelligeBuchstabenUrlMap);
        set_search_zufaelligeBuchstabenUrlMap(search_zufaelligeBuchstabenUrlMap);
        set_damen_zufaelligeBuchstabenUrlMap(damen_zufaelligeBuchstabenUrlMap);
        set_zufaelligeBuchstabenUrlMap(zufaelligeBuchstabenUrlMap);
        set_c_zufaelligeBuchstabenUrlMap(c_zufaelligeBuchstabenUrlMap);
        set_p_zufaelligeBuchstabenUrlMap(p_zufaelligeBuchstabenUrlMap);


        applicationUrl = urlMap.get(shop + " " + environment);

        System.out.println(applicationUrl);
        getWebDriver().get(applicationUrl);



        //JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("return document.readyState").toString().equals("complete");


        loginPage = PageFactory.initElements(driver,LoginPage.class);
        homePage= PageFactory.initElements(driver,HomePage.class);
        productListPage= PageFactory.initElements(driver,ProductListPage.class);
        registrationPage= PageFactory.initElements(driver,RegistrationPage.class);
        filterComponent= PageFactory.initElements(driver,FilterComponent.class);
        versandArtPage = PageFactory.initElements(driver,VersandArtPage.class);
        zahlungsMethodePage = PageFactory.initElements(driver,ZahlungsMethodePage.class);
        formularLieferadresse = PageFactory.initElements(driver,FormularLieferadresse.class);
        formularRechnungsadresse = PageFactory.initElements(driver,FormularRechnungsadresse.class);
        kontaktFormular = PageFactory.initElements(driver,KontaktFormular.class);
        filialsuchePage = PageFactory.initElements(driver,FilialsuchePage.class);
        formularNeueLieferAdresseHinzufuegen = PageFactory.initElements(driver,FormularNeueLieferAdresseHinzufuegen.class);
        checkoutSummaryPage = PageFactory.initElements(driver,CheckoutSummaryPage.class);
        newsletterPage = PageFactory.initElements(driver,NewsletterPage.class);
        refactorFormularLieferAdresseAendern = PageFactory.initElements(driver, Refactor_FormularLieferAdresseAendern.class);
        registrationPageHfuenfDHU = PageFactory.initElements(driver,RegistrationPageHfuenfDHU.class);
        homePageGemini = PageFactory.initElements(driver,HomePageGemini.class);
        loginPageGemini = PageFactory.initElements(driver,LoginPageGemini.class);
        productListPageGemini = PageFactory.initElements(driver,ProductListPageGemini.class);
        versandArtPageGemini = PageFactory.initElements(driver,VersandArtPageGemini.class);
        errorPage = PageFactory.initElements(driver,ErrorPage.class);
        jsonComparePage = PageFactory.initElements(driver,JsonComparePage.class);
        extentReportConfig = PageFactory.initElements(driver, ExtentReportConfig.class);
        jsonCompareSearchPage = PageFactory.initElements(driver, JSONCompareSearchPage.class);
        jsonCompareSearchPage1 = PageFactory.initElements(driver, JSONCompareSearchPage1.class);
        jsonCompareSearchPage2 = PageFactory.initElements(driver, JSONCompareSearchPage2.class);
        influxDBComponent = PageFactory.initElements(driver, InfluxDBComponent.class);

        if (environment.equalsIgnoreCase("QA"))
        {
            boolean elemntNotFound = driver.findElements(By.id("input_1")).isEmpty();

            System.out.println("elemntNotFound" +  elemntNotFound);
            if (!elemntNotFound)
            {
                System.out.println("in");
                loginUserName = propertyReader.readApplicationFile("QAUserName");
                loginPassword = propertyReader.readApplicationFile("QAPassword");
                loginPage = loginPage.loginIntoPlatformQA(loginUserName, loginPassword);
            }



            loginPage.clickOnCookiesOkayButton(shop, environment);
        }

    }

    @AfterClass
    public void tearDowm() {
        this.driver.close();
        this.driver.quit();
    }

    public WebDriver getWebDriver() {
        return this.driver;
    }

    public PropertyReader getProperty() {
        return this.propertyReader;
    }

    public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            long range = (long)aEnd - (long)aStart + 1L;
            long fraction = (long)((double)range * aRandom.nextDouble());
            int randomNumber = (int)(fraction + (long)aStart);
            return randomNumber;
        }
    }

    public String randomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);

        for(int i = 0; i < len; ++i) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }

        return sb.toString();
    }

    static enum DriverType {
        Firefox,
        IE,
        Chrome;

        private DriverType() {
        }
    }


}
