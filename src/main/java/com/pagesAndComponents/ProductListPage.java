package com.pagesAndComponents;

import com.utils.DriverHelper;
import com.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPage extends DriverHelper {

    public PropertyReader propertyReader;


    @FindBy(xpath = "(//span[contains(text(),'Farben: Schwarz')])")
    private WebElement filterFarbeSetSchwarz;

    @FindBy(xpath = "(//span[contains(text(),'Farben: Grau')])")
    private WebElement filterFarbeSetGrau;

    @FindBy(xpath = "(//span[contains(text(),'Marke: Nike')])")
    private WebElement filterMarkeSetNike;

    @FindBy(xpath = "(//span[contains(text(),'Geschlecht: männlich')])")
    private WebElement filterGeschleschtSetMaennlich;

    @FindBy(xpath = "(//article//section[@class='prices m-price-list']/strong)[1]")
    private WebElement firstArticlePreis;

    @FindBy(xpath = "(//article//section[@class='prices m-price-list']/strong)[2]")
    private WebElement secondArticlePrice;

    @FindBy(xpath = "(//input[@name='addToWhishlist']/following-sibling::button)[1]")
    private WebElement wunschListForFirstArtikel;


    public ProductListPage(WebDriver driver) {
        super(driver);
    }


    public boolean isAllFilterdDisplayed() {

        if (filterFarbeSetSchwarz.isDisplayed() && filterFarbeSetGrau.isDisplayed() && filterMarkeSetNike.isDisplayed() && filterGeschleschtSetMaennlich.isDisplayed()) {
            return true;
        } else {
            return false;
        }

    }


    public boolean isFirstpriceIsLessorThenSecond() {

        String fp = firstArticlePreis.getText();
        String sp = secondArticlePrice.getText();
        String[] fp1 = fp.split(" ");
        String[] sp1 = sp.split(" ");

        String fp2 = fp1[0].replace(",", "");
        String sp2 = sp1[0].replace(",", "");

        if (Integer.valueOf(fp2) < Integer.valueOf(sp2)) {
            return true;

        } else {
            return false;
        }
    }

    public ProductListPage addFirstArtikelToWunschList() {
        wunschListForFirstArtikel.click();
        System.out.println("First Shoes added to wishlist");
        return PageFactory.initElements(getWebDriver(), ProductListPage.class);
    }


    public String URLDamenSchuhe(String shop, String environment) throws InterruptedException {
        propertyReader = new PropertyReader();

        seturlDamenSchuheMap(urlDamenSchuheMap);
        String urlDamenSchuhe = urlDamenSchuheMap.get(shop + " " + environment);
        System.out.println(urlDamenSchuhe);
        driver.get(urlDamenSchuhe);
        Thread.sleep(60000);
        return urlDamenSchuhe;

    }

    public String URLNewsletter(String shop, String environment) {
        propertyReader = new PropertyReader();
        String url = null;

        seturlNewsletterMap(urlNewsletterMap);
        url =urlNewsletterMap.get(shop + " " + environment);

        System.out.println(url);
        driver.get(url);

        return url;

    }


}
