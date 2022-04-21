package com.pagesAndComponents;

import com.utils.DriverTestCase;
import com.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class NewsletterPage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;


    public Response response;
    public PropertyReader propertyReader;

    final public String frauXpath = "//label[@data-key='cms.component.newsletter.salutationFemale']";
    @FindBy(xpath = frauXpath)
    private WebElement frau;

    final public String vornameXpath = "//input[@data-key='cms.component.newsletter.firstname']";
    @FindBy(xpath = vornameXpath)
    private WebElement vorname;

    final public String nachnameXpath = "//input[@data-key='cms.component.newsletter.lastname']";
    @FindBy(xpath = nachnameXpath)
    private WebElement nachname;


    final public String emailXPATH = "//input[@data-key='cms.component.newsletter.email']";
    @FindBy(xpath = emailXPATH)
    private WebElement email;

    final public String anmeldenXpath = "//button[@data-key='cms.component.newsletter.subscribe']";
    @FindBy(xpath = anmeldenXpath)
    private WebElement anmelden;

    @FindBy(xpath = "//h3[@data-key='cms.component.newsletter.headlineSuccess']")
    private WebElement kontrolNewsletter;



    public NewsletterPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }


    public void newsletterAnmelden() throws InterruptedException {

        String randomTxt=randomString(10);
        String randomDomain=randomString(4);
        String randomEmail = randomTxt+"@" + randomDomain + ".de";

        frau.click();
        Thread.sleep(500);
        vorname.click();
        Thread.sleep(500);
        vorname.sendKeys("vorname");
        Thread.sleep(500);
        nachname.click();
        Thread.sleep(500);
        nachname.sendKeys("nachname");
        Thread.sleep(500);
        email.click();
        Thread.sleep(500);
        email.sendKeys(randomEmail);
        Thread.sleep(500);
        anmelden.click();
        Thread.sleep(500);

    }



    public void newsletterBestaetigung() {
        if (kontrolNewsletter.isDisplayed()) System.out.println("Newsletter angemeldet");
    }






}
