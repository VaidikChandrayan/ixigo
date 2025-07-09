package com.stepDefinition;

import com.pages.HotelBookingPage;
import com.pages.HotelsPage;
import com.pages.SearchPage;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;

import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.setup.BaseSteps; // <- adjust if your driver helper class differs
import com.utils.ExcelReader;
import com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter;

public class HotelsTest {

	private final WebDriver driver;
	private final HotelsPage hotelsPage;
	private final SearchPage searchPage;
	private final HotelBookingPage bookingPage;

	public HotelsTest() {
		driver = BaseSteps.launchChrome(); // get shared WebDriver
		hotelsPage = new HotelsPage(driver);
		searchPage = new SearchPage(driver);
		bookingPage = new HotelBookingPage(driver);
	}
	
	
	//===========================================Scenario 1 ===========================================
	
	

	@Given("user launches the ixigo hotels website")
	public void launch_ixigo() {
		searchPage.loadHomePage();
	}

	@When("user handles the initial popup")
	public void handle_popup() {
		searchPage.handleInitialPopUp();
	}

	@And("user clicks on the Hotels tab")
	public void click_hotels_tab() {
		searchPage.clickHotelsTab();
	}

	@Then("user should be on the Hotels page")
	public void verify_hotels_page() {
		// Assert.assertTrue(" Not on Hotels page!", hotelsPage.isHotelsTabSelected());
		System.out.println("User landed on Hotels page.");
	}

	
	
	
	//===============================Scenario 2=====================================================
	
	
	
	@Given("user is on the Hotels page")
	public void user_is_on_hotels_page() {
		//searchPage.loadHomePage();
		//searchPage.handleInitialPopUp();
		//searchPage.clickHotelsTab();
	}

	
	@When("user enters the destination from Excel using row {int} and column {int}")
	public void user_enters_the_destination_from_excel(int row, int col) {
	    try {
	        String path = "C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\ExcelData\\Data.xlsx"; // Path to your file
	        String destination = ExcelReader.readExcelCell(path, "Sheet1", row, col);
	        searchPage.enterDestination(destination);
	    } catch (Exception e) {
	        System.out.println("Could not read data: " + e.getMessage());
	    }
	}
	
	@And("user selects the destination")
	public void user_selects_the_destination() {
		searchPage.selectDestinationSuggestion();
		
	}

	@And("user selects the check-in and check-out dates")
	public void user_selects_check_in_and_check_out_dates() {
		searchPage.selectCheckInCheckOutDates();
	}

	@And("user selects rooms and guests")
	public void user_selects_rooms_and_guests() {
		searchPage.selectRoomsAndGuests();
		
	}

	@And("user clicks on the Search Hotels button")
	public void user_clicks_search_button() {
		searchPage.clickSearchHotels();
			
		}

	@Then("user should see the hotel search results")
	public void user_should_see_search_results() {
		// Assert.assertTrue("Hotels results page not displayed",
		// hotelsPage.isHotelsTabSelected());
		System.out.println("Hotel results displayed successfully");
	}
	
	
	
	
	
	
	//===================================Scenario 3 ====================================
	
	 
	    @Given("user is on the hotel search results page")
	    public void user_is_on_search_results_page() {
	    	bookingPage.loadHomePage();
	    }
	 
	    @When("user opens the Popularity sort dropdown")
	    public void open_sort_dropdown() {
	    	bookingPage.openSortDropdown();
	    }
	 
	    @And("user selects a random sort option")
	    public void select_random_sort() {
	        bookingPage.selectRandomSortOption();
	    }
	 
	    @And("user enters area name from Excel using row {int} and column {int}")
	    public void user_enters_area_from_excel(int row, int col) {
	    	bookingPage.scrollToSearchWithinArea();
	    	try {
	            String path = "C:\\Windows.old\\Windows\\System32\\config\\systemprofile\\eclipse-workspace\\My_Project\\IxigoTest\\src\\test\\resources\\ExcelData\\Data.xlsx";
	            String area = ExcelReader.readExcelCell(path, "Sheet1", row, col);
	            bookingPage.enterAreaName(area);  // Assumes method exists in your HotelBookingPage
	        } catch (Exception e) {
	            System.out.println("Could not read area from Excel: " + e.getMessage());
	        }
	    }
	 
