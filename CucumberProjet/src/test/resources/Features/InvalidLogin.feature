Feature: InvaliedLogin

  @SmokeTest
  Scenario Outline: Verify invalid login functionality
    Given I am on Orange HRM login screen
    When I enter invalid <username> and <password>
    And I click login button
    Then I should get the <errormessage>

    Examples: 
      | username | password | errormessage             |
      | Mamun    |          | Password cannot be empty |
      |          | Mamun123 | Username cannot be empty |
      | Mamun    | Mamun123 | Invalid credentials      |