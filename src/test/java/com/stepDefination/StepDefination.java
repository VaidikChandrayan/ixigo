package com.stepDefination;

//import com.pageFa.IxigoBusSearchPage;
import com.pages.BasePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
 
public class StepDefination {
 
    WebDriver driver;
    BasePage busSearchPage;
 
    @Given("User is logged into Ixigo application")
    public void user_is_logged_into_ixigo_application() {
        // Placeholder for login logic if needed
    }
 
    @Given("User is on the Bus search page")
    public void user_is_on_the_bus_search_page() {
        driver = new ChromeDriver();
        busSearchPage = new BasePage(driver);
        busSearchPage.openWebsite();
    }
 
    @Given("I open the Ixigo bus website")
    public void i_open_the_ixigo_bus_website() {
        driver = new ChromeDriver();
        busSearchPage = new BasePage(driver);
        busSearchPage.openWebsite();
    }
 
    @When("I enter {string} as the source city")
    public void i_enter_as_the_source_city(String city) {
        busSearchPage.enterSourceCity(city);
    }
 
    @When("I enter {string} as the destination city")
    public void i_enter_as_the_destination_city(String city) {
        busSearchPage.enterDestinationCity(city);
    }
 
    @When("I select a travel date")
    public void i_select_a_travel_date() {
        busSearchPage.selectTravelDate(); // Add logic when implemented
    }
 
    @When("I click on the Search button")
    public void i_click_on_the_search_button() {
        busSearchPage.clickSearch();
    }
 
    @Then("I should see a list of available bus options")
    public void i_should_see_a_list_of_available_bus_options() {
        // Add validations or assertions here
    }
}


