Feature: Find all broken links on Magnus website

  Scenario: Validate all links on the Magnus home page
    Given I am on the Magnus home page
    Then I should find all broken links on the page
