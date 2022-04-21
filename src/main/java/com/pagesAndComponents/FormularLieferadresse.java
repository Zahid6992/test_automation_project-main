package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormularLieferadresse extends DriverHelper{

    public FormularLieferadresse(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(xpath = "(//input[@id='delivery-firstName'])[position()=1]")
    private WebElement txtfirstname;

    @FindBy(xpath = "(//input[@id='delivery-lastName'])[position()=1]")
    private WebElement txtlastname;

    @FindBy(xpath = "//input[@id='delivery-email']")
    private WebElement txtemail;

    @FindBy(xpath = "//input[@id='delivery-line1']")
    private WebElement txtline1;

    final public String  txtline1DSDXPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = txtline1DSDXPATH)
    private WebElement txtline1DSD;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    @FindBy(xpath = "//input[@id='delivery-line2']")
    private WebElement txtline2;

    @FindBy(xpath = "//span[@data-zip='3045']")
    private WebElement option1;

    final public String  option1XPATH = "//span[@data-zip='3045']";

    @FindBy(xpath = "//input[@id='delivery-postalCode']")
    private WebElement txtpostalcode;

    final public String  txtcityXPATH = "//input[@id='delivery-town']";
    @FindBy(xpath = txtcityXPATH)
    private WebElement txtcity;

    @FindBy(xpath = "(//span[@class='uniserv-item'])[position()=1]")
    private WebElement txtcityOption1;

    @FindBy(xpath = "//input[@id='delivery-phone']")
    private WebElement txttelefon;

    @FindBy(xpath = "//input[@id='delivery-password']")
    private WebElement passwordan;

    @FindBy(xpath = "//button[@data-value='Find Address']")
    private WebElement findAdressButton;

    @FindBy(xpath = "(//span[contains(text(),'17 Prize Walk LONDON, E20 1AB, United Kingdom')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdress;

    @FindBy(xpath = "(//span[contains(text(),'3 Prize Walk LONDON, E20 1AA, United Kingdom')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdressDUK;

    @FindBy(xpath = "(//span[contains(text(),'105 1 De Ruijterkade AMSTERDAM, 1011 AB')])[position()=1]")
//    @FindBy(xpath = "(//span[contains(text(),'125 De Ruijterkade AMSTERDAM, 1011 AC')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdressVHS;

    @FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=2]")
    private WebElement confirmAdress;

    @FindBy(xpath = "//span[contains(text(),' Confirm Address ')]")
    private WebElement confirmAdressDUK;

    final public String confirmAdressVHSAXPATH = "//m-button[@data-key='register-checkout.component.suggestModal.button']";
    @FindBy(xpath = confirmAdressVHSAXPATH)
    private WebElement confirmAdressVHSA;

    final public String confirmAdressVHSAXPBTH = "//button[@data-value='']";
    @FindBy(xpath = confirmAdressVHSAXPBTH)
    private WebElement confirmAdressVHSB;

    public RegistrationPage enterFirstname(String firstname) {

        txtfirstname.click();
        txtfirstname.sendKeys(firstname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage clearPostalCode() {

        txtpostalcode.clear();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterLastName(String lastname) {

        txtlastname.click();
        txtlastname.sendKeys(lastname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterEmail(String email) {

        txtemail.click();
        txtemail.sendKeys(email);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterStreet(String Street) throws InterruptedException {
        Thread.sleep(500);
        txtline1.clear();
        Thread.sleep(500);
        txtline1.click();
        Thread.sleep(500);
        txtline1.sendKeys(Street);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterStreetOption1() throws InterruptedException {

        txtline1DSD.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterHouseNumber(String Housenumber) throws InterruptedException {
        Thread.sleep(500);
        txtline2.clear();
        Thread.sleep(500);
        txtline2.click();
        Thread.sleep(500);
        txtline2.sendKeys(Housenumber);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage postalCode(String shop) throws InterruptedException {

        if (shop.equalsIgnoreCase("VHS"))
        {
            enterPostalCode(shop);
            Thread.sleep(2000);
//            findAdressButton.click();
//            Thread.sleep(2000);
            findAdressVHS();
            Thread.sleep(2000);
            clearPostalCode();

        }
        if (shop.equalsIgnoreCase("DUK"))
        {

                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                findAdressDUK();
                Thread.sleep(2000);
                clearPostalCode();


        }
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage enterPostalCode(String shop) throws InterruptedException {
        txtpostalcode.clear();
        Thread.sleep(500);
        txtpostalcode.click();
        Thread.sleep(500);
        setPlzMap(plzMap);
        txtpostalcode.sendKeys(plzMap.get(shop));
        Thread.sleep(3000);
        if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
            optionListe1.click();
        }
        txtpostalcode.click();
        Thread.sleep(3000);
        txtpostalcode.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage findAdressDUK() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,200)");
        Thread.sleep(2000);
        findAdressButton.click();
        Thread.sleep(2000);
        firstAdress.click();
        Thread.sleep(2000);
        confirmAdressDUK.click();
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage findAdressVHS() throws InterruptedException {
        Thread.sleep(10000);
        findAdressButton.click();
        Thread.sleep(2000);
        firstAdressVHS.click();
        Thread.sleep(2000);
        if (!driver.findElements(By.xpath(confirmAdressVHSAXPATH)).isEmpty()) {
            confirmAdressVHSA.click();
        }
        else if (!driver.findElements(By.xpath(confirmAdressVHSAXPBTH)).isEmpty()) {
            confirmAdressVHSB.click();
        }

        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterCity(String City) throws InterruptedException {

        txtcity.clear();
        Thread.sleep(500);
        txtcity.click();
        Thread.sleep(500);
        txtcity.sendKeys(City);
        Thread.sleep(500);
        if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
            optionListe1.click();
        }
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterCityDSD() {

        txtcityOption1.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterTelefonnumber(String telefon) throws InterruptedException {

        txttelefon.clear();
        Thread.sleep(500);
//        txttelefon.click();
        Thread.sleep(500);
        txttelefon.sendKeys(telefon);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterPasswordAlsGast(String p) {
        passwordan.sendKeys(p);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public void clearFelds() throws InterruptedException {
        Thread.sleep(500);
        txtline2.clear();
        Thread.sleep(500);
        txtline2.click();
        Thread.sleep(500);
        txtline1.clear();
        Thread.sleep(500);
        txtline1.click();
        Thread.sleep(500);
        txtcity.clear();
        Thread.sleep(500);
        txtcity.click();
        Thread.sleep(500);

    }


    public void lieferadresseAusfuellen(String email, String shop, String vorname, String nachname, String strasse, String haunummer, String stadt, String password) throws InterruptedException {

        enterFirstname(vorname);
        Thread.sleep(500);
        enterLastName(nachname);
        Thread.sleep(500);
        enterEmail(email);


        switch (shop)
        {
            case "DUK":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                findAdressDUK();
                Thread.sleep(3000);
                enterHouseNumber(haunummer);
                break;
            case "DHU":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);


                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(5000) ;
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(2000) ;
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,-250)");
                Thread.sleep(1000);
                enterTelefonnumber("+36300000000");
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
//                enterCity(stadt);
                Thread.sleep(500);
                break;
            case "VHS":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(2000) ;
                jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,-500)");
                Thread.sleep(2000) ;
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(1000);
                findAdressVHS();
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
                break;
            case "DSD":
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
               //enterStreetOption1();
                Thread.sleep(1000);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
/*                enterCity(stadt);
                Thread.sleep(500);
                enterCityDSD();
                Thread.sleep(500);*/
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
                break;

            default:
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                enterHouseNumber(haunummer);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
        }





        if (password.equalsIgnoreCase("null")) {
            System.out.println("Kein Password ist erforderlich");
        } else {
            enterPasswordAlsGast(password);
        }

    }

    public void lieferadresseAusfuellenLeer(String email, String shop, String vorname, String nachname, String strasse, String haunummer, String stadt, String password) throws InterruptedException {



        switch (shop)
        {
            case "DUK":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                findAdressDUK();
                Thread.sleep(3000);
                enterHouseNumber(haunummer);
                break;
            case "DHU":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(5000) ;
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(2000) ;
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,-250)");
                Thread.sleep(1000);
                enterTelefonnumber("+36300000000");
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(1000);
                Thread.sleep(500);
                break;
            case "VHS":
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                findAdressButton.click();
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
                break;
            case "DSD":
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                //enterStreetOption1();
                Thread.sleep(1000);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
/*                enterCity(stadt);
                Thread.sleep(500);
                enterCityDSD();
                Thread.sleep(500);*/
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
                break;

            default:
                Thread.sleep(500);
                enterPostalCode(shop);
                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(500);
                enterHouseNumber(haunummer);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);
        }





        if (password.equalsIgnoreCase("null")) {
            System.out.println("Kein Password ist erforderlich");
        } else {
            enterPasswordAlsGast(password);
        }

    }



}
