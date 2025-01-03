# Created by XEON STORE at 1/2/2025
Feature: Add products to cart

Feature: Add Products to Cart

  Scenario: Add Sony Vaio i5 to cart
    Given user is on the homepage
    When user navigates to Laptops category and adds Sony Vaio i5 to the cart
    Then the product "Sony Vaio i5" should be added to the cart successfully

  Scenario: Add Apple Monitor 24 to cart
    Given user is on the homepage
    When user navigates to Monitors category and adds Apple Monitor 24 to the cart
    Then the product "Apple Monitor 24" should be added to the cart successfully