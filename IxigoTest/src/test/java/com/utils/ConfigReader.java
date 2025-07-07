package com.utils;
 
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
 
public class ConfigReader {
 
    private static Properties properties;
 
    // Static block to load the config once
    static {
        try {
            FileInputStream input = new FileInputStream("src\\test\\resources\\config.properties");
            properties = new Properties();
            properties.load(input);
        } catch (IOException e) {
            System.out.println("X Failed to load config.properties: " + e.getMessage());
        }
    }
 
    // Generic getter
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
