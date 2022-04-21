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




public class JSONCompareSearchPage1 extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;
    public String inside;
    public Response response;
    RequestSpecification requestSpecification = RestAssured.given();


    public JSONCompareSearchPage1(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public List checkAPIResponse1(String base_store_id, String referer, String search_expression) throws IOException, ParseException {

        Integer responseCode;
        FileOutputStream fis;
        byte[] mybytes;
        JSONParser parser = new JSONParser();
        Object obj1;
        JSONObject gesamtJsonObject1;

        JSONArray productsJsonObject1;
        JSONObject paginationJsonObject1 = null;

        Iterator productObjIterator1;
        JSONObject list = null;

        String facetValueCode = null;


        String calledURL = "https://www.deichmann.com/de-de/rest/v2/deichmann-de/products/search";

        switch (search_expression)
        {
            case "Slipper":
                switch (base_store_id) {
                    case "deichmann-de-men":
                        facetValueCode = "msl1d";
                        break;
                    case "deichmann-de-women":
                        facetValueCode = "wsl1f";
                        break;
                    default:
                        facetValueCode = "dsl1f";
                        break;
                }
                break;
            case "Loafer":
                facetValueCode = "dsl1d";
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + search_expression);
        }



        driver.get(referer);
        Set<Cookie> seleniumCookies = driver.manage().getCookies();


        ArrayList restAssuredCookies = new ArrayList();

        for (org.openqa.selenium.Cookie cookie : seleniumCookies) {
            if(cookie.getName()!="rat_v"&& cookie.getName()!="path"){
                restAssuredCookies.add(new Cookie.Builder(cookie.getName(), cookie.getValue()).build());
            }
        }

        for (int j = 0; j < 48; j++) {


            requestSpecification = RestAssured

                    .given().cookies(new Cookies(restAssuredCookies))

                    .queryParam("query", ":relevance:allCategoriesSEO:" + facetValueCode + ":distributionChannel:ONLINESHOP:inStockFlag:true&currentPage=" + j + "&pageSize=48&fields=FULL&lang=de_DE_DEICHMANN")
                    .queryParam("currentPage", j)
                    .queryParam("pageSize", 48)
                    .queryParam("fields", "FULL")
                    .queryParam("lang", "de_DE_DEICHMANN")

                    .header("Accept-Encoding", "gzip, deflate, br")
                    .header("Connection", "keep-alive")
                    .header("X-SC", "rlk")
                    .header("sec-ch-ua-mobile", "?0")
                    .header("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/98.0.4758.109 Safari/537.36")
                    .header("Vary", "accept-encoding, accept-language, ng-route, basestore-id, cart_id, cart_guid, X-SC")
                    .header("Accept", "application/json, text/plain, */*")
                    .header("sec-ch-ua", " Not A;Brand\";v=\"99\", \"Chromium\";v=\"98\", \"Google Chrome\";v=\"98")
                    .header("sec-ch-ua-platform", "\"macOS\"")
                    .header("basestore-id", base_store_id)
                    .header("Sec-Fetch-Site", "same-origin")
                    .header("Sec-Fetch-Mode", "cors")
                    .header("Sec-Fetch-Dest", "empty")
                    .header("Referer", referer)
                    .header("Accept-Language", "de-DE,de;q=0.9");

            QueryableRequestSpecification queryable = SpecificationQuerier.query(requestSpecification);

           requestHeaders = queryable.getHeaders().toString();
           queryParameters = queryable.getQueryParams().toString();
           methode = "GET";
           requestURL = calledURL;

           response = requestSpecification.get(calledURL);

        responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode.toString(), "200");


        String currentWorkingDir = System.getProperty("user.dir");
        fis = new FileOutputStream(currentWorkingDir + "/src/main/resources/Search_Slipper/Response1.json");
        mybytes = response.getBody().asString().getBytes();
        fis.write(mybytes);


        obj1 = parser.parse(response.getBody().asString());
        gesamtJsonObject1 = (JSONObject) obj1;


        productsJsonObject1 = (JSONArray) gesamtJsonObject1.get("products");
        paginationJsonObject1 = (JSONObject) gesamtJsonObject1.get("pagination");

        productObjIterator1 = productsJsonObject1.iterator();
//        Iterator articleNumberObject1Iterator1 = articleNumberJsonObject1.iterator();
        int i =0;
        while (productObjIterator1.hasNext()) {
            i++;
            list = (JSONObject) productObjIterator1.next();
            productCodeList1.add(list.get("articleNumber").toString());

        }
    }
        System.out.println("-------------------------------------------------");
        System.out.println("Check Response 1");
        System.out.println("-------------------------------------------------");
//        System.out.println("total Results Response1: " + paginationJsonObject1.get("totalResults"));
        System.out.println("Number of products in Response 1: " + productCodeList1.size());
        System.out.println("product List1: " + productCodeList1);
        System.out.println("-------------------------------------------------");

        totalResults1 = productCodeList1.size();


        return productCodeList1;

    }






}
