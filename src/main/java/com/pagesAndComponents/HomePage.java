package com.pagesAndComponents;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utils.DriverHelper;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends DriverHelper {

    public HomePage(WebDriver driver) {
        super(driver);
    }



    @FindBy(xpath = "//input[contains(@id,'search') and @type='search']")
    private WebElement SearchTextField;

    @FindBy(xpath = "//h1[@class='message-pipe']")
    private WebElement SearchShirtMessage;

    @FindBy(xpath = "//div/p[@class='message-pipe' and @data-value='Ergebnisse']")
    private WebElement SearchShirtResult;

    @FindBy(xpath = "//label[@title='Schuhe']")
    private WebElement SubMenuShoesLink;
    //label[@for='submenu-women-shoesLink']/a

    @FindBy(xpath = "//label[@title='Schnürboots']/a")
    private WebElement TieBootLink;

    @FindBy(xpath = "//section/article[4]/a")
    private WebElement firstBoot;

    @FindBy(xpath = "//span[@class='link-name' and text()='Damen']")
    private WebElement DamenMainMenu;

    @FindBy(xpath = "//span[@data-value='Wähle deine Größe']")
    private WebElement ChooseSize;

    @FindBy(xpath = "//div[@class='m-size-selection']/ul[2]/li[1]")
    private WebElement SelectFirstSize;

    @FindBy(xpath = "//span[contains(text(),'44')]")
    private WebElement SelectSize44;

    @FindBy(xpath = "//span[contains(text(),'36')]")
    private WebElement SelectSizeSechsUndDreissig;

    @FindBy(xpath = "//li[contains(text(),'EU')]")
    private WebElement SelectSizeEUPDP;

    @FindBy(xpath = "//label[contains(text(),'EU')]")
    private WebElement SelectSizeEUFilterPLP;


    @FindBy(xpath = "(//label[contains(text(),'EU')])[3]")
    private WebElement SelectSizeEUFilterPLPDSD;

    @FindBy(xpath = "//div[@class='m-size-selection']/ul[2]/li[6]")
    private WebElement SelectLasttSize;

    //@FindBy(xpath = "(//span[@data-value='In den Warenkorb'])[position()=1]")
    @FindBy(xpath = "(//form[contains(@class,'m-add-to-cart')])[1]")
    private WebElement AddToCartButton;

    @FindBy(xpath = "(//span[@data-value='In den Warenkorb'])[1]")
    private WebElement AddToCartButtonDSD;

    @FindBy(xpath = "(//span[@data-value='In den Warenkorb'])[1]")
    private WebElement AddToCartButtonDSDLoggedIn;


    @FindBy(xpath = "(//button/span[contains(text(),' Jetzt sicher zur Kasse ')])[2]")
    //@FindBy(xpath = "//a[@data-value='Jetzt sicher zur Kasse']")
    private WebElement SafelyCheckoutButton;

    @FindBy(xpath = "//input[@id='search0']")
    private WebElement textSearch;

    @FindBy(xpath = "//span[text()='Schwarze lauf']/strong[text()='lernschuhe']")
    private WebElement searchOption;

    @FindBy(xpath = "//span[text()='Stiefel']")
    private WebElement searchOption1;

    @FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement btnFilter;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement btnsize;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-39.0']/parent::li")
    private WebElement chkSize1;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[1]")
    private WebElement backarrowsize;

    @FindBy(xpath = "//label[@data-key='core.component.searchPageTemplate.show-results']")
    private WebElement bntshowResult;

    //@FindBy(xpath = "//html/body/div[3]/div/footer/button[3]")
    private final String cookiesOkButtonXPATH = "//button[@data-key='consent.modal.agree']";
    @FindBy(xpath = cookiesOkButtonXPATH)
    private WebElement CookiesOkButton;

    @FindBy(xpath = "//span[contains(text(),' Größe ')]")
    private WebElement filterGroesseDE;

    @FindBy(xpath = "//span[contains(text(),' Size ')]")
    private WebElement filterGroesseDUK;

    @FindBy(xpath = "//span[contains(text(),' Maat ')]")
    //@FindBy(xpath = "//span[@data-value='Filtern']")
    private WebElement filterGroesseVHS;

    @FindBy(xpath = "//label[contains(text(),'EU')]")
    private WebElement filterGroesseVHSMaatEU;

    @FindBy(xpath = "//span[contains(text(),' Maat ')]")
    private WebElement filterGroesseVBE;

    @FindBy(xpath = "//span[contains(text(),' Grösse ')]")
    private WebElement filterGroesseDOS;

    @FindBy(xpath = "(//span[contains(text(),' Méret ')])[1]")
    private WebElement filterGroesseDHU;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-36.0']/parent::li")
    private WebElement groesseEU36;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-40.0']/parent::li")
    private WebElement groesseEU40;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-44.0']/parent::li")
    private WebElement groesseEU44;

    @FindBy(xpath = "(//span[@data-key='core.component.facets.save'])[1]")
    private WebElement filterGroesseBackArrow;

//    @FindBy(xpath = "//span[@i18ntext='Ergebnisse anzeigen']")
//    @FindBy(xpath = "//section[@class='filter-and-sort']/form[@class='m-facet-form ng-untouched ng-pristine ng-valid']/label[@class='button use-filter-button']/button[@class='clickthrough']/span[@data-value='Ergebnisse anzeigen']")

//    @FindBy(xpath = "(//label[@class='button use-filter-button'])[12]")
    @FindBy(xpath = "//section[@class='filter-and-sort']/form[@class='m-facet-form ng-untouched ng-pristine ng-valid']/label[@class='button use-filter-button']")
    private WebElement allefilterErgebnisseAnzeigen;

    @FindBy(xpath = "//input[@id='list-facet-sizeEU-17.0']/parent::li")
    private WebElement groesseEUSiebzhen;

    @FindBy(xpath = "//div[@class='dy-full-width-notifications-close']")
    private WebElement closeNotifRabatt;

    @FindBy(xpath = "//div[@class='dy-lb-close']")
    private WebElement closeNotifCC;

    @FindBy(xpath = "(//a[@class='trigger']//*[local-name() = 'svg'])[position()=2]")
    private WebElement closeWarenkorbDesktop;

    @FindBy(xpath = "(//a[@class='trigger']//*[local-name() = 'svg'])[position()=1]")
    private WebElement closeWarenkorbMobile;

    @FindBy(xpath = "//span[contains(text(),'Dames')]")
    private WebElement damesZielgruppeDesktop;

    @FindBy(xpath = "//label[@for='submenu-WomenBaseStoreLink']")
    private WebElement damesZielgruppeMobil;

    @FindBy(xpath = "//span[contains(text(),'Heren')]")
    private WebElement herenZielgruppe;

    @FindBy(xpath = "//a[@class='next-area-link active active-entry active-link-group']//span[contains(text(),'Dames')]")
    private WebElement damesZielgruppeAusgewaehltDesktop;

    @FindBy(xpath = "//label[@class='active-navigation-element' and @title='Dames']")
    private WebElement damesZielgruppeAusgewaehltMobil;

    @FindBy(xpath = "//m-language-selection[@class='desktop']")
    private WebElement languageSelectionDesktop;

    @FindBy(xpath = "//m-language-selection[@class='mobile']//div//a")
    private WebElement languageSelectionMobil;

    @FindBy(xpath = "//label[@for='radio-contextfr-be']")
    private WebElement francais;

    @FindBy(xpath = "//label[@for='radio-contextnl-be']")
    private WebElement nederlands;

    @FindBy(xpath = "//button[@data-key='languageSelection.modal.buttonSave']")
    private WebElement spracheBestaetigen;

    @FindBy(xpath = "//m-slot[@data-position='NavigationBar']")
    private WebElement menuMobil;

    public HomePage damenSeitePruefen(String shop, String sprache) {
        switch (shop)
        {
            case "VBE":

            default:
                System.out.println("Please verify the shop variable!");
        }


        Assert.assertEquals(driver.getCurrentUrl(), "https://www2.vanharen.be/nl-be/dames");

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage herenZielgruppeAuswaehlen() {
        herenZielgruppe.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage sprachauswahlBastaetigen() {
        spracheBestaetigen.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage francaisAuswaehlen() {
        francais.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage nederlandsAuswaehlen() {
        nederlands.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage spracheAuswaehlen(String mobilOrDesktop) throws InterruptedException {
        switch (mobilOrDesktop)
        {
            case "Desktop":
                languageSelectionDesktop.click();
                break;
            default:
                menuMobil.click();
                Thread.sleep(2000);
                languageSelectionMobil.click();

        }



        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage damesZielgruppeAuswaehlen(String mobilOrDesktop) throws InterruptedException {
        switch (mobilOrDesktop)
        {
            case "Desktop":
                damesZielgruppeDesktop.click();
                System.out.println("Desktop");
                break;
            default:
                menuMobil.click();
                Thread.sleep(2000);
                damesZielgruppeMobil.click();

        }
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage damesZielgruppeGeklickt(String desktopOrMobil) throws InterruptedException {
        switch (desktopOrMobil)
        {
            case "Desktop":
                damesZielgruppeAusgewaehltDesktop.click();
                break;
            default:
//                menuMobil.click();
//                Thread.sleep(2000);
                damesZielgruppeAusgewaehltMobil.click();

        }

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage mouseHoverOnShoesSubMenu() {

        Actions actions = new Actions(driver);
        actions.moveToElement(SubMenuShoesLink).build().perform();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage mouseHoverOnFirstShoe() {

        Actions actions = new Actions(driver);
        actions.moveToElement(firstBoot).build().perform();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnTieBootLink() throws InterruptedException {
        TieBootLink.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(DamenMainMenu).build().perform();
        //Thread.sleep(2000);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnFirstShoeImage() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(firstBoot));
        firstBoot.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnChooseSize() throws InterruptedException {
        ChooseSize.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage selectFirstShoeSize() throws InterruptedException {
        SelectFirstSize.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage selectLastShoeSize() throws InterruptedException {
        SelectLasttSize.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage selectShoeSize44() throws InterruptedException {
        SelectSize44.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage selectShoeSize36() throws InterruptedException {
        SelectSizeSechsUndDreissig.click();
        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage selectShoeSizeEUPDP(String shop) throws InterruptedException {

        SelectSizeEUPDP.click();
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage selectShoeSizeFilterPLPEU(String shop) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                SelectSizeEUFilterPLPDSD.click();
                break;
            default:
                SelectSizeEUFilterPLP.click();
        }


        //Thread.sleep(2000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnAddToCart(String shop, Boolean loggedIn) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                if (loggedIn)
                {
                    AddToCartButtonDSDLoggedIn.click();
                }
                else
                {
                    AddToCartButtonDSD.click();
                }
                break;
            default:
                AddToCartButton.click();

        }



        //Thread.sleep(1000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage clickOnSafelyCheckoutButton(String mobileOrDesktop) throws InterruptedException {

        if (mobileOrDesktop.equalsIgnoreCase("Mobile")) {
            Thread.sleep(5000);
            driver.findElement(By.xpath("(//a[@data-value='Jetzt sicher zur Kasse'])[position()=2]")).click();
            System.out.println("Checkout Button geklickt");
        }
        else
        {
  //          SafelyCheckoutButton.click();
            Thread.sleep(5000);
            //driver.findElement(By.xpath("(//button/span[contains(text(),' Jetzt sicher zur Kasse ')])[2]")).click();
//            driver.findElement(By.xpath("(//button[@data-value='Jetzt sicher zur Kasse'])[position()=2]")).click();
            driver.findElement(By.xpath("(//a[@data-value='Jetzt sicher zur Kasse'])[position()=3]")).click();
        }


        //Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }




    public HomePage enterSearchKeyword(String searchKey) throws InterruptedException {
        SearchTextField.clear();
        SearchTextField.sendKeys(searchKey);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnSearchIcon() throws InterruptedException {
        //SearchIcon.click();
        Thread.sleep(2000);
        SearchTextField.sendKeys(Keys.ENTER);
        Thread.sleep(2000);
        WaitUntilWebElementIsVisible(SearchShirtMessage);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage enterSearchCriteriaAndChooseResult(String Criteria) {

        this.wait.until(ExpectedConditions.visibilityOf(textSearch));
        textSearch.click();
        textSearch.sendKeys(Criteria);
        textSearch.click();
        System.out.println("Search text entered");
        this.wait.until(ExpectedConditions.visibilityOf(searchOption));
        searchOption.click();
        if(driver.findElement(By.xpath("//h1[text()=' Suche: \"Schwarze lauflernschuhe\" ']")).isDisplayed())
        {
            System.out.println("stadtSuchen applied");
        }
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public String getSearchShirtMessage() {
        return SearchShirtMessage.getText();
    }

    public String getSearchShirtResult() {
        return SearchShirtResult.getText();
    }

    public void clickOnCookiesOkayButton()
    {

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

    public FilterComponent clickOnFilter() throws InterruptedException {
        //Thread.sleep(3000);
        btnFilter.click();
        System.out.println("Filter Button geklickt");
        return PageFactory.initElements(getWebDriver(), FilterComponent.class);
    }

    public HomePage clickOnFilterGroesse(String shop) throws InterruptedException {

        switch (shop)
        {
            case "DSD":
                filterGroesseDE.click();
                System.out.println("Filter Größe DE ausgewählet");
                break;
            case "VHS":
                Thread.sleep(2000);
                filterGroesseVHS.click();
                System.out.println("Filter Größe VHS ausgewählet");
                Thread.sleep(2000);
                filterGroesseVHSMaatEU.click();
                break;
            case "VBE":
                filterGroesseVBE.click();
                System.out.println("Filter Größe VBE ausgewählet");
                break;
            case "DOS":
                filterGroesseDOS.click();
                System.out.println("Filter Größe DOS ausgewählet");
                break;
            case "DHU":
                filterGroesseDHU.click();
                System.out.println("Filter Größe DHU ausgewählet");
                break;
            case "DUK":
                filterGroesseDUK.click();
                System.out.println("Filter Größe DUK ausgewählet");
                break;
            default:
                System.out.println("verify shop variable!!");
        }



        //Thread.sleep(3000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage chooseOnFilterGroesse40EU() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(groesseEUSiebzhen));
        groesseEU40.click();
        //Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage chooseOnFilterGroesse44EU() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(groesseEUSiebzhen));
        groesseEU44.click();
        //Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage chooseOnFilterGroesse36EU() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(groesseEUSiebzhen));
        groesseEU36.click();
        //Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage chooseOnFilterGroesseSiebzhenEU() throws InterruptedException {
        //this.wait.until(ExpectedConditions.visibilityOf(groesseEUSiebzhen));
        groesseEUSiebzhen.click();
        Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnFilterGroesseBackArrow()
    {
        //this.wait.until(ExpectedConditions.visibilityOf(filterGroesseBackArrow));

        filterGroesseBackArrow.click();
        System.out.println("Filtered by Size ");
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage clickOnAlleFilterErgebnisseAnzeigen() throws InterruptedException {
        // this.wait.until(ExpectedConditions.visibilityOf(filterErgebnisseAnzeigen));
        wait.until(ExpectedConditions.elementToBeClickable(allefilterErgebnisseAnzeigen));
        Thread.sleep(5000);
/*        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("arguments[0].click()", allefilterErgebnisseAnzeigen);*/
        allefilterErgebnisseAnzeigen.click();
        System.out.println("Alle Ergebnisse geklickt");
//        allefilterErgebnisseAnzeigen.click();
        //Thread.sleep(5000);
        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public void closeNotificationRabatt() throws InterruptedException {
        if (!driver.findElements(By.xpath("//div[@class='dy-full-width-notifications-close']")).isEmpty())
        {
            //((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", closeNotifRabatt);
            Thread.sleep(2000);
            closeNotifRabatt.click();
            //driver.navigate().back();
        }
        else {

            System.out.println("Notification rabatt ist nicht da");
        }

    }

    public void closeNotificationClickAndCollect() throws InterruptedException {
        if (!driver.findElements(By.xpath("//div[@class='dy-lb-close']")).isEmpty())
        {
            //((JavascriptExecutor)driver).executeScript("arguments[0].style.visibility='hidden'", closeNotifRabatt);
            Thread.sleep(2000);
            closeNotifCC.click();
            //driver.navigate().back();
        }
        else {

            System.out.println("Notification rabatt ist nicht da");
        }

    }


    public HomePage produktAuswahlenPLP(String shop) throws InterruptedException {
        Thread.sleep(30000);
        closeNotificationRabatt();
        clickOnCookiesOkayButton();
        clickOnFilter();
        Thread.sleep(2000);
        clickOnCookiesOkayButton();
        clickOnFilterGroesse(shop);
        Thread.sleep(500) ;
        selectShoeSizeFilterPLPEU(shop);
        Thread.sleep(500) ;
        closeNotificationRabatt();
//        chooseOnFilterGroesse44EU();
        closeNotificationClickAndCollect();
        chooseOnFilterGroesse36EU();
        clickOnFilterGroesseBackArrow();
        clickOnAlleFilterErgebnisseAnzeigen();
        Thread.sleep(15000);
        clickOnFirstShoeImage();
        closeNotificationRabatt();

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


    public HomePage produktAuswahlenPDP(String shop, String mobileOrDesktop, Boolean loggedIn) throws InterruptedException {

        clickOnChooseSize();
//        clickOnCookiesOkayButton();
        Thread.sleep(500);
        selectShoeSizeEUPDP(shop);
        Thread.sleep(500);
//        selectShoeSize44();
        selectShoeSize36();
        //clickOnCookiesOkayButton();
        Thread.sleep(2000);
        //searchSizeEnabled();
        closeNotificationRabatt();
        clickOnAddToCart(shop, loggedIn);
        Thread.sleep(3000);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }

    public HomePage closeWarenkorbAnsicht(String mobileOrDesktop) throws InterruptedException {

        Thread.sleep(2000);
        if (mobileOrDesktop.equalsIgnoreCase("Desktop"))
        {
            closeWarenkorbDesktop.click();
        }
        else
        {
            closeWarenkorbMobile.click();
        }

        Thread.sleep(3000);

        return PageFactory.initElements(getWebDriver(), HomePage.class);
    }


}
