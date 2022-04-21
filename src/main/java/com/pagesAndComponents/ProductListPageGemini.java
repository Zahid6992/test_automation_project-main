package com.pagesAndComponents;

import com.utils.DriverHelper;
import com.utils.PropertyReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductListPageGemini extends DriverHelper {

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


    public ProductListPageGemini(WebDriver driver) {
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

    public ProductListPageGemini addFirstArtikelToWunschList() {
        wunschListForFirstArtikel.click();
        System.out.println("First Shoes added to wishlist");
        return PageFactory.initElements(getWebDriver(), ProductListPageGemini.class);
    }


    public String URLDamenSchuhe(String shop, String environment) {
        propertyReader = new PropertyReader();
        String url = null;
        switch (shop) {
            case "DSD":
                switch (environment) {
                    case "Gemini":
                        url = "https://pilot:DhkX57@gemini.deichmann.com/DE/de/shop/damen/damen-schuhe/damen-schuhe-boots.cat";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            case "DHU":
                switch (environment) {
                    case "Gemini":
                        url = "https://pilot:DhkX57@gemini.deichmann.com/HU/hu/shop/taskak.cat";
                        break;
                    default:
                        System.out.println("Please verify the environment variable!!");
                }
                break;
            default:
                System.out.println("Please verify the chosen shop variable!!");
        }


        System.out.println(url);
        driver.get(url);

        return url;

    }


}
