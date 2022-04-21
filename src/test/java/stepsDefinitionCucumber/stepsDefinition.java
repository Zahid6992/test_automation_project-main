package stepsDefinitionCucumber;

import com.pagesAndComponents.*;
import com.utils.PropertyReader;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class stepsDefinition {

    public PropertyReader propertyReader;
    public LoginPage loginPage;
    public HomePage homePage;
    public ProductListPage productListPage;
    public RegistrationPage registrationPage;
    public FilterComponent filterComponent;
    public WebDriver driver;
    public FormularLieferadresse formularLieferadresse;



    @Before
    public void setUp( ) throws MalformedURLException {
        // ITestContext ctx;
        String mobileOrDesktop = "Desktop";
        String deviceName = "";


        propertyReader = new PropertyReader();

        String host = "localhost";
        //String mobileOrDesktop;
        //String deviceName;

        DesiredCapabilities dc = DesiredCapabilities.chrome();

        String browser = propertyReader.readApplicationFile("BROWSER");

        if (browser.equalsIgnoreCase("firefox")) {
            dc = DesiredCapabilities.firefox();
        }

        // String testName = ctx.getCurrentXmlTest().getName();
        String completeUrl = "http://" + host + ":4444/wd/hub";


        if (mobileOrDesktop.equalsIgnoreCase("Mobile")) {
            HashMap<String, String> mobileEmulation  = new HashMap<>();
            mobileEmulation.put("deviceName",deviceName);
            Map<String, Object> chromeOptions = new HashMap<>();
            chromeOptions.put("mobileEmulation",mobileEmulation);
            dc.setCapability(ChromeOptions.CAPABILITY,chromeOptions);
        }

        dc.setCapability("name", "TestCucumber");
        this.driver = new RemoteWebDriver(new URL(completeUrl), dc);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        //String applicationUrl = propertyReader.readApplicationFile("App_URL");
        String applicationUrl = "https://www2.deichmann.com/de-de";
        getWebDriver().get(applicationUrl);
        //JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("return document.readyState").toString().equals("complete");


        loginPage = PageFactory.initElements(driver,LoginPage.class);
        homePage= PageFactory.initElements(driver,HomePage.class);
        productListPage= PageFactory.initElements(driver,ProductListPage.class);
        registrationPage= PageFactory.initElements(driver,RegistrationPage.class);
        filterComponent= PageFactory.initElements(driver,FilterComponent.class);

        System.out.println("before hook executed successfully");

    }

    @AfterClass
    public void tearDown() {
        this.driver.close();
        this.driver.quit();
    }
    public WebDriver getWebDriver() {
        return this.driver;
    }

    public PropertyReader getProperty() {
        return this.propertyReader;
    }
    public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
        if (aStart > aEnd) {
            throw new IllegalArgumentException("Start cannot exceed End.");
        } else {
            long range = (long)aEnd - (long)aStart + 1L;
            long fraction = (long)((double)range * aRandom.nextDouble());
            int randomNumber = (int)(fraction + (long)aStart);
            return randomNumber;
        }
    }
    public String randomString(int len) {
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);

        for(int i = 0; i < len; ++i) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }

        return sb.toString();
    }
    static enum DriverType {
        Firefox,
        IE,
        Chrome;

        private DriverType() {
        }
    }




    @Given("^Benutzerdaten vorhanden$")
    public void userdataread() {
        System.out.println("Userdaten sind vorhanden");
    }


    @When("^Benutzer loggt sich mit seinem (.+) und (.+) auf QA ein$")
    public void user_enters_and(String username, String password) throws InterruptedException {

        loginPage = loginPage.loginIntoPlatformQA(username, password);
        loginPage.clickOnCookiesOkayButton("DSD", "QA");
    }


    @Then("^Login erfolgreich$")
    public void login_successfully() throws Throwable
    {
        System.out.println("login successfully!!");
    }

    @Then("^Benutzer ist erfolgreich registriert$")
    public void benutzer_ist_erfolgreich_registriert() throws Throwable {

        System.out.println("New User Registered Successfully");
    }

    @And("^Benutzer navigiert zur Registrierungsseite$")
    public void benutzer_navigiert_zur_registrierungsseite() throws Throwable {
        String shop = null;
        loginPage.mouseHoverOnRegisterIcon();
        loginPage.mouseHoverOnRegisterIcon();
        registrationPage.clickOnNewAccount(shop);

    }

    @And("^Benutzer wählt ein Geschlecht im Checkbox aus$")
    public void benutzer_whlt_ein_geschlecht_im_checkbox_aus() throws Throwable {
        registrationPage.selectGenderFrau();

    }

    @And("^Benutzer füllt das Registrierungsformular aus (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+)$")
    public void benutzer_fllt_das_registrierungsformular_aus(String vorname, String nachname, String email, String passwort, String straße, String hausnummer, String postleizahl, String stadt) throws Throwable {
        String name=randomString(10);
        formularLieferadresse.enterFirstname(vorname);
        formularLieferadresse.enterLastName(nachname);
        formularLieferadresse.enterEmail(name+email);
        registrationPage.enterPwd(passwort);
        formularLieferadresse.enterStreet(straße);
        formularLieferadresse.enterHouseNumber(hausnummer);
        formularLieferadresse.enterPostalCode(postleizahl);
        formularLieferadresse.enterCity(stadt);

    }

    @And("^Benutzer akzeptiert die Datenbestimmung$")
    public void benutzer_akzeptiert_die_datenbestimmung() throws Throwable {
        registrationPage.selectPolicy("DSD", "false");

    }

    @And("^Benutzer klickt auf Jetzt Registrieren$")
    public void benutzer_klickt_auf_jetzt_registrieren() throws Throwable {
        String shop = null;
        registrationPage.ClickOnRegister(shop);
    }






}
