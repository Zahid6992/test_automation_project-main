package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class RegistrationPage extends DriverHelper {

    private WebDriverWait wait;

    @FindBy(xpath = "//span[@class='input-radio']")
    private WebElement radioGenderFrau;

    @FindBy(xpath = "//input[@id='delivery-password']")
    private WebElement txtpassword;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=1]")
    private WebElement newsletter;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=3]")
    private WebElement txtppolicyOld;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=2]")
    private WebElement txtppolicyDHU;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=2]")
    private WebElement txtppolicyDOS;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=2]")
    private WebElement txtppolicyDUK;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=3]")
    private WebElement txtppolicy;

    @FindBy(xpath = "(//span[@class='checkmark'])[position()=2]")
    private WebElement txtppolicyA;

    public static final String btnRegisterXpath = "//button[@data-value='Jetzt kostenlos registrieren']";
    @FindBy(xpath = btnRegisterXpath)
    private WebElement btnRegister;

    public static final String btnRegisterVHSXpath = "//button[@data-value='Jetzt kostenlos registrieren']";
    @FindBy(xpath = btnRegisterVHSXpath)
    private WebElement btnRegisterVHS;

    public static final String btnRegisterDOSXpath = "//button[@data-value='Jetzt kostenlos registrieren']";
    @FindBy(xpath = btnRegisterDOSXpath)
    private WebElement btnRegisterDOS;

    public static final String btnRegisterVBEXpath = "//button[@data-value='Jetzt kostenlos registrieren']";
    @FindBy(xpath = btnRegisterVBEXpath)
    private WebElement btnRegisterVBE;

    public static final String btnRegisterDHUXpath = "//button[@data-value='Jetzt kostenlos registrieren']";
    @FindBy(xpath = btnRegisterDHUXpath)
    private WebElement btnRegisterDHU;

    public static final String btnRegisterDUKXpath = "//button[@data-key='register.component.register']";
    @FindBy(xpath = btnRegisterDUKXpath)
    private WebElement btnRegisterDUK;

    @FindBy(xpath = "//a[@data-value='Neu hier']")
    private WebElement btnNewAcount;

    @FindBy(xpath = "//a[@data-value='Ich habe noch keinen Account']")
    private WebElement btnNewAcountDSD;

    @FindBy(xpath = "//body/div[1]/main[1]/form[1]/form[1]/label[1]/span[1]")
    private WebElement checkliefer;

    @FindBy(xpath = "//label[@for='radio-gender_paymentAddress1']")
    private WebElement herr;

    @FindBy(xpath = "//input[@name='newsletterDesired']/parent::label")
    private WebElement Newslettertxt;

    @FindBy(xpath = "(//a[@data-value='Meine Adressen'])[position()=3]")
    private WebElement liferadresseMobile;

    @FindBy(xpath = "(//a[@data-value='Meine Adressen'])[position()=2]")
    private WebElement liferadresseDesktop;

    @FindBy(xpath = "//button[@data-value='Neue Adresse hinzufügen']")
    private WebElement addresseHinzufügen;

    @FindBy(xpath = "//span[@data-value='Passwort vergessen?']")
    private WebElement passverg;

    @FindBy(xpath = "//input[@name='passwordReset']")
    private WebElement PVemail;

    @FindBy(xpath = "//button[@data-value='Passwort zusenden']")
    private WebElement btnreset;

    @FindBy(xpath = "//*[@id='reset-password-modal']//header//a//*[local-name() = 'svg']")
    private WebElement btnresetClose;

    @FindBy(xpath = "(//p[text()='Sneaker'])[position()=1] ")
    private WebElement sneak;

    @FindBy(xpath = "//span[@data-value='Wähle deine Größe']")
    private WebElement grosse;

    @FindBy(xpath = "//*[@data-value='Als Gast fortfahren']")
    private WebElement btngast;

    public static final String btnliefermethodeXpath = "//button[@data-value='Weiter zur Liefermethode']";
    @FindBy(xpath = btnliefermethodeXpath)
    private WebElement btnliefermethode;

    @FindBy(xpath = "//label[@for='create-account']")
    private WebElement kundenKontoAnlegen;

    @FindBy(xpath = "(//span[@data-value='In den Warenkorb'])[position()=1]")
    private WebElement warenkorb;

    @FindBy(xpath = "(//a[@data-value='Warenkorb ansehen'])[position()=2]")
    private WebElement warenkorbSehenMobile;

    @FindBy(xpath = "(//a[@data-value='Warenkorb ansehen'])[position()=3]")
    private WebElement warenkorbSehenDesktop;

    @FindBy(xpath = "(//a[@data-value='Abmelden'])[position()=3]")
    private WebElement abmeldenMobile;

    @FindBy(xpath = "(//a[@data-value='Abmelden'])[position()=2]")
    private WebElement abmeldenDesktop;

    @FindBy(xpath = "//body/div[@id='added-modal_desktop']/div[2]/div[1]/div[1]/div[2]/m-button[1]/button[1]")
    private WebElement sofortkasse;

    @FindBy(xpath = "//a[@data-value='Als Gast fortfahren']")
    private WebElement alsgast;

    public final String kontotxtXPATH = "//h1[@data-value='Mein Konto']";
    @FindBy(xpath = kontotxtXPATH)
    private WebElement kontotxt;

    @FindBy(xpath = "//Select[@id='undefined']/option[7]")
    private WebElement de;

    @FindBy(xpath = "//button[@data-value='Weiter zur WeiterZurLiefermethode']")
    private WebElement btnweiter;

    @FindBy(xpath = "//body/div[1]/main[1]/div[1]/div[1]/section[1]/m-checkout-address-page[1]/form[1]/form[1]/label[1]/span[1]")
    private WebElement checkliferano;

    @FindBy(xpath = "//button[@data-value='Weiter zur Zahlungsmethode']")
    private WebElement versand;

    @FindBy(xpath = "//label[@for='paymentMethode-sofort#deichmann_DE']")
    private WebElement methode;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=1]")
    private WebElement valid1;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=2]")
    private WebElement valid2;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=3]")
    private WebElement valid3;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=4]")
    private WebElement valid4;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=5]")
    private WebElement valid5;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=6]")
    private WebElement valid6;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=7]")
    private WebElement valid7;

    @FindBy(xpath = "(//span[@class='form-control-errors'])[position()=8]")
    private WebElement valid8;


    public void selectsneack() {
        sneak.click();
    }

    public void GrosseSelect() {
        grosse.click();
    }

    public void meinAdressenZeigen(String mobileDesktop) {
        if (mobileDesktop.equalsIgnoreCase("Mobile")) {
            liferadresseMobile.click();
        } else {
            liferadresseDesktop.click();
        }
    }

    public void addressenhinzufuegen() {
        addresseHinzufügen.click();
    }


    public void passwortvergessen() {
        passverg.click();
    }

    public RegistrationPage enterPassvergessenmail(String pv) {
        PVemail.sendKeys(pv);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public void ResetMyMail() {
        btnreset.click();
    }

    public void ResetMyMailClose() {
        btnresetClose.click();
    }

    public RegistrationPage WeiterZurLiefermethode(String shop) throws InterruptedException {


        btnliefermethode.click();
        Thread.sleep(2000);
        if (!driver.findElements(By.xpath(btnliefermethodeXpath)).isEmpty()) {
            btnliefermethode.click();
            System.out.println("Button weiter zur WeiterZurLiefermethode zum zweiten Mal geklickt");
        } else {
            System.out.println("Button weiter zur WeiterZurLiefermethode ist nicht da");
        }

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }


    public RegistrationPage clickOnNewAccount(String shop) {


        btnNewAcount.click();

/*
        switch (shop) {
            case "DSD":
                btnNewAcountDSD.click();
                break;
            default:
                btnNewAcount.click();
        }
*/


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage selectGenderFrau() {

        radioGenderFrau.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage alsGastClick(String mobileDesktop) {


        if (mobileDesktop.equalsIgnoreCase("Mobile")) {

            driver.findElement(By.xpath("//label[@data-value='Neu hier?']")).click();
            btngast.click();
        } else {
            driver.findElement(By.xpath("//*[@data-value='Als Gast fortfahren']")).click();
        }


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage enterPwd(String pwd) {

        txtpassword.click();
        txtpassword.sendKeys(pwd);
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage selectNewsletter() {

        newsletter.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage selectPolicy(String shop, String checkout) {

        switch (shop)
        {
            case "VBE":
                if (checkout.equalsIgnoreCase("true")) {
                    txtppolicy.click();
                } else {
                    System.out.println("No Checkbox for Policy for VHS Shop a Release 22.0.1");
                    //  txtppolicy.click();
                }


            case "VHS":

                if (checkout.equalsIgnoreCase("true")) {
                    txtppolicy.click();
                } else {
                    System.out.println("No Checkbox for Policy for VHS Shop a Release 22.0.1");
                    //   txtppolicy.click();
                }
                break;
            case "DHU":

                if (checkout.equalsIgnoreCase("true")) {
                    txtppolicy.click();
                } else {
                    System.out.println("No Checkbox for Policy for DHU Shop a Release 22.0.1");
                    txtppolicyDHU.click();
                }
                break;
            case "DSD":

                if (checkout.equalsIgnoreCase("true")) {
                    txtppolicy.click();
                } else {
                    JavascriptExecutor jse = (JavascriptExecutor)driver;
                    jse.executeScript("window.scrollBy(0,250)");
                    txtppolicyA.click();
                }
                break;
            case "DOS":
                txtppolicyA.click();

                break;
            case "DUK":
                txtppolicyA.click();

                break;
            default:
            txtppolicy.click();
        }



        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    @FindBy(xpath = "//label[@for='payment-eq-delivery']")
    private WebElement rechnungsAdresse;

    public RegistrationPage selectRechnungsadresse() {
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,250)");
        rechnungsAdresse.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage ClickOnRegister(String shop) throws InterruptedException {

        switch (shop) {
            case "DSD":
                btnRegister.click();
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(btnRegisterXpath)).isEmpty()) {
                    btnRegister.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            case "DHU":
                btnRegisterDHU.click();
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(btnRegisterDHUXpath)).isEmpty()) {
                    btnRegisterDHU.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            case "DOS":
                btnRegisterDOS.click();
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(btnRegisterDOSXpath)).isEmpty()) {
                    btnRegisterDOS.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            case "VBE":
                btnRegisterVBE.click();
                Thread.sleep(3000);
                if (!driver.findElements(By.xpath(btnRegisterVBEXpath)).isEmpty()) {
                    btnRegisterVBE.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            case "VHS":
                btnRegisterVHS.click();
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(btnRegisterVHSXpath)).isEmpty()) {
                    btnRegisterVHS.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            case "DUK":
                btnRegisterDUK.click();
                Thread.sleep(1000);
                if (!driver.findElements(By.xpath(btnRegisterDUKXpath)).isEmpty()) {
                    btnRegisterDUK.click();
                } else {
                    System.out.println("Button registrieren ist nicht da");
                }
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public boolean verifyRegister() throws InterruptedException {

        if (!driver.findElements(By.xpath(kontotxtXPATH)).isEmpty())
        {
            System.out.println("Registrierung erfolgreich");
            kontotxt.click();
            Thread.sleep(2000);
            return true;

        } else {
            System.out.println("Fehler beim Registrieren");
            Thread.sleep(2000);
            return false;
        }



    }


    public RegistrationPage kontoAnlegen(String shop) throws InterruptedException {

        kundenKontoAnlegen.click();
        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public void clickwarenkorb(String shop) {

        warenkorb.click();

    }

    public void warenkorbAnsehen(String mobileDesktop) {
        if (mobileDesktop.equalsIgnoreCase("Mobile")) {

            warenkorbSehenMobile.click();
        } else {
            warenkorbSehenDesktop.click();
        }


    }

    public void clickOnAbmelden(String mobileDesktop) {

        if (mobileDesktop.equalsIgnoreCase("Mobile")) {

            abmeldenMobile.click();
        } else {
            abmeldenDesktop.click();
        }


    }


    public void sofortclick(String mobileDesktop) {

        if (mobileDesktop.equalsIgnoreCase("Mobile")) {

            driver.findElement(By.xpath("//a[@data-value='Jetzt sicher zur Kasse']")).click();
        } else {

            sofortkasse.click();
        }


    }

    public void anonymeLand() {
        de.click();
    }

    public void weiterZurLief() {
        btnweiter.click();
    }

    public void checkAnonymeLief() {
        checkliferano.click();
    }

    public void clickonVersand() {
        versand.click();
    }

    public void methodecheck() {
        methode.click();
    }

    public void clickalsgast() {
        alsgast.click();
    }


    public void RoteFelderwait(String shop) {


        if (valid1.isEnabled()) {
            System.out.println("Der erster Roter Felder ist da ");
        }
        if (valid2.isEnabled()) {
            System.out.println("Der zweiter Roter Felder ist da ");
        }
        if (valid3.isEnabled()) {
            System.out.println("Der dritter Roter Felder ist da ");
        }
        if (valid4.isEnabled()) {
            System.out.println("Der vierter Roter Felder ist da ");
        }

        if (!shop.equalsIgnoreCase("DUK"))
        {
//            if (valid5.isEnabled()) {
//                System.out.println("Der fünfter Roter Felder ist da ");
//            }
//            if (valid6.isEnabled()) {
//                System.out.println("Der sechster Roter Felder ist da ");
//            }
/*            if (valid7.isEnabled()) {
                System.out.println("Der siebter Roter Felder ist da ");
            }*/

            if (!shop.equalsIgnoreCase("VHS")) {
                if (valid8.isEnabled()) {
                    System.out.println("Der achter Roter Felder ist da ");
                }
            }
        }



    }


}
