package com.pagesAndComponents;

import com.utils.DriverTestCase;
import com.utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import org.apache.commons.collections4.Get;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ErrorPage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;
    public String inside;


    public Response response;
    public PropertyReader propertyReader;

    final public String errorMessageXpath = "(//h1[contains(text(),'Leider konnten wir')])";
    @FindBy(xpath = errorMessageXpath)
    private WebElement errorMessage;

    final public String errorMessageXpathDHU = "//h3[contains(text(),'A keresett oldal sajnos nem')]";
    @FindBy(xpath = errorMessageXpathDHU)
    private WebElement errorMessageDHU;

    final public String errorMessageXpathDUK = "(//h1[contains(text(),'Leider konnten wir')])";
    @FindBy(xpath = errorMessageXpathDUK)
    private WebElement errorMessageDUK;

    final public String errorMessageXpathVBE = "(//h1[contains(text(),'Leider konnten wir')])";
    @FindBy(xpath = errorMessageXpathVBE)
    private WebElement errorMessageVBE;

    final public String errorMessageXpathVHS = "(//h1[contains(text(),'Leider konnten wir')])";
    @FindBy(xpath = errorMessageXpathVHS)
    private WebElement errorMessageVHS;



    public ErrorPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }


    public  boolean checkNotFoundErrorPresent(String shop)
    {
        boolean notFoundErrorPresent;
        switch (shop)
        {
            case "DHU":
                notFoundErrorPresent = !driver.findElements(By.xpath(errorMessageXpathDHU)).isEmpty();
                System.out.println("errorMessage Status: " + driver.findElements(By.xpath(errorMessageXpathDHU)).isEmpty());
                if (notFoundErrorPresent) {
                    errorMessageDHU.click();
                }
                break;
            case "VHS":
                notFoundErrorPresent = !driver.findElements(By.xpath(errorMessageXpathVHS)).isEmpty();
                if (notFoundErrorPresent) {
                    errorMessageVHS.click();
                }
                break;
            case "VBE":
                notFoundErrorPresent = !driver.findElements(By.xpath(errorMessageXpathDHU)).isEmpty();
                if (notFoundErrorPresent) {
                    errorMessageDHU.click();
                }
            break;
            case "DUK":
                notFoundErrorPresent = !driver.findElements(By.xpath(errorMessageXpathDUK)).isEmpty();
                if (notFoundErrorPresent) {
                    errorMessageDUK.click();
                }
                break;
            default:
                notFoundErrorPresent = !driver.findElements(By.xpath(errorMessageXpath)).isEmpty();
                if (notFoundErrorPresent) {
                    errorMessage.click();
                }

        }

        return notFoundErrorPresent;
    }

    public String checkResponseCode(String calledURL)
    {

        response = RestAssured
                .given()
/*//                    .header("Connection", "keep-alive")
//                    .header("Vary", "accept-encoding, accept-language, ng-route, basestore-id, cart_id, cart_guid, X-SC")
                    .header("Accept-Language", "de-DE,de;q=0.9")*/
                    .header("Accept", "application/json, text/plain, */*")
                .when()
                    .get(calledURL);

        Integer responseCode = response.getStatusCode();
        return responseCode.toString();

    }


    public String checkBody()
    {
        String responseBody = response.getBody().asString();
        return "Actual Response Body is: " + responseBody;

    }




}
