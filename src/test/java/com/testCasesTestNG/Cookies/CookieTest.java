package com.testCasesTestNG.Cookies;

import com.utils.DriverTestCase;
import org.openqa.selenium.Cookie;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CookieTest extends DriverTestCase {
    String loginUserName;
    String loginPassword;
    String umgebung;


    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test
    public void setCookies(String cookies, String cookiesTrueFalse, String deviceName, String shop, String environment) throws InterruptedException {

        if (cookiesTrueFalse.equalsIgnoreCase("true")){

            driver.manage().addCookie(new Cookie("userconsent_facebook", "false"));
            driver.manage().addCookie(new Cookie("userconsent_sovendus", "false"));
            driver.manage().addCookie(new Cookie("userconsent_plannet", "false"));
            driver.manage().addCookie(new Cookie("userconsent_googleads", "false"));
            driver.manage().addCookie(new Cookie("userconsent_criteo", "false"));
            driver.manage().addCookie(new Cookie("userconsent_crealytics", "false"));
            driver.manage().addCookie(new Cookie("userconsent_tiktok", "false"));
            driver.manage().addCookie(new Cookie("userconsent_bing", "false"));
            driver.manage().addCookie(new Cookie("userconsent_zenloop", "false"));
            driver.manage().addCookie(new Cookie("userconsent_contentsquare", "false"));
            driver.manage().addCookie(new Cookie("userconsent_paymentprovider", "false"));
            driver.manage().addCookie(new Cookie("userconsent_artefact", "false"));
            driver.manage().addCookie(new Cookie("userconsent_googletagmanager", "false"));
            driver.manage().addCookie(new Cookie("userconsent_youtube", "false"));
            driver.manage().addCookie(new Cookie("userconsent_googleanalytics", "false"));
            driver.manage().addCookie(new Cookie("userconsent_ekomi", "false"));
            driver.manage().addCookie(new Cookie("userconsent_dynamicyield", "false"));
            driver.manage().addCookie(new Cookie("userconsent_deichmann", "false"));

            switch (cookies){
                case "facebookTrue":
                    driver.manage().addCookie(new Cookie("userconsent_facebook", "true"));
                    Cookie cookieName = driver.manage().getCookieNamed("userconsent_facebook");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;
                case "sovendusTrue":
                    driver.manage().addCookie(new Cookie("userconsent_sovendus", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_sovendus");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "plannetTrue":
                    driver.manage().addCookie(new Cookie("userconsent_plannet", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_plannet");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googleadsTrue":

                    driver.manage().addCookie(new Cookie("userconsent_googleads", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googleads");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "criteoTrue":
                    driver.manage().addCookie(new Cookie("userconsent_criteo", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_criteo");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "crealyticsTrue":
                    driver.manage().addCookie(new Cookie("userconsent_crealytics", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_crealytics");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "tiktokTrue":
                    driver.manage().addCookie(new Cookie("userconsent_tiktok", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_tiktok");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "bingTrue":
                    driver.manage().addCookie(new Cookie("userconsent_bing", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_bing");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "zenloopTrue":
                    driver.manage().addCookie(new Cookie("userconsent_zenloop", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_zenloop");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "contentsquareTrue":
                    driver.manage().addCookie(new Cookie("userconsent_contentsquare", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_contentsquare");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "paymentproviderTrue":
                    driver.manage().addCookie(new Cookie("userconsent_paymentprovider", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_paymentprovider");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "artefactTrue":
                    driver.manage().addCookie(new Cookie("userconsent_artefact", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_artefact");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googletagmanagerTrue":
                    driver.manage().addCookie(new Cookie("userconsent_googletagmanager", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googletagmanager");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "youtubeTrue":
                    driver.manage().addCookie(new Cookie("userconsent_youtube", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_youtube");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googleanalyticsTrue":
                    driver.manage().addCookie(new Cookie("userconsent_googleanalytics", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googleanalytics");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "ekomiTrue":
                    driver.manage().addCookie(new Cookie("userconsent_ekomi", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_ekomi");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "dynamicyieldTrue":
                    driver.manage().addCookie(new Cookie("userconsent_dynamicyield", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_dynamicyield");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "deichmannTrue":
                    driver.manage().addCookie(new Cookie("userconsent_deichmann", "true"));
                    cookieName = driver.manage().getCookieNamed("userconsent_deichmann");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;
                case "allFalse":
                    System.out.println("all cookies false");
                    break;
                default:
                    System.out.println("please verify the cookies parameter!" + cookies);
                    driver.quit();
                    break;

            }

        }

        else if (cookiesTrueFalse.equalsIgnoreCase("false")) {
            driver.manage().addCookie(new Cookie("userconsent_facebook", "true"));
            driver.manage().addCookie(new Cookie("userconsent_sovendus", "true"));
            driver.manage().addCookie(new Cookie("userconsent_plannet", "true"));
            driver.manage().addCookie(new Cookie("userconsent_googleads", "true"));
            driver.manage().addCookie(new Cookie("userconsent_criteo", "true"));
            driver.manage().addCookie(new Cookie("userconsent_crealytics", "true"));
            driver.manage().addCookie(new Cookie("userconsent_tiktok", "true"));
            driver.manage().addCookie(new Cookie("userconsent_bing", "true"));
            driver.manage().addCookie(new Cookie("userconsent_zenloop", "true"));
            driver.manage().addCookie(new Cookie("userconsent_contentsquare", "true"));
            driver.manage().addCookie(new Cookie("userconsent_paymentprovider", "true"));
            driver.manage().addCookie(new Cookie("userconsent_artefact", "true"));
            driver.manage().addCookie(new Cookie("userconsent_googletagmanager", "true"));
            driver.manage().addCookie(new Cookie("userconsent_youtube", "true"));
            driver.manage().addCookie(new Cookie("userconsent_googleanalytics", "true"));
            driver.manage().addCookie(new Cookie("userconsent_ekomi", "true"));
            driver.manage().addCookie(new Cookie("userconsent_dynamicyield", "true"));
            driver.manage().addCookie(new Cookie("userconsent_deichmann", "true"));

            switch (cookies){
                case "facebookFalse":
                    driver.manage().addCookie(new Cookie("userconsent_facebook", "false"));
                    Cookie cookieName = driver.manage().getCookieNamed("userconsent_facebook");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;
                case "sovendusFalse":
                    driver.manage().addCookie(new Cookie("userconsent_sovendus", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_sovendus");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "plannetFalse":
                    driver.manage().addCookie(new Cookie("userconsent_plannet", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_plannet");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googleadsFalse":

                    driver.manage().addCookie(new Cookie("userconsent_googleads", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googleads");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "criteoFalse":
                    driver.manage().addCookie(new Cookie("userconsent_criteo", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_criteo");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "crealyticsFalse":
                    driver.manage().addCookie(new Cookie("userconsent_crealytics", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_crealytics");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "tiktokFalse":
                    driver.manage().addCookie(new Cookie("userconsent_tiktok", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_tiktok");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "bingFalse":
                    driver.manage().addCookie(new Cookie("userconsent_bing", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_bing");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "zenloopFalse":
                    driver.manage().addCookie(new Cookie("userconsent_zenloop", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_zenloop");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "contentsquareFalse":
                    driver.manage().addCookie(new Cookie("userconsent_contentsquare", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_contentsquare");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "paymentproviderFalse":
                    driver.manage().addCookie(new Cookie("userconsent_paymentprovider", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_paymentprovider");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "artefactFalse":
                    driver.manage().addCookie(new Cookie("userconsent_artefact", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_artefact");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googletagmanagerFalse":
                    driver.manage().addCookie(new Cookie("userconsent_googletagmanager", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googletagmanager");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "youtubeFalse":
                    driver.manage().addCookie(new Cookie("userconsent_youtube", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_youtube");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "googleanalyticsFalse":
                    driver.manage().addCookie(new Cookie("userconsent_googleanalytics", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_googleanalytics");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "ekomiFalse":
                    driver.manage().addCookie(new Cookie("userconsent_ekomi", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_ekomi");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "dynamicyieldFalse":
                    driver.manage().addCookie(new Cookie("userconsent_dynamicyield", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_dynamicyield");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;

                case "deichmannFalse":
                    driver.manage().addCookie(new Cookie("userconsent_deichmann", "false"));
                    cookieName = driver.manage().getCookieNamed("userconsent_deichmann");
                    System.out.println(cookies + " cookie gesetzt");
                    System.out.println(cookieName.getValue());
                    break;
                case "allTrue":
                    System.out.println("all cookies true");
                    break;

                default:
                    System.out.println("please verify the cookies parameter!" + cookies);
                    driver.quit();
                    break;

            }


        }

        else {
            System.out.println("please verify the cookiesTrueFalse parameter!" + cookiesTrueFalse);
            driver.quit();
        }


    }

    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "setCookies", invocationCount = 1)
    public void PLPTest(String deviceName, String shop, String environment) throws InterruptedException {

        String urlPLP = null;
        urlPLP = productListPage.URLDamenSchuhe(shop, environment);

        driver.get(urlPLP);
        homePage.produktAuswahlenPLP(shop);
    }

    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PLPTest", invocationCount = 1)
    public void PDPTest(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        homePage.clickOnChooseSize();
        //homePage.selectShoeSize44();
        Thread.sleep(500) ;
        homePage.selectShoeSizeEUPDP(shop);
        Thread.sleep(500) ;
        homePage.selectShoeSize36();
        //homePage.searchSizeEnabled();
        homePage.clickOnAddToCart(shop, false);
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);


    }

    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "PDPTest")
    public void GastAdressFormular(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {


        registrationPage.alsGastClick(mobileOrDesktop);
        registrationPage.selectGenderFrau();
        String randomTxt=randomString(10);
        String randomEmail = randomTxt+"@gmail.com";
        formularLieferadresse.enterFirstname("Anna");
        formularLieferadresse.enterLastName("Annatest");
        formularLieferadresse.enterEmail(randomEmail);
        formularLieferadresse.enterStreet("Berlinerstraße");
        formularLieferadresse.enterHouseNumber("10");
        formularLieferadresse.enterPostalCode(shop);
        formularLieferadresse.enterCity("Dortmund");
        registrationPage.kontoAnlegen(shop);
        formularLieferadresse.enterPasswordAlsGast("Test@123");
        registrationPage.selectPolicy(shop, "true");
        registrationPage.WeiterZurLiefermethode(shop);


    }

    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "GastAdressFormular", invocationCount = 1)
    public void CheckoutVersandart(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        //Thread.sleep(5000);
        versandArtPage.setLiefermethode(shop);


    }

    @Parameters({"cookies", "cookiesTrueFalse", "mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "CheckoutVersandart", invocationCount = 1)
    public void CheckoutPayment(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
        zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);

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
