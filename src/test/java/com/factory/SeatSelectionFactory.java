package com.factory;

import java.io.FileInputStream;
import java.time.Duration;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeatSelectionFactory extends homeFactory {
	
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
	    public void enterDestinationCity4() {
	        String city = properties.getProperty("toCity");

	        wait.until(ExpectedConditions.elementToBeClickable(toStation)).click();
	        toStation.clear();
	        toStation.sendKeys(city);

	        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
	            By.xpath("//li[contains(@class, 'collection-item') and contains(.,'" + city + "')]")
	        ));
	        option.click();
	    }
	    
	  public SeatSelectionFactory(WebDriver driver) {
	        super(driver);
	    }
	  
    WebDriver driver;
    WebDriverWait wait;

    // Date pickers
    @FindBy(id = "onward_cal")
    WebElement dateInput;

    @FindBy(className = "monthTitle")
    WebElement monthTitle;

    @FindBy(className = "next")
    WebElement nextMonthButton;

    

    @FindBy(xpath="//span[@data-date='31' and @data-month='7' and @data-year='2025']")
	WebElement dateClick;
    
    @FindBy(xpath = "(//span[text()='Show seats'])[1]")
    WebElement firstShowSeatsButton;

    @FindBy(xpath = "//ul[contains(@class,'seat-layout')]//li[contains(@class,'seat-available')]")
    List<WebElement> availableSeats;

    @FindBy(xpath = "//button[contains(text(),'Continue')]")
    WebElement continueButton;

    @FindBy(xpath = "//div[contains(@class,'boarding-point')]//label")
    List<WebElement> boardingPoints;

    @FindBy(xpath = "//div[contains(@class,'dropping-point')]//label")
    List<WebElement> droppingPoints;

    public void clickFirstShowSeatsButton() {
        wait.until(ExpectedConditions.elementToBeClickable(firstShowSeatsButton)).click();
    }

    public void selectSeat() {
        wait.until(ExpectedConditions.visibilityOfAllElements(availableSeats));
        if (!availableSeats.isEmpty()) {
            availableSeats.get(0).click();
        } else {
            System.out.println("No available seats found.");
        }
    }

    public void selectBoardingPoint() {
        wait.until(ExpectedConditions.visibilityOfAllElements(boardingPoints));
        if (!boardingPoints.isEmpty()) {
            boardingPoints.get(0).click();
        }
    }

    public void selectDroppingPoint() {
        wait.until(ExpectedConditions.visibilityOfAllElements(droppingPoints));
        if (!droppingPoints.isEmpty()) {
            droppingPoints.get(0).click();
        }
    }

    public void clickContinue() {
        wait.until(ExpectedConditions.elementToBeClickable(continueButton)).click();
    }

    public void selectTravelDate() throws InterruptedException {


	    try {
	        WebElement dateField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text' and @placeholder='Onward Journey Date']")));
	        dateField.click();

	        // Pick your specific date:
	        WebElement dateElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@data-date='31' and @data-month='7' and @data-year='2025']")));
	        dateElement.click();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
    }
   



      
        }
    

