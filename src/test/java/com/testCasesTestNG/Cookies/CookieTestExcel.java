package com.testCasesTestNG.Cookies;

import com.utils.DriverTestCase;
import com.utils.ExcelDataReader;
import org.openqa.selenium.Cookie;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class CookieTestExcel extends DriverTestCase {


    @DataProvider
    public Object[][] getRegistrationData() throws IOException {
        String excel_lo = propertyReader.readApplicationFile("Excel_location_Cookies");
        System.out.println(excel_lo);
        Object data[][] = ExcelDataReader.getDataFromExcel(excel_lo);
        return data ;

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dataProvider = "getRegistrationData")
    public void setCookies(String facebook, String sovendus, String plannet, String googleads, String criteo, String crealytics, String tiktok, String bing, String zenloop, String contentsquare, String paymentprovider, String artefact, String googletagmanager, String youtube, String googleanalytics, String ekomi, String dynamicyield, String deichmann, String testcasenumber, String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {

        driver.manage().deleteAllCookies();


            driver.manage().addCookie(new Cookie("userconsent_facebook", facebook));
            driver.manage().addCookie(new Cookie("userconsent_sovendus", sovendus));
            driver.manage().addCookie(new Cookie("userconsent_plannet", plannet));
            driver.manage().addCookie(new Cookie("userconsent_googleads", googleads));
            driver.manage().addCookie(new Cookie("userconsent_criteo", criteo));
            driver.manage().addCookie(new Cookie("userconsent_crealytics", crealytics));
            driver.manage().addCookie(new Cookie("userconsent_tiktok", tiktok));
            driver.manage().addCookie(new Cookie("userconsent_bing", bing));
            driver.manage().addCookie(new Cookie("userconsent_zenloop", zenloop));
            driver.manage().addCookie(new Cookie("userconsent_contentsquare", contentsquare));
            driver.manage().addCookie(new Cookie("userconsent_paymentprovider", paymentprovider));
            driver.manage().addCookie(new Cookie("userconsent_artefact", artefact));
            driver.manage().addCookie(new Cookie("userconsent_googletagmanager", googletagmanager));
            driver.manage().addCookie(new Cookie("userconsent_youtube", youtube));
            driver.manage().addCookie(new Cookie("userconsent_googleanalytics", googleanalytics));
            driver.manage().addCookie(new Cookie("userconsent_ekomi", ekomi));
            driver.manage().addCookie(new Cookie("userconsent_dynamicyield", dynamicyield));
            driver.manage().addCookie(new Cookie("userconsent_deichmann", deichmann));

            System.out.println(testcasenumber);

        Cookie cookieName = driver.manage().getCookieNamed("userconsent_facebook");
        System.out.println("userconsent_facebook actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_sovendus");
        System.out.println("userconsent_sovendus actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_plannet");
        System.out.println("userconsent_plannet actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_googleads");
        System.out.println("userconsent_googleads actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_criteo");
        System.out.println("userconsent_criteo actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_crealytics");
        System.out.println("userconsent_crealytics actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_tiktok");
        System.out.println("userconsent_tiktok actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_bing");
        System.out.println("userconsent_zenloop actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_zenloop");
        System.out.println("userconsent_facebook actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_contentsquare");
        System.out.println("userconsent_contentsquare actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_paymentprovider");
        System.out.println("userconsent_paymentprovider actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_artefact");
        System.out.println("userconsent_artefact actual value" + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_googletagmanager");
        System.out.println("userconsent_googletagmanager actual value " + cookieName.getValue());

        cookieName = driver.manage().getCookieNamed("userconsent_youtube");
        System.out.println("userconsent_youtube actual value" + cookieName.getValue());


        cookieName = driver.manage().getCookieNamed("userconsent_googleanalytics");
        System.out.println("userconsent_googleanalytics actual value " + cookieName.getValue());


        cookieName = driver.manage().getCookieNamed("userconsent_ekomi");
        System.out.println("userconsent_ekomi actual value " + cookieName.getValue());


        cookieName = driver.manage().getCookieNamed("userconsent_dynamicyield");
        System.out.println("userconsent_dynamicyield actual value" + cookieName.getValue());


        cookieName = driver.manage().getCookieNamed("userconsent_deichmann");
        System.out.println("userconsent_deichmann actual value " + cookieName.getValue());



        this.driver.get(propertyReader.readApplicationFile("App_URL_QA"));
        Thread.sleep(2000);


        String urlPLP = null;
        switch(propertyReader.readApplicationFile("Environment")) {
            case "Prod":
                urlPLP = propertyReader.readApplicationFile("App_URL_Prod") + "/damen/schuhe/c-ws";
                break;
            case "QA":
                urlPLP = propertyReader.readApplicationFile("App_URL_QA") + "/damen/schuhe/c-ws";
                break;
            default:
                System.out.println("Please verify the environment variable!!");
        }

        urlPLP = productListPage.URLDamenSchuhe(shop, environment);

        driver.get(urlPLP);
        homePage.produktAuswahlenPLP(shop);


        homePage.clickOnChooseSize();
        //homePage.selectShoeSize44();
        homePage.selectShoeSize44();
        //homePage.searchSizeEnabled();
        homePage.clickOnAddToCart(shop, false);
        homePage.clickOnSafelyCheckoutButton(mobileOrDesktop);

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

        versandArtPage.setLiefermethode(shop);

        zahlungsMethodePage.setPaymentMethode(mobileOrDesktop, shop);
        zahlungsMethodePage.setZahlungsMethodeVerwenden(mobileOrDesktop, shop);




    }






}
