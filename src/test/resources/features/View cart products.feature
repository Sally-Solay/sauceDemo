Feature: View products in the shopping cart


  Scenario: Verify the added products are the same ones exits in the shopping cart
    Given I have navigated to saucedemo website
    And  I enter the required fields and press Login
    When Add some products and by checking the shopping cart
    Then The added products should be the same ones displayed in the shopping cart