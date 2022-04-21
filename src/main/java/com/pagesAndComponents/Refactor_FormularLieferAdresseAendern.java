package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class Refactor_FormularLieferAdresseAendern extends DriverHelper{

    public boolean compareRechnungsadress ;

    public Refactor_FormularLieferAdresseAendern(WebDriver webdriver) {
        super(webdriver);
    }

    public String newAdress = "";

    @FindBy(xpath = "(//section[@class='defaultDeliveryAddress']//m-address-card//*[local-name() = 'svg'])[position()=1]")
    private WebElement aendernSymbolDelivery;

    final private static String aendernSymbolDeliveryVBEXPATH = "(//section[@class='defaultDeliveryAddress']//m-address-card//*[local-name() = 'svg'])[position()=1]";
    @FindBy(xpath = aendernSymbolDeliveryVBEXPATH)
    private WebElement aendernSymbolDeliveryVBE;

    @FindBy(xpath = "(//section[@class='defaultDeliveryAddress']//m-address-card//*[local-name() = 'svg'])[position()=1]")
    private WebElement aendernSymbolDeliveryVHS;

    @FindBy(xpath = "(//section[@class='defaultDeliveryAddress']//m-address-card//*[local-name() = 'svg'])[position()=1]")
    private WebElement aendernSymbolDeliveryDSD;

    @FindBy(xpath = "//div[@id='edit-address-modal-322']")
    private WebElement modal;

    @FindBy(xpath = "(//section[@class='defaultDeliveryAddress']//m-address-card//*[local-name() = 'svg'])[position()=1]")
    private WebElement aendernSymbolDeliveryDOS;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPayment;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPaymentVBE;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPaymentDUK;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPaymentVHS;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPaymentDSD;

    @FindBy(xpath = "(//section[@class='defaultPaymentAddress']//m-address-card//*[local-name() = 'svg'])[position()=2]")
    private WebElement aendernSymbolPaymentDOS;

    @FindBy(xpath = "//input[@id='1']")
    private WebElement herr;

//    @FindBy(xpath = "//input[@id='firstName'])[position()=2]")
    @FindBy(xpath = "(//div[@id='edit-address-modal-314']//form[@method='POST']//input[@id='firstName'])")
    private WebElement vornameDelivery;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//form[@method='POST']//input[@id='firstName'])")
    private WebElement vornameDeliveryDOS;

//    @FindBy(xpath = "(//input[@id='firstName'])[position()=3]")
    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='firstName'])[position()=2]")
    private WebElement vornamePayment;

//    @FindBy(xpath = "(//input[@id='lastName'])[position()=2]")
    @FindBy(xpath = "//div[@id='edit-address-modal-322']//input[@id='lastName']")
    private WebElement nachnameDelivery;

    @FindBy(xpath = "//div[@data-key='core.component.addressCard.edit']//input[@id='lastName']")
    private WebElement nachnameDeliveryDOS;


//    @FindBy(xpath = "(//input[@id='lastName'])[position()=3]")
    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='lastName'])[position()=2]")
    private WebElement nachnamePayment;

//    @FindBy(xpath = "(//input[@data-key='myAccount.addresses.component.phone.placeholder'])[position()=1]")
    @FindBy(xpath = "//div[@id='edit-address-modal-322']//input[@data-key='myAccount.addresses.component.phone.placeholder']")
    private WebElement phonePayment;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='phone'])[position()=1]")
    private WebElement phonePaymentVHS;

//    @FindBy(xpath = "(//input[@id='line1'])[position()=1]")
    @FindBy(xpath = "(//input[@id='line1'])[position()=2]")
    private WebElement strasseDelivery;

//    @FindBy(xpath = "(//input[@id='line1'])[position()=2]")
    @FindBy(xpath = "//div[@id='edit-address-modal-322']//input[@id='line1']")
    private WebElement strasseDeliveryDHU;

