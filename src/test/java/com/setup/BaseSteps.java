package com.setup;

import org.openqa.selenium.WebDriver;



import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSteps {
	protected static WebDriver driver;
    private static final String BASE_URL = "https://bus.ixigo.com/"; // Set your base URL directly
 
    @Before
    public void setUp() {
        if (driver == null) {
            System.out.println(" Launching browser without config file...");
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
    }
 
    @After
    public void tearDown() {
        if (driver != null) {
        	
        	try {
        		Thread.sleep(5000);
        	}catch(InterruptedException e)
        	{
        		e.printStackTrace();
        	}
            System.out.println(" Cleaning up browser...");
            driver.quit();
            driver = null;
        }
    }
 
    public static WebDriver getDriver() {
        return driver;
    }
 
    public static String getBaseUrl() {
        return BASE_URL;
    }
}


