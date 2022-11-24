#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: Login and Add to cart functionality
 
  @tag1
  Scenario: To test the end to end scenerio of user from login to add to cart
    Given Chrome Browser Should Open
    And Login Credentions would be entered
    When Login credentials are correct 
    And User Lands on the Home Page
    And User Selects three Item
    And Adds then into the cart 
    And User Clicks on Show Cart 
    Then User Should land to Add to cart Page
   

