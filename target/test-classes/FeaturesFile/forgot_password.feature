Feature: Forgot Password functionality

  Scenario: Enter valid email
    Given I am on the Magnus forgot password page
    When I enter email as "validemail@jalaacademy.com"
    And I click on the get password button
    Then I should see a confirmation message "Password reset link sent to your email"

  Scenario: Enter invalid email
    Given I am on the Magnus forgot password page
    When I enter email as "invalidemail@jalaacademy.com"
    And I click on the get password button
    Then I should see an error message "Email not found"

  Scenario: Enter empty email
    Given I am on the Magnus forgot password page
    When I leave the email field empty
    And I click on the get password button
    Then I should see an error message "Please enter your email"

  Scenario: Check back button
    Given I am on the Magnus forgot password page
    When I click on the back button
    Then I should be redirected to the login page
