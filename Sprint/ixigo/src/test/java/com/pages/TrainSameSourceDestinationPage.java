package com.pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TrainSameSourceDestinationPage extends BasePage{

	public TrainSameSourceDestinationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void invalidFromanTo()
	{
		 wait.until(ExpectedConditions.elementToBeClickable(FromValid)).click();
		    FromValid.clear();
		    FromValid.sendKeys(prop.getProperty("FromToInvalid"));

		    wait.until(ExpectedConditions.visibilityOf(suggPune)).click();

		    wait.until(ExpectedConditions.elementToBeClickable(ToValid)).click();
		    ToValid.clear();
		    ToValid.sendKeys(prop.getProperty("FromToInvalid"));

		    wait.until(ExpectedConditions.visibilityOf(suggPune)).click();
	}
	public void selctDate()
	{
		LocalDate today = LocalDate.now();
	    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("E, dd MMM", Locale.ENGLISH);
	    String todayStr = today.format(formatter);

	    String xpath = "//span[contains(text(),'" + todayStr + "')]";
	    WebElement dataField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
	    dataField.click();

	    wait.until(ExpectedConditions.elementToBeClickable(dateClick)).click();

	}
	public void selctSearch()
	{
		wait.until(ExpectedConditions.elementToBeClickable(searchBtn)).click();
	}
	public void assertSameData()
	{
		Assert.assertTrue(driver.getPageSource().contains("Source and destination cannot be the same"), "Expected error not found on page");

	}
	

}
