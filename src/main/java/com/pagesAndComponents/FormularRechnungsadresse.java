package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FormularRechnungsadresse extends DriverHelper {
    public FormularRechnungsadresse(WebDriver webdriver) {
        super(webdriver);
    }


    @FindBy(xpath = "(//input[@id='payment-firstName'])[position()=1]")
    private WebElement vornametxt;

    @FindBy(xpath = "(//input[@id='payment-lastName'])[position()=1]")
    private WebElement nachnametxt;

    @FindBy(xpath = "(//input[@id='payment-phone'])[position()=1]")
    private WebElement telefonnummerTxt;

    @FindBy(xpath = "(//input[@id='payment-line1'])[position()=1]")
    private WebElement strassetxt;

    @FindBy(xpath = "(//input[@id='payment-line2'])[position()=1]")
    private WebElement hausnumtxt;

    @FindBy(xpath = "(//input[@id='payment-postalCode'])[position()=1]")
    private WebElement plztxt;

    @FindBy(xpath = "(//input[@id='payment-town'])[position()=1]")
    private WebElement stadttxt;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[2]")
    private WebElement landAuslandVHS;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[1]")
    private WebElement landAuslandVBE;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[1]")
    private WebElement landAuslandDHU;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[1]")
    private WebElement landAuslandDOS;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[1]")
    private WebElement landAuslandDUK;

    @FindBy(xpath = "//select[@formcontrolname='country']/option[1]")
    private WebElement landAuslandDSD;

    @FindBy(xpath = "//button[@data-value='Find Address']")
    private WebElement findAdressButton;

    @FindBy(xpath = "//span[@data-zip='3045']")
    private WebElement option1;

    @FindBy(xpath = "(//span[@class='uniserv-item'])[position()=1]")
    private WebElement txtline1DSD;

    @FindBy(xpath = "(//span[contains(text(),'3 Prize Walk LONDON, E20 1AA, United Kingdom')])[position()=1]")
    //@FindBy(xpath = "(//div[@class='radio-button-list'])[position()=1]")
    private WebElement firstAdress;

    @FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=2]")
    private WebElement confirmAdress;

    @FindBy(xpath = "(//span[contains(text(),' Confirm Address ')])[position()=1]")
    private WebElement confirmAdressDUK;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    public RegistrationPage findAdressDUK() throws InterruptedException {
        Thread.sleep(2000);
        findAdressButton.click();
/*        Thread.sleep(2000);
        firstAdress.click();
        Thread.sleep(2000);
        confirmAdressDUK.click();*/
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage vornameEingeben(String n) throws InterruptedException {
        vornametxt.click();
        Thread.sleep(2000);
        vornametxt.sendKeys(n);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage nachnameEingeben(String nachn) throws InterruptedException {
        nachnametxt.click();
        nachnametxt.sendKeys(nachn);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage telefonnummerEingeben(String str) throws InterruptedException {
        telefonnummerTxt.click();
        telefonnummerTxt.sendKeys(str);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage strasseEingeben(String str) throws InterruptedException {
        strassetxt.click();
        strassetxt.sendKeys(str);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage HausnummerEingeben(String hn) throws InterruptedException {
        hausnumtxt.click();

        hausnumtxt.sendKeys(hn);

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage plzEingeben(String shop, String ausland) throws InterruptedException {


        String postalcode = null;
        switch (shop) {
            case "DSD":
                if (ausland.equalsIgnoreCase("ja")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "1020";
                } else if (ausland.equalsIgnoreCase("nein")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "44225";
                } else {
                    System.out.println("check variable Ausland");
                }

                break;
            case "DHU":
                postalcode = "1020";
                break;
            case "DOS":
                postalcode = "8000";
                break;
            case "VBE":
                if (ausland.equalsIgnoreCase("ja")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "1020";
                } else if (ausland.equalsIgnoreCase("nein")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "1020";
                } else {
                    System.out.println("check variable Ausland");
                }

                break;
            case "VHS":
                if (ausland.equalsIgnoreCase("ja")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "1020";
                } else if (ausland.equalsIgnoreCase("nein")) {
                    //Postleizahl im Ausland in Belgien
                    postalcode = "1020AB";
                } else {
                    System.out.println("check variable Ausland");
                }

                break;
            case "DUK":
                if (ausland.equalsIgnoreCase("ja")) {
                    //Postleizahl im Ausland in Dortmund
                    postalcode = "4225";
                } else if (ausland.equalsIgnoreCase("nein")) {
                    //Postleizahl im Inland in UK
                    postalcode = "E20 1EH";
                } else {
                    System.out.println("check variable Ausland");
                }

                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }

        plztxt.click();
        plztxt.sendKeys(postalcode);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage stadtEingeben(String sdt) throws InterruptedException {
        stadttxt.click();
        stadttxt.sendKeys(sdt);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage checkLandAusland(String shop) throws InterruptedException {

        switch (shop) {
            case "DSD":
                landAuslandDSD.click();
                break;
            case "VBE":
                landAuslandVBE.click();
                break;
            case "VHS":
                landAuslandVHS.click();
                break;
            case "DHU":
                landAuslandDHU.click();
                break;
            case "DUK":
                landAuslandDUK.click();
                break;
            case "DOS":
                landAuslandDUK.click();
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);


    }

    public void scrollDown(String mobileOrDesktop) throws InterruptedException {
        if (mobileOrDesktop.equalsIgnoreCase("Mobile"))
        {
            Thread.sleep(2000);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,350)", "");
            Thread.sleep(2000);
        }


    }



    public void rechnungsadresseAusfuellen(String email, String shop, String vorname, String nachname, String strasse, String haunummer, String stadt, String ausland) throws InterruptedException {



        switch (shop)

        {

            case "DHU":
                vornameEingeben(vorname);
                Thread.sleep(500);
                nachnameEingeben(nachname);
                Thread.sleep(500);
                telefonnummerEingeben("+36 30 000 0000");
                Thread.sleep(500) ;
                strasseEingeben(strasse);
                Thread.sleep(2000) ;
//                option1.click();
                        Thread.sleep(500);
                HausnummerEingeben(haunummer);
                Thread.sleep(500);
                stadtEingeben(stadt);
                Thread.sleep(500);
                checkLandAusland(shop);
                Thread.sleep(500);
                break;
            case "VHS":
                vornameEingeben(vorname);
                Thread.sleep(500);
                nachnameEingeben(nachname);
                Thread.sleep(500);
                plzEingeben(shop, ausland);
                Thread.sleep(500);
                checkLandAusland(shop);
                Thread.sleep(500);
                findAdressButton.click();
                Thread.sleep(500);
                strasseEingeben(strasse);
                Thread.sleep(500);
                HausnummerEingeben(haunummer);
                Thread.sleep(500);
                stadtEingeben(stadt);
                Thread.sleep(500);
                break;
            case "DSD":
                vornameEingeben(vorname);
                Thread.sleep(500);
                nachnameEingeben(nachname);
                Thread.sleep(500);
                checkLandAusland(shop);
                Thread.sleep(500);
                strasseEingeben(strasse);
                Thread.sleep(500);
//                txtline1DSD.click();
                Thread.sleep(500);
                HausnummerEingeben(haunummer);
/*                Thread.sleep(500);
                stadtEingeben(stadt);*/
                Thread.sleep(500);
                plzEingeben(shop, ausland);
                Thread.sleep(500);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(500);
//                stadtEingeben(stadt);
                Thread.sleep(500);
                break;
            case "DUK":
                vornameEingeben(vorname);
                Thread.sleep(500);
                nachnameEingeben(nachname);
                Thread.sleep(3000);
                plzEingeben(shop, ausland);
                Thread.sleep(500);
                Thread.sleep(500);
                checkLandAusland(shop);

                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                findAdressDUK();
                Thread.sleep(500);
                strasseEingeben(strasse);
                Thread.sleep(500);
                HausnummerEingeben(haunummer);
                Thread.sleep(500);
/*                stadtEingeben(stadt);
                Thread.sleep(500);*/
                break;
            case "DOS":
                vornameEingeben(vorname);
                Thread.sleep(500);
                strasseEingeben(strasse);
                Thread.sleep(500);
                nachnameEingeben(nachname);
                Thread.sleep(500);
                plzEingeben(shop, ausland);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }

/*                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }*/
                Thread.sleep(500);
                HausnummerEingeben(haunummer);
                Thread.sleep(500);
                stadtEingeben(stadt);
                Thread.sleep(500);
                checkLandAusland(shop);
                Thread.sleep(500);
                break;
            default:
                plzEingeben(shop, ausland);
                Thread.sleep(500);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }

                strasseEingeben(strasse);
                Thread.sleep(500);
/*                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }*/
                Thread.sleep(500);
                HausnummerEingeben(haunummer);
                Thread.sleep(500);
                stadtEingeben(stadt);
                Thread.sleep(500);
                checkLandAusland(shop);
                Thread.sleep(500);
        }





    }

}
