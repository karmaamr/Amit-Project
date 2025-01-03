# Created by XEON STORE at 12/26/2024
Feature: SignUp Feature
  # Enter feature description here

  Scenario: User SignUp Successfully
    Given user opens Demoblaze homepage and click on Sign Up button
    When user enters valid user name and valid password and click on Sign Up button
    Then the Sign Up Successful message should be displayed
