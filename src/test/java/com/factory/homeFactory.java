//package com.factory;

//
//import java.awt.AWTException;
//import java.awt.Robot;
//import java.awt.event.InputEvent;
//import java.io.FileInputStream;
//import java.time.Duration;
//import java.util.Properties;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class homeFactory {
//	
//	Properties properties;
//
//    WebDriver driver;
//    WebDriverWait wait;
//
//    @FindBy(xpath = "//input[@placeholder='From Station']")
//    WebElement fromStation;
//
//    @FindBy(xpath = "//input[@placeholder='To Station']")
//    WebElement toStation;
//
//    @FindBy(xpath = "//button[text()='Search']")
//    WebElement searchButton;
//    
//    @FindBy(xpath="//li[contains(@class, 'collection-item') and contains(@class, 'auto-complete-list-item') and @data-id='51 Pune (Maharashtra)']")
//    WebElement sourceCity;
//    
//    @FindBy(xpath="//li[.//div[text()='Mumbai'] and .//small[text()='Maharashtra']]")
//    WebElement desCity;
//
//    public homeFactory(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
//    }
//
//    public void openWebsite() {
//        driver.get("https://bus.ixigo.com/");
//        driver.manage().window().maximize();
//        try {
//            Robot robot = new Robot();
//            Thread.sleep(2000);
//            robot.mouseMove(250, 350);
//            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
//            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
//           // Thread.sleep(3000);
//        } catch (AWTException | InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    
//    public void loadProperties() {
//        try {
//            properties = new Properties();
//            FileInputStream fis = new FileInputStream("C:\\Users\\VAIDCHAN\\OneDrive\\eclipse\\ixigo\\src\\test\\resource\\PropertiesFiles\\Bus.properties");
//            properties.load(fis);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    } 
//
//   // public void enterSourceCity() {
////    	wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
////    	 fromStation.clear();
//    	//Thread.sleep(2000);
//    //	fromStation.click();
//    //	driver.get(properties.getProperty("fromCity"));
//        
//       
//        //fromStation.sendKeys(city);
//
////        // Wait for dropdown to load and click correct option
////        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(sourceCity));
////        option.click();
////    }
////    
////    public void enterSourceCity1() {
//////    	wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
//////    	 fromStation.clear();
////    	toStation.click();
////    	driver.get(properties.getProperty("toCity"));
////        
////       
////        //fromStation.sendKeys(city);
////
////        // Wait for dropdown to load and click correct option
////        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(desCity));
////        option.click();
//  //  }
//
////    public void enterDestinationCity() {
////    	wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
////   	 fromStation.clear();
////   	driver.get(properties.getProperty("toCity"));
//////        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
//////        toStation.clear();
//////        toStation.sendKeys(city);
////
////        // Wait for dropdown to load and click correct option
////        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(desCity));
////                
////        option.click();
////    }
//// 
//    public void enterSourceCity() {
//        wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
//        fromStation.clear();
//        fromStation.sendKeys(properties.getProperty("fromCity"));
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(sourceCity));
//        option.click();
//    }
//
//    public void enterDestinationCity() {
//        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
//        toStation.clear();
//        toStation.sendKeys(properties.getProperty("toCity"));
//        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(desCity));
//        option.click();
//    }
//
//    public void selectTravelDate() throws InterruptedException {
//        // TODO: Implement your date picker logic
//    	 WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @placeholder='Onward Journey Date']")));
//	        dateField.click();
//
//	        // Pick your specific date:
//	        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-date='31' and @data-month='7' and @data-year='2025']")));
//	        dateElement.click();
//
//    	}
//   
//    public void clickSearch() {
//        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
//    }
//    @FindBy(xpath  = "//input[@placeholder='Onward Journey Date']") // or the actual ID/class of the date input
//    WebElement dateInput;
////
////   
//        }


    package com.factory;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class homeFactory {

    Properties properties;
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(xpath = "//input[@placeholder='From Station']")
    WebElement fromStation;

    @FindBy(xpath = "//input[@placeholder='To Station']")
    WebElement toStation;

    @FindBy(xpath = "//button[text()='Search']")
    WebElement searchButton;

    public homeFactory(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

//    public void openWebsite() {
//        driver.get("https://bus.ixigo.com/");
//        driver.manage().window().maximize();
//
//        // load properties file
//        loadProperties();
//
//        // wait for page fully loaded and From Station field clickable
//        wait.until(ExpectedConditions.elementToBeClickable(fromStation));
//    }
    public void openWebsite() {
        driver.get("https://bus.ixigo.com/");
        driver.manage().window().maximize();
        try {
            Robot robot = new Robot();
            Thread.sleep(2000);
            robot.mouseMove(250, 350);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
           // Thread.sleep(3000);
        } catch (AWTException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void loadProperties() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream(
                "C:\\Users\\VAIDCHAN\\OneDrive\\eclipse\\ixigo\\src\\test\\resource\\PropertiesFiles\\Bus.properties"
            );
            properties.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterSourceCity() {
     

        wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
       // fromStation.clear();
        String city = properties.getProperty("fromCity");
        fromStation.sendKeys(city);

        // Wait for suggestion dropdown
        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//div[contains(@class, 'col') and text()='Pune']")
        ));
        option.click();
    }

    public void enterDestinationCity() {
        String city = properties.getProperty("toCity");

        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
        toStation.clear();
        toStation.sendKeys(city);

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li[contains(@class, 'collection-item') and contains(.,'" + city + "')]")
        ));
        option.click();
    }
    
    

    public void selectTravelDate() throws InterruptedException {
        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//input[@placeholder='Onward Journey Date']")
        ));
        dateField.click();

        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//span[@data-date='31' and @data-month='7' and @data-year='2025']")
        ));
        dateElement.click();
    }

    public void clickSearch() {
        wait.until(ExpectedConditions.elementToBeClickable(searchButton)).click();
    }
}


    