//    @FindBy(xpath = "(//input[@id='line1'])[position()=2]")
    @FindBy(xpath = "//div[@id='edit-address-modal-322']//input[@id='line1']")
    private WebElement strasseDeliveryVBE;

    @FindBy(xpath = "//div[@data-key='core.component.addressCard.edit']//input[@id='line1']")
    private WebElement strasseDeliveryDOS;

    @FindBy(xpath = "(//input[@id='line1'])[position()=2]")
    private WebElement strassePayment;

    @FindBy(xpath = "(//input[@id='line1'])[position()=3]")
    private WebElement strassePaymentVBE;


    @FindBy(xpath = "(//input[@id='line1'])[position()=3]")
    private WebElement strassePaymentDHU;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='line1'])[position()=2]")
    private WebElement strassePaymentDOS;

    @FindBy(xpath = "(//input[@id='line2'])[position()=2]")
    private WebElement hausnummerDelivery;

    @FindBy(xpath = "(//input[@id='line2'])[position()=2]")
    private WebElement hausnummerDeliveryDHU;

    @FindBy(xpath = "(//input[@id='line2'])[position()=2]")
    private WebElement hausnummerDeliveryVBE;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='line2'])[position()=1]")
    private WebElement hausnummerDeliveryDOS;

    @FindBy(xpath = "(//input[@id='line2'])[position()=3]")
    private WebElement hausnummerPayment;

    @FindBy(xpath = "(//input[@id='line2'])[position()=3]")
    private WebElement hausnummerPaymentVBE;

    @FindBy(xpath = "(//input[@id='line2'])[position()=3]")
    private WebElement hausnummerPaymentDHU;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='line2'])[position()=2]")
    private WebElement hausnummerPaymentDOS;

    @FindBy(xpath = "(//input[@id='postalCode'])[position()=2]")
    private WebElement postleizahlDelivery;

    @FindBy(xpath = "//div[@data-key='core.component.addressCard.edit']//input[@id='postalCode']")
    private WebElement postleizahlDeliveryDOS;

    @FindBy(xpath = "(//input[@id='postalCode'])[position()=3]")
    private WebElement postleizahlPayment;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='postalCode'])[position()=2]")
    private WebElement postleizahlPaymentDOS;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='postalCode'])[position()=2]")
    private WebElement postleizahlPaymentVBE;

    @FindBy(xpath = "(//input[@id='town'])[position()=1]")
    private WebElement stadtDelivery;

    @FindBy(xpath = "(//input[@id='town'])[position()=2]")
    private WebElement stadtDeliveryVBE;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='town'])[position()=1]")
    private WebElement stadtDeliveryDOS;

    @FindBy(xpath = "(//input[@id='town'])[position()=2]")
    private WebElement stadtDeliveryDHU;

    @FindBy(xpath = "(//input[@id='town'])[position()=2]")
    private WebElement stadtPayment;

    @FindBy(xpath = "(//input[@id='town'])[position()=3]")
    private WebElement stadtPaymentVBE;

    @FindBy(xpath = "(//input[@id='town'])[position()=3]")
    private WebElement stadtPaymentDSD;

    @FindBy(xpath = "(//input[@id='town'])[position()=3]")
    private WebElement stadtPaymentDHU;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='town'])[position()=2]")
    private WebElement stadtPaymentDOS;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//button[@data-value='Speichern'])[position()=1]")
    private WebElement neueAdresseSpeichernDelivery;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=3]")
    private WebElement neueAdresseSpeichernDeliveryVBE;

    final public String  neueAdresseSpeichernDeliveryDSDXPATH = "(//button[@data-value='Speichern'])[position()=2]";
    @FindBy(xpath = neueAdresseSpeichernDeliveryDSDXPATH)
    private WebElement neueAdresseSpeichernDeliveryDSD;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=3]")
    private WebElement neueAdresseSpeichernDeliveryDHU;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=4]")
    private WebElement neueAdresseSpeichernPaymentVBE;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=3]")
    private WebElement neueAdresseSpeichernPaymentDSD;

    @FindBy(xpath = "(//form[@action='/my-account/addresses/edit']//button[@data-value='Speichern'])[position()=2]")
    private WebElement neueAdresseSpeichernPaymentDHU;

    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=4]")
    private WebElement neueAdresseSpeichernPaymentDOS;

    @FindBy(xpath = "(//m-address)[position()=1]")
    private WebElement verifyNewDeliveryAdress;

    @FindBy(xpath = "(//m-address)[position()=2]")
    private WebElement verifyNewPaymentAdress;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[4]")
    private WebElement country;

    @FindBy(xpath = "//input[@id='postalCode']")
    private WebElement txtpostalcodeNewAdress;

    @FindBy(xpath = "(//button[@data-value='Find Address'])[position()=2]")
    private WebElement findAdressButtonDelivery;

    @FindBy(xpath = "(//button[@data-value='Find Address'])[position()=2]")
    private WebElement findAdressButtonPayment;



    @FindBy(xpath = "(//input[@id='phone'])[position()=1]")
    private WebElement txttelefon;

    @FindBy(xpath = "(//input[@id='phone'])[position()=2]")
    private WebElement txttelefonDHU;

    @FindBy(xpath = "(//input[@id='phone'])[position()=3]")
    private WebElement txttelefonDHUPayment;

    @FindBy(xpath = "(//div[@data-key='core.component.addressCard.edit']//input[@id='phone'])[position()=2]")
    private WebElement txttelefonDOSPayment;

    @FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement adressOption;

    @FindBy(xpath = "//span[contains(text(),'Confirm Address')]")
    private WebElement confirmAdressDelivery;

    //@FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=3]")
    @FindBy(xpath = "//span[contains(text(),'Confirm Address')]")
    private WebElement confirmAdressPayment;

    @FindBy(xpath = "(//input[@id='line2'])[position()=3]")
    private WebElement hausnummerPaymentDSD;

