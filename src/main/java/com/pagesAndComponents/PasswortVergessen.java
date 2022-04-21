package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswortVergessen extends DriverHelper {

    private WebDriver driver;
    private WebDriverWait wait;


    @FindBy(xpath = "//label[@for='radio-gender_deliveryAddress0'][1]")
    private WebElement rbgender;

    @FindBy(xpath = "//input[@name='firstName'][1]")
    private WebElement txtfirstname;

    @FindBy(xpath = "//input[@name='lastName'][1]")
    private WebElement txtlastname;

    @FindBy(xpath = "//input[@type='email'][1]")
    private WebElement txtemail;

    @FindBy(xpath = "//input[@name='password'][1]")
    private WebElement txtpassword;

    @FindBy(xpath = "//input[@name='line1'][1]")
    private WebElement txtline1;

    @FindBy(xpath = "//input[@name='line2'][1]")
    private WebElement txtline2;

    @FindBy(xpath = "//input[@name='postalCode'][1]")
    private WebElement txtpostalcode;

    @FindBy(xpath = "//input[@name='town'][1]")
    private WebElement txtcity;

    @FindBy(xpath = "//input[@name='privacyPolicyConfirmed'][1]/parent::label")
    private WebElement txtppolicy;

    @FindBy(xpath = "//button[@data-value='Registrieren']")
    private WebElement btnRegister;

    @FindBy(xpath = "//a[contains(@data-key,'hasNoAccount')]")
    private WebElement btnNewAcount;

    @FindBy(xpath = "//input[@name='phone']")
    private WebElement phonetxt;
    @FindBy(xpath = "(//label[@class='click-label'])[position()=8]")
    private WebElement nurLiefertxt;

    @FindBy(xpath = "//span[@data-value='Passwort vergessen?']")
    private WebElement passverg;

    @FindBy(xpath = "//button[@data-value='Weiter zur WeiterZurLiefermethode']")
    private WebElement btnliefermethode;


    public void phoneEnter() {
        phonetxt.click();
    }

    public void nurLiefer() {
        nurLiefertxt.click();
    }


    public void passwortvergessen() {
        passverg.click();
    }

    public PasswortVergessen Liefermethode() {
        btnliefermethode.click();
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen(WebDriver driver) {
        super(driver);
    }


    public PasswortVergessen clickOnNewAccount() {

        btnNewAcount.click();
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }


    public PasswortVergessen selectGender() {

        rbgender.click();
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterFirstname(String firstname) {

        txtfirstname.click();

        txtfirstname.sendKeys(firstname);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterLastName(String lastname) {

        txtlastname.click();
        txtlastname.sendKeys(lastname);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterEmail(String email) {

        txtemail.click();
        txtemail.sendKeys(email);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterPwd(String pwd) {

        txtpassword.click();
        txtpassword.sendKeys(pwd);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterStreet(String Street) {

        txtline1.click();
        txtline1.sendKeys(Street);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterHouseNumber(String Housenumber) {

        txtline2.click();
        txtline2.sendKeys(Housenumber);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterPostalCode(String Postcode) {

        txtpostalcode.click();
        txtpostalcode.sendKeys(Postcode);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen enterCity(String City) {

        txtcity.click();
        txtcity.sendKeys(City);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen selectPolicy() {

        txtppolicy.click();
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }

    public PasswortVergessen ClickOnRegister() throws InterruptedException {

        btnRegister.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), PasswortVergessen.class);
    }


}
