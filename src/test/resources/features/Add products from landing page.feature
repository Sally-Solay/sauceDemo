Feature: Add Products to the Shopping Cart Function

@loog
  Scenario: Verify the user can add products from the landing page and displayed successfully in shopping cart
    Given I have navigated to saucedemo website
    And  I enter the required fields and press Login
    When I should be logged in successfully
    Then By adding some products, the number of products displayed in the shopping cart should equal to the added number of products