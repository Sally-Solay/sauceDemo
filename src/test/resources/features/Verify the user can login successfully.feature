Feature: Login Function


  Scenario: Verify the user can login successfully
    Given I have navigated to saucedemo website
    When  I enter the required fields and press Login
    Then I should be logged in successfully

