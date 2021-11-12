Feature: Sign up

  @qa @prePost @signup
  Scenario: Student should be able to register with valid info
    Given I am at TalentTEK Homepage
    And I click Create New Account Button in Login Page
    And I enter valid student information
    When I click on Create my account button
    Then  I should see Thank you for sign up message

