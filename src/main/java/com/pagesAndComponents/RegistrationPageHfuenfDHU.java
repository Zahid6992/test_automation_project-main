package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPageHfuenfDHU extends DriverHelper {

    private WebDriverWait wait;

    public RegistrationPageHfuenfDHU(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "(//input[@id='paymentAddress.gender_female'])[position()=1]")
    private WebElement gender;

    @FindBy(xpath = "(//input[@id='paymentAddress.firstname'])[position()=1]")
    private WebElement txtfirstname;

    @FindBy(xpath = "(//input[@id='paymentAddress.lastname'])[position()=1]")
    private WebElement txtlastname;

    @FindBy(xpath = "//input[@id='login']")
    private WebElement txtemail;

    @FindBy(xpath = "//input[@id='paymentAddress.postalcode']")
    private WebElement txtpostalcode;

    final public String optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    @FindBy(xpath = "//input[@id='paymentAddress.streetname']")
    private WebElement txtline1;

    @FindBy(xpath = "//input[@id='paymentAddress.phone1']")
    private WebElement txttelefon;

    @FindBy(xpath = "//input[@id='paymentAddress.town']")
    private WebElement stadt;

    @FindBy(xpath = "//input[@id='paymentAddress.streetnumber']")
    private WebElement txtline2;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordan;

    @FindBy(xpath = "(//input[@id='privacyPolicyConfirmed'])[position()=1]")
    private WebElement txtppolicyDHU;

    public static final String btnRegisterDHUXpath = "//span[contains(text(),'Regisztráció')]";
    @FindBy(xpath = btnRegisterDHUXpath)
    private WebElement btnRegisterDHU;

    public final String kontotxtXPATH = "//h1[@data-value='Mein Konto']";
    @FindBy(xpath = kontotxtXPATH)
    private WebElement kontotxt;

    private final String cookiesOkButtonXPATH = "//button[@class='button-consent-agree']";
    @FindBy(xpath = cookiesOkButtonXPATH)
    private WebElement CookiesOkButton;

    public final String logoutXPATH = "(//span[@class='quick-action__icon'])[position()=3]";
    @FindBy(xpath = logoutXPATH)
    private WebElement logout;

    public RegistrationPage selectGender() {

        gender.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterFirstname(String firstname) {

        txtfirstname.click();
        txtfirstname.sendKeys(firstname);
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

    public RegistrationPage enterPostalCode(String shop) throws InterruptedException {

        txtpostalcode.clear();
        Thread.sleep(500);
        txtpostalcode.click();
        Thread.sleep(500);
        txtpostalcode.sendKeys("1021");
        Thread.sleep(3000);
        if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
            optionListe1.click();
        }

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

    public RegistrationPage enterStadt(String Street) throws InterruptedException {
        Thread.sleep(500);
        stadt.clear();
        Thread.sleep(500);
        stadt.click();
        Thread.sleep(500);
        stadt.sendKeys(Street);
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

    public RegistrationPage enterHouseNumber(String Housenumber) throws InterruptedException {
        Thread.sleep(500);
        txtline2.clear();
        Thread.sleep(500);
        txtline2.click();
        Thread.sleep(500);
        txtline2.sendKeys(Housenumber);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage enterPasswordAlsGast(String p) {
        passwordan.sendKeys(p);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public void lieferadresseAusfuellen(String email, String shop, String vorname, String nachname, String strasse, String haunummer, String stadt, String password) throws InterruptedException {

        selectGender();
        Thread.sleep(500);
        enterFirstname(vorname);
        Thread.sleep(500);
        enterLastName(nachname);
        Thread.sleep(500);
        enterEmail(email);
        Thread.sleep(500);
        enterPostalCode(shop);
        Thread.sleep(500);
        enterStreet(strasse);
        Thread.sleep(500);
        enterStadt(stadt);
        Thread.sleep(2000);
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-250)");
        Thread.sleep(1000);
        enterTelefonnumber("+36300000000");
        Thread.sleep(500);
        enterHouseNumber(haunummer);
        Thread.sleep(500);
        //enterCity(stadt);
        Thread.sleep(500);


        if (password.equalsIgnoreCase("null")) {
            System.out.println("Kein Password ist erforderlich");
        } else {
            enterPasswordAlsGast(password);
        }

    }


    public RegistrationPage selectPolicy() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,-850)");
        Thread.sleep(1000);
        txtppolicyDHU.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage ClickOnRegister() throws InterruptedException {

                btnRegisterDHU.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public boolean verifyRegister() throws InterruptedException {

        if (!driver.findElements(By.xpath(logoutXPATH)).isEmpty())
        {
            System.out.println("Registrierung erfolgreich");
            logout.click();
            Thread.sleep(2000);
            selectGender();
            Thread.sleep(500);
            enterFirstname("vorname");
            Thread.sleep(2000);
            return true;

        } else {
            System.out.println("Fehler beim Registrieren");
            Thread.sleep(2000);
            return false;
        }



    }

    public void clickOnCookiesOkayButton() {
        //System.out.println("conditio now !! " + !(ExpectedConditions.elementToBeClickable(By.xpath(cookiesOkButtonXPATH)) == null));

        System.out.println("IS enabled !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isEnabled()));
        System.out.println("IS displayed !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isDisplayed()));
        System.out.println("IS selected !! " + (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isSelected()));
        //if (!driver.findElements(By.xpath(cookiesOkButtonXPATH)).isEmpty())

        if (driver.findElement(By.xpath(cookiesOkButtonXPATH)).isDisplayed()) {

            CookiesOkButton.click();
        } else {

            System.out.println("Cookies Button ist nicht da");
        }

    }




}
