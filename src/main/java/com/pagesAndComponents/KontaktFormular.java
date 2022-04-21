package com.pagesAndComponents;

import com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.utils.DriverHelper;

public class KontaktFormular extends DriverHelper {


    public KontaktFormular(WebDriver webdriver) {
        super(webdriver);
    }


    @FindBy(xpath = "//a[contains(text(),'Unternehmen')][position()=1]")
    private WebElement kontaktlink ;

    @FindBy(xpath = "//section[@data-component-id='HotlineTab']")
    private WebElement kundenService;

    @FindBy(xpath = "//a[@href='/de-de/kontakt']")
    private WebElement kundenServiceLinkDSD;

    @FindBy(xpath = "//a[@href='/hu-hu/kapcsolat']")
    private WebElement kundenServiceLinkDHU;

    @FindBy(xpath = "//a[@href='/de-ch/kontakt']")
    private WebElement kundenServiceLinkDOS;

    @FindBy(xpath = "//a[@href='/en-gb/contact']")
    private WebElement kundenServiceLinkDUK;

    @FindBy(xpath = "(//a[@href='/nl-nl/contact'])[position()=2]")
//    @FindBy(xpath = "//span[@data-key='general.close']")
    private WebElement kundenServiceLinkVHS;

   // @FindBy(xpath = "(//a[@href='/nl-be/contact'])[position()=3]")
    @FindBy(xpath = "(//a[@href=\"/nl-be/faq\"])[position()=2]")
//    @FindBy(xpath = "//section[@data-component-id='HotlineTab']")
    private WebElement kundenServiceLinkVBE;

    @FindBy(xpath = "//input[@formcontrolname='firstName']")
    private WebElement ktkname;

    @FindBy(xpath = "//input[@formcontrolname='lastName']")
    private WebElement ktknachname;

    @FindBy(xpath = "//input[@formcontrolname='email']")
    private WebElement ktkemail;

    @FindBy(xpath = "//input[@formcontrolname='addressLine1']")
    private WebElement ktkadresse;

    @FindBy(xpath = "//input[@formcontrolname='addressLine2']")
    private WebElement ktkoptional;

    @FindBy(xpath = "//input[@formcontrolname='postalCode']")
    private WebElement ktkplz;

    @FindBy(xpath = "//input[@formcontrolname='town']")
    private WebElement ktkstadt;

    @FindBy(xpath = "//input[@formcontrolname='phone']")
    private WebElement ktktelephone;

    @FindBy(xpath = "//select[@formcontrolname='reason']/option[2]")
    private WebElement ktkreason;

    @FindBy(xpath = "//input[@formcontrolname='orderNumber']")
    private WebElement ktkbestellnum;

    @FindBy(xpath = "//input[@formcontrolname='customerNumber']")
    private WebElement ktk_kundnum;

    @FindBy(xpath = "//textarea[position()=1]")
    private WebElement ktkfrage;

    @FindBy(xpath = "//button[@data-value='Senden']")
    private WebElement ktkbutton;

    @FindBy(xpath = "//h1[position()=1]")
    private WebElement ktkcontrol;

    @FindBy(xpath = "//m-slot[@id='HiddenContentSlot-KontaktPage']")
    private WebElement ktkcontrolDOS;


    @FindBy(xpath = "//span[@class='input-radio'][position()=2]")
    private WebElement ktkgender;

    @FindBy(xpath = "(//a[@href=\"/nl-be/contact\"])[position()=1]")
    private WebElement contactVBE;

    @FindBy(xpath = "//div[@class='dy-full-width-notifications-close']")
    private WebElement closeNotifRabatt;

    public final String closePopupNewsletterXPATH = "//div[@class='dy-lb-close']";
    @FindBy(xpath = closePopupNewsletterXPATH)
    private WebElement closePopupNewsletter;




    public Boolean isElementPresent(String locator) {
        Boolean result = false;
        try {
            getWebDriver().findElement(ByLocator(locator));
            result = true;
        } catch (Exception ex) {

        }

        return result;
    }
    public void gotoKontaktformular(){
        if(kontaktlink.isDisplayed()){
            kontaktlink.click();
        }
        else{
            System.out.println("noch nict da ");
        }
    }
    public void SayHallo(){
        System.out.println("Hallo");
    }


