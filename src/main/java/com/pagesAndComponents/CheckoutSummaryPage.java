package com.pagesAndComponents;

import com.utils.DriverHelper;
import com.utils.DriverTestCase;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CheckoutSummaryPage extends DriverHelper {

    @FindBy(xpath = "//span[@class='add-coupon-label']")
    private WebElement btncoupon;

    @FindBy(xpath = "//input[@name='voucher'][1]")
    private WebElement inputcoupon;

    @FindBy(xpath = "//button[@data-value='Hinzufügen']")
    private WebElement bnthinzu;

    @FindBy(xpath = "//span[@class='add-giftcard-label'][1]")
    private WebElement geschenkbtn;

    @FindBy(xpath = "//input[@name='cardNumber'][1]")
    private WebElement cartinput;

    @FindBy(xpath = "//input[@name='cardPin'][1]")
    private WebElement pininput;

    @FindBy(xpath = "//button[contains(text(),'Prüfen')]")
    private WebElement gutscheinPrüfen;

    @FindBy(xpath = "//button[contains(text(),'Ellenőrzés')]")
    private WebElement gutscheinPrüfenDHU;

//    @FindBy(xpath = "//button[contains(text(),' Kijk op')]")
    @FindBy(xpath = "//button[@data-key='core.component.formGiftcard.check']")
    private WebElement gutscheinPrüfenVBE;

//    @FindBy(xpath = "//button[contains(text(),' Kijk op')]")
    @FindBy(xpath = "//button[@data-key='core.component.formGiftcard.check']")
    private WebElement gutscheinPrüfenVHS;

    @FindBy(xpath = "//button[contains(text(),'Check')]")
    private WebElement gutscheinPrüfenDUK;

    @FindBy(xpath = "//a[@href='/de-de/checkout/addresses/delivery']")
    private WebElement aendernSymbolDelivery;

    @FindBy(xpath = "//a[@href='/de-de/checkout/addresses/payment']")
    private WebElement aendernSymbolPayment;

    @FindBy(xpath = "//span[@data-value='Neue Adresse / Wunschfiliale hinzufügen'][1]")
    private WebElement neueAdresseHinzufuegenDSD;

    @FindBy(xpath = "//span[@data-value='Neue Adresse hinzufügen'][1]")
    private WebElement neueAdresseHinzufuegen;

    @FindBy(xpath = "//span[@data-value='Neue Adresse / Wunschfiliale hinzufügen'][1]")
    private WebElement neueAdresseHinzufuegenDOS;

    @FindBy(xpath = "//input[@id='firstName']")
    private WebElement vorname;

    @FindBy(xpath = "//input[@id='lastName']")
    private WebElement nachname;

    @FindBy(xpath = "(//input[@id='line1'])[position()=1]")
    private WebElement strasse;

    @FindBy(xpath = "(//input[@id='line2'])[position()=1]")
    private WebElement hausnummer;

    @FindBy(xpath = "(//input[@id='postalCode'])[position()=1]")
    private WebElement postleizahl;

    @FindBy(xpath = "(//input[@id='town'])[position()=1]")
    private WebElement stadt;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[4]")
    private WebElement country;

    @FindBy(xpath = "//option[@value='3: Object']")
    private WebElement countryDE;

    @FindBy(xpath = "//button[@data-key='myAccount.addresses.component.save']")
    private WebElement neueAdresseSpeichern;

    @FindBy(xpath = "(//m-address)[position()=1]")
    private WebElement verifyNewDeliveryAdress;

    @FindBy(xpath = "(//m-address)[position()=2]")
    private WebElement verifyNewPaymentAdress;

    @FindBy(xpath = "//button[@data-value='Find Address']")
    private WebElement findAdressButton;

    @FindBy(xpath = "(//input[@id='phone'])[position()=1]")
    private WebElement txttelefon;

    @FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement adressOption;

    @FindBy(xpath = "(//m-button[@data-value='Confirm Address'])[position()=2]")
    private WebElement confirmAdress;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    final public String  txtline1DSDXPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = txtline1DSDXPATH)
    private WebElement txtline1DSD;

    @FindBy(xpath = "(//span[contains(text(),'105 1 De Ruijterkade AMSTERDAM, 1011 AB')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdressVHS;


    @FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=1]")
    private WebElement confirmAdressDUK;

    final public String confirmAdressVHSAXPATH = "//span[contains(text(),'Bevestig adres')]";
    @FindBy(xpath = confirmAdressVHSAXPATH)
    private WebElement confirmAdressVHSA;

    final public String confirmAdressVHSAXPBTH = "(//button[@data-value=''])[position()=3]";
    @FindBy(xpath = confirmAdressVHSAXPBTH)
    private WebElement confirmAdressVHSB;

    //@FindBy(xpath = "(//span[contains(text(),'3 Prize Walk LONDON, E20 1AA, United Kingdom')])[position()=1]")
    @FindBy(xpath = "(//span[contains(text(),'17 Prize Walk LONDON, E20 1AB, United Kingdom')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdress;


    final public String deliverySymbolXPATHDUK = "(//a[@href='/en-gb/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHDUK)
    private WebElement deliverySymbolDUK;

    final public String deliverySymbolXPATHDOS = "(//a[@href='/de-ch/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHDOS)
    private WebElement deliverySymbolDOS;

    final public String deliverySymbolXPATHDSD = "(//a[@href='/de-de/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHDSD)
    private WebElement deliverySymbolDSD;

    final public String deliverySymbolXPATHVHS = "(//a[@href='/nl-nl/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHVHS)
    private WebElement deliverySymbolVHS;

    final public String deliverySymbolXPATHVBE = "(//a[@href='/nl-be/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHVBE)
    private WebElement deliverySymbolVBE;

    final public String deliverySymbolXPATHDHU = "(//a[@href='/hu-hu/checkout/addresses/delivery'])[position()=1]";
    @FindBy(xpath = deliverySymbolXPATHDHU)
    private WebElement deliverySymbolDHU;

    final public String paymentSymbolXPATHDUK = "(//a[@href='/en-gb/checkout/addresses/payment'])[position()=1]";
    @FindBy(xpath = paymentSymbolXPATHDUK)
    private WebElement paymentSymbolDUK;

    public CheckoutSummaryPage(WebDriver webdriver) {
        super(webdriver);
    }

    public RegistrationPage findAdressDUK() throws InterruptedException {
        vorname.click();
        Thread.sleep(1000);
        vorname.sendKeys(Keys.TAB);
        Thread.sleep(1000);
        Thread.sleep(2000);
       findAdressButton.click();
       Thread.sleep(5000);
        firstAdress.click();
        Thread.sleep(2000);
        confirmAdressDUK.click();
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage findAdressVHS() throws InterruptedException {
        Thread.sleep(2000);
        findAdressButton.click();
        Thread.sleep(2000);
        firstAdressVHS.click();
        Thread.sleep(2000);
        confirmAdressVHSA.click();
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }
    public void CouponsClick() {
        btncoupon.click();
    }


    public void EnterCoupon(String c) {
        if (inputcoupon.isDisplayed()) {
            inputcoupon.sendKeys(c);
            bnthinzu.click();
        } else {
            System.out.println("Fehler vorhanden");
        }
    }


    public void geschenkClick() {
        geschenkbtn.click();

    }


    public void inputsAusfüllen(String cn, String p) {
        cartinput.sendKeys(cn);
        pininput.sendKeys(p);


    }

    public void clickOnPrüfen(String shop) {

        switch (shop) {
            case "DHU":
                gutscheinPrüfenDHU.click();
                break;
            case "VBE":
                gutscheinPrüfenVBE.click();
            case "VHS":
                gutscheinPrüfenVHS.click();
                break;
            case "DUK":
                gutscheinPrüfenDUK.click();
                break;
            default:
                gutscheinPrüfen.click();

        }


    }



    public void lieferAdresseAendernCheckout(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String Shop) throws InterruptedException {

switch (Shop)
{
    case "DUK":
        deliverySymbolDUK.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDSD.click();
        break;
    case "DOS":
        deliverySymbolDOS.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDOS.click();
        break;
    case "DSD":
        deliverySymbolDSD.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDSD.click();
        break;
    case "VHS":
        deliverySymbolVHS.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDSD.click();
        break;
    case "VBE":
        deliverySymbolVBE.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDSD.click();
        break;
    case "DHU":
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(1000);
        deliverySymbolDHU.click();
        Thread.sleep(8000);
        neueAdresseHinzufuegenDSD.click();
        break;
}


        Thread.sleep(2000);

        vorname.clear();
        Thread.sleep(500);
        vorname.sendKeys(Vorname);
        Thread.sleep(500);

        nachname.clear();
        Thread.sleep(500);
        nachname.sendKeys(Nachname);
        Thread.sleep(500);

        postleizahl.clear();
        Thread.sleep(500);
        setPlzMap(plzMap);
        postleizahl.sendKeys(plzMap.get(Shop));
        Thread.sleep(500);
        Thread.sleep(1000);

        if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
            optionListe1.click();
        }

        switch (Shop)
        {
            case "VHS":
                Thread.sleep(500);
                findAdressVHS();
                Thread.sleep(500);
                break;
            case "DHU":
                Thread.sleep(2000);
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,-250)");
                Thread.sleep(1000);
                txttelefon.click();
                Thread.sleep(1000);
                txttelefon.clear();
                Thread.sleep(1000);
                txttelefon.sendKeys("+36300000000");
                break;
            case "DUK":
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                setPlzMap(urlMap);
                postleizahl.sendKeys(urlMap.get(Shop));
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(3000);
                findAdressDUK();
                break;

            default:

        }


        strasse.clear();
        Thread.sleep(500);
        strasse.sendKeys(Strasse);
        Thread.sleep(500);
        strasse.sendKeys(Keys.TAB);
        Thread.sleep(1000);

        stadt.clear();
        Thread.sleep(500);
        stadt.sendKeys("Dortmund");
        Thread.sleep(500);
        hausnummer.clear();
        Thread.sleep(500);
        hausnummer.sendKeys(Hausnummer.toString());
        Thread.sleep(500);
        hausnummer.sendKeys(Keys.ENTER);
        Thread.sleep(1000);
        hausnummer.sendKeys(Keys.ENTER);
        Thread.sleep(15000);


    }

    public void verifylieferAdresseAendernCheckout(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String Shop) throws InterruptedException {

        setcountryMap(countryMap);
                System.out.println(verifyNewDeliveryAdress.getText());
                String newAdress =  Vorname + " " +  Nachname + "\n" +
                        Strasse + " " + Hausnummer.toString() + "\n" +
                        plzMap.get(Shop) + " " + "Dortmund" + "\n" +
                        countryMap.get(Shop) ;
                System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
                Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);




    }




    public boolean rechnungsAdresseAendernCheckout(String Vorname, String Nachname, String Strasse, String Stadt, Integer Hausnummer, String phone, String Shop) throws InterruptedException {
        setXpathAendernSymbolPaymentMap(xpathAendernSymbolPaymentMap);
        setPlzMap(plzMap);
        driver.findElement(By.xpath(xpathAendernSymbolPaymentMap.get(Shop))).click();
        Thread.sleep(2000);
        switch (Shop)
        {
            case "DSD":
                neueAdresseHinzufuegen.click();
                break;
            default:

                neueAdresseHinzufuegen.click();
        }

        Thread.sleep(2000);
        vorname.clear();
        Thread.sleep(500);
        vorname.sendKeys(Vorname);
        Thread.sleep(500);
        nachname.clear();
        Thread.sleep(500);
        nachname.sendKeys(Nachname);
        Thread.sleep(500);



        switch (Shop)
        {
            case "VHS":
                txttelefon.click();
                Thread.sleep(500);
                txttelefon.clear();
                Thread.sleep(500);
                txttelefon.sendKeys("+46" + phone);
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                Thread.sleep(500);
                findAdressVHS();
                Thread.sleep(500);
                break;
            case "VBE":
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
/*                findAdressButton.click();
                Thread.sleep(500);*/
//                country.click();
                break;
            case "DHU":
                Thread.sleep(1000);
                txttelefon.click();
                Thread.sleep(500);
                txttelefon.clear();
                Thread.sleep(500);
                txttelefon.sendKeys("+36300000000");
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                JavascriptExecutor jse = (JavascriptExecutor)driver;
                jse.executeScript("window.scrollBy(0,250)");

//                country.click();
                break;
            case "DSD":
                txttelefon.click();
                Thread.sleep(500);
                txttelefon.clear();
                Thread.sleep(500);
                txttelefon.sendKeys( "+49" + phone);
                Thread.sleep(500);
                break;
            case "DUK":
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                Thread.sleep(500);
                vorname.click();
                Thread.sleep(500);
                vorname.sendKeys(Keys.TAB);
/*                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }*/
                Thread.sleep(3000);
                findAdressDUK();
                break;

            case "DOS":
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(1000);
//                country.click();
                break;

            default:
                Thread.sleep(500);
                postleizahl.clear();
                Thread.sleep(500);
                postleizahl.sendKeys(plzMap.get(Shop));
                if (!driver.findElements(By.xpath(txtline1DSDXPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
                Thread.sleep(500);
                country.click();
        }
        Thread.sleep(500);
        strasse.clear();
        Thread.sleep(500);
        strasse.sendKeys(Strasse);
        Thread.sleep(500);
//        strasse.sendKeys(Keys.ENTER);
//        Thread.sleep(500);

        hausnummer.clear();
        Thread.sleep(500);
        hausnummer.sendKeys(Hausnummer.toString());
        Thread.sleep(500);

        stadt.clear();
        Thread.sleep(500);
        stadt.sendKeys("Dortmund");
        Thread.sleep(500);
        stadt.sendKeys(Keys.ENTER);
        Thread.sleep(500);

      neueAdresseSpeichern.click();
        Thread.sleep(15000);

        if (verifyNewPaymentAdress.isEnabled()) {
            return true;
        }
        else {
            return false;
        }




    }


    public void lieferadresseAdresseCheck(String Vorname, String Nachname, String Strasse, String Stadt, String Hausnummer, String Shop)
    {

        System.out.println(verifyNewDeliveryAdress.getText());
        String newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer + "\n" +
                plzMap.get(Shop) + " " + Stadt + "\n" +
                countryMap.get(Shop) + "\n" +
                telefonnummerMap.get(Shop);
        System.out.println(verifyNewDeliveryAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewDeliveryAdress.getText(), newAdress);
    }


    public void rechnungsAdresseCheck(String Vorname, String Nachname, String Strasse, String Stadt, String Hausnummer, String Shop)
    {

        System.out.println(verifyNewPaymentAdress.getText());
        String newAdress =  Vorname + " " +  Nachname + "\n" +
                Strasse + " " + Hausnummer + "\n" +
                plzMap.get(Shop) + " " + Stadt + "\n" +
                countryMap.get(Shop) + "\n" +
                telefonnummerMap.get(Shop);
        System.out.println(verifyNewPaymentAdress.getText().equalsIgnoreCase(newAdress));
        Assert.assertEquals(verifyNewPaymentAdress.getText(), newAdress);
    }





}
