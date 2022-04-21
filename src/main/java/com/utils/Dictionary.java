package com.utils;



import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Dictionary {
    public PropertyReader propertyReader;
    public ExtentReports extent;
    public ExtentTest test;
    public ExtentSparkReporter spark;
    public String requestBody1;
    public String requestBody2;
    public long totalResults1;
    public long totalResults2;
    public int numberOfOverlappedProducts;
    public String requestHeaders;
    public String queryParameters;
    public String methode;
    public String requestURL;
    public float qualityParam1;
    public int qualityParam2;

    public List<String> productCodeList1 = new ArrayList<>();
    public List<String> productCodeList2 = new ArrayList<>();

    public List<Integer> sortedIndicesList;
    public List<String> sortedProductCodeList;
//    public Stream<Map.Entry<String, Integer>> sortedRetainedListProductCodeandIndiceMap;
    public List<String> sortedRetainedProductCodeandIndiceList ;

    public HashMap<String, String> plzMap = new HashMap<String, String>();
    public void  setPlzMap(HashMap<String, String> plzMap) {
        this.plzMap = plzMap;
        plzMap.put("DSD", "44227");
        plzMap.put("DHU", "1021");
        plzMap.put("DOS", "8001");
        plzMap.put("VBE", "1020");
        plzMap.put("VHS", "1011 AB");
        plzMap.put("DUK", "E20 1AB");
    }

    public HashMap<String, String> telefonnummerMap = new HashMap<String, String>();
    public void setTelefonnummerMap(HashMap<String, String> telefonnummerMap) {
        this.telefonnummerMap = telefonnummerMap;
        telefonnummerMap.put("DSD", "44225");
        telefonnummerMap.put("DHU", "+36300000000");
        telefonnummerMap.put("DOS", "8001");
        telefonnummerMap.put("VBE", "1020");
        telefonnummerMap.put("VHS", "1011AB");
        telefonnummerMap.put("DUK", "E20 1AA");
    }

    public HashMap<String, String> countryMap = new HashMap<String, String>();
    public void setcountryMap(HashMap<String, String> countryMap) {
        this.countryMap = countryMap;
        countryMap.put("DSD", "Deutschland");
        countryMap.put("DHU", "Magyarország");
        countryMap.put("DOS", "Schweiz");
        countryMap.put("VBE", "België");
        countryMap.put("VHS", "Nederland");
        countryMap.put("DUK", "United Kingdom");
    }

    public HashMap<String, String> urlCountryMarkMap = new HashMap<String, String>();
    public void setUrlCountryMarkMap(HashMap<String, String> urlCountryMarkMap) {
        this.urlCountryMarkMap = urlCountryMarkMap;
        urlCountryMarkMap.put("DSD", "deichmann-de");
        urlCountryMarkMap.put("DHU", "deichmann-hu");
        urlCountryMarkMap.put("DOS", "dosenbach-ch");
        urlCountryMarkMap.put("VBE", "vanharen-be");
        urlCountryMarkMap.put("VHS", "vanharen-nl");
        urlCountryMarkMap.put("DUK", "deichmann-gb");
    }

    public HashMap<String, String> countryLanguageCodeMap = new HashMap<String, String>();
    public void setCountryLanguageCodeMap(HashMap<String, String> countryLanguageCodeMap) {
        this.countryLanguageCodeMap = countryLanguageCodeMap;
        countryLanguageCodeMap.put("DSD", "de_DE_DEICHMANN");
        countryLanguageCodeMap.put("DHU", "hu-hu");
        countryLanguageCodeMap.put("DOS", "de_CH");
        countryLanguageCodeMap.put("VBE", "nl_BE");
        countryLanguageCodeMap.put("VHS", "nl_NL");
        countryLanguageCodeMap.put("DUK", "en_GB");
    }

    public HashMap<String, String> urlMap = new HashMap<String, String>();
    public void setUrlMap(HashMap<String, String> urlMap) {
        this.urlMap = urlMap;
        propertyReader = new PropertyReader();
        urlMap.put("DSD QA", propertyReader.readApplicationFile("URL_DE_QA"));
        urlMap.put("DSD Prod", propertyReader.readApplicationFile("URL_DE_Prod"));
        urlMap.put("DSD Gemini", propertyReader.readApplicationFile("URL_DE_Gemini"));
        urlMap.put("DHU QA", propertyReader.readApplicationFile("URL_DHU_QA"));
        urlMap.put("DHU Prod", propertyReader.readApplicationFile("URL_DHU_Prod"));
        urlMap.put("DHUHfuenf QA", propertyReader.readApplicationFile("URL_DHU_Hfuenf_QA"));
        urlMap.put("DHUHfuenf Prod", propertyReader.readApplicationFile("URL_DHU_Hfuenf_Prod"));
        urlMap.put("DOS QA", propertyReader.readApplicationFile("URL_DOS_QA"));
        urlMap.put("DOS Prod", propertyReader.readApplicationFile("URL_DOS_Prod"));
        urlMap.put("VBE QA", propertyReader.readApplicationFile("URL_VBE_QA"));
        urlMap.put("VBE Prod", propertyReader.readApplicationFile("URL_VBE_Prod"));
        urlMap.put("VHS QA", propertyReader.readApplicationFile("URL_VHS_QA"));
        urlMap.put("VHS Prod", propertyReader.readApplicationFile("URL_VHS_Prod"));
        urlMap.put("DUK QA", propertyReader.readApplicationFile("URL_DUK_QA"));
        urlMap.put("DUK Prod", propertyReader.readApplicationFile("URL_DUK_Prod"));
    }


    public HashMap<String, String> urlDamenSchuheMap = new HashMap<String, String>();
    public void seturlDamenSchuheMap(HashMap<String, String> urlDamenSchuheMap) {
        this.urlDamenSchuheMap = urlDamenSchuheMap;
        setUrlMap(urlMap);
        propertyReader = new PropertyReader();
        urlDamenSchuheMap.put("DSD QA", urlMap.get("DSD QA") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("DSD Prod", urlMap.get("DSD Prod") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("DHU QA", urlMap.get("DHU QA") + "/női/cipők/c-ws");
        urlDamenSchuheMap.put("DHU Prod", urlMap.get("DHU Prod") + "/női/cipők/c-ws");
        urlDamenSchuheMap.put("DOS QA", urlMap.get("DOS QA") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("DOS Prod", urlMap.get("DOS Prod") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("VBE QA", urlMap.get("VBE QA") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("VBE Prod", urlMap.get("VBE Prod") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("VHS QA", urlMap.get("VHS QA") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("VHS Prod", urlMap.get("VHS Prod") + "/damen/schuhe/c-ws");
        urlDamenSchuheMap.put("DUK QA", urlMap.get("DUK QA") + "/women/shoes/c-ws");
        urlDamenSchuheMap.put("DUK Prod", urlMap.get("DUK Prod") + "/women/shoes/c-ws");
    }


    public HashMap<String, String> urlNewsletterMap = new HashMap<String, String>();
    public void seturlNewsletterMap(HashMap<String, String> urlNewsletterMap) {
        this.urlNewsletterMap = urlNewsletterMap;
        setUrlMap(urlMap);
        propertyReader = new PropertyReader();
        urlNewsletterMap.put("DSD QA", urlMap.get("DSD QA") + "/newsletter");
        urlNewsletterMap.put("DSD Prod", urlMap.get("DSD Prod") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("DHU QA", urlMap.get("DHU QA") + "/női/cipők/c-ws");
        urlNewsletterMap.put("DHU Prod", urlMap.get("DHU Prod") + "/női/cipők/c-ws");
        urlNewsletterMap.put("DOS QA", urlMap.get("DOS QA") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("DOS Prod", urlMap.get("DOS Prod") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("VBE QA", urlMap.get("VBE QA") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("VBE Prod", urlMap.get("VBE Prod") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("VHS QA", urlMap.get("VHS QA") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("VHS Prod", urlMap.get("VHS Prod") + "/damen/schuhe/c-ws");
        urlNewsletterMap.put("DUK QA", urlMap.get("DUK QA") + "/women/shoes/c-ws");
        urlNewsletterMap.put("DUK Prod", urlMap.get("DUK Prod") + "/women/shoes/c-ws");
    }


    public HashMap<String, String> xpathAendernSymbolDeliveryMap = new HashMap<String, String>();
    public void setxpathAendernSymbolDelivery(HashMap<String, String> xpathAendernSymbolDeliveryMap) {
        this.xpathAendernSymbolDeliveryMap = xpathAendernSymbolDeliveryMap;
        xpathAendernSymbolDeliveryMap.put("DSD", "//a[@href='/de-de/checkout/addresses/delivery']");
        xpathAendernSymbolDeliveryMap.put("DHU", "//a[@href='/hu-hu/checkout/addresses/delivery']");
        xpathAendernSymbolDeliveryMap.put("DOS", "//a[@href='/de-ch/checkout/addresses/delivery']");
        xpathAendernSymbolDeliveryMap.put("VBE", "//a[@href='/nl-be/checkout/addresses/delivery']");
        xpathAendernSymbolDeliveryMap.put("VHS", "//a[@href='/nl-nl/checkout/addresses/delivery']");
        xpathAendernSymbolDeliveryMap.put("DUK", "(//a[@href='/en-gb/checkout/addresses/delivery'])[position()=2]");
    }

    public HashMap<String, String> xpathAendernSymbolPaymentMap = new HashMap<String, String>();
    public void setXpathAendernSymbolPaymentMap(HashMap<String, String> xpathAendernSymbolPaymentMap) {
        this.xpathAendernSymbolPaymentMap = xpathAendernSymbolPaymentMap;
        xpathAendernSymbolPaymentMap.put("DSD", "//a[@href='/de-de/checkout/addresses/payment']");
        xpathAendernSymbolPaymentMap.put("DHU", "//a[@href='/hu-hu/checkout/addresses/payment']");
        xpathAendernSymbolPaymentMap.put("DOS", "//a[@href='/de-ch/checkout/addresses/payment']");
        xpathAendernSymbolPaymentMap.put("VBE", "//a[@href='/nl-be/checkout/addresses/payment']");
        xpathAendernSymbolPaymentMap.put("VHS", "//a[@href='/nl-nl/checkout/addresses/payment']");
        xpathAendernSymbolPaymentMap.put("DUK", "//a[@href='/en-gb/checkout/addresses/payment']");
    }


    public HashMap<String, String> zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_zufaelligeBuchstabenUrlMap(HashMap<String, String> zufaelligeBuchstabenUrlMap) {
        this.zufaelligeBuchstabenUrlMap = zufaelligeBuchstabenUrlMap;
        zufaelligeBuchstabenUrlMap.put("DSD", "zueflligebuchstaben");
        zufaelligeBuchstabenUrlMap.put("DHU", "zueflligebuchstaben");
        zufaelligeBuchstabenUrlMap.put("DOS", "zueflligebuchstaben");
        zufaelligeBuchstabenUrlMap.put("VBE", "zueflligebuchstaben");
        zufaelligeBuchstabenUrlMap.put("VHS", "zueflligebuchstaben");
        zufaelligeBuchstabenUrlMap.put("DUK", "zueflligebuchstaben");
    }


    public HashMap<String, String> c_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_c_zufaelligeBuchstabenUrlMap(HashMap<String, String> c_zufaelligeBuchstabenUrlMap) {
        this.c_zufaelligeBuchstabenUrlMap = c_zufaelligeBuchstabenUrlMap;
        c_zufaelligeBuchstabenUrlMap.put("DSD", "c-zueflligebuchstaben");
        c_zufaelligeBuchstabenUrlMap.put("DHU", "c-zueflligebuchstaben");
        c_zufaelligeBuchstabenUrlMap.put("DOS", "c-zueflligebuchstaben");
        c_zufaelligeBuchstabenUrlMap.put("VBE", "c-zueflligebuchstaben");
        c_zufaelligeBuchstabenUrlMap.put("VHS", "c-zueflligebuchstaben");
        c_zufaelligeBuchstabenUrlMap.put("DUK", "c-zueflligebuchstaben");
    }


    public HashMap<String, String> p_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_p_zufaelligeBuchstabenUrlMap(HashMap<String, String> p_zufaelligeBuchstabenUrlMap) {
        this.p_zufaelligeBuchstabenUrlMap = p_zufaelligeBuchstabenUrlMap;
        p_zufaelligeBuchstabenUrlMap.put("DSD", "p-zueflligebuchstaben");
        p_zufaelligeBuchstabenUrlMap.put("DHU", "p-zueflligebuchstaben");
        p_zufaelligeBuchstabenUrlMap.put("DOS", "p-zueflligebuchstaben");
        p_zufaelligeBuchstabenUrlMap.put("VBE", "p-zueflligebuchstaben");
        p_zufaelligeBuchstabenUrlMap.put("VHS", "p-zueflligebuchstaben");
        p_zufaelligeBuchstabenUrlMap.put("DUK", "p-zueflligebuchstaben");
    }


    public HashMap<String, String> search_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_search_zufaelligeBuchstabenUrlMap(HashMap<String, String> search_zufaelligeBuchstabenUrlMap) {
        this.search_zufaelligeBuchstabenUrlMap = search_zufaelligeBuchstabenUrlMap;
        search_zufaelligeBuchstabenUrlMap.put("DSD", "search/zueflligebuchstaben");
        search_zufaelligeBuchstabenUrlMap.put("DHU", "search/zueflligebuchstaben");
        search_zufaelligeBuchstabenUrlMap.put("DOS", "search/zueflligebuchstaben");
        search_zufaelligeBuchstabenUrlMap.put("VBE", "search/zueflligebuchstaben");
        search_zufaelligeBuchstabenUrlMap.put("VHS", "search/zueflligebuchstaben");
        search_zufaelligeBuchstabenUrlMap.put("DUK", "search/zueflligebuchstaben");
    }


    public HashMap<String, String> damen_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_damen_zufaelligeBuchstabenUrlMap(HashMap<String, String> damen_zufaelligeBuchstabenUrlMap) {
        this.damen_zufaelligeBuchstabenUrlMap = damen_zufaelligeBuchstabenUrlMap;
        damen_zufaelligeBuchstabenUrlMap.put("DSD", "damen/zueflligebuchstaben");
        damen_zufaelligeBuchstabenUrlMap.put("DHU", "noi/zueflligebuchstaben");
        damen_zufaelligeBuchstabenUrlMap.put("DOS", "damen/zueflligebuchstaben");
        damen_zufaelligeBuchstabenUrlMap.put("VBE", "dames/zueflligebuchstaben");
        damen_zufaelligeBuchstabenUrlMap.put("VHS", "dames/zueflligebuchstaben");
        damen_zufaelligeBuchstabenUrlMap.put("DUK", "women/zueflligebuchstaben");
    }



    public HashMap<String, String> damen_c_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_damen_c_zufaelligeBuchstabenUrlMap(HashMap<String, String> damen_c_zufaelligeBuchstabenUrlMap) {
        this.damen_c_zufaelligeBuchstabenUrlMap = damen_c_zufaelligeBuchstabenUrlMap;
        damen_c_zufaelligeBuchstabenUrlMap.put("DSD", "damen/c-zueflligebuchstaben");
        damen_c_zufaelligeBuchstabenUrlMap.put("DHU", "noi/c-zueflligebuchstaben");
        damen_c_zufaelligeBuchstabenUrlMap.put("DOS", "damen/c-zueflligebuchstaben");
        damen_c_zufaelligeBuchstabenUrlMap.put("VBE", "dames/c-zueflligebuchstaben");
        damen_c_zufaelligeBuchstabenUrlMap.put("VHS", "dames/c-zueflligebuchstaben");
        damen_c_zufaelligeBuchstabenUrlMap.put("DUK", "women/c-zueflligebuchstaben");
    }



    public HashMap<String, String> damen_p_zufaelligeBuchstabenUrlMap = new HashMap<String, String>();
    public void set_damen_p_zufaelligeBuchstabenUrlMap(HashMap<String, String> damen_p_zufaelligeBuchstabenUrlMap) {
        this.damen_p_zufaelligeBuchstabenUrlMap = damen_p_zufaelligeBuchstabenUrlMap;
        damen_p_zufaelligeBuchstabenUrlMap.put("DSD", "damen/p-zueflligebuchstaben");
        damen_p_zufaelligeBuchstabenUrlMap.put("DHU", "noi/p-zueflligebuchstaben");
        damen_p_zufaelligeBuchstabenUrlMap.put("DOS", "damen/p-zueflligebuchstaben");
        damen_p_zufaelligeBuchstabenUrlMap.put("VBE", "dames/p-zueflligebuchstaben");
        damen_p_zufaelligeBuchstabenUrlMap.put("VHS", "dames/p-zueflligebuchstaben");
        damen_p_zufaelligeBuchstabenUrlMap.put("DUK", "women/p-zueflligebuchstaben");
    }






}
