Feature: Logout Function


  Scenario: Verify the user can logout successfully
    Given I have navigated to saucedemo website
    And  I enter the required fields and press Login
    When I am in Landing page, and I press logout
    Then The user should be logged out successfully