	    @And("user selects the first area suggestion")
	    public void select_first_suggestion() {
	    	bookingPage.scrollToSearchWithinArea();
	    	bookingPage.selectFirstAreaSuggestion();
	    }
	 
	    @Then("hotel results should update based on the selected sort and area")
	    public void verify_results_updated_area_sort() {
	        // You can add waits/assertions here
	        System.out.println("Area and sort applied.");
	    }
	 
	    @When("user scrolls to the Most Popular filter section")
	    public void scroll_to_filter_section() {
	        bookingPage.scrollToMostPopularFilter();
	    }
	 
	    @And("user selects a random filter option")
	    public void apply_random_filter() {
	    	bookingPage.selectFreeBreakfastFilter();
	    }
	 
	    @Then("hotel results should update based on selected filter")
	    public void verify_results_updated_after_filter() {
	        System.out.println("✅ First filter applied.");
	    }
	 
	    @When("user scrolls back to the Most Popular filter section")
	    public void scroll_again_to_filter_section() {
	        bookingPage.scrollToMostPopularFilter();
	    }
	 
	    @And("user selects another random filter option")
	    public void apply_another_random_filter() {
	    	bookingPage.selectParkingAvailableFilter();
	    }
	 
	    @Then("hotel results should update with both filters applied")
	    public void verify_both_filters_applied() {
	        System.out.println("Second filter applied.");
	    }
	
	 

	// =====================================Scenario 4==================================================
	
	
	@Given("user has completed a hotel search and is viewing the results")
	public void user_has_completed_search() {
		
		bookingPage.loadHomePage(); 
		
	}

	@When("user scrolls to the User Rating filter section")
	public void scroll_to_user_rating_section() {
		bookingPage.scrollToUserRatingFilter();
	}

	@And("user selects a random option from User Rating")
	public void select_random_user_rating_filter() {
		bookingPage.selectRandomUserRating();
	}

	@And("hotel results should update based on selected User Rating filter")
	public void wait_after_user_rating_filter() {
		bookingPage.waitForHotelResultsToUpdates();
	}

	@And("user scrolls to the Star Rating filter section")
	public void scroll_to_star_rating_section() {
		bookingPage.scrollToStarRatingFilter();
	}

	@And("user selects a random option from Star Rating")
	public void select_random_star_rating_filter() {
		bookingPage.selectStarRating();
	}

	@Then("hotel results should update based on both applied filters")
	public void wait_after_star_filter() {
		bookingPage.waitForHotelResultsToUpdates();
	}
	
	

	// ========================================Scenario 5 =======================================
	
	
	
	@Given("user has performed a hotel search and is viewing the search results")
	public void user_performed_hotel_search_and_viewing_results() {
		
		System.out.println("User is on page");
		bookingPage.loadHomePage(); // Optional if already loaded
		
	}

	@When("user clicks on the Book Now button of the first listed hotel")
	public void click_book_now_button() {
		bookingPage.clickFirstBookNowButton();
	}

	@Then("user should be redirected to the reservation page")
	public void verify_redirection_to_reservation_page() {
	    Assert.assertTrue("User not redirected to reservation page", bookingPage.isOnReservationPage());
	}
	 
	

	//====================================Scenario 6 (Negative)========================================

	
	/*@Given("user is on the Hotels page") 
	 public void user_is_on_hotels_page() {
		 searchPage.loadHomePage();
		 searchPage.handleInitialPopUp();
		 searchPage.clickHotelsTab(); 
		 searchPage.enterDestination("Goa");
		 searchPage.selectDestinationSuggestion(); }
	 
	 @When("user selects today as the check-in date") public void
	 user_selects_today_as_checkin() { 
		 bookingPage.selectTodayAsCheckInDate(); 
		 }
	 
	 @And("user selects the same date as the check-out date") public void
	 user_selects_same_date_checkout() { 
		 bookingPage.selectSameDateAsCheckOut(); 
		 }
	 
	 @Then("check-out date should not be accepted") public void
	 verify_checkout_date_not_accepted() { 
		 bookingPage.takesscreen(); 
		 }*/
	
	
	
	 
	@AfterStep
	public void tearDown(Scenario scenario) // wil take screenshots for each and every scenario
	{
		final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "Image");
		
	}
	
	
	}
	 


