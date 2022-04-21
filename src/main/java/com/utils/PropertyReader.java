//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.utils;

import java.io.*;
import java.util.Locale;
import java.util.Properties;

public class PropertyReader {

    public PropertyReader() {
    }

    String path =  getPath();
    public String readApplicationFile(String key){
        String value = "";
        String appPropPath = "";
        try{
            Properties prop = new Properties();


            appPropPath = "//src//main//java//com//config//application.properties";
            File f = new File(path + "//src//main//java//com//config//application.properties");
            if(f.exists()){
                prop.load(new FileInputStream(f));
                value = prop.getProperty(key);

            }
        }
        catch(Exception e){
            System.out.println("Failed to read from application.properties file.");
        }
        return value;
    }

    public String readApplicationFileUsers(String key){
        String value = "";
        String appPropPath = "";
        try{
            Properties prop = new Properties();


            appPropPath = "//src//main//java//com//config//users.properties";
            File f = new File(path + "//src//main//java//com//config//users.properties");
            if(f.exists()){
                prop.load(new FileInputStream(f));
                value = prop.getProperty(key);

            }
        }
        catch(Exception e){
            System.out.println("Failed to read from application.properties file.");
        }
        return value;
    }




/*
    public String writeApplicationFile(String key, String valueToSet){
        String value = "";
        String appPropPath = "";
        try{
            Properties prop = new Properties();


            appPropPath = "//src//main//java//com//config//application.properties";
            File f = new File(path + "//src//main//java//com//config//application.properties");
            if(f.exists()){
                prop.load(new FileInputStream(f));
                value = prop.getProperty(key);
                prop.setProperty(key, valueToSet);
                //prop.store(new FileOutputStream(f), null);

            }
        }
        catch(Exception e){
            System.out.println("Failed to read from application.properties file.");
        }
        return value;
    }

*/


    public String writeApplicationFile(String key, String valueToSet){
        String value = null;

        try (OutputStream output = new FileOutputStream(path + "//src//main//java//com//config//users.properties"))


        {

            Properties prop = new Properties();

            // set the properties value
            prop.setProperty(key, valueToSet);

            // save properties to project root folder
            prop.store(output, null);

            System.out.println(prop);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return value;
    }


    public String getPath()
    {
        String path ="";
        File file = new File("");
        String absolutePathOfFirstFile = file.getAbsolutePath();
        path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
        return path;
    }




}
