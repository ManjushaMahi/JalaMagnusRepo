@test2
Feature: Admin Login functionality

  Scenario: Click on admin login tab and enter valid credentials
    Given I am on the Magnus login page
    When I click on the admin login tab
    And I enter admin email or mobile as "admin@jalaacademy.com" and password as "adminpassword"
    And I click on the sign in button
    Then I should be redirected to the admin dashboard

  Scenario: Admin login failure with invalid credentials
    Given I am on the Magnus login page
    When I click on the admin login tab
    And I enter admin email or mobile as "invalid@jalaacademy.com" and password as "wrongpassword"
    And I click on the sign in button
    Then I should see an error message "Invalid admin credentials"

  Scenario: Check back button
    Given I am on the Magnus admin login page
    When I click on the back button
    Then I should be redirected to the main login page