//    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=0]";
    final public String  optionListe1XPATH = "(//span[@class='uniserv-wrap'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    //DSD
//    Delivery
/*    final public static String DSDXPATH = "(//div[@data-key='core.component.addressCard.edit']//form[@action='/my-account/addresses/edit']";

    final public static String vornameDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
    @FindBy(xpath = vornameDeliveryDSDXPATH)
    private WebElement vornameDeliveryDSD;

    final public static String nachnameDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='lastName'])[position()=2]";
    @FindBy(xpath = nachnameDeliveryDSDXPATH)
    private WebElement nachnameDeliveryDSD;

    final public static String strasseDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='line1'])[position()=2]";
    @FindBy(xpath = strasseDeliveryDSDXPATH)
    private WebElement strasseDeliveryDSD;

    final public static String hausnummerDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
    @FindBy(xpath = hausnummerDeliveryDSDXPATH)
    private WebElement hausnummerDeliveryDSD;

    final public static String postleizahlDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
    @FindBy(xpath = postleizahlDeliveryDSDXPATH)
    private WebElement postleizahlDeliveryDSD;

    final public static String stadtDeliveryDSDXPATH = DSDXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
    @FindBy(xpath = stadtDeliveryDSDXPATH)
    private WebElement stadtDeliveryDSD;*/


    //DUK
//    Delivery
    final public static String DUKXPATH = "(//div[@data-key='core.component.addressCard.edit']//form[@action='/my-account/addresses/edit']";

    final public static String vornameDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='firstName'])[position()=1]";
    @FindBy(xpath = vornameDeliveryDUKXPATH)
    private WebElement vornameDeliveryDUK;

    final public static String nachnameDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='lastName'])[position()=1]";
    @FindBy(xpath = nachnameDeliveryDUKXPATH)
    private WebElement nachnameDeliveryDUK;

    final public static String strasseDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='line1'])[position()=1]";
    @FindBy(xpath = strasseDeliveryDUKXPATH)
    private WebElement strasseDeliveryDUK;

    final public static String stadtDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='town'])[position()=1]";
    @FindBy(xpath = stadtDeliveryDUKXPATH)
    private WebElement stadtDeliveryDUK;

    final public static String hausnummerDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='line2'])[position()=1]";
    @FindBy(xpath = hausnummerDeliveryDUKXPATH)
    private WebElement hausnummerDeliveryDUK;

    final public static String postleizahlDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='postalCode'])[position()=1]";
    @FindBy(xpath = postleizahlDeliveryDUKXPATH)
    private WebElement postleizahlDeliveryDUK;


    final public static String neueAdresseSpeichernDeliveryDUKXPATH = DUKXPATH + "//input[@formcontrolname='town'])[position()=1]";
    @FindBy(xpath = "(//button[@data-value='Speichern'])[position()=3]")
    private WebElement neueAdresseSpeichernDeliveryDUK;

//    Payment

    final public static String stadtPaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='town'])[position()=2]";
    @FindBy(xpath = stadtPaymentDUKXPATH)
    private WebElement stadtPaymentDUK;

    final public static String strassePaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='line1'])[position()=2]";
    @FindBy(xpath = strassePaymentDUKXPATH)
    private WebElement strassePaymentDUK;

    final public static String hausnummerPaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='line2'])[position()=2]";
    @FindBy(xpath = hausnummerPaymentDUKXPATH)
    private WebElement hausnummerPaymentDUK;

