# Created by XEON STORE at 12/29/2024
Feature: Login Feature
  # Enter feature description here

  Scenario: User Login successfully
    # Enter steps here
    Given user opens Demoblaze homepage and click on Login button
    When user enters valid user name and valid password and click on login button
    Then user should see a welcome message with the valid username