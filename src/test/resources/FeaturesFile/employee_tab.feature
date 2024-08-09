Feature: Employee Tab functionality

  Scenario: Enter employee details and save
    Given I am on the Magnus employee tab page
    When I enter first name as "John"
    And I enter last name as "Doe"
    And I enter email as "johndoe@jalaacademy.com"
    And I enter mobile number as "1234567890"
    And I select date of birth as "01-01-1990"
    And I select gender as "Male"
    And I enter address as "123 Main St"
    And I select country as "India"
    And I select city as "Hyderabad"
    And I enter skills as "Java, Selenium"
    And I click on the save button
    Then I should see a success message "Employee details saved successfully"

  Scenario: Display error message on not filling mandatory fields
    Given I am on the Magnus employee tab page
    When I leave mandatory fields empty
    And I click on the save button
    Then I should see error messages indicating missing fields

  Scenario: Check cancel button
    Given I am on the Magnus employee tab page
    When I click on the cancel button
    Then I should see the form reset or be redirected to the previous page

  Scenario: Check for deleting employee
    Given I am on the Magnus employee list page
    When I click on the delete button for an employee
    Then I should see a confirmation message "Are you sure you want to delete?"
    When I confirm deletion
    Then the employee should be removed from the list
