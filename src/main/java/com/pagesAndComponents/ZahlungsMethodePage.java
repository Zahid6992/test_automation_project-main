package com.pagesAndComponents;

import com.utils.DriverTestCase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ZahlungsMethodePage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "(//button[@type='submit'])[1]")
    private WebElement bestellenButton;

    @FindBy(xpath = "(//h2[contains(text(),'Vielen Dank für deine Bestellung!')])")
    private WebElement bestellungErfolgreich;

    public ZahlungsMethodePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public void bestellen(String mobileDesktop, String shop) throws InterruptedException {

        Thread.sleep(2000);
        bestellenButton.click();
        Thread.sleep(5000);
        bestellungErfolgreich.click();
        if (bestellungErfolgreich.isEnabled()) {
            System.out.println("Bestellung erfolgreich");
        } else {
            System.out.println("Fehler der Bestellung");
        }
        Thread.sleep(10000);

    }

    public void setPaymentMethode(String mobileDesktop, String shop) throws InterruptedException {

        String paymentMethodeXpath = null;
        switch (mobileDesktop)
        {
            case "Mobile":
                paymentMethodeXpath = "(//a[@routerlink='/checkout/payment/'])[3]";
                break;

            case "Desktop":
                paymentMethodeXpath = "(//div[@class='payment-details'])[3]";
                break;
        }

        if (!driver.findElements(By.xpath(paymentMethodeXpath)).isEmpty()) {
            driver.findElement(By.xpath(paymentMethodeXpath)).click();
        } else {
            System.out.println("Payment bereits ausgewählt");
        }


    }


    public boolean setZahlungsMethodeVerwenden(String mobileDesktop, String shop) throws InterruptedException {
        
        List<WebElement> paymentDetailsClass = driver.findElements(By.xpath("//div[@class='payment-details']"));
        int size = paymentDetailsClass.size();
        int idClass = 0;
        String xpathString = null;
        boolean condition = true;
        System.out.println("Size Payment Class " + size);
        switch (mobileDesktop)
        {
            case "Mobile":
                idClass = size + 3;
                System.out.println("ID Class Mobile " + size);
            break;
            case "Desktop":
                idClass = 3;
                System.out.println("ID Class Desktop " + size);
                break;
            
        }

        xpathString = "(//button[@data-value='Zahlungsmethode verwenden'])[" + idClass + "]";
        if (!driver.findElements(By.xpath(xpathString)).isEmpty()) {
            driver.findElement(By.xpath(xpathString)).click();
            condition = false;
            System.out.println(xpathString + " gefunden im Shop " + shop);
        }
        else
        {
            System.out.println(xpathString + " nicht gefunden im Shop " + shop);
        }

        return !condition;

    }



}
