package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class TrainAvailabilityPage extends BasePage{
	

	public TrainAvailabilityPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void clickFirstAvailability() 
	 {
		 	wait.until(ExpectedConditions.visibilityOf(loadTrain));

		  
		    WebElement showButton = wait.until(ExpectedConditions.elementToBeClickable(showAvlBtn));
		    js.executeScript("arguments[0].scrollIntoView({block: 'center'});", showButton);
		    actions.moveToElement(showButton).click().perform();

		     
	 }
	 public void verifyAvailability()
	 {
		 wait.until(ExpectedConditions.visibilityOfAllElements(seatElement));
		 Assert.assertTrue(seatElement.size() > 0,"Seat availability details should be displayed");
		 
	 }

}
