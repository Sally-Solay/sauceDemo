Feature: Checkout of empty cart


  Background:
    Given I have navigated to saucedemo website

  @checkout
  Scenario: Checkout of empty cart
    Given  I enter the required fields and press Login
    And  I Navigate to the shopping cart
    When I fill the required fields and press checkout
    Then I should see the checkout overview and finish the process

  @checkout
  Scenario: Cancel Checkout of empty cart
    Given I enter the required fields and press Login
    And  I Navigate to the shopping cart
    When I fill the required fields and press checkout
    Then I should see the checkout overview and cancel the process

