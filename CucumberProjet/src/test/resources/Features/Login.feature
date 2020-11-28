Feature: LoginFeature

	Background: User should be logged in
		Given I am on Orange HRM login screen
    When I enter usename and password
    And I click login button
    
	@SmokeTest @POM
  Scenario: Verify login for Orange HRM website 
   Then I should be able to login successfully

  @SmokeTest @POM
    Scenario: Verify homepage
    Then I shoud able to see homepage 