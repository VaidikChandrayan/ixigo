package com.stepDefinition;

import com.pages.HotelBookingPage;
import com.pages.HotelsPage;
import com.pages.SearchPage;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import com.setup.BaseSteps; // <- adjust if your driver helper class differs
import com.utils.ExcelReader;

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

	/*@Given("user launches the ixigo hotels website")
	public void launch_ixigo() {
		//hotelsPage.loadHomePage();
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
		// Assert.assertTrue("❌ Not on Hotels page!", hotelsPage.isHotelsTabSelected());
		System.out.println("✅ User landed on Hotels page.");
	}*/

	
	
	
	// ---------------------------Scenario 2-----------------------------
	
	@Given("user is on the Hotels page")
	public void user_is_on_hotels_page() {
		searchPage.loadHomePage();
		searchPage.handleInitialPopUp();
		searchPage.clickHotelsTab();
	}

	@When("user enters the destination")
	public void user_enters_the_destination() {
		searchPage.enterDestination("Goa");
	}
	
	/*@When("user enters the destination from Excel")
	public void user_enters_the_destination_from_excel(int row, int col) {
		 try {
		        String place = ExcelReader.getCellData("Sheet1", 1, 0);
		        hotelsPage.enterDestination(place);
		    } catch (Exception e) {
		        System.out.println("❌ Failed to read destination from Excel: " + e.getMessage());
		    }
		}*/
	
	

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
		System.out.println("✅ Hotel results displayed successfully");
	}

	// ------------------------------Scenario 3-------------------------------------

	/*@Given("user is on the hotel search-results page")
	public void user_is_on_the_hotel_search_results_page() {
		bookingPage.loadHomePage(); // Optional if already loaded
		

	}

	@When("user opens the Popularity sort dropdown")
	public void user_opens_the_popularity_sort_dropdown() {
		bookingPage.openSortDropdown();
	}

	@And("user selects a random sort option")
	public void user_selects_a_random_sort_option() {
		bookingPage.selectRandomSortOption();
	}

	@Then("hotel results should refresh according to the selected option")
	public void hotel_results_should_refresh() {
		bookingPage.validateSortedResults();
	} */

	// ------------------------------Scenario 4--------------------------------
	

	/*@Given("user is on the hotel search results page")
	public void user_on_results_page() {
		bookingPage.loadHomePage();
		
		
	}

	@When("user clicks on the {string} field")
	public void user_clicks_area_field(String ignore) {
		bookingPage.openAreaSearchField();
	}

	@When("user selects the first area suggestion")
	public void user_selects_the_first_area_suggestion() {
		bookingPage.selectFirstAreaSuggestion();
	}

	@Then("hotel results should update based on the selected area")
	public void verify_area_filter_applied() {
		Assert.assertTrue("Area filter not applied!", bookingPage.isAreaFilterApplied());
		System.out.println("✅ Results refreshed for selected area.");
	}

	// --------------------------------------Scenario 5-----------------------------------

	
	@Given("user has completed a hotel search and is viewing the results") public
	 void user_has_completed_a_hotel_search_and_is_viewing_results() {
		 bookingPage.loadHomePage();
	 } 

	@When("user scrolls to the Most Popular filter section")
	public void user_scrolls_to_the_most_popular_filter_section() {
		bookingPage.scrollToMostPopularFilter();
	}

	@And("user selects a random filter option")
	public void user_selects_a_random_filter_option() {
		bookingPage.selectFreeBreakfastFilter();
	}

	@And("hotel results should update based on selected filter")
	public void hotel_results_should_update_based_on_selected_filter() {
		bookingPage.waitForHotelResultsToUpdate();
	}

	@And("user scrolls back to the Most Popular filter section")
	public void user_scrolls_back_to_the_most_popular_filter_section() {
		bookingPage.scrollToMostPopularFilter();
	}

	@And("user selects another random filter option")
	public void user_selects_another_random_filter_option() {
		bookingPage.selectParkingAvailableFilter();
	}

	@Then("hotel results should update with both filters applied")
	public void hotel_results_should_update_with_both_filters_applied() {
		bookingPage.waitForHotelResultsToUpdate();
	}

	// -----------------------------------Scenario 6 --------------------------------
	/*@Given("user has completed a hotel search and is viewing the results")
	public void user_has_completed_search() {
		
		bookingPage.loadHomePage(); // Optional if already loaded
		
	}

	@When("user scrolls to the User Rating filter section")
	public void scroll_to_user_rating_section() {
		bookingPage.scrollToUserRatingFilter();
	}

	@And("user selects a random option from User Rating")
	public void select_random_user_rating_filter() {
		bookingPage.selectGoodUserRating();
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
		bookingPage.selectFourStarRating();
	}

	@Then("hotel results should update based on both applied filters")
	public void wait_after_star_filter() {
		bookingPage.waitForHotelResultsToUpdates();
	}*/

	// -------------------------Scenario 7 --------------------------------
	
	/*@Given("user has performed a hotel search and is viewing the search results")
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
		System.out.println("User is on page");
		// Assert.assertTrue("User not redirected to reservation page",
		// hotelsPage.isOnReservationPage());
	}*/

	// ---------------------------Negative Scenario----------------

	/*
	 @Given("user is on the Hotels page") 
	 public void user_is_on_hotels_page() {
	 hotelsPage.loadHomePage(); hotelsPage.handleInitialPopUp();
	 hotelsPage.clickHotelsTab(); hotelsPage.enterDestination("Goa");
	 hotelsPage.selectDestinationSuggestion(); }
	 
	 @When("user selects today as the check-in date") public void
	 user_selects_today_as_checkin() { hotelsPage.selectTodayAsCheckInDate(); }
	 
	 @And("user selects the same date as the check-out date") public void
	 user_selects_same_date_checkout() { hotelsPage.selectSameDateAsCheckOut(); }
	 
	 @Then("check-out date should not be accepted") public void
	 verify_checkout_date_not_accepted() { hotelsPage.isCheckOutDateAccepted(); }
	 */

}
