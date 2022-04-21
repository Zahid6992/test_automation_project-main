package com.pagesAndComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.DriverHelper;


public class FilialsuchePage extends DriverHelper {
    public FilialsuchePage(WebDriver webdriver) {
        super(webdriver);
    }

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement inputsuchen;

    @FindBy(xpath = "//input[@id='searchInput']")
    private WebElement inputsuchenVBE;

    @FindBy(xpath = "//button[@aria-label='Suchen']")
    private WebElement bntserach;

    @FindBy(xpath = "//button[@aria-label='Suchen']")
    private WebElement bntserachDSD;

    @FindBy(xpath = "//button[@i18ntext='Suchen']")
    private WebElement bntserachDUK;

    @FindBy(xpath = "(//button[@aria-label='Zoeken'])[position()=2]")
    private WebElement bntserachVHS;

    @FindBy(xpath = "(//button[@aria-label='Zoeken op'])[position()=1]")
    private WebElement bntserachVBE;

    @FindBy(xpath = "(//button[@aria-label='Keresés'])[position()=2]")
    private WebElement bntserachDHU;

    @FindBy(xpath = "//span[@class='address']")
    private WebElement adressezeigen;

    final public String  optionListe1XPATH = "(//span[@class='uniserv-item'])[position()=1]";
    @FindBy(xpath = optionListe1XPATH)
    private WebElement optionListe1;

    @FindBy(xpath = "(//span[@class='today'])[position()=1]")
    private WebElement bntfilialewait;

    public void stadtSuchen(String shop) throws InterruptedException {



        switch (shop) {
            case "DSD":
                inputsuchen.click();
                Thread.sleep(500);
                inputsuchen.sendKeys("Dortmund");
                Thread.sleep(1000);
                inputsuchen.sendKeys(Keys.ENTER);
                break;
            case "VHS":
                inputsuchenVBE.click();
                Thread.sleep(500);
                inputsuchenVBE.sendKeys("Amsterdam");
                Thread.sleep(1000);
                inputsuchenVBE.sendKeys(Keys.ENTER);
                break;
            case "VBE":
                inputsuchenVBE.click();
                Thread.sleep(500);
                inputsuchenVBE.sendKeys("Gent");
                Thread.sleep(1000);
                inputsuchenVBE.sendKeys(Keys.ENTER);
                break;
            case "DOS":
                inputsuchen.click();
                Thread.sleep(500);
                inputsuchen.sendKeys("Basel");
                Thread.sleep(1000);
                inputsuchenVBE.sendKeys(Keys.ENTER);
                break;
            case "DHU":
                inputsuchenVBE.click();
                Thread.sleep(500);
                inputsuchenVBE.sendKeys("Budapest");
                Thread.sleep(1000);
                inputsuchenVBE.sendKeys(Keys.ENTER);
                break;
            case "DUK":
                inputsuchen.click();
                Thread.sleep(500);
                inputsuchen.sendKeys("London");
                Thread.sleep(1000);
                inputsuchenVBE.sendKeys(Keys.ENTER);
                break;
            default:
                System.out.println("verify shop variable!!");
        }


    }

    public void AufSuchenKlicken(String shop) throws InterruptedException {
        switch (shop) {
            case "DHU":
                bntserachDHU.click();
                break;
            case "DUK":
                Thread.sleep(2000);
                if (!driver.findElements(By.xpath(optionListe1XPATH)).isEmpty()) {
                    optionListe1.click();
                }
                Thread.sleep(1000);
                bntserachDUK.click();
                break;
            case "VBE":
                bntserachVBE.click();
                break;
            default:
                bntserach.click();

        }
    }

    public void Ergebniss() {
        adressezeigen.click();
    }

    public void filialeWait() {
        bntfilialewait.click();
    }





}
