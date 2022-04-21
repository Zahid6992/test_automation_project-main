package com.pagesAndComponents;

import com.utils.DriverTestCase;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.Assert;

import java.io.*;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class JsonComparePage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;
    public String inside;
    public Response response;

    public JsonComparePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }

    public List checkAPIResponse1() throws IOException, ParseException {

        Integer responseCode;
        FileOutputStream fis;
        byte[] mybytes;
        JSONParser parser = new JSONParser();
        Object obj1;
        JSONObject gesamtJsonObject1;
        List<String> productCodeList1 = null;
        productCodeList1= new ArrayList<>();
        JSONArray productsJsonObject1;
        JSONObject paginationJsonObject1 = null;

        Iterator productObjIterator1;
        JSONObject list = null;

        for (int j = 0; j < 49; j++) {

            String calledURL = "https://www.deichmann.com/de-de/rest/v2/deichmann-de/products/search";
        response = RestAssured
                .given()
                .queryParam("query", ":relevance:allCategoriesSEO:dsl1f:distributionChannel:ONLINESHOP:inStockFlag:true")
                .queryParam("currentPage", "0")
                .queryParam("pageSize", 48)
                .queryParam("fields", "FULL")
                .queryParam("lang", "de_DE_DEICHMANN")
                .header("Vary", "accept-encoding, accept-language, ng-route, basestore-id, cart_id, cart_guid, X-SC")
                .header("Accept", "application/json, text/plain, */*")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("basestore-id", "deichmann-de")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Dest", "empty")
                .header("Referer", "https://www.deichmann.com/de-de/")
                .header("Accept-Language", "de-DE,de;q=0.9")
                .when()
                .get(calledURL);

        responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode.toString(), "200");
/*        System.out.println("Actual Response Code is: " + responseCode.toString());
        System.out.println("Actual Response Body is: " + response.getBody());*/


        fis = new FileOutputStream("/Users/oussamabenmahmoud/Documents/test_automation/src/main/resources/Search_Slipper/Response2.json");
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
//                System.out.println("code is: " + list.get("code"));
            productCodeList1.add(list.get("articleNumber").toString());

//                System.out.println(String.format("obj %d: %s", i, productObjIterator1.next()));
        }
    }
        System.out.println("-------------------------------------------------");
        System.out.println("Check Response 1");
        System.out.println("-------------------------------------------------");
        System.out.println("total Results Response1: " + paginationJsonObject1.get("totalResults"));
        System.out.println("Number of products in Response 1: " + productCodeList1.size());
        System.out.println("product List1: " + productCodeList1);
        System.out.println("-------------------------------------------------");


        return productCodeList1;

    }


    public List checkAPIResponse2() throws IOException, ParseException {

        Integer responseCode;
        FileOutputStream fis;
        byte[] mybytes;
        JSONParser parser = new JSONParser();
        Object obj2;
        JSONObject gesamtJsonObject2;
        List<String> productCodeList2 = null;
        List<String> productCodeList22 = null;
        productCodeList2= new ArrayList<>();
        JSONArray productsJsonObject2;
        JSONObject paginationJsonObject2 = null;

        Iterator productObjIterator2;
        JSONObject list = null;

        for (int j = 0; j < 49; j++) {

                String calledURL = "https://www.deichmann.com/de-de/rest/v2/deichmann-de/products/search";
        response = RestAssured
                .given()
                .queryParam("query", "Slipper:relevance:distributionChannel:ONLINESHOP:inStockFlag:true")
                .queryParam("currentPage", j)
                .queryParam("pageSize", 48)
                .queryParam("fields", "FULL")
                .queryParam("lang", "de_DE_DEICHMANN")
                .header("Vary", "accept-encoding, accept-language, ng-route, basestore-id, cart_id, cart_guid, X-SC")
                .header("Accept", "application/json, text/plain, */*")
                .header("sec-ch-ua-platform", "\"Android\"")
                .header("basestore-id", "deichmann-de-women")
                .header("Sec-Fetch-Site", "same-origin")
                .header("Sec-Fetch-Mode", "cors")
                .header("Sec-Fetch-Dest", "empty")
                .header("Referer", "https://www.deichmann.com/de-de/damen/schuhe/c-ws")
                .header("Accept-Language", "de-DE,de;q=0.9")
                .when()
                .get(calledURL);

        responseCode = response.getStatusCode();
        Assert.assertEquals(responseCode.toString(), "200");
/*        System.out.println("Actual Response Code is: " + responseCode.toString());
        System.out.println("Actual Response Body is: " + response.getBody());*/


        fis = new FileOutputStream("/Users/oussamabenmahmoud/Documents/test_automation/src/main/resources/Search_Slipper/Response2.json");
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
//                System.out.println("code is: " + list.get("code"));
            productCodeList2.add(list.get("articleNumber").toString());

//                System.out.println(String.format("obj %d: %s", i, productObjIterator1.next()));
        }


        }
        System.out.println("-------------------------------------------------");
        System.out.println("Check Response 2");
        System.out.println("-------------------------------------------------");
        System.out.println("total Results Response2:  " + paginationJsonObject2.get("totalResults"));
        System.out.println("Number of products in Response 2: " + productCodeList2.size());
        System.out.println("product List2: " + productCodeList2);
        System.out.println("-------------------------------------------------");


        return  productCodeList2;

    }


    public void compareJson(List productCodeList1, List productCodeList2) throws IOException, ParseException {

        System.out.println("-------------------------------------------------");
        System.out.println("Number of products in Response 1: " + productCodeList1.size());
        System.out.println("Number of products in Response 2: " + productCodeList2.size());
        System.out.println("-------------------------------------------------");
        System.out.println("product List1: " + productCodeList1);
        System.out.println("product List2: " + productCodeList2);
        System.out.println("-------------------------------------------------");
        productCodeList1.retainAll(productCodeList2);
        System.out.println("Retained List: " + productCodeList1);
        System.out.println("-------------------------------------------------");
        System.out.println("Size of retained productist1 " + productCodeList1.size());


    }












}
