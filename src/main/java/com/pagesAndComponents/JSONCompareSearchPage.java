package com.pagesAndComponents;

import com.utils.DriverTestCase;
import io.restassured.response.Response;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;


public class JSONCompareSearchPage extends DriverTestCase {

    private WebDriver driver;
    private WebDriverWait wait;
    public String inside;
    public Response response;

    public JSONCompareSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);

    }



    public void compareJson(List productCodeList1, List productCodeList2) throws IOException, ParseException {

        System.out.println("-------------------------------------------------");
        System.out.println("Number of products in Response 1: " + productCodeList1.size());
        System.out.println("Number of products in Response 2: " + productCodeList2.size());
        System.out.println("-------------------------------------------------");
        System.out.println("product List1: " + productCodeList1);
        System.out.println("product List2: " + productCodeList2);
        System.out.println("-------------------------------------------------");


        qualityParam2 = 0;

        List<Integer> indices = new ArrayList<>(productCodeList1.size());
        Map<String, Integer> retainedListMap = new HashMap<>(productCodeList1.size());

        Map<String, Integer> retainedListProductCodeandIndiceMap = new HashMap<>(productCodeList1.size());

        for (int i = 0; i < productCodeList1.size(); i++) {

            for (int j = 0; j < productCodeList2.size(); j++) {

                if (productCodeList1.get(i).toString().equalsIgnoreCase(productCodeList2.get(j).toString()))
                {
                    retainedListMap.put((String) productCodeList1.get(i), j);
                    qualityParam2 = Math.abs(i - j) + qualityParam2;
                    indices.add(Math.abs(i - j));

                    retainedListProductCodeandIndiceMap.put((String) productCodeList1.get(i), Math.abs(i - j));
                }

            }

        }

        sortedRetainedProductCodeandIndiceList =
                retainedListProductCodeandIndiceMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(entry -> entry.getKey() + "=" + entry.getValue())
                        .collect(Collectors.toList());


        System.out.println("Begin sortedRetainedListProductCodeandIndiceMap: ");
        sortedRetainedProductCodeandIndiceList.forEach(System.out::println);
        System.out.println("Ende sortedIndicesList: ");


        sortedIndicesList =
                retainedListProductCodeandIndiceMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(Map.Entry::getValue).collect(Collectors.toList());

        sortedProductCodeList =
                retainedListProductCodeandIndiceMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .map(Map.Entry::getKey).collect(Collectors.toList());


/*        Stream<Map.Entry<String, Integer>> sorted =
                retainedListProductCodeandIndiceMap.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()));*/

/*        List<Integer> indicesSorted =
                retainedListProductCodeandIndiceMap.entrySet().stream()
                        .map(Map.Entry::getValue)
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .collect(Collectors.toList());*/

/*        List<Integer> sortedIndicesList =
                         sorted.map(Map.Entry::getValue).collect(Collectors.toList());*/

/*        List<String> sortedProductCodeList =
                sorted.map(Map.Entry::getKey).collect(Collectors.toList());*/




        System.out.println("Begin sortedIndicesList: ");
        sortedIndicesList.forEach(System.out::println);
        System.out.println("Ende sortedIndicesList: ");


        System.out.println("Begin sortedProductCodeList: ");
        sortedProductCodeList.forEach(System.out::println);
        System.out.println("Ende sortedProductCodeList: ");

/*        List<Integer> sortedListIndices = indices.stream().sorted().collect(Collectors.toList());
        sortedListIndices.forEach(System.out::println);*/


        Collections.sort(indices, Collections.reverseOrder());
//


        productCodeList1.retainAll(productCodeList2);
        System.out.println("Retained List: " + productCodeList1);
        System.out.println("-------------------------------------------------");
        System.out.println("Size of retained productist1 " + productCodeList1.size());
        System.out.println("-------------------------------------------------");
        System.out.println("List of indices " + indices.size() +  indices);
        numberOfOverlappedProducts = productCodeList1.size();
        qualityParam1 = ((float) retainedListMap.size() / (float)productCodeList1.size());
        qualityParam2 = (qualityParam2/retainedListMap.size());




    }












}
