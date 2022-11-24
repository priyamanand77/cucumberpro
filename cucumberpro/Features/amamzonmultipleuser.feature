

@tag
Feature: To check end to end functionality of Amazon website

  @tag1
  Scenario Outline: Login and Add to cart Functionality
    Given Chrome browser shuould open and User navigates to the Amaazon page
    When User Gives email <email> and password <pass>
    And User Adds Three Item into the Cart 
    And USer Clicks on Show Cart 
    Then User Should land on Cart Page

    Examples: 
      | email  										| pass						  | 
      | "7436873429"						  |     "xxxxxxxxx" | 
      | "priyamanand77@gmail.com" |     "xxxxxxxxx" | 
