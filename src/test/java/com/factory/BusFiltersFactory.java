package com.factory;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

public class BusFiltersFactory extends homeFactory {
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
	 public void enterDestinationCity1() {
	        String city = properties.getProperty("toCity");

	        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
	        toStation.clear();
	        toStation.sendKeys(city);

	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[contains(@class, 'collection-item') and contains(.,'" + city + "')]")
	        ));
	        option.click();
	    }
	public BusFiltersFactory(WebDriver driver) {
        super(driver);
    }

    public By acFilterCheckbox = By.xpath("//a[span[text()='AC']]");
    public By sleeperFilterCheckbox = By.xpath("//a[span[text()='Sleeper']]");
    public By lowestPriceOption = By.xpath("//a[span[text()='Price']]");
    public By seats = By.xpath("//a[span[text()='Seats']]");
    public By ratings = By.xpath("//a[span[text()='Ratings']]");
    public By ArrivalTime = By.xpath("//a[span[text()='Arrival Time']]");
    public By DepartureTime = By.xpath("//a[span[text()='Departure Time']]");
    
    public By adjustPrice = By.xpath("//div[contains(@class, 'slider-thumb') and contains(@class, 'slider-thumb-0')]");
   
    public void applyACFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkboxx = wait.until(ExpectedConditions.elementToBeClickable(acFilterCheckbox));
        checkboxx.click();
        Thread.sleep(3000);
        System.out.println("AC filter applied.");
    }

    public void applySleeperFilter() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkbox = wait.until(ExpectedConditions.elementToBeClickable(sleeperFilterCheckbox));
        checkbox.click();
        Thread.sleep(3000);
        System.out.println("Sleeper filter applied.");
    }

    public void seats() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement seat = wait.until(ExpectedConditions.elementToBeClickable(seats));
        seat.click();
        Thread.sleep(3000);
        System.out.println("Sorted by seats.");
    }
    public void Arrival() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement arrival = wait.until(ExpectedConditions.elementToBeClickable(ArrivalTime));
        arrival.click();
        Thread.sleep(3000);
        System.out.println("Sorted by arrival.");
    }
    public void Departure() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement depart = wait.until(ExpectedConditions.elementToBeClickable(DepartureTime));
        depart.click();
        Thread.sleep(3000);
        System.out.println("Sorted by departure.");
    }
    public void Ratings() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement rating = wait.until(ExpectedConditions.elementToBeClickable(ratings));
        rating.click();
        Thread.sleep(3000);
        System.out.println("Sorted by ratings.");
    }
    public void sortByLowestPrice() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement priceOp = wait.until(ExpectedConditions.elementToBeClickable(lowestPriceOption));
        priceOp.click();
        Thread.sleep(3000);
        System.out.println("Sorted by ratings.");
    }
        
     

     
     
     }