//    final public static String findAdressButtonPaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
//    @FindBy(xpath = findAdressButtonPaymentDUKXPATH)
//    private WebElement findAdressButtonPaymentDUK;

    final public static String vornamePaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='firstName'])[position()=2]";
    @FindBy(xpath = vornamePaymentDUKXPATH)
    private WebElement vornamePaymentDUK;

    final public static String nachnamePaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='lastName'])[position()=2]";
    @FindBy(xpath = nachnamePaymentDUKXPATH)
    private WebElement nachnamePaymentDUK;

    final public static String phonePaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='phone1'])[position()=1]";
    @FindBy(xpath = phonePaymentDUKXPATH)
    private WebElement phonePaymentDUK;

    final public static String phonePaymentDHUXPATH = DUKXPATH + "//input[@formcontrolname='phone1'])[position()=2]";
    @FindBy(xpath = phonePaymentDHUXPATH)
    private WebElement phonePaymentDHU;

    final public static String postleizahlPaymentDUKXPATH = DUKXPATH + "//input[@formcontrolname='postalCode'])[position()=2]";
    @FindBy(xpath = postleizahlPaymentDUKXPATH)
    private WebElement postleizahlPaymentDUK;



    public void lieferAdresseAendernMeinKonto(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String Shop) throws InterruptedException {

        setPlzMap(plzMap);
        setcountryMap(countryMap);

        switch (Shop)
        {
            case "DSD":
                Thread.sleep(5000);
                aendernSymbolDeliveryDSD.click();
                Thread.sleep(5000);
//                modal.click();
//                Thread.sleep(500);
                vornameDeliveryDUK.click();
                Thread.sleep(500);
                vornameDeliveryDUK.clear();
                Thread.sleep(500);
                vornameDeliveryDUK.sendKeys(Vorname);
                Thread.sleep(500);
                nachnameDeliveryDUK.clear();
                Thread.sleep(500);
                nachnameDeliveryDUK.sendKeys(Nachname);
                Thread.sleep(2000);
                postleizahlDeliveryDUK.clear();
                Thread.sleep(500);
                postleizahlDeliveryDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                strasseDeliveryDUK.click();
                Thread.sleep(2000);
                strasseDeliveryDUK.clear();
                Thread.sleep(500);
                strasseDeliveryDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerDeliveryDUK.clear();
                Thread.sleep(500);
                hausnummerDeliveryDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtDeliveryDUK.clear();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys("Dortmund");
                Thread.sleep(500);
                vornameDeliveryDUK.click();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys(Keys.TAB);
                Thread.sleep(500);
                neueAdresseSpeichernDelivery.click();
                Thread.sleep(15000);
                break;

            case "VHS":
                aendernSymbolDeliveryVHS.click();
                Thread.sleep(2000);
                vornameDeliveryDOS.clear();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Vorname);
                Thread.sleep(500);
                nachnameDeliveryDOS.clear();
                Thread.sleep(500);
                nachnameDeliveryDOS.sendKeys(Nachname);
                Thread.sleep(2000);
                postleizahlDeliveryDOS.clear();
                Thread.sleep(500);
                postleizahlDeliveryDOS.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
//                findAdressButtonDelivery.click();
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(2000);
                hausnummerDeliveryDOS.clear();
                Thread.sleep(500);
                hausnummerDeliveryDOS.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                strasseDeliveryDOS.click();
                Thread.sleep(2000);
                strasseDeliveryDOS.clear();
                Thread.sleep(500);
                strasseDeliveryDOS.sendKeys(Strasse);
                Thread.sleep(500);
                strasseDeliveryDOS.sendKeys(Keys.TAB);

                Thread.sleep(2000);
                stadtDeliveryDOS.clear();
                Thread.sleep(500);
                stadtDeliveryDOS.sendKeys(Stadt);
                Thread.sleep(500);
                neueAdresseSpeichernDelivery.click();
                Thread.sleep(15000);
                break;
            case "VBE":
                aendernSymbolDeliveryVBE.click();
                Thread.sleep(2000);
                vornameDeliveryDOS.clear();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Vorname);
                Thread.sleep(500);
                nachnameDeliveryDOS.clear();
                Thread.sleep(500);
                nachnameDeliveryDOS.sendKeys(Nachname);
                Thread.sleep(2000);
                postleizahlDeliveryDOS.clear();
                Thread.sleep(500);
                postleizahlDeliveryDOS.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
               // findAdressButtonDelivery.click();
