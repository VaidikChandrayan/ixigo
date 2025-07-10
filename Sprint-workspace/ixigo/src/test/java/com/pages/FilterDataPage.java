package com.pages;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FilterDataPage extends BasePage {
    WebDriver driver;
    WebDriverWait wait;

    public FilterDataPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void filter() throws InterruptedException {
        // Step 1: Switch to the new tab
        String originalWindow = driver.getWindowHandle();
        Set<String> allWindows = driver.getWindowHandles();
        for (String handle : allWindows) {
            if (!handle.equals(originalWindow)) {
                driver.switchTo().window(handle);
                System.out.println("Switched to tab: " + driver.getTitle());
                break;
            }
        }

        try {
            //Step 2: Wait for Air India filter text
            By airIndiaText = By.xpath("//p[contains(text(),'Air India')]");
            wait.until(ExpectedConditions.presenceOfElementLocated(airIndiaText));
            System.out.println("Page loaded and Air India Express filter available");

            // Step 3: Scroll to Air India element
            WebElement airIndiaElement = driver.findElement(airIndiaText);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airIndiaElement);
         
            System.out.println("Scrolled to Air India Express section");

            Thread.sleep(3000);

            Robot robot = new Robot();
            robot.mouseMove(285, 445);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
    	    robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            System.out.println("Air India Express filter clicked successfully");
            

            Thread.sleep(2000); // Wait for popup to appear

           robot.mouseMove(100, 100); // Move mouse to a safe area away from elements
          robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
          robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        System.out.println("Popup closed by clicking outside");

        } catch (Exception e) {
            System.out.println("Error during filter interaction: " + e.getMessage());
        }
    }
    

}