    public void gotoKontaktformular(String mobileOrDesktop, String shop) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(500);
                        JavascriptExecutor jse = (JavascriptExecutor)driver;
                        jse.executeScript("window.scrollBy(0,2500)");
                        Thread.sleep(2000);
                        kundenService.click();
                        Thread.sleep(2000);
                        kundenServiceLinkDSD.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        if (kundenServiceLinkDSD.isDisplayed()) {
                            kundenServiceLinkDSD.click();
                        } else {
                            System.out.println("noch nicht da ");
                        }
                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }
                break;
            case "DHU":
                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(500);
                        JavascriptExecutor jse = (JavascriptExecutor)driver;
                        jse.executeScript("window.scrollBy(0,4000)");
                        Thread.sleep(2000);
                        kundenService.click();
                        Thread.sleep(2000);
                        kundenServiceLinkDHU.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        Thread.sleep(500);
                        JavascriptExecutor jsef = (JavascriptExecutor)driver;
                        jsef.executeScript("window.scrollBy(0,4000)");
                        Thread.sleep(2000);
                        kundenServiceLinkDHU.click();
                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }
                break;
            case "DOS":
                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(500);
                        kundenService.click();
                        Thread.sleep(500);
                        kundenServiceLinkDOS.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        if (kundenServiceLinkDOS.isDisplayed()) {
                            kundenServiceLinkDOS.click();
                        } else {
                            System.out.println("noch nicht da ");
                        }
                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }
                break;
            case "VHS":
/*                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(2000);
                        kundenService.click();
                        Thread.sleep(2000);
                        kundenServiceLinkVHS.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        if (kundenServiceLinkVHS.isDisplayed()) {
                            kundenServiceLinkVHS.click();
                        } else {
                            System.out.println("noch nicht da ");
                        }

                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }*/

                driver.get("https://www2.vanharen.nl/nl-nl/contact");
                break;
            case "VBE":
                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(2000);
                        kundenService.click();
                        Thread.sleep(2000);
                        kundenServiceLinkVBE.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        if (kundenServiceLinkVBE.isDisplayed()) {
                            kundenServiceLinkVBE.click();
                        } else {
                            System.out.println("noch nicht da ");
                        }
                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }
                break;
            case "DUK":
                switch (mobileOrDesktop) {
                    case "Mobile":
                        Thread.sleep(500);
                        kundenService.click();
                        Thread.sleep(500);
                        kundenServiceLinkDUK.click();
                        break;
                    case "Desktop":
                        Thread.sleep(5000);
                        if (kundenServiceLinkDUK.isDisplayed()) {
                            kundenServiceLinkDUK.click();
                        } else {
                            System.out.println("noch nicht da ");
                        }
                        break;

                    default:
                        System.out.println("Please verify the mobileOrDesktop Variable!!");
                }
                break;
            default:
                System.out.println("Please verify the Shop Variable!!");
        }




    }


    public void kontaktgender() {
        if (ktkgender.isDisplayed()) {
            ktkgender.click();
        } else {
            System.out.println("fehler in gender ");
        }
    }

    public void contact() {

            contactVBE.click();
    }






    public void kontaktvorname(String v) {
        ktkname.click();
        ktkname.sendKeys(v);
    }

    public void kontaktnachname(String n) {
        ktknachname.click();
        ktknachname.sendKeys(n);
    }

    public void kontaktemail(String e) {
        ktkemail.click();
        ktkemail.sendKeys(e);
    }

    public void kontaktadresse(String a) {
        ktkadresse.click();
        ktkadresse.sendKeys(a);
    }

    public void kontaktoptional(String o) {
        ktkoptional.click();
        ktkoptional.sendKeys(o);
    }

    public void kontaktpostLZ(String p) {
        ktkplz.click();
        ktkplz.sendKeys(p);
    }

    public void kontaktstadt(String s) {
        ktkstadt.click();
        ktkstadt.sendKeys(s);
    }

    public void kontakt_telephone(String t) {
        ktktelephone.click();
        ktktelephone.sendKeys(t);
    }

    public void kontakt_reason() {
        ktkreason.click();
    }

    public void kontakt_bestellnummer(String num) {
        ktkbestellnum.click();
        ktkbestellnum.sendKeys(num);
    }

    public void kontakt_kundennummer(String kn) {
        ktk_kundnum.click();
        ktk_kundnum.sendKeys(kn);
    }

    public void kontakt_frage(String fr) {
        ktkfrage.click();
        ktkfrage.sendKeys(fr);
    }

    public void kontakt_senden() {
        if (ktkbutton.isDisplayed()) ktkbutton.click();
    }

    public void kontakt_Control_Displayed() {
        if (ktkcontrol.isDisplayed()) System.out.println("ist schon da !");
    }

    public void kontakt_Control_DisplayedDOS() {
        if (ktkcontrolDOS.isDisplayed()) System.out.println("ist schon da !");
    }

    public void closeNotificationRabatt() throws InterruptedException {
        if (!driver.findElements(By.xpath("//div[@class='dy-full-width-notifications-close']")).isEmpty())
        {
            //((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", closeNotifRabatt);
            Thread.sleep(2000);
            closeNotifRabatt.click();
            //driver.navigate().back();
        }
        else {

            System.out.println("Notification rabatt ist nicht da");
        }

    }

    public void closeNewsletterAbonnierenPopup()
    {

        if (!driver.findElements(By.xpath(closePopupNewsletterXPATH)).isEmpty())
        {

            closePopupNewsletter.click();
        }
        else {

            System.out.println("Newsletter Popup ist nicht da ist nicht da");
        }

    }


    public void kontaktformularAusfuellen(String shop, String environment, String mobileOrDesktop) throws InterruptedException {
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
                postalcode = "E20 1EH";
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }

        closeNotificationRabatt();
