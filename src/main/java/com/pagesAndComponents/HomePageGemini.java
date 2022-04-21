package com.pagesAndComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.DriverHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePageGemini extends DriverHelper {

    final static String zurKasseXpath = "(//span[contains(text(),'Zur Kasse')])[position()=1]";
    @FindBy(xpath = zurKasseXpath)
    private WebElement zurKasse;


    final static String zurKasseXpathDHU = "(//span[contains(text(),'Tovább a fizetéshez')])[position()=1]";
    @FindBy(xpath = zurKasseXpathDHU)
    private WebElement zurKasseDHU;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    final public String  txtline1DSDXPATH = "(//span[@class='uniserv-item'])[position()=1]";
    final public String  txtcityXPATH = "//input[@id='paymentAddress.town']";
    final public String confirmAdressVHSAXPATH = "//m-button[@data-key='register-checkout.component.suggestModal.button']";
    final public String confirmAdressVHSAXPBTH = "//button[@data-value='']";
    private final String cookiesOkButtonXPATH = "//button[@data-key='consent.modal.agree']";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    @FindBy(xpath = "(//input[@id='paymentAddress.firstname'])[position()=1]")
    private WebElement txtfirstname;

    @FindBy(xpath = "(//input[@id='paymentAddress.lastname'])[position()=1]")
    private WebElement txtlastname;

    @FindBy(xpath = "(//input[@id='login'])[position()=1]")
    private WebElement txtemail;

    @FindBy(xpath = "//input[@id='paymentAddress.streetname']")
    private WebElement txtline1;

    @FindBy(xpath = txtline1DSDXPATH)
    private WebElement txtline1DSD;

    @FindBy(xpath = "//input[@id='paymentAddress.streetnumber']")
    private WebElement txtline2;

    @FindBy(xpath = "//input[@id='paymentAddress.postalcode']")
    private WebElement txtpostalcode;

    @FindBy(xpath = txtcityXPATH)
    private WebElement txtcity;

    @FindBy(xpath = "(//span[@class='uniserv-item'])[position()=1]")
    private WebElement txtcityOption1;

    @FindBy(xpath = "//input[@id='delivery-phone']")
    private WebElement txttelefon;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordan;

    @FindBy(xpath = "//button[@data-value='Find Address']")
    private WebElement findAdressButton;

    @FindBy(xpath = "(//span[contains(text(),'3 Prize Walk LONDON, E20 1AA, United Kingdom')])[position()=1]")
    private WebElement firstAdress;

    @FindBy(xpath = "(//button[@class='primary message-pipe'])[position()=2]")
    private WebElement confirmAdressDUK;

    @FindBy(xpath = "(//div[@data-positioninlist='2'])[1]")
    private WebElement firstBoot;

    @FindBy(xpath = "(//form[contains(@class,'m-add-to-cart')])[1]")
    private WebElement AddToCartButton;

    @FindBy(xpath = "//a[contains(text(),'In den Warenkorb')]")
    private WebElement AddToCartButtonDSD;


    @FindBy(xpath = "//a[contains(text(),'Kosárba')]")
    private WebElement AddToCartButtonDHUGemini;

    @FindBy(xpath = "//a[contains(text(),'In den Warenkorb')]")
    private WebElement AddToCartButtonDSDLoggedIn;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement bntshowResult;

    @FindBy(xpath = cookiesOkButtonXPATH)
    private WebElement CookiesOkButton;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement filterGroesseDE;

    @FindBy(xpath = "//span[contains(text(),' Size ')]")
    private WebElement filterGroesseDUK;

    @FindBy(xpath = "//span[contains(text(),' Maat ')]")
    private WebElement filterGroesseVHS;

    @FindBy(xpath = "//label[contains(text(),'EU')]")
    private WebElement filterGroesseVHSMaatEU;

    @FindBy(xpath = "//span[contains(text(),' Maat ')]")
    private WebElement filterGroesseVBE;

    @FindBy(xpath = "//span[contains(text(),' Grösse ')]")
    private WebElement filterGroesseDOS;

    @FindBy(xpath = "(//span[contains(text(),' Méret ')])[1]")
    private WebElement filterGroesseDHU;

    @FindBy(xpath = "(//a[@data-filtervalue='37'])[1]")
    private WebElement groesseEU37;

    @FindBy(xpath = "//div[@class='dy-full-width-notifications-close']")
    private WebElement closeNotifRabatt;

    @FindBy(xpath = "(//span[@class='quick-action__icon'])[4]")
    private WebElement zumWarenkorb;

    @FindBy(xpath = "//input[@id='privacyPolicyConfirmed']")
    private WebElement datenschutz;



    @FindBy(xpath = "//input[@id='paymentAddress.gender_female']")
    private WebElement radioGenderFrau;

    @FindBy(xpath = "//button[@value='register']")
    private WebElement registrieren;

    @FindBy(xpath = "//input[@id='deliverydhl-DE']")
    private WebElement dhl;

    @FindBy(xpath = "//input[@id='deliverygls']")
    private WebElement glc;

    @FindBy(xpath = "//input[@id='paymentcashOnDelivery']")
    private WebElement nachname;

    @FindBy(xpath = "//input[@id='paymentcashOnDelivery']")
    private WebElement nachnameDHU;

    @FindBy(xpath = "//input[@id='paymentAddress.phone1']")
    private WebElement telefonnummer;

    @FindBy(xpath = "//a[@class='cart_button arrow navigateToSummary CONTINUECHECKOUT']")
    private WebElement zusammenfassung;

    @FindBy(xpath = "(//span[contains(text(),'JETZT KAUFEN')])[1]")
    private WebElement kaufenButton;

    @FindBy(xpath = "(//span[contains(text(),'VÁSÁRLÁS MOST')])[1]")
    private WebElement kaufenButtonDHU;

    @FindBy(xpath = "//input[@id='acceptGeneralTermsAndConditionsOutsideForm']")
    private WebElement kaufenButtonDHUCheckbox;


    @FindBy(xpath = "(//span[contains(text(),'10')])[position()=1]")
    private WebElement schliessen;

    @FindBy(xpath = "(//span[contains(text(),'FIÓKOM')])[position()=1]")
    private WebElement buttonText;


    @FindBy(xpath = "(//button[contains(text(),'Absenden')])[position()=1]")
    private WebElement absenden;

    @FindBy(xpath = "//a[@data-size-value='37']")
    private WebElement SelectSizeSiebenUndDreissig;


    public HomePageGemini(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage telefonnummerHinzufuegen(String tel) throws InterruptedException {
        Thread.sleep(500);
        telefonnummer.clear();
        Thread.sleep(500);
        telefonnummer.click();
        Thread.sleep(500);
        telefonnummer.sendKeys(tel);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage kaufBestaetigung(String shop) throws InterruptedException {
        switch (shop)
        {
            case "DSD":
                schliessen.click();
                Thread.sleep(2000);
                absenden.click();
                break;
            case "DHU":
                buttonText.click();
                break;
        }

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage kaufen(String shop) throws InterruptedException {
        switch (shop)
        {
            case "DSD":
                kaufenButton.click();
                break;
            case "DHU":
                kaufenButtonDHUCheckbox.click();
                Thread.sleep(2000);
                kaufenButtonDHU.click();
                break;
        }


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage liefermethodeAuswaehlen(String shop) {
switch (shop)
{
    case "DSD":
        dhl.click();
        break;
    case "DHU":
        glc.click();
        break;
}

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage weiterZurZusammenfassung() {
        zusammenfassung.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage zahlungsmethode(String shop) {
        switch (shop)
        {
            case "DSD":
                nachname.click();
                break;
            case "DHU":
                nachnameDHU.click();
                break;

        }


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterFirstname(String firstname) {

        txtfirstname.click();
        txtfirstname.sendKeys(firstname);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage datenschutzBestaetigung() {

        datenschutz.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage jetztRegistrieren() {

        registrieren.click();
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


            Thread.sleep(500);
            enterPostalCode(shop, "44225");
            Thread.sleep(500);
            findAdressDUK();
            Thread.sleep(2000);
            clearPostalCode();

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    public RegistrationPage enterPostalCode(String shop, String zipCode) throws InterruptedException {

        txtpostalcode.clear();
        Thread.sleep(500);
        txtpostalcode.click();
        Thread.sleep(500);
        txtpostalcode.sendKeys(zipCode);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage findAdressDUK() throws InterruptedException {
        Thread.sleep(2000);
        findAdressButton.click();
        Thread.sleep(2000);
        firstAdress.click();
        Thread.sleep(2000);
        confirmAdressDUK.click();
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
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }




    public RegistrationPage enterPasswordAlsGast(String p) {
        passwordan.sendKeys(p);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public void lieferadresseAusfuellen(String email, String shop, String vorname, String nachname, String strasse, String haunummer, String stadt, String password, String telefon, String zip) throws InterruptedException {

        enterFirstname(vorname);
        Thread.sleep(500);
        enterLastName(nachname);
        Thread.sleep(500);
        enterEmail(email);

                Thread.sleep(500);
                enterStreet(strasse);
                Thread.sleep(1000);
                enterHouseNumber(haunummer);
                Thread.sleep(1000);
        telefonnummerHinzufuegen(telefon);
        Thread.sleep(1000);
                enterPostalCode(shop, zip);
                Thread.sleep(500);
                enterCity(stadt);
                Thread.sleep(500);




            enterPasswordAlsGast(password);




    }




    public HomePage clickOnFirstShoeImage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstBoot));
        firstBoot.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }



    public HomePage clickOnAddToCart(String shop, Boolean loggedIn, String environment) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                if (loggedIn)
                {
                    AddToCartButtonDSDLoggedIn.click();
                }
                else
                {
                    AddToCartButtonDSD.click();
                }
                break;
            case "DHU":
                if (environment.equalsIgnoreCase("Gemini"))
                {
                    AddToCartButtonDHUGemini.click();
                }
                break;


            default:
                AddToCartButton.click();

        }

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public RegistrationPage selectGenderFrau() {

        radioGenderFrau.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public HomePage clickOnSafelyCheckoutButton(String mobileOrDesktop, String shop) throws InterruptedException {

        if (mobileOrDesktop.equalsIgnoreCase("Mobile")) {
            Thread.sleep(5000);
            driver.findElement(By.xpath(zurKasseXpath)).click();
            System.out.println("Checkout Button geklickt");
        }
        else
        {

            if (!shop.equalsIgnoreCase("DHU"))
            {
                Thread.sleep(5000);
                driver.findElement(By.xpath(zurKasseXpath)).click();
            }
            else
            {
                Thread.sleep(5000);
                driver.findElement(By.xpath(zurKasseXpathDHU)).click();
            }

        }


        //Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }




    public void clickOnCookiesOkayButton()
    {
/*        System.out.println("IS enabled !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isEnabled()));
        System.out.println("IS displayed !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isDisplayed()));
        System.out.println("IS selected !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isSelected()));*/

        if (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isDisplayed()) {

            CookiesOkButton.click();
        } else {

            System.out.println("Cookies Button ist nicht da");
        }

    }



    public HomePage clickOnFilterGroesse(String shop) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                filterGroesseDE.click();
                System.out.println("Filter Größe DE ausgewählet");
                break;
            case "VHS":
                Thread.sleep(2000);
                filterGroesseVHS.click();
                System.out.println("Filter Größe VHS ausgewählet");
                Thread.sleep(2000);
                filterGroesseVHSMaatEU.click();
                break;
            case "VBE":
                filterGroesseVBE.click();
                System.out.println("Filter Größe VBE ausgewählet");
                break;
            case "DOS":
                filterGroesseDOS.click();
                System.out.println("Filter Größe DOS ausgewählet");
                break;
            case "DHU":
                filterGroesseDHU.click();
                System.out.println("Filter Größe DHU ausgewählet");
                break;
            case "DUK":
                filterGroesseDUK.click();
                System.out.println("Filter Größe DUK ausgewählet");
                break;
            default:
                System.out.println("verify shop variable!!");
        }



        //Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }



    public HomePage chooseOnFilterGroesse37EU() throws InterruptedException {
        groesseEU37.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }




    public void closeNotificationRabatt() throws InterruptedException {
        if (!driver.findElements(By.xpath("//div[@class='dy-full-width-notifications-close']")).isEmpty())
        {
            Thread.sleep(2000);
            closeNotifRabatt.click();
        }
        else {

            System.out.println("Notification rabatt ist nicht da");
        }

    }



    public HomePage produktAuswahlenPLP(String shop) throws InterruptedException {

if (!shop.equalsIgnoreCase("DHU"))
{
    chooseOnFilterGroesse37EU();
}

        Thread.sleep(5000);
        clickOnFirstShoeImage();

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage selectShoeSize37() throws InterruptedException {
        SelectSizeSiebenUndDreissig.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage produktAuswahlenPDP(String shop, String mobileOrDesktop, Boolean loggedIn, String environment) throws InterruptedException {

        clickOnAddToCart(shop, loggedIn, environment);
        Thread.sleep(3000);
        if (!shop.equalsIgnoreCase("DHU"))
        {
            selectShoeSize37();
        }
        Thread.sleep(3000);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }



    public HomePage zumWarenkorb() throws InterruptedException {

        Thread.sleep(2000);
        zumWarenkorb.click();


        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }




}
