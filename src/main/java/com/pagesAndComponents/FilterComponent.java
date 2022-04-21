package com.pagesAndComponents;

import com.utils.DriverHelper;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterComponent extends DriverHelper {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@type='submit']")
    private WebElement bestellen;

    @FindBy(xpath = "//input[@id='relevance']/parent::summary")
    private WebElement filterSortierenRelevanz;

    @FindBy(xpath = "(//label[contains(text(),' Preis (aufsteigend) ')])[2]")
    private WebElement filterSortierenPreisAufsteigend;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-17.0']/parent::li")
    private WebElement groesseEUSiebzhen;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-44.0']/parent::li")
    private WebElement groesseEU44;

    @FindBy(xpath = "//input[@id='max-price']")
    private WebElement filterGroesseMaxPreis;

    @FindBy(xpath = "//label[@for='Schwarz']")
    private WebElement filterFarbe1;

    @FindBy(xpath = "//label[@for='Grau']")
    private WebElement filterFarbe2;

    @FindBy(xpath = "//span[contains(text(),' Marke ')]")
    private WebElement filterBrand;

    @FindBy(xpath = "//p[contains(text(),' Nike ')]")
    private WebElement filterBrandNike;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[2]")
    private WebElement saveFilterBrand;

    @FindBy(xpath = "//span[contains(text(),' Geschlecht ')]")
    private WebElement filterGeschlescht;

    @FindBy(xpath = "//p[contains(text(),' männlich ')]")
    private WebElement filterGeschleschtMaennlich;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[3]")
    private WebElement filterGeschleschtBackarrow;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement filterErgebnisseAnzeigen;

    public FilterComponent(WebDriver driver) {
        super(driver);
    }


    public FilterComponent clickOnFilterSortierenBeiRelevanz() {
        filterSortierenRelevanz.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterSortierenBeiPreisAufsteigend() throws InterruptedException {
        filterSortierenPreisAufsteigend.click();
        System.out.println("Sort by Price Aufsteigend selected");
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }


    public FilterComponent chooseOnFilterGroesseSiebzhenEU() throws InterruptedException {
        groesseEUSiebzhen.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseOnFilterGroesse44EU() throws InterruptedException {
        groesseEU44.click();
        //Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }


    public FilterComponent clickOnFilterGroesseMaxPreisFuenfzig() {
        filterGroesseMaxPreis.clear();
        filterGroesseMaxPreis.sendKeys("50" + Keys.TAB);
        System.out.println("Filter by max price ");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterFarbeWeiss() throws InterruptedException {
        Thread.sleep(3000);
        filterFarbe1.click();
        System.out.println("Filter by color : Weiß");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterFarbeSchwarz() throws InterruptedException {
        Thread.sleep(3000);
        filterFarbe2.click();
        System.out.println("Filter by color : Schwarz");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterBrand() throws InterruptedException {
        filterBrand.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseFilterBrandNike() throws InterruptedException {
        filterBrandNike.click();
        Thread.sleep(3000);
        System.out.println("Filter by Brand Nike");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent saveFilterBrand() throws InterruptedException {
        saveFilterBrand.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGeschlescht() throws InterruptedException {
        filterGeschlescht.click();
        Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent chooseOnFilterGeschleschtMaennlich() throws InterruptedException {
        filterGeschleschtMaennlich.click();
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterGeschleschtBackarrow() throws InterruptedException {
        filterGeschleschtBackarrow.click();
        System.out.println("Filter by Geschlescht Männlich");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public FilterComponent clickOnFilterErgebnisseAnzeigen() throws InterruptedException {
        filterErgebnisseAnzeigen.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }


}
