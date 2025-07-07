Feature: Ixigo Bus Search Module
 
Background:
     
     Given User is on the Bus search page
     

  @log1
  Scenario: User enters source, destination, selects date, and searches for buses
    
    When I enter data as the source city
    And I enter data as the destination city
    And I select a travel date
    And I click on the Search button
    Then I should see a list of available bus options


 @log2
 Scenario: User enters source,seelcts dateand searches for buses
   
   When I enter data as the source city
  And I click on the Search button
   Then I should see an erorr message
 
    
@partialText
Scenario: Verify Partial Name Suggestion
  When the user types a partial city name in the From Station field
  And the user types a partial city name in the To Station field
  Then the system should display suggestions for cities in the From Station field
  And the system should display suggestions for cities in the To Station field
    