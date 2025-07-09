<<<<<<< HEAD
//package com.factory;
//
//import java.time.Duration;
//import java.util.List;
//
//import org.openqa.selenium.*;
//import org.openqa.selenium.support.*;
//import org.openqa.selenium.support.ui.*;
//
//public class newhomFactory extends homeFactory {
//
//    public newhomFactory(WebDriver driver) {
//        super(driver);
//    }
//
//    @FindBy(xpath = "//input[@placeholder='From Station']")
//    WebElement Fromstation;
//
//    @FindBy(xpath = "//input[@placeholder='To Station']")
//    WebElement Tostation;
//
//    public void fromStation() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOf(Fromstation));
//        wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();
//
//        // Clear any pre-filled value
//        Fromstation.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        Fromstation.sendKeys(Keys.DELETE);
//        Thread.sleep(1000);
//
//        Fromstation.sendKeys("Pun");
//        Thread.sleep(2000);
//
//        List<WebElement> cities = driver.findElements(By.className("station-item"));
//        Thread.sleep(2000);
//
//        if (cities.size() > 0) {
//            cities.get(0).click();
//        } else {
//            throw new RuntimeException("No suggestions appeared for 'Pun'");
//        }
//        Thread.sleep(2000);
//
//        wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();
//
//        cities = driver.findElements(By.className("station-item"));
//        if (cities.size() > 1) {
//            cities.get(1).click();
//        } else {
//            throw new RuntimeException("Second suggestion not available for 'Pun'");
//        }
//        Thread.sleep(2000);
//    }
//
//    public void toStation() throws InterruptedException {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOf(Tostation));
//        wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();
//
//        // Clear any pre-filled value
//        Tostation.sendKeys(Keys.chord(Keys.CONTROL, "a"));
//        Tostation.sendKeys(Keys.DELETE);
//        Thread.sleep(1000);
//
//        Tostation.sendKeys("Mum");
//        Thread.sleep(2000);
//
//        List<WebElement> citiess = driver.findElements(
//                By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li")
//        );
//        Thread.sleep(2000);
//
//        if (citiess.size() > 0) {
//            citiess.get(0).click();
//        } else {
//            throw new RuntimeException("No suggestions appeared for 'Mum'");
//        }
//        Thread.sleep(2000);
//
//        wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();
//
//        citiess = driver.findElements(
//                By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li")
//        );
//        if (citiess.size() > 1) {
//            citiess.get(1).click();
//        } else {
//            throw new RuntimeException("Second suggestion not available for 'Mum'");
//        }
//        Thread.sleep(2000);
//    }
//    
//    
//    
//}


package com.factory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.*;

public class newhomFactory extends homeFactory {
	

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
	    public void enterDestinationCity2() {
	        String city = properties.getProperty("toCity");

	        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
	        toStation.clear();
	        toStation.sendKeys(city);

	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[contains(@class, 'collection-item') and contains(.,'" + city + "')]")
	        ));
	        option.click();
	    }
    public newhomFactory(WebDriver driver) {
        super(driver);
    }

//    @FindBy(xpath = "//input[@placeholder='From Station']")
//    WebElement fromStation;
//
//    @FindBy(xpath = "//input[@placeholder='To Station']")
//    WebElement toStation;
//
//    public void fromStation() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
//        fromStation.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//        fromStation.sendKeys("Pun");
//
//        // Wait for suggestions to appear
//        List<WebElement> cities = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//            By.className("station-item")
//        ));
//
//        if (cities.size() > 0) {
//            cities.get(0).click();
//        } else {
//            throw new RuntimeException("No suggestions appeared for 'Pun'");
//        }
//
//        // Reopen and select second suggestion if available
//        wait.until(ExpectedConditions.elementToBeClickable(fromStation)).click();
//        cities = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//            By.className("station-item")
//        ));
//
//        if (cities.size() > 1) {
//            cities.get(1).click();
//        } else {
//            throw new RuntimeException("Second suggestion not available for 'Pun'");
//        }
//    }
//
//    public void toStation() {
//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
//        toStation.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
//        toStation.sendKeys("Mum");
//
//        List<WebElement> cities = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//            By.xpath("//ul[contains(@class,'auto-complete-list')]//li")
//        ));
//
//        if (cities.size() > 0) {
//            cities.get(0).click();
//        } else {
//            throw new RuntimeException("No suggestions appeared for 'Mum'");
//        }
//
//        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
//        cities = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
//            By.xpath("//ul[contains(@class,'auto-complete-list')]//li")
//        ));
//
//        if (cities.size() > 1) {
//            cities.get(1).click();
//        } else {
//            throw new RuntimeException("Second suggestion not available for 'Mum'");
//        }
//    }
//}