/*                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }*/
                Thread.sleep(2000);
                vornameDeliveryDOS.click();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                strasseDeliveryDOS.click();
                Thread.sleep(2000);
                strasseDeliveryDOS.clear();
                Thread.sleep(500);
                strasseDeliveryDOS.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerDeliveryVBE.clear();
                Thread.sleep(500);
                hausnummerDeliveryVBE.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtDeliveryVBE.clear();
                Thread.sleep(500);
                stadtDeliveryVBE.sendKeys(Stadt);
                Thread.sleep(500);
                stadtDeliveryVBE.sendKeys(Keys.ENTER);
                Thread.sleep(500);
                neueAdresseSpeichernDeliveryVBE.click();
                Thread.sleep(15000);
              //  neueAdresseSpeichernDeliveryVBE.click();
              //  Thread.sleep(15000);
                break;
            case "DHU":
                aendernSymbolDelivery.click();
                Thread.sleep(2000);
                vornameDeliveryDUK.clear();
                Thread.sleep(500);
                vornameDeliveryDUK.sendKeys(Vorname);
                Thread.sleep(500);
                nachnameDeliveryDUK.clear();
                Thread.sleep(500);
                nachnameDeliveryDUK.sendKeys(Nachname);
                Thread.sleep(2000);
                postleizahlDeliveryDUK.clear();
                Thread.sleep(500);
                postleizahlDeliveryDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                phonePaymentDUK.click();
                Thread.sleep(500);
                phonePaymentDUK.clear();
                Thread.sleep(500);
                phonePaymentDUK.sendKeys("+36300000000");
                Thread.sleep(500);
                strasseDeliveryDUK.click();
                Thread.sleep(2000);
                strasseDeliveryDUK.clear();
                Thread.sleep(500);
                strasseDeliveryDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerDeliveryDUK.clear();
                Thread.sleep(500);
                hausnummerDeliveryDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtDeliveryDUK.clear();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys(Stadt);
                Thread.sleep(500);
                stadtDeliveryDUK.click();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys(Keys.TAB);
                Thread.sleep(500);
                neueAdresseSpeichernDelivery.click();
                Thread.sleep(10000);
                break;
            case "DUK":
                Thread.sleep(500);
                aendernSymbolDeliveryVBE.click();
                Thread.sleep(2000);
                vornameDeliveryDUK.clear();
                Thread.sleep(500);
                vornameDeliveryDUK.sendKeys(Vorname);
                Thread.sleep(500);
                nachnameDeliveryDUK.clear();
                Thread.sleep(500);
                nachnameDeliveryDUK.sendKeys(Nachname);
                Thread.sleep(500);
                postleizahlDeliveryDUK.clear();
                Thread.sleep(500);
                postleizahlDeliveryDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(3000);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(2000);
                strasseDeliveryDUK.click();
                Thread.sleep(500);
                strasseDeliveryDUK.clear();
                Thread.sleep(500);
                strasseDeliveryDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerDeliveryDUK.clear();
                Thread.sleep(500);
                hausnummerDeliveryDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtDeliveryDUK.clear();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys(Stadt);
                Thread.sleep(500);
                vornameDeliveryDUK.click();
                Thread.sleep(500);
                stadtDeliveryDUK.sendKeys(Keys.TAB);
                Thread.sleep(500);
                neueAdresseSpeichernDelivery.click();
                Thread.sleep(15000);
                break;
            case "DOS":
                Thread.sleep(8000);
                aendernSymbolDeliveryDOS.click();
                Thread.sleep(2000);
                vornameDeliveryDOS.clear();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Vorname);
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                nachnameDeliveryDOS.clear();
                Thread.sleep(500);
                nachnameDeliveryDOS.sendKeys(Nachname);
                Thread.sleep(500);
                nachnameDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                strasseDeliveryDOS.click();
                Thread.sleep(2000);
                strasseDeliveryDOS.clear();
                Thread.sleep(500);
                strasseDeliveryDOS.sendKeys(Strasse);
                Thread.sleep(500);
                vornameDeliveryDOS.click();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                hausnummerDeliveryDOS.clear();
                Thread.sleep(500);
                hausnummerDeliveryDOS.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                hausnummerDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                postleizahlDeliveryDOS.clear();
                Thread.sleep(500);
                postleizahlDeliveryDOS.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                postleizahlDeliveryDOS.sendKeys(Keys.TAB);