//        gotoKontaktformular(mobileOrDesktop, shop);
/*        Thread.sleep(5000);
        closeNewsletterAbonnierenPopup();
        Thread.sleep(500);*/
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
//        closeNotificationRabatt();
//        closeNewsletterAbonnierenPopup();
        Thread.sleep(2000);
        URLcontact(shop, environment, mobileOrDesktop);
/*        if (shop.equalsIgnoreCase("VBE") || shop.equalsIgnoreCase("DOS"))
        {

            Thread.sleep(2000);
            if (mobileOrDesktop.equalsIgnoreCase("Mobile"))
            {

            }
            else
            {
                contact();
            }

        }*/
        Thread.sleep(2000);
        kontaktgender();
        Thread.sleep(500);
        kontaktvorname("konaktname");
        Thread.sleep(500);
        closeNotificationRabatt();
        Thread.sleep(500);
        closeNewsletterAbonnierenPopup();
        Thread.sleep(500);
        kontaktnachname("kontaktnachname");
        Thread.sleep(500);
        closeNotificationRabatt();
        Thread.sleep(500);
        kontaktemail("kontaktmail@yopmail.com");
        Thread.sleep(500);
        kontaktadresse("Berliner Straße 29") ;
        Thread.sleep(500);
        jse.executeScript("window.scrollBy(0,250)");
        Thread.sleep(500);
        kontaktoptional("Dortmunder Straße 30");
        Thread.sleep(500);
        kontaktpostLZ(postalcode);
        Thread.sleep(500);
        kontaktstadt("Berlin");
        Thread.sleep(500);
        kontakt_telephone("0231 4444 5555") ;
        Thread.sleep(500);
        kontakt_reason();
        Thread.sleep(500);
        kontakt_bestellnummer("112233");
        Thread.sleep(500);
        kontakt_kundennummer("XXYYZZ");
        Thread.sleep(500);
        kontakt_frage("Hier ist eine Kundenanfrage über Kontaktformular");
        Thread.sleep(500);
        kontakt_senden();
        Thread.sleep(2000);
        if (shop.equalsIgnoreCase("DOS") || shop.equalsIgnoreCase("VBE") || shop.equalsIgnoreCase("DHU"))
        {
            kontakt_Control_DisplayedDOS();
            Thread.sleep(2000);
        }
        else
        {
            kontakt_Control_Displayed();
            Thread.sleep(2000);
        }


    }

    public PropertyReader propertyReader;
    public String URLcontact(String shop, String environment, String mobileOrDesktop) {
        propertyReader = new PropertyReader();
        String url = null;
        switch (shop) {
            case "DHU":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_DHU_QA") + "/kapcsolat";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_DHU_Prod") + "/kapcsolat";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            case "DSD":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_DE_QA") + "/kontakt";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_DE_Prod") + "/kontakt";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;

            case "VHS":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_VHS_QA") + "/contact";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_VHS_Prod") + "/contact";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            case "DOS":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_DOS_QA") + "/kontakt";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_DOS_Prod") + "/kontakt";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            case "VBE":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_VBE_QA") + "/contact";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_VBE_Prod") + "/contact";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            case "DUK":
                switch (environment) {
                    case "QA":
                        url = propertyReader.readApplicationFile("URL_DUK_QA") + "/contact";
                        break;
                    case "Prod":
                        url = propertyReader.readApplicationFile("URL_DUK_Prod") + "/contact";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }


        System.out.println(url);
        driver.get(url);

        return url;

    }







}
