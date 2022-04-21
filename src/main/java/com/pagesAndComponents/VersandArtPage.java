package com.pagesAndComponents;

import com.utils.DriverTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VersandArtPage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;

    //@FindBy(xpath = "//*[@class='card']")

    //@FindBy(xpath = "//label[@for='radio-deliveryModedhl-DE#deichmann_DE']")
    //@FindBy(xpath = "//input[@id='radio-deliveryModedhl-DE#deichmann_DE']")
    @FindBy(xpath = "//label[@for='radio-deliveryModedhl-DE#deichmann_DE']")
    private WebElement dhl;

    @FindBy(xpath = "//label[@for='radio-deliveryModehermes#deichmann_GB']")
    private WebElement hermes;

    public static final String postNLxpath = "//label[@for='radio-deliveryModeIdpost#vanharen_NL']";
    @FindBy(xpath = postNLxpath)
    private WebElement postNL;

    @FindBy(xpath = "//button[@data-key='checkout.deliveryModeId.buttonSave']")
    private WebElement versandArtVerwenden;

    @FindBy(xpath = "//button[@data-key='checkout.deliveryMode.buttonSave']")
    private WebElement versandArtVerwendenDUK;

    @FindBy(xpath = "//button[@data-key='checkout.deliveryMode.buttonSave']")
    private WebElement versandArtVerwendenDSD;

    public VersandArtPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void setLiefermethode(String shop) throws InterruptedException {

        switch (shop) {
            case "DSD":
                Thread.sleep(10000);
                this.wait.until(ExpectedConditions.visibilityOf(this.dhl));
                this.dhl.click();
                clickVersandArtVerwendenDSD();
                break;
            case "DHU":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "DUK":
                this.wait.until(ExpectedConditions.visibilityOf(this.hermes));
                this.hermes.click();
                clickVersandArtVerwendenDUK();
                break;
            case "DOS":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "VBE":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "VHS":
                this.wait.until(ExpectedConditions.visibilityOf(this.postNL));
                Thread.sleep(2000);
                this.postNL.click();

                clickVersandArtVerwenden();
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");

        }


    }

    public void setLiefermethodeAngemeldet(String shop) throws InterruptedException {

        switch (shop) {
            case "DSD":
                if (!driver.findElements(By.xpath("//label[@for='radio-deliveryModedhl-DE#deichmann_DE']")).isEmpty()) {

                    dhl.click();
                } else {

                    System.out.println("dhl Button ist nicht da");
                }
                break;

            case "DHU":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "DOS":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "VBE":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;

            case "VHS":
                if (!driver.findElements(By.xpath(postNLxpath)).isEmpty()) {
                    this.postNL.click();
                    Thread.sleep(2000);
                    clickVersandArtVerwenden();
                } else {
                    System.out.println("post NL ist nicht da");
                }
/*                this.wait.until(ExpectedConditions.visibilityOf(this.postNL));
                Thread.sleep(2000);
                this.postNL.click();
                clickVersandArtVerwenden();*/
                break;

            default:
                System.out.println("Please verify the chosen shop variable!!");

        }


    }


    public void clickVersandArtVerwenden() {
        this.wait.until(ExpectedConditions.visibilityOf(this.versandArtVerwenden));
        System.out.println("Versandart geklickt");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)");
        this.versandArtVerwenden.click();

    }

    public void clickVersandArtVerwendenDUK() {
        this.wait.until(ExpectedConditions.visibilityOf(this.versandArtVerwendenDUK));
        System.out.println("Versandart geklickt");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)");
        this.versandArtVerwendenDUK.click();

    }

    public void clickVersandArtVerwendenDSD() {
        this.wait.until(ExpectedConditions.visibilityOf(this.versandArtVerwendenDSD));
        System.out.println("Versandart geklickt");
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,450)");
        this.versandArtVerwendenDSD.click();

    }

    public void clickVersandArtVerwendenAnegmeldet(String shop) {

        switch (shop) {

            case "DHU":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "VBE":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;
            case "VHS":
                System.out.println("Keine Liefermethodeauswahl bei diesem Shop");
                break;

            default:
                if (!driver.findElements(By.xpath("//*[@type='submit']")).isEmpty()) {

                    this.versandArtVerwenden.click();
                } else {
                    System.out.println("Versandart Button ist nicht da ist nicht da");
                }

        }


    }


}
