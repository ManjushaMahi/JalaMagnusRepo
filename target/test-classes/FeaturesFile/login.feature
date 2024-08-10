@test1
Feature: Login functionality

  Scenario: Successful login with valid credentials
    Given I am on the Magnus login page
    When I enter username as "training@jalaacademy.com" and password as "jobprogram"
    And I click on the login button
    Then I should be redirected to the dashboard

  Scenario: Login failure with invalid credentials
    Given I am on the Magnus login page
    When I enter username as "invalid@jalaacademy.com" and password as "wrongpassword"
    And I click on the login button
    Then I should see an error message "Invalid credentials"

  Scenario: Login failure with empty fields
    Given I am on the Magnus login page
    When I leave the username and password fields empty
    And I click on the login button
    Then I should see an error message "Please enter username and password"

  Scenario: Login with admin credentials
    Given I am on the Magnus login page
    When I enter username as "admin@jalaacademy.com" and password as "adminpassword"
    And I click on the login button
    Then I should be redirected to the admin dashboard

  Scenario: Logout scenario
    Given I am logged into the Magnus application
    When I click on the logout button
    Then I should be redirected to the login page
