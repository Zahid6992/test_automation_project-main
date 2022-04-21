package com.testCasesTestNG.Registrierung;

import com.utils.ExcelDataReader;
import com.utils.DriverTestCase;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

public class RegistrierungExcelReader extends DriverTestCase{

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test()
    public void clicnewAccount(String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException, InterruptedException {
        loginPage.clickOnCookiesOkayButton(shop, environment);
        loginPage.mouseHoverOnRegisterIcon();
        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(2000) ;

    }

    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dependsOnMethods = "clicnewAccount")
    public  void chooseGender(String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException {
        registrationPage.selectGenderFrau();
        Thread.sleep(2000) ;
    }

    @DataProvider
    public Object[][] getRegistrationData() throws IOException {
        String excel_lo = propertyReader.readApplicationFile("Excel_location");
        Object data[][] = ExcelDataReader.getDataFromExcel(excel_lo);
        return data ;

    }


    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @Test(dataProvider = "getRegistrationData",dependsOnMethods = "chooseGender")
    public void  creatAccountNew (String geschlescht ,String vorname, String nachname,String email,String password, String strasse , String hausnummer, String postleizahl ,String stadt, String mobileOrDesktop, String deviceName, String shop, String environment) throws InterruptedException, IOException {
        //registrationPage.clickOnNewAccount();
        //registrationPage.selectGenderFrau();
        //String name = randomString(10);
        //System.out.println("Login with email : " + name + "@gmail.com");

        System.out.println(geschlescht);
        formularLieferadresse.enterFirstname(vorname);
        formularLieferadresse.enterLastName(nachname);
        formularLieferadresse.enterEmail(email);
        registrationPage.enterPwd(password);
        formularLieferadresse.enterStreet(strasse);
        formularLieferadresse.enterHouseNumber(hausnummer);
        formularLieferadresse.enterPostalCode(postleizahl);
        formularLieferadresse.enterCity(stadt);
        registrationPage.selectPolicy(shop, "false");
        // registrationPage.ClickOnRegister();
        System.out.println("New User Registered Successfully");
        Thread.sleep(2000);

        this.driver.get(propertyReader.readApplicationFile("App_URL"));
        Thread.sleep(2000);
        // loginPage.clickOnCookiesOkayButton();
        loginPage.mouseHoverOnRegisterIcon();

        registrationPage.clickOnNewAccount(shop);
        Thread.sleep(2000);

    }




}


