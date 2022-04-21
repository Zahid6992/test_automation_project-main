package com.testCasesTestNG.JsonCompare;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.utils.DriverTestCase;
import org.json.simple.parser.ParseException;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.IOException;

import java.time.Instant;
import java.util.List;

import com.influxdb.annotations.Column;
import com.influxdb.annotations.Measurement;
import com.influxdb.client.InfluxDBClient;
import com.influxdb.client.InfluxDBClientFactory;
import com.influxdb.client.WriteApi;
import com.influxdb.client.domain.WritePrecision;
import com.influxdb.client.write.Point;
import com.influxdb.query.FluxTable;


public class SearchQuality extends DriverTestCase {
    public String actualResult = "actual result";
    public String expectedResult = "expected result";
    float percentage;
    @Parameters({"mobileOrDesktop", "deviceName", "shop", "kategorie","environment",  "base_store_id", "referer", "search_expression", "test_id"})
    @Test()
    public void  ZielGruppe (String mobileOrDesktop, String deviceName, String shop, String kategorie, String environment, String base_store_id, String referer, String search_expression, String test_id) throws InterruptedException, IOException, ParseException {

        String token = "vTUHv2J6qZX8dWUbAZil7AQ5b3NHIvVjf1469mZsTy8z4YANUEuWuZw6qCV_3FxJVa8O4r6MnkIbseoBGuUVXA==";
        String bucket = "deichmann";
        String org = "deichmann";

        InfluxDBClient client = InfluxDBClientFactory.create("http://localhost:8086", token.toCharArray());

        System.out.println("connection ok");

        String testCaseName = test_id + "_Search_Quality";
        extentReportConfig.configureExtentReportBeforeTest(testCaseName, mobileOrDesktop, deviceName, shop, environment);


        jsonCompareSearchPage.compareJson(jsonCompareSearchPage1.checkAPIResponse1(base_store_id, referer, search_expression), jsonCompareSearchPage2.checkAPIResponse2(base_store_id, referer, search_expression));

        extentReportConfig.configureExtentReportTestInfo("Request 1: Aufruf der Sub Menu Slipper - ");
        extentReportConfig.configureExtentReportTestInfo("Request URL: "+ jsonCompareSearchPage1.requestURL);
        extentReportConfig.configureExtentReportTestInfo("Request methode: "+ jsonCompareSearchPage1.methode);
        extentReportConfig.configureExtentReportTestInfo("Query Parameters: "+ jsonCompareSearchPage1.queryParameters);
        extentReportConfig.configureExtentReportTestInfo("Request headers: "+ jsonCompareSearchPage1.requestHeaders);
        extentReportConfig.configureExtentReportTestInfo("Anzahl der Produkte unter der Kategorie Slipper: "+ jsonCompareSearchPage1.totalResults1);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Request 2: Allgemeine Suche - Slipper");
        extentReportConfig.configureExtentReportTestInfo("Request URL: "+ jsonCompareSearchPage2.requestURL);
        extentReportConfig.configureExtentReportTestInfo("Request methode: "+ jsonCompareSearchPage2.methode);
        extentReportConfig.configureExtentReportTestInfo("Query Parameters: "+ jsonCompareSearchPage2.queryParameters);
        extentReportConfig.configureExtentReportTestInfo("Request headers: "+ jsonCompareSearchPage2.requestHeaders);
        extentReportConfig.configureExtentReportTestInfo("Anzahl der Produkte in der Sucherergebnisse - Suche Slipper: "+ jsonCompareSearchPage2.totalResults2);


        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Anzahl überlappender Prdukte: "+ jsonCompareSearchPage.numberOfOverlappedProducts);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Search Quality Parameter 2: Anzahl der Produkte der überlappenden Produkte durch den Anzahl der Produkte der SOLL Liste: "+ jsonCompareSearchPage.qualityParam1);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Search Quality Parameter 2: Durschnitt der Difference der Produktindexen der IST Liste und die SOLL Liste: " + jsonCompareSearchPage.qualityParam2);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Sorted Product Indices: " + jsonCompareSearchPage.sortedIndicesList);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("Sorted Product Code: " + jsonCompareSearchPage.sortedProductCodeList);

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");

        extentReportConfig.configureExtentReportTestInfo("------------------------------------------------------------------------------------");
        extentReportConfig.configureExtentReportTestInfo("Sorted Product Code and Indices: " + jsonCompareSearchPage.sortedRetainedProductCodeandIndiceList.toString());

    int lenghtlist = jsonCompareSearchPage.sortedRetainedProductCodeandIndiceList.size();
    for (int i = 0; i<lenghtlist; i++)
    {
        Point point = Point
                .measurement("mem")
                .addTag("kategorie", kategorie)
                .addTag("shop", shop)
                .addTag("search expression", search_expression)
                .addField("Product Indice", jsonCompareSearchPage.sortedIndicesList.get(i))
                .addField("Product Code", jsonCompareSearchPage.sortedProductCodeList.get(i))
                .time(Instant.now(), WritePrecision.NS);

        try (WriteApi writeApi = client.getWriteApi()) {
            writeApi.writePoint(bucket, org, point);
        }


    }



    }



    @Parameters({"mobileOrDesktop", "deviceName", "shop", "environment"})
    @AfterMethod
    public void getResult(ITestResult result, String mobileOrDesktop, String deviceName, String shop, String environment) throws IOException {

        extentReportConfig.configureExtentReportAfterTest(result, mobileOrDesktop, deviceName, shop, environment);
    }

    @AfterTest
    public void tearDown() {

        extentReportConfig.configureExtentReportTearDown();
    }







}
