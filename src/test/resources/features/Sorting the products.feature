Feature: Sorting Products Alphabetically

@Sort
  Scenario: Verify sorting Alphabetically function
    Given I have navigated to saucedemo website
    And  I enter the required fields and press Login
    When I select sorting from Z to A
    Then I should see the displayed products sorted successfully