/*                Thread.sleep(500);
                findAdressButtonDelivery.click();
                Thread.sleep(500);
                adressOption.click();
                Thread.sleep(500);
                confirmAdressDelivery.click();*/
                stadtDeliveryDOS.clear();
                Thread.sleep(500);
                stadtDeliveryDOS.sendKeys(Stadt);
                Thread.sleep(500);
                vornameDeliveryDOS.click();
                Thread.sleep(500);
                vornameDeliveryDOS.sendKeys(Keys.TAB);
                Thread.sleep(500);
                neueAdresseSpeichernDelivery.click();
                Thread.sleep(15000);
                break;
        }

switch (Shop)
{
    case "DHU":
        System.out.println(verifyNewDeliveryAdress.getText());
        String newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer.toString() + "\n" +
                plzMap.get(Shop)  + " " + Stadt + "\n" +
                countryMap.get(Shop) ;
//                + "\n" + "+36300000000";
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
        break;

    case "DUK":
        System.out.println(verifyNewDeliveryAdress.getText());
        newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer.toString() + "\n" +
                plzMap.get(Shop)  + " " + Stadt + "\n" +
                "United Kingdom"  ;
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
        break;

    case "DOS":
        System.out.println(verifyNewDeliveryAdress.getText());
        newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer.toString() + "\n" +
                plzMap.get(Shop)  + " " + Stadt + "\n" +
                "Schweiz"  ;
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
        break;

    case "VHS" :
    case "VBE":
        System.out.println(verifyNewDeliveryAdress.getText());
        newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer.toString() + "\n" +
                plzMap.get(Shop)  + " " + Stadt + "\n" +
                countryMap.get(Shop)  ;
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
        break;

    default:
        System.out.println(verifyNewDeliveryAdress.getText());
        newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer.toString() + "\n" +
                plzMap.get(Shop)  + " " + "Dortmund" + "\n" +
                countryMap.get(Shop)  ;
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
}


    }


    public void rechnungsAdresseAendernMeinKonto(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String phone, String Shop) throws InterruptedException {

        setPlzMap(plzMap);
        switch (Shop)
        {

            case "DSD":
                aendernSymbolPaymentDSD.click();
                Thread.sleep(5000);
                vornamePaymentDUK.clear();
                Thread.sleep(500);
                vornamePaymentDUK.sendKeys(Vorname);
                Thread.sleep(500);
                phonePaymentDUK.click();
                Thread.sleep(500);
                phonePaymentDUK.clear();
                Thread.sleep(500);
                phonePaymentDUK.sendKeys("+49" + phone);
                Thread.sleep(500);
                nachnamePaymentDUK.clear();
                Thread.sleep(500);
                nachnamePaymentDUK.sendKeys(Nachname);
                Thread.sleep(500);
                postleizahlPaymentDUK.clear();
                Thread.sleep(500);
                postleizahlPaymentDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);

//                findAdressButtonPayment.click();
//                Thread.sleep(500);
                // country.click();
                Thread.sleep(500);
                strassePaymentDUK.clear();
                Thread.sleep(500);
                strassePaymentDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerPaymentDUK.clear();
                Thread.sleep(500);
                hausnummerPaymentDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);

                stadtPaymentDUK.clear();
                Thread.sleep(500);
                stadtPaymentDUK.sendKeys(Stadt);
                Thread.sleep(500);
                hausnummerPaymentDUK.click();
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);
                break;
            case "VHS":
                Thread.sleep(2000);
                aendernSymbolPaymentVHS.click();
                Thread.sleep(2000);
                vornamePayment.clear();
                Thread.sleep(500);
                vornamePayment.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePayment.clear();
                Thread.sleep(500);
                nachnamePayment.sendKeys(Nachname);
                Thread.sleep(500);
                phonePaymentVHS.click();
                Thread.sleep(500);
                phonePaymentVHS.clear();
                Thread.sleep(500);
                phonePaymentVHS.sendKeys("+36" + phone);
                Thread.sleep(500);
                postleizahlPayment.clear();
                Thread.sleep(500);
                postleizahlPayment.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);


                //findAdressButtonPayment.click();
                Thread.sleep(500);
               // country.click();
                Thread.sleep(500);
                strassePayment.clear();
                Thread.sleep(500);
                strassePayment.sendKeys(Strasse);
                Thread.sleep(500);

                hausnummerPayment.clear();
                Thread.sleep(500);
                hausnummerPayment.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtPayment.clear();
                Thread.sleep(500);
                stadtPayment.sendKeys(Stadt);
                Thread.sleep(500);
                stadtPayment.sendKeys(Keys.ENTER);
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);


 /*       country.click();
        Thread.sleep(500);*/
