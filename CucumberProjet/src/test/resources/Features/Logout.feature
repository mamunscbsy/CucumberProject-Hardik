Feature: LogoutFeature

  Background: User should be logged in
    Given I am on Orange HRM login screen
    When I enter usename and password
    And I click login button

  @WIP @SmokeTest
  Scenario: Verify logout
    When I click on logout
    Then I should be logout successfully