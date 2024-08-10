@test5
Feature: Navigation and Interaction on Magnus Website

  Scenario: Navigate and interact with menu options
    Given I am on the Magnus home page
    When I navigate to the "More" options
    Then I print all options under "More"
    When I click on the "Menu" option
    And I click on the "Testing" option
    And I click on the "Links" option
    And I click on the "Images" option
    Then I should be on the respective pages
