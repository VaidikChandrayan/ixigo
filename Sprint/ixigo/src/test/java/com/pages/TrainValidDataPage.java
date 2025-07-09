package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TrainValidDataPage extends BasePage{

	public TrainValidDataPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void fromToData()
	{
		wait.until(ExpectedConditions.elementToBeClickable(FromValid)).click();
		
		FromValid.sendKeys(prop.getProperty("FromValid"));
//		 Actions actions = new Actions(driver);
//		 actions.moveToElement(FromValid).click().sendKeys("Pune").pause(Duration.ofMillis(500)).perform();

	   wait.until(ExpectedConditions.elementToBeClickable(suggPune)).click();
	    
	   
	    wait.until(ExpectedConditions.elementToBeClickable(ToValid)).click();
	    ToValid.sendKeys(prop.getProperty("ToValid"));


	   wait.until(ExpectedConditions.elementToBeClickable(suggMum)).click();
		
	}
	
	
	public void selctDate()
	{
		LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
	    String todayStr = today.format(formatter); // e.g., "Thu, 03 Jul"

	    String xpath = "//span[contains(text(),'" + todayStr + "')]";
	    WebElement dataField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    dataField.click();

	    wait.until(ExpectedConditions.elementToBeClickable(dateClick)).click();

	}
	public void clickSearch()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();

	}
	public void assertValidData()
	{
		Assert.assertTrue(driver.getPageSource().contains("Pune"), "From station not found");
		Assert.assertTrue(driver.getPageSource().contains("Mumbai"), "To station not found");

	}

}
