Feature: Remove Products from the Shopping Cart Function


  Scenario: Verify the user can remove products from the landing page and reflected successfully in shopping cart
    Given I have navigated to saucedemo website
    And  I enter the required fields and press Login
    And  By adding some products, the number of products displayed in the shopping cart should equal to the added number of products
    When I make sure that Remove buttons are displayed
    Then By removing these products, the shopping cart should be empty