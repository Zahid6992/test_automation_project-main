package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.Key;

public class FormularNeueLieferAdresseHinzufuegen extends DriverHelper{


    public FormularNeueLieferAdresseHinzufuegen(WebDriver webdriver) {
        super(webdriver);
    }

    //@FindBy(xpath = "(//span[@class='input-radio'])[position()=1]")
    //@FindBy(xpath = "(//span[@data-key='myAccount.component.personalData.gendertype.woman'])[position()=1]")
    @FindBy(xpath = "//div[@id='new-address-modal']//span[@data-key='myAccount.component.personalData.gendertype.woman']")
    private WebElement frau;

    @FindBy(xpath = "//div[@id='new-address-modal']")
    private WebElement newAdressModal;

    //@FindBy(xpath = "(//input[@id='firstName'])[position()=1]")
    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='firstName']")
    private WebElement txtfirstnameNewADress;

    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='town']")
    private WebElement cityNewADress;

//    @FindBy(xpath = "(//input[@id='lastName'])[position()=1]")
    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='lastName']")
    private WebElement txtlastnameNewAdress;

    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='line1']")
    private WebElement txtline1NewAdress;

    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='line2']")
    private WebElement txtline2NewAdress;

    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='postalCode']")
    private WebElement txtpostalcodeNewAdress;

    @FindBy(xpath = "//div[@id='new-address-modal']//input[@id='town']")
    private WebElement txtcityNewAdress;

    @FindBy(xpath = "//input[@id='phone']")
    private WebElement phonetxt;

    @FindBy(xpath = "//div[@id='new-address-modal']//button[@data-value='Speichern']")
    private WebElement btnspeichern;

    @FindBy(xpath = "//div[@id='new-address-modal']//button[@data-value='Speichern']")
    private WebElement btnspeichernDSD;

    @FindBy(xpath = "(//div[@id='new-address-modal']//button[@data-value='Speichern'])[position()=1]")
    private WebElement btnspeichernDUK;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=1]")
    private WebElement btnspeichernVHS;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=1]")
    private WebElement btnspeichernDHU;

    final public String  findAdressButtonXPATH = "//button[@data-value='Find Address']";
    @FindBy(xpath = findAdressButtonXPATH)
    private WebElement findAdressButton;

    @FindBy(xpath = "(//span[contains(text(),'3 Prize Walk LONDON, E20 1AA, United Kingdom')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdress;

    @FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=2]")
    private WebElement confirmAdress;

    @FindBy(xpath = "(//span[contains(text(),' Confirm address ')])[position()=1]")
    private WebElement confirmAdressDUK;

    @FindBy(xpath = "(//span[contains(text(),'105 1 De Ruijterkade AMSTERDAM, 1011 AB')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdressVHS;

    final public String confirmAdressVHSAXPATH = "//m-button[@data-key='register-checkout.component.suggestModal.button']";
    @FindBy(xpath = confirmAdressVHSAXPATH)
    private WebElement confirmAdressVHSA;

    final public String confirmAdressVHSAXPBTH = "//button[@data-value='']";
    @FindBy(xpath = confirmAdressVHSAXPBTH)
    private WebElement confirmAdressVHSB;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;


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


    public void genderFrau() {
        frau.click();
    }

    public void modal() {
        newAdressModal.click();
    }

    public void phoneEnterNewAdress(String phone) {
        phonetxt.click();
    }

    public void AdresseSpeichernNewAdress(String shop) throws InterruptedException {
        switch (shop) {
            case "DSD":
                btnspeichernDSD.click();
                break;
            case "VHS":
                btnspeichernVHS.click();
                break;
            case "DHU":
                txtline1NewAdress.sendKeys(Keys.ENTER);
                //btnspeichernDHU.click();
                break;
            case "DOS":
                btnspeichern.click();
                Thread.sleep(3000);

                break;
            case "DUK":
                Thread.sleep(500);
                cityNewADress.sendKeys(Keys.TAB);
                Thread.sleep(500);
                btnspeichernDUK.click();
                break;
            default:
                btnspeichern.click();
        }
    }



    public RegistrationPage enterPostalCodeNewAdress(String shop) throws InterruptedException {


        String postalcode = null;
        switch (shop) {
            case "DSD":
                postalcode = "44225";
                break;
            case "DHU":
                postalcode = "1020";
                break;
            case "DOS":
                postalcode = "8000";
                break;
            case "VBE":
                postalcode = "1020";
                break;
            case "VHS":
                postalcode = "1011AB";
                break;
            case "DUK":
                postalcode = "E20 1AA";
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }

        txtpostalcodeNewAdress.click();
        txtpostalcodeNewAdress.sendKeys(postalcode);
        Thread.sleep(500);
        txtpostalcodeNewAdress.sendKeys(Keys.ENTER);
        Thread.sleep(500);
        txtpostalcodeNewAdress.sendKeys(Keys.TAB);
        Thread.sleep(500);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage enterCityNewAdress(String City) {

        txtcityNewAdress.click();
        txtcityNewAdress.sendKeys(City);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterStreetNewAdress(String Street) {

        txtline1NewAdress.click();
        txtline1NewAdress.sendKeys(Street);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage enterHouseNumberNewAdress(String Housenumber) throws InterruptedException {

        txtline2NewAdress.click();
        txtline2NewAdress.sendKeys(Housenumber);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage enterFirstnameNewAdress(String firstname) {

        txtfirstnameNewADress.click();
        txtfirstnameNewADress.sendKeys(firstname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage enterLastNameNewAdress(String lastname) {

        txtlastnameNewAdress.click();
        txtlastnameNewAdress.sendKeys(lastname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage formularAusfuellenNeueLieferadresse(String vorname, String nachname, String shop, String strasse, String hausnummer) throws InterruptedException {

        enterFirstnameNewAdress("Lifer");
        Thread.sleep(500);
        enterLastNameNewAdress("Liefertest");
        Thread.sleep(500);
        enterPostalCodeNewAdress(shop);



        if (shop.equalsIgnoreCase("VHS"))
        {

            Thread.sleep(2000);
            findAdressButton.click();
            Thread.sleep(2000);
            firstAdressVHS.click();
            Thread.sleep(2000);
            if (!driver.findElements(By.xpath(confirmAdressVHSAXPATH)).isEmpty()) {
                confirmAdressVHSA.click();
            }
            Thread.sleep(2000);
            if (!driver.findElements(By.xpath(confirmAdressVHSAXPBTH)).isEmpty()) {
                confirmAdressVHSB.click();
            }

            Thread.sleep(2000);
        }

        if (shop.equalsIgnoreCase("DUK"))
        {


            findAdressDUK();
            Thread.sleep(2000);
/*            firstAdress.click();
            Thread.sleep(1000);
            confirmAdressDUK.click();
            Thread.sleep(2000);*/
/*            if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                optionListe1.click();
            }
            Thread.sleep(2000);*/

            enterHouseNumberNewAdress("10");
        }

        if (!shop.equalsIgnoreCase("DUK"))
        {
            Thread.sleep(500);
            enterStreetNewAdress("Hörderstr");
            Thread.sleep(500);
            if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                optionListe1.click();
            }
            Thread.sleep(500);
            enterHouseNumberNewAdress("10");
            Thread.sleep(500);
            enterCityNewAdress("Dortmund");
            Thread.sleep(500);
            if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                optionListe1.click();
            }
        }



        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }




}
