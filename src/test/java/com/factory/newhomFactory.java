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
