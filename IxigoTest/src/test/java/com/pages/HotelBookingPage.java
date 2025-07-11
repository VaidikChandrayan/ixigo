package com.pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.utils.ConfigReader;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.io.File;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import com.utils.ScreenshotUtil;

public class HotelBookingPage extends BasePage {

	// Web-driver setup

	private final WebDriver driver;
	private final WebDriverWait wait;
	private final JavascriptExecutor js;

	// Page-Factory locators 
	

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[1]/div/div")
	WebElement sortDropdown;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[3]")
	WebElement sortOptions;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/div/div/div/div[2]/input")
	WebElement areaSearchInput;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/div/div[1]/div/div")
	WebElement areaSuggestions;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/p")
	WebElement mostPopularHeader;

	@FindBy(xpath = "/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]/div[2]/span/input")
	WebElement freeBreakfastOption;

	
	// Constructor
	
	public HotelBookingPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.js = (JavascriptExecutor) driver;
		PageFactory.initElements(driver, this);
	}

	
	// =====================================Scenario 3=========================================================
	
	
	public void loadHomePage() {
		try {
			String url = ConfigReader.getProperty("filter.url");
			driver.get(url);
			System.out.println("Loaded: " + url);
		} catch (Exception e) {
			System.out.println("Failed to load homepage: " + e.getMessage());
		}
	}
	
	public void openSortDropdown() {
		try {
			//wait.until(ExpectedConditions.elementToBeClickable(sortDropdown)).click();
			By dropdownButton =  By.cssSelector("body > div.min-w-1336 > div:nth-child(2) > div.container.flex.items-start.gap-x-20 > div.flex-1 > div > div > div.relative.flex.items-center.gap-x-20 > div > div");
			 
			WebElement dropdownBtn = wait.until(ExpectedConditions.elementToBeClickable(dropdownButton));
			dropdownBtn.click();
			System.out.println("Opened sort dropdown.");
		} catch (Exception e) {
			System.out.println("Failed to open sort dropdown: " + e.getMessage());
		}
	}

	
	public void selectRandomSortOption() {
	    try {
	        Thread.sleep(2000); // Wait for rating options to be visible
	 
	        // Use CSS selector to fetch all rating filter elements
	        List<WebElement> sortOptions = driver.findElements(By.cssSelector("body > div.min-w-1336 > div:nth-child(2) > div.container.flex.items-start.gap-x-20 > div.flex-1 > div > div > div.relative.flex.items-center.gap-x-20 > div > div.absolute.right-0.z-50.cursor-pointer")); // Replace with actual class
	 
	        if (sortOptions.size() == 0) {
	            throw new RuntimeException(" No dropdown options found using CSS Selector.");
	        }
	 
	        Random rand = new Random();
	        int index = rand.nextInt(sortOptions.size());
	 
	        WebElement selectedOption = sortOptions.get(index);
	selectedOption.click();
	 
	        System.out.println("Selected Random dropdown option : " + selectedOption.getText());
	 
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Failed to select dropdown option: " + e.getMessage());
	    }
	}
	
	
	public void scrollToSearchWithinArea() {
		try {
			WebElement mostPopular = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/p")));
			
			js.executeScript("arguments[0].scrollIntoView(true);", mostPopular);
			Thread.sleep(1000);
			System.out.println("Scrolled to Search within area");
		} catch (Exception e) {
			System.out.println("Failed to scroll to Search within area: " + e.getMessage());
		}
	}


	// open the “Search within area” input
	public void openAreaSearchField() {
		try {
			areaSearchInput.click();
			System.out.println(" Opened area search field");
		} catch (Exception e) {
			System.out.println("Failed to open area field: " + e.getMessage());
		}
	}
	
	public void enterAreaName(String area) {
	    try {
	        // Click inside the input field
	       
			areaSearchInput.click();
			areaSearchInput.sendKeys(area);
			
	 
	        System.out.println("Entered area: " + area);
	        Thread.sleep(1000); // wait for suggestions to appear
	    } catch (Exception e) {
	        System.out.println("Failed to enter area: " + e.getMessage());
	    }
	}

	// click the first area suggestion
	public void selectFirstAreaSuggestion() {
		try {
			areaSuggestions.click();
			System.out.println("Selected sort option: ");

		} catch (Exception e) {
			System.out.println("Failed to select area suggestion: " + e.getMessage());
		}
	}

	// quick validation that results list refreshed (url or title contains the area)
	public boolean isAreaFilterApplied() {
		try {
			Thread.sleep(1500); 
			return driver.getPageSource().toLowerCase().contains("showing properties")
					|| driver.getCurrentUrl().contains("&area=");
		} catch (Exception ignored) {
			return false;
		}
	}
	
	
	
	// Scroll to Most Popular section
	public void scrollToMostPopularFilter() {
		try {
			WebElement mostPopular = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/p")));
			
			js.executeScript("arguments[0].scrollIntoView(true);", mostPopular);
			Thread.sleep(1000);
			System.out.println("Scrolled to Most Popular filter section");
		} catch (Exception e) {
			System.out.println("Failed to scroll to Most Popular section: " + e.getMessage());
		}
	}

	public void selectFreeBreakfastFilter() {
		try {

			// Click on "Free Breakfast"
			By freeBreakfastFilter = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[2]");
			WebElement freeBreakfast = wait.until(ExpectedConditions.elementToBeClickable(freeBreakfastFilter));
			js.executeScript("arguments[0].click();", freeBreakfast);
			System.out.println("Selected filter: Free Breakfast");

			Thread.sleep(3000); // Wait for results update
		} catch (Exception e) {
			System.out.println("Failed to select Free Breakfast filter: " + e.getMessage());
		}
	}

	public void selectParkingAvailableFilter() {
		try {
//			WebElement viewMore = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
//					"/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/button")));
//			viewMore.click();
			
			

			// Click on "Parking Available"
			By parkingFilter = By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[3]/div[4]");
			WebElement parking = wait.until(ExpectedConditions.elementToBeClickable(parkingFilter));
			js.executeScript("arguments[0].click();", parking);
			System.out.println("Selected filter: Parking Available");

			Thread.sleep(3000); // Wait again for results update
		} catch (Exception e) {
			System.out.println("Failed to select Parking Available filter: " + e.getMessage());
		}
	}
	

	// Wait after filter applied (can improve with dynamic wait later)
	public void waitForHotelResultsToUpdate() {
		try {
			Thread.sleep(3000);
			System.out.println("Waited for hotel results to update");
		} catch (Exception e) {
			System.out.println("Waiting failed: " + e.getMessage());
		}
	}

	
	
	//=================================== Scenario-4 Methods==============================================
	
	

	// Scroll to User Rating section
	public void scrollToUserRatingFilter() {
		try {
			WebElement userRating = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[5]/p")));
			js.executeScript("arguments[0].scrollIntoView(true);", userRating);
			Thread.sleep(1000);
			System.out.println(" Scrolled to User Rating section");
		} catch (Exception e) {
			System.out.println(" Scroll to User Rating failed: " + e.getMessage());
		}
	}

	
	public void selectRandomUserRating() {
	    try {
	        Thread.sleep(2000); // Wait for rating options to be visible
	 
	        // Use CSS selector to fetch all rating filter elements
	        List<WebElement> ratingOptions = driver.findElements(By.cssSelector("body > div.min-w-1336 > div:nth-child(2) > div.container.flex.items-start.gap-x-20 > div.sticky.z-\\[99\\].flex-shrink-0.rounded-10 > div.flex.flex-col.gap-y-30.rounded-10.bg-primary.pb-20 > div:nth-child(5)")); // Replace with actual class
	 
	        if (ratingOptions.size() == 0) {
	            throw new RuntimeException(" No rating options found using CSS Selector.");
	        }
	 
	        Random rand = new Random();
	        int index = rand.nextInt(ratingOptions.size());
	 
	        WebElement selectedOption = ratingOptions.get(index);
	selectedOption.click();
	 
	        System.out.println("Selected Random Rating using CSS: " + selectedOption.getText());
	 
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Failed to select rating using CSS: " + e.getMessage());
	    }
	}
	 

	// Scroll to Star Rating section
	public void scrollToStarRatingFilter() {
		try {
			WebElement starRating = wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[7]/p")));
			js.executeScript("arguments[0].scrollIntoView(true);", starRating);
			Thread.sleep(1000);
			System.out.println("Scrolled to Star Rating section");
		} catch (Exception e) {
			System.out.println("Scroll to Star Rating failed: " + e.getMessage());
		}
	}
	public void selectStarRating(){
	    try {
	        Thread.sleep(2000); // Wait for rating options to be visible
	 
	        // Use CSS selector to fetch all rating filter elements
	        List<WebElement> ratingOptions = driver.findElements(By.cssSelector("body > div.min-w-1336 > div:nth-child(2) > div.container.flex.items-start.gap-x-20 > div.sticky.z-\\[99\\].flex-shrink-0.rounded-10 > div.flex.flex-col.gap-y-30.rounded-10.bg-primary.pb-20 > div:nth-child(7)")); // Replace with actual class
	 
	        if (ratingOptions.size() == 0) {
	            throw new RuntimeException(" No rating options found using CSS Selector.");
	        }
	 
	        Random rand = new Random();
	        int index = rand.nextInt(ratingOptions.size());
	 
	        WebElement selectedOption = ratingOptions.get(index);
	selectedOption.click();
	 
	        System.out.println("Selected Random Rating using CSS: " + selectedOption.getText());
	 
	        Thread.sleep(2000);
	    } catch (Exception e) {
	        System.out.println("Failed to select rating using CSS: " + e.getMessage());
	    }
	}


	// Wait for hotel list to refresh
	public void waitForHotelResultsToUpdates() {
		try {
			Thread.sleep(3000);
			System.out.println("Waited for hotel results to update");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	
	
	
	//=======================================Scenario-5 Methods==========================================
	
	
	
	// Click the "Book Now" button on the first hotel result
	public void clickFirstBookNowButton() {
		try {
			By bookNowBtn = By.xpath("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/a[1]/div/div[1]/div[3]/button");
			WebElement bookNow = wait.until(ExpectedConditions.elementToBeClickable(bookNowBtn));
			js.executeScript("arguments[0].click();", bookNow);
			System.out.println("Clicked on Book Now for first hotel");
			Thread.sleep(3000); // Let the page load
		} catch (Exception e) {
			System.out.println("X Failed to click Book Now: " + e.getMessage());
		}
	}

	// Validate redirection to reservation page
	
	public boolean isOnReservationPage() {
	    try {
	        String currentUrl = driver.getCurrentUrl();
	        System.out.println("Current URL: " + currentUrl);
	        
	        // Check if the URL contains "hotels"
	        return currentUrl.contains("/hotels/");
	        
	    } catch (Exception e) {
	        System.out.println("Failed to verify reservation page: " + e.getMessage());
	        return false;
	    }
	}
	 
	
	

	// ==================================== Scenario-6 (Negative Scenario)===========================================

	
	 public void selectTodayAsCheckInDate() {
		 try { 
			
			
			 WebElement date = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
						"/html/body/main/div[4]/div[2]/div/div[2]/div[1]/div/input")));
			 date.click();
			 
			 
			 WebElement checkIn =
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[13]"))); 
			 checkIn.click();
			  
	 } catch (Exception e) { System.out.println("Failed to select today: " +e.getMessage()); } }
	 
	  public void selectSameDateAsCheckOut() { 
		  try {
	  WebElement checkOut =
	 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/main/div[4]/div[2]/div/div[2]/div[3]/div/div[1]/div/div[2]/div[1]/div/div/div[2]/button[13]" )));
	 
	 checkOut.click(); 
	 
		  } catch (Exception e) {
	 System.out.println("Failed to select same check-out date: " +
	 e.getMessage()); } }
	
	 
	  
	  public void takesscreen() {
		    try {
		        TakesScreenshot ts = (TakesScreenshot) driver;
		        File src = ts.getScreenshotAs(OutputType.FILE);
		 
		        String dest = "C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\Screenshot\\" + System.currentTimeMillis() + ".png";
		        FileUtils.copyFile(src, new File(dest));
		 
		        System.out.println("Screenshot saved at: " + dest);
		    } catch (Exception e) {
		        System.out.println("Failed to take screenshot: " + e.getMessage());
		    }
		}
	 

}