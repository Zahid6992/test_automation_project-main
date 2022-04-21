package com.pagesAndComponents;

import com.utils.DriverHelper;
import com.utils.PropertyReader;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageGemini extends DriverHelper {
    public PropertyReader propertyReader;

    @FindBy(id = "input_1")
    private WebElement usernameTxt;

    @FindBy(id = "input_1")
    private WebElement usernameTxtGemini;

    @FindBy(id = "input_2")
    private WebElement passowrdTxt;

    @FindBy(id = "input_2")
    private WebElement passowrdTxtGemini;

    @FindBy(xpath = "/html/body/table[2]/tbody/tr/td[1]/form/table/tbody/tr[5]/td/input")
    private WebElement logon;

    @FindBy(xpath = "//div[@class='shortcuts']/map[2]/a")
    private WebElement AccountIcon;

    //div[@class='shortcuts']//a/span[@data-value='Mein Account']
    //div[@class='shortcuts']/map[2]/a
    //a/span[contains(text(),'Mein Account')]
    @FindBy(xpath = "//button[contains(text(),'Anmelden')]")
    private WebElement RegisterButton;

    @FindBy(xpath = "//div/input[@type='email' and @placeholder='E-Mail-Adresse']")
    private WebElement EmailAddress;

    @FindBy(xpath = "//div/input[@type='password' and @placeholder='Passwort']")
    private WebElement Passoword;

    @FindBy(xpath = "//button[@type='submit']/span[contains(text(),'Anmelden')]")
    private WebElement SubmitButton;

    @FindBy(xpath = "//html/body/div[3]/div/footer/button[2]")
    private WebElement neinCookies;


    @FindBy(className = "logout")
    private WebElement LogoutLink;

    @FindBy(xpath = "//h1[contains(text(),'Mein Konto')]")
    private WebElement MyAccount;

    @FindBy(xpath = "//div[@class='m-login']")
    private WebElement LoginForm;

    @FindBy(xpath = "//h1[contains(text(),'Anmelden')]")
    private WebElement RegisterTextAtLoginForm;

    //@FindBy(xpath = "//html/body/div[3]/div/footer/button[3]")
    private final String cookiesOkButtonXPATH = "//button[@data-key='consent.modal.agree']";
    @FindBy(xpath = cookiesOkButtonXPATH)
    private WebElement CookiesOkButton;

    @FindBy(xpath = "//input[@name='username']")
    private WebElement username;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement password;

    private final String btnanmeldenXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenXPATH)
    private WebElement btnanmelden;

    private final String btnanmeldenDSDXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenDSDXPATH)
    private WebElement btnanmeldenDSD;

    private final String btnanmeldenVHSXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenVHSXPATH)
    private WebElement btnanmeldenVHS;

    private final String btnanmeldenVBEXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenVBEXPATH)
    private WebElement btnanmeldenVBE;

    private final String btnanmeldenDHUXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenDHUXPATH)
    private WebElement btnanmeldenDHU;

    private final String btnanmeldenDOSXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenDOSXPATH)
    private WebElement btnanmeldenDOS;

    private final String btnanmeldenDUKXPATH = "(//button[@data-value='Jetzt anmelden'])[position()=1]";
    @FindBy(xpath = btnanmeldenDUKXPATH)
    private WebElement btnanmeldenDUK;

    @FindBy(xpath = "//h1[@data-value='Mein Konto']")
    private WebElement kontotxt;

    public final String closeNotifRabattXPATH = "//div[@class='dy-full-width-notifications-close']";
    @FindBy(xpath = closeNotifRabattXPATH)
    private WebElement closeNotifRabatt;

    public final String closePopupNewsletterXPATH = "//div[@class='dy-lb-close']";
    @FindBy(xpath = closePopupNewsletterXPATH)
    private WebElement closePopupNewsletter;


    protected WebDriverWait wait;


    public LoginPageGemini(WebDriver driver) {

        super(driver);
        this.wait = new WebDriverWait(driver, 10);
    }


    public void closeNewsletterAbonnierenPopup() {

        if (!driver.findElements(By.xpath(closePopupNewsletterXPATH)).isEmpty()) {

            closePopupNewsletter.click();
        } else {

            System.out.println("Newsletter Popup ist nicht da ist nicht da");
        }

    }

    public void closeNotificationRabatt() {

        if (!driver.findElements(By.xpath(closeNotifRabattXPATH)).isEmpty()) {

            closeNotifRabatt.click();
        } else {

            System.out.println("Newsletter Popup ist nicht da ist nicht da");
        }

    }


    public LoginPageGemini mouseHoverOnRegisterIcon() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", AccountIcon);
        Thread.sleep(500);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }


    public LoginPageGemini clickOnRegisterButton() {
        RegisterButton.click();
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterEmailAddress(String emailAddress) {
        EmailAddress.clear();
        EmailAddress.sendKeys(emailAddress);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterUsernameQA(String username) {
        usernameTxt.clear();
        usernameTxt.sendKeys(username);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterUsernameGemini(String username) {
        usernameTxtGemini.clear();
        usernameTxtGemini.sendKeys(username);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterPassword(String password) {
        Passoword.clear();
        Passoword.sendKeys(password);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterPasswordQA(String passwordQA) {
        passowrdTxt.clear();
        passowrdTxt.sendKeys(passwordQA);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini enterPasswordGemini(String passwordQA) {
        passowrdTxtGemini.clear();
        passowrdTxtGemini.sendKeys(passwordQA);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }


    public LoginPageGemini clickOnLoginButton() {
        SubmitButton.click();
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini clickOnLogonButtonQA() {
        logon.click();
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini loginIntoApplication(String emailAddress, String password) throws InterruptedException {

        mouseHoverOnRegisterIcon();
        //clickOnRegisterButton();
        enterEmailAddress(emailAddress);
        enterPassword(password);
        clickOnLoginButton();
        waitForInvisibility(LoginForm, 5);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini loginIntoPlatformQA(String username, String password) throws InterruptedException {

        enterUsernameQA(username);
        enterPasswordQA(password);
        clickOnLogonButtonQA();
        // waitForInvisibility(LoginForm, 5);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public LoginPageGemini loginIntoPlatformGemini(String username, String password) throws InterruptedException {

        enterUsernameGemini(username);
        enterPasswordGemini(password);
        clickOnLogonButtonQA();
        // waitForInvisibility(LoginForm, 5);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }

    public void waitForInvisibility(WebElement webElement, int maxSeconds) {
        Long startTime = System.currentTimeMillis();
        try {
            while (System.currentTimeMillis() - startTime < maxSeconds * 1000 && webElement.isDisplayed()) {
            }
        } catch (Exception e) {
            return;
        }
    }


    public LoginPageGemini verifyMyAccountIsDisplayed() {
        AccountIcon.click();
        boolean result = MyAccount.isDisplayed();
        System.out.println("Result is: " + result);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }


    public boolean WaitUntilWebElementIsInvisible(WebElement element) {
        try {
            this.wait.until(ExpectedConditions.visibilityOf(element));
            System.out.println("WebElement is NOT visible using locator: " + "<" + element.toString() + ">");
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void signOutFromApplication() throws InterruptedException {
        mouseHoverOnRegisterIcon2();
        LogoutLink.click();
        System.out.println("Signed Out from Application");
    }


    public LoginPageGemini mouseHoverOnRegisterIcon2() throws InterruptedException {

        Actions actions = new Actions(driver);
        actions.moveToElement(AccountIcon).build().perform();

        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
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

    public void checkCookiesButton() {

        try {
            CookiesOkButton.click();
        } catch (Exception e) {
            System.out.println("Cookies Button ist nicht da");
        }


    }


    public RegistrationPage anmelden(String shop) throws InterruptedException {
        String username = null;
        String password = null;
        propertyReader = new PropertyReader();
        switch (propertyReader.readApplicationFile("Environment")) {
            case "QA":
                username = propertyReader.readApplicationFile("UserNameQA");
                password = propertyReader.readApplicationFile("PasswordQA");
                break;
            case "Prod":
                username = propertyReader.readApplicationFile("UsernameProd");
                password = propertyReader.readApplicationFile("PasswordProd");
                break;
            default:
                System.out.println("please verify the environment variable!");
        }
        System.out.println(username);
        System.out.println(password);
        Thread.sleep(500);
        this.username.clear();
        Thread.sleep(500);
        this.username.sendKeys(username);
        Thread.sleep(500);
        this.password.clear();
        Thread.sleep(500);
        this.password.sendKeys(password);
        Thread.sleep(500);
        switch (shop) {
            case "VHS":
                btnanmeldenVHS.click();
                break;
            case "VBE":
                btnanmeldenVBE.click();
                break;
            case "DHU":
                btnanmeldenDHU.click();
            case "DOS":
                btnanmeldenDOS.click();
                break;
            case "DUK":
                btnanmeldenDUK.click();
                break;
            case "DSD":
                btnanmeldenDSD.click();
                break;
            default:
                btnanmelden.click();
        }
        kontotxt.click();
        if (kontotxt.isEnabled()) {
            System.out.println("Login erfolgreich");
        } else {
            System.out.println("Fehler beim Login");
        }

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public RegistrationPage checkAbmeldungErfolgreich() throws InterruptedException {

        Thread.sleep(500);
        this.username.clear();
        Thread.sleep(500);
        this.password.clear();
        Thread.sleep(500);


        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public RegistrationPage anmeldenNachPasswordVergessen(String email, String password, String shop) throws InterruptedException {


        System.out.println(email);
        System.out.println(password);
        Thread.sleep(500);
        this.username.clear();
        Thread.sleep(500);
        this.username.sendKeys(email);
        Thread.sleep(500);
        this.password.clear();
        Thread.sleep(500);
        this.password.sendKeys(password);
        Thread.sleep(500);
        switch (shop) {
            case "VHS":
                btnanmeldenVHS.click();
                break;
            case "VBE":
                btnanmeldenVBE.click();
                break;
            case "DHU":
                btnanmeldenDHU.click();
            case "DOS":
                btnanmeldenDOS.click();
                break;
            case "DUK":
                btnanmeldenDUK.click();
                break;
            case "DSD":
                btnanmeldenDSD.click();
                break;
            default:
                btnanmelden.click();
        }
        kontotxt.click();
        if (kontotxt.isEnabled()) {
            System.out.println("Login erfolgreich");
        } else {
            System.out.println("Fehler beim Login");
        }

        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }


    public boolean anmeldenImCheckout(String shop) throws InterruptedException {
        boolean isPresent = false;
        String username = null;
        String password = null;
        propertyReader = new PropertyReader();
        switch (propertyReader.readApplicationFile("Environment")) {
            case "QA":
                username = propertyReader.readApplicationFile("UserNameQA");
                password = propertyReader.readApplicationFile("PasswordQA");
                break;
            case "Prod":
                username = propertyReader.readApplicationFile("UsernameProd");
                password = propertyReader.readApplicationFile("PasswordProd");
                break;
            default:
                System.out.println("please verify the environment variable!");
        }
        System.out.println(username);
        System.out.println(password);
        this.username.sendKeys(username);
        this.password.sendKeys(password);

        switch (shop) {
            case "VHS":
                btnanmeldenVHS.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenVHSXPATH)).size() > 0;
                break;
            case "VBE":
                btnanmeldenVBE.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenVBEXPATH)).size() > 0;
                break;
            case "DHU":
                btnanmeldenDHU.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDHUXPATH)).size() > 0;
                break;
            case "DOS":
                btnanmeldenDOS.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDOSXPATH)).size() > 0;
                break;
            case "DUK":
                btnanmeldenDUK.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDUKXPATH)).size() > 0;
                break;
            case "DSD":
                btnanmeldenDSD.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDSDXPATH)).size() > 0;
                break;
            default:
                btnanmelden.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenXPATH)).size() > 0;
                break;
        }


        return !isPresent;

//        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }

    public boolean anmeldenImCheckoutHfuenf(String shop) throws InterruptedException {
        boolean isPresent = false;
        String username = null;
        String password = null;
        propertyReader = new PropertyReader();
        switch (propertyReader.readApplicationFile("Environment")) {
            case "QA":
                username = propertyReader.readApplicationFileUsers("UsernameProd");
                password = propertyReader.readApplicationFile("PasswordQA");
                break;
            case "Prod":
                username = propertyReader.readApplicationFile("UsernameProd");
                password = propertyReader.readApplicationFile("PasswordProd");
                break;
            default:
                System.out.println("please verify the environment variable!");
        }
        System.out.println(username);
        System.out.println(password);
        this.username.clear();
        Thread.sleep(500);
        this.password.clear();
        Thread.sleep(500);
        this.username.sendKeys(username);
        Thread.sleep(500);
        this.password.sendKeys(password);

        switch (shop) {
            case "VHS":
                btnanmeldenVHS.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenVHSXPATH)).size() > 0;
                break;
            case "VBE":
                btnanmeldenVBE.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenVBEXPATH)).size() > 0;
                break;
            case "DHU":
                btnanmeldenDHU.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDHUXPATH)).size() > 0;
                break;
            case "DOS":
                btnanmeldenDOS.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDOSXPATH)).size() > 0;
                break;
            case "DUK":
                btnanmeldenDUK.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDUKXPATH)).size() > 0;
                break;
            case "DSD":
                btnanmeldenDSD.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenDSDXPATH)).size() > 0;
                break;
            default:
                btnanmelden.click();
                Thread.sleep(10000);
                isPresent = driver.findElements(By.xpath(btnanmeldenXPATH)).size() > 0;
                break;
        }


        return !isPresent;

//        return PageFactory.initElements(getWebDriver(), RegistrationPage.class);
    }



    @FindBy(xpath = "//div[@class='shortcuts']/map[1]/a")
    private WebElement suchen;

    @FindBy(xpath = "(//a[@data-value='Meine Adressen'])[position()=1]")
    private WebElement meineAdressen;


    public LoginPageGemini mouseHoverOnFilialeSuchen() throws InterruptedException {

        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", suchen);
        Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), LoginPageGemini.class);
    }


    public void meineAdressen() {

        meineAdressen.click();

    }


}