@FindBy(xpath = "//input[@placeholder='From Station']")  
WebElement Fromstation;  

@FindBy(xpath = "//input[@placeholder='To Station']")  
WebElement Tostation;  

public void fromStation() throws InterruptedException {  
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

    wait.until(ExpectedConditions.visibilityOf(Fromstation));  
    wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();  

    // Clear any pre-filled value  
    Fromstation.sendKeys(Keys.chord(Keys.CONTROL, "a"));  
    Fromstation.sendKeys(Keys.DELETE);  
    Thread.sleep(1000);  

    Fromstation.sendKeys("Pun");  
    Thread.sleep(2000);  

    List<WebElement> cities = driver.findElements(By.className("station-item"));  
    Thread.sleep(2000);  

    if (cities.size() > 0) {  
        cities.get(0).click();  
    } else {  
        throw new RuntimeException("No suggestions appeared for 'Pun'");  
    }  
    Thread.sleep(2000);  

    wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();  

    cities = driver.findElements(By.className("station-item"));  
    if (cities.size() > 1) {  
        cities.get(1).click();  
    } else {  
        throw new RuntimeException("Second suggestion not available for 'Pun'");  
    }  
    Thread.sleep(2000);  
}  

public void toStation() throws InterruptedException {  
    wait = new WebDriverWait(driver, Duration.ofSeconds(10));  

    wait.until(ExpectedConditions.visibilityOf(Tostation));  
    wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();  

    // Clear any pre-filled value  
    Tostation.sendKeys(Keys.chord(Keys.CONTROL, "a"));  
    Tostation.sendKeys(Keys.DELETE);  
    Thread.sleep(1000);  

    Tostation.sendKeys("Mum");  
    Thread.sleep(2000);  

    List<WebElement> citiess = driver.findElements(  
            By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li")  
    );  
    Thread.sleep(2000);  

    if (citiess.size() > 0) {  
        citiess.get(0).click();  
    } else {  
        throw new RuntimeException("No suggestions appeared for 'Mum'");  
    }  
    Thread.sleep(2000);  

    wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();  

    citiess = driver.findElements(  
            By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li")  
    );  
    if (citiess.size() > 1) {  
        citiess.get(1).click();  
    } else {  
        throw new RuntimeException("Second suggestion not available for 'Mum'");  
    }  
    Thread.sleep(2000);  
}  
}


 
=======
package com.factory;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class newhomFactory extends homeFactory{
  
   public newhomFactory(WebDriver driver) {
		super(driver);
		
	}
   
   
   
   @FindBy(xpath="//input[@placeholder='From Station']")
   WebElement Fromstation;
   
   public void fromStation() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       
       WebElement Fromstation = driver.findElement(By.xpath("//input[@placeholder='From Station']"));
       wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();
       Fromstation.sendKeys("Pun");
       Thread.sleep(3000);
       
       List<WebElement> cities = driver.findElements(By.className("station-item"));
       Thread.sleep(5000);
       
       // Click first city
       cities.get(0).click();
       Thread.sleep(5000);
       
       wait.until(ExpectedConditions.elementToBeClickable(Fromstation)).click();
       cities = driver.findElements(By.className("station-item"));
       // Click second city
       cities.get(1).click();
       Thread.sleep(5000);

   }
   
   public void toStation() throws InterruptedException {
	   wait = new WebDriverWait(driver, Duration.ofSeconds(10));

       WebElement Tostation = driver.findElement(By.xpath("//input[@placeholder='To Station']"));
       wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();
       Tostation.sendKeys("Mum");
       Thread.sleep(3000);

       List<WebElement> citiess = driver.findElements(By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li"));
       Thread.sleep(5000);

       // Click first city
       citiess.get(0).click();
       Thread.sleep(5000);

       wait.until(ExpectedConditions.elementToBeClickable(Tostation)).click();
       citiess = driver.findElements(By.xpath("//ul[@class='collection auto-complete-list primary sm false']//li"));
       // Click second city
       citiess.get(1).click();
       Thread.sleep(5000);

   }
   
   
   
	
	
	
}
>>>>>>> ed83b207d06e2c8156bab4542d29e1ddfb2416ab