/*                neueAdresseSpeichernPayment.click();
                Thread.sleep(15000);*/
                break;
            case "VBE":
                Thread.sleep(20000);
                aendernSymbolPaymentVBE.click();
                Thread.sleep(2000);
                vornamePayment.clear();
                Thread.sleep(500);
                vornamePayment.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePayment.clear();
                Thread.sleep(500);
                nachnamePayment.sendKeys(Nachname);
                Thread.sleep(500);
                phonePaymentVHS.click();
                Thread.sleep(500);
                phonePaymentVHS.clear();
                Thread.sleep(500);
                phonePaymentVHS.sendKeys("+32" + phone);
                Thread.sleep(3000);
                postleizahlPaymentVBE.clear();
                Thread.sleep(500);
                postleizahlPaymentVBE.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                //findAdressButtonPayment.click();
                Thread.sleep(500);
//                country.click();
                Thread.sleep(500);
                strassePaymentDOS.clear();
                Thread.sleep(500);
                strassePaymentDOS.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerPaymentVBE.clear();
                Thread.sleep(500);
                hausnummerPaymentVBE.sendKeys(Hausnummer.toString());
                Thread.sleep(500);

                stadtPaymentVBE.clear();
                Thread.sleep(500);
                stadtPaymentVBE.sendKeys(Stadt);
                Thread.sleep(500);
                stadtPaymentVBE.sendKeys(Keys.ENTER);
                Thread.sleep(500);
                Thread.sleep(500);
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);

 /*       country.click();
        Thread.sleep(500);*/
/*                neueAdresseSpeichernPaymentVBE.click();
                Thread.sleep(15000);*/
                break;
            case "DHU":
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,500)");
                Thread.sleep(2000);
                aendernSymbolPayment.click();
                Thread.sleep(2000);
                vornamePaymentDUK.clear();
                Thread.sleep(500);
                vornamePaymentDUK.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePaymentDUK.clear();
                Thread.sleep(500);
                nachnamePaymentDUK.sendKeys(Nachname);
                Thread.sleep(500);
                postleizahlPaymentDUK.clear();
                Thread.sleep(500);
                postleizahlPaymentDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                phonePaymentDHU.click();
                Thread.sleep(500);
                phonePaymentDHU.clear();
                Thread.sleep(500);
                phonePaymentDHU.sendKeys("+36300000000");
                Thread.sleep(500);
//                country.click();
                Thread.sleep(500);
                strassePaymentDUK.clear();
                Thread.sleep(500);
                strassePaymentDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerPaymentDUK.clear();
                Thread.sleep(500);
                hausnummerPaymentDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);

                stadtPaymentDUK.clear();
                Thread.sleep(500);
                stadtPaymentDUK.sendKeys(Stadt);
                Thread.sleep(500);
                stadtPaymentDUK.sendKeys(Keys.ENTER);
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);
                break;
            case "DUK":
                aendernSymbolPaymentDUK.click();
                Thread.sleep(2000);
                vornamePaymentDUK.clear();
                Thread.sleep(500);
                vornamePaymentDUK.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePaymentDUK.clear();
                Thread.sleep(500);
                nachnamePaymentDUK.sendKeys(Nachname);
                Thread.sleep(500);
                phonePaymentDUK.click();
                Thread.sleep(500);
                phonePaymentDUK.clear();
                Thread.sleep(500);
                phonePaymentDUK.sendKeys("+44" + phone);
                Thread.sleep(500);
                postleizahlPaymentDUK.clear();
                Thread.sleep(500);
                postleizahlPaymentDUK.sendKeys(plzMap.get(Shop));
                Thread.sleep(2000);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
