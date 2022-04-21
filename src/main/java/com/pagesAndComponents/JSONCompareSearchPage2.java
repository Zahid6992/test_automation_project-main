package com.pagesAndComponents;

import com.utils.DriverTestCase;
import io.restassured.RestAssured;
import io.restassured.http.Cookies;
import io.restassured.response.Response;
import io.restassured.specification.QueryableRequestSpecification;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.SpecificationQuerier;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;


public class JSONCompareSearchPage2 extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;
    public String inside;
    public Response response;
    RequestSpecification requestSpecification = RestAssured.given();

    public JSONCompareSearchPage2(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public List checkAPIResponse2(String base_store_id, String referer, String search_expression) throws IOException, ParseException {

        Integer responseCode;
        FileOutputStream fis;
        byte[] mybytes;
        JSONParser parser = new JSONParser();
        Object obj2;
        JSONObject gesamtJsonObject2;
        JSONArray productsJsonObject2;
        JSONObject paginationJsonObject2 = null;


        Iterator productObjIterator2;
        JSONObject list = null;


        driver.get(referer);
        Set<Cookie> seleniumCookies = driver.manage().getCookies();


        ArrayList restAssuredCookies = new ArrayList();


        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            if(cookie.getName()!="rat_v"&& cookie.getName()!="path"){
                restAssuredCookies.add(new Cookie.Builder(cookie.getName(), cookie.getValue()).build());
            }
        }

        String calledURL = "https://www.deichmann.com/de-de/rest/v2/deichmann-de/products/search";

        for (int j = 0; j < 48; j++) {


            requestSpecification = RestAssured
                .given().cookies(new Cookies(restAssuredCookies))
                .queryParam("query", search_expression + ":relevance:distributionChannel:ONLINESHOP:inStockFlag:true")
                .queryParam("currentPage", j)
                .queryParam("pageSize", 48)
                .queryParam("fields", "FULL")
                .queryParam("lang", "de_DE_DEICHMANN")
                .header("Vary", "accept-encoding, accept-language, ng-route, basestore-id, cart_id, cart_guid, X-SC")
                .header("Accept", "application/json, text/plain, */*")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("basestore-id", base_store_id)
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Dest", "empty")
                .header("Referer", referer)
                .header("Accept-Language", "de-DE,de;q=0.9")
                .when();

            QueryableRequestSpecification queryable = SpecificationQuerier.query(requestSpecification);

            requestHeaders = queryable.getHeaders().toString();
            queryParameters = queryable.getQueryParams().toString();
            methode = "GET";
            requestURL = calledURL;

            response = requestSpecification.get(calledURL);


        responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode.toString(), "200");

        String currentWorkingDir = System.getProperty("user.dir");

        fis = new FileOutputStream(currentWorkingDir + "/src/main/resources/Search_Slipper/Response2.json");
        mybytes = response.getBody().asString().getBytes();
        fis.write(mybytes);


        obj2 = parser.parse(response.getBody().asString());
        gesamtJsonObject2 = (JSONObject) obj2;


        productsJsonObject2 = (JSONArray) gesamtJsonObject2.get("products");
        paginationJsonObject2 = (JSONObject) gesamtJsonObject2.get("pagination");

        productObjIterator2 = productsJsonObject2.iterator();
//        Iterator articleNumberObject1Iterator1 = articleNumberJsonObject1.iterator();
        int i =0;
        while (productObjIterator2.hasNext()) {
            i++;
            list = (JSONObject) productObjIterator2.next();
            productCodeList2.add(list.get("articleNumber").toString());

        }
        }
        System.out.println("-------------------------------------------------");
        System.out.println("Check Response 2");
        System.out.println("-------------------------------------------------");
//        System.out.println("total Results Response2:  " + paginationJsonObject2.get("totalResults"));
        System.out.println("Number of products in Response 2: " + productCodeList2.size());
        System.out.println("product List2: " + productCodeList2);
        System.out.println("-------------------------------------------------");

        totalResults2 = productCodeList2.size();

        return  productCodeList2;

    }



}
