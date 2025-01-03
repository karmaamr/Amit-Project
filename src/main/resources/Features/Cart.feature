# Created by XEON STORE at 1/2/2025
Feature: Shopping Cart Functionality

  Scenario: Verify that the user can log in, add products to the cart, and complete a purchase
    Given the user logs in with username karma and password karma123
    When the user adds the first product to the cart
    And the user navigates to the homepage
    And the user adds the second product to the cart
    Then the cart should contain the correct products with prices
    And the user completes the purchase with name "Karma Amr", country "Egypt", city "Cairo", card "1234567812345678", month "12", and year "2025"