Feature: Ixigo Bus Search Module

  

  Background:
    Given User is on the Bus search page

  @log1
  Scenario: User enters source, destination, selects date, and searches for buses
    When I enter  as the source city 
    And I enter   as the destination city
    And I select a travel date
    And I click on the Search button
    Then I should see a list of available bus options

  @log2
  Scenario Outline: User enters source, selects date and searches for buses without destination
    When I enter the source city from excel with "<RowIndex>"
    And I click on the Search button
    Then I should see an error message
    
    Examples:
    |RowIndex|
    |1       |

  @partialText
  Scenario: Verify Partial Name Suggestion on results page
    When I enter  as the source city
    And I enter  as the destination cy
    And I select a travel date
    And I click on the Search button
    And the user types a partial city name in the From Station field
    And the user types a partial city name in the To Station field
    Then the system should display suggestions for cities in the From Station field
    And the system should display suggestions for cities in the To Station field
    
    #Examples:
    #|source| destination|
    #|pun | mum|
    
	@selectSeat
	Scenario: User searches buses and selects seats
    When I enter  as the source city
    And I enter  as the destin city
    And I select travel date 
    And I click on the Search button
    And I click on Show Seats for the first bus
    And I select a seat
    And I select a boarding point
    And I select a dropping point
    And I click on Continue after seat selection
    Then I should proceed to booking page

   @filters
    Scenario: Apply filters and sort on Ixigo results page
      When I enter  as the source city
      And I enter  as the destination 
      And I select a travel date
      And I click on the Search button
      And I apply the AC bus filter
      And I apply the Sleeper bus filter
      And I apply the LowestPrice bus filter
      And I apply the seats bus filter
      And I apply the ratings bus filter
      And I apply the Arrival Time bus filter
      And I apply the Departure Time bus filter
      Then I should see filtered and sorted results
    