/*                //findAdressButtonPaymentDUK.click();
                Thread.sleep(3000);
                adressOption.click();
                Thread.sleep(3000);
                confirmAdressPayment.click();*/
                Thread.sleep(3000);
                strassePaymentDUK.clear();
                Thread.sleep(500);
                strassePaymentDUK.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerPaymentDUK.clear();
                Thread.sleep(500);
                hausnummerPaymentDUK.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtPaymentDUK.clear();
                Thread.sleep(500);
                stadtPaymentDUK.sendKeys(Stadt);
                Thread.sleep(500);
                Thread.sleep(500);
                hausnummerPaymentDUK.click();
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);
                break;

            case "DOS":
                Thread.sleep(2000);
                aendernSymbolPaymentDOS.click();
                Thread.sleep(2000);
                vornamePayment.clear();
                Thread.sleep(500);
                vornamePayment.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePayment.clear();
                Thread.sleep(500);
                nachnamePayment.sendKeys(Nachname);
                Thread.sleep(500);
                postleizahlPaymentDOS.clear();
                Thread.sleep(500);
                postleizahlPaymentDOS.sendKeys("9485");
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                txttelefonDOSPayment.click();
                Thread.sleep(500);
                txttelefonDOSPayment.clear();
                Thread.sleep(500);
                txttelefonDOSPayment.sendKeys("+36300000000");
                Thread.sleep(500);
//                country.click();
                Thread.sleep(500);
                strassePaymentDOS.clear();
                Thread.sleep(500);
                strassePaymentDOS.sendKeys(Strasse);

                Thread.sleep(500);
                stadtPaymentDOS.clear();
                Thread.sleep(500);
                stadtPaymentDOS.sendKeys(Stadt);
                Thread.sleep(500);
                hausnummerPaymentDOS.click();
                Thread.sleep(500);
                hausnummerPaymentDOS.clear();
                Thread.sleep(500);
                hausnummerPaymentDOS.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                neueAdresseSpeichernPaymentDHU.click();
                Thread.sleep(15000);
                break;
            default:

                aendernSymbolPayment.click();
                Thread.sleep(2000);
                vornamePayment.clear();
                Thread.sleep(500);
                vornamePayment.sendKeys(Vorname);
                Thread.sleep(500);
                nachnamePayment.clear();
                Thread.sleep(500);
                nachnamePayment.sendKeys(Nachname);
                Thread.sleep(500);
                postleizahlPayment.clear();
                Thread.sleep(500);
                postleizahlPayment.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                country.click();
                Thread.sleep(500);
                strassePayment.clear();
                Thread.sleep(500);
                strassePayment.sendKeys(Strasse);
                Thread.sleep(500);
                hausnummerPayment.clear();
                Thread.sleep(500);
                hausnummerPayment.sendKeys(Hausnummer.toString());
                Thread.sleep(500);
                stadtPaymentVBE.clear();
                Thread.sleep(500);
                stadtPaymentVBE.sendKeys(Stadt);
                Thread.sleep(500);
 /*       country.click();
        Thread.sleep(500);*/
/*                neueAdresseSpeichernPayment.click();
                Thread.sleep(15000);*/
        }


    }


    public boolean rechnungsadressePruefen(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String phone, String Shop) throws InterruptedException {

        switch (Shop)
        {
            case "DSD":
/*                neueAdresseSpeichernPaymentDSD.click();
                System.out.println("Speichern geklickt");
                Thread.sleep(15000);*/
                break;

        }


        Thread.sleep(15000);

        setcountryMap(countryMap);
        switch (Shop)
        {

            case "DHU":
                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + Stadt + "\n" +
                        countryMap.get(Shop) + "\n" +
                        "+36300000000";
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));

                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);

                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);


                break;

            case "DOS":
                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        "9485" + " " + Stadt + "\n" +
                        "Schweiz" + "\n" +
                        "+36300000000";
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));

                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);

                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);


                break;

            case "DSD":

                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + Stadt + "\n" +
                        countryMap.get(Shop) + "\n" +
                         "+49" + phone;
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));
                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);
                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);


                break;

            case "VHS":

                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + Stadt + "\n" +
                        countryMap.get(Shop) + "\n" +
                        "+36" + phone;
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));
                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);
                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);
                break;

            case "VBE":
                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + Stadt + "\n" +
                        countryMap.get(Shop) + "\n" +
                        "+32" + phone;
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));
                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);
                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);
                break;

            case "DUK":
                System.out.println(verifyNewPaymentAdress.getText());
                newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + Stadt + "\n" +
                        "United Kingdom" + "\n" +
                        "+44" + phone;
                System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));
                Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);
                compareRechnungsadress = verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress);
                break;

        }

        return compareRechnungsadress;

    }

}
