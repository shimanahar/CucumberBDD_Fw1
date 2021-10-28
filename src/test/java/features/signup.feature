Feature: Sign up

  @qa @prePost
  Scenario: Student should be able to register with valid info
    Given I am at TalentTEK Homepage
    And I click Create New Account Button in Login Page
    And I enter valid student information
    When I click on Create my account button
    Then I should see Thank you for sign up message

  @qa
  Scenario: Student should be able to register with valid info
    Given I am at TalentTEK Homepage
    And I click Create New Account Button in Login Page
    And I enter valid student information
    When I click on Create my account button
    Then I should see Thank you for sign up message

  @dev
  Scenario: Student should be able to register with valid info
    Given I am at TalentTEK Homepage
    And I click Create New Account Button in Login Page
    And I enter valid student information
    When I click on Create my account button
    Then I should see Thank you for sign up message