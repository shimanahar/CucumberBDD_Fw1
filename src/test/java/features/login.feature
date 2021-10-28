Feature: Login Feature Test

  @login @smoke @regression @prePost
  Scenario: Login with valid email and password
    Given I am at TalentTEK Homepage
    And I enter a valid email address
    And I enter a valid password
    When I click on Login Button
    Then I should be able to successfully log in