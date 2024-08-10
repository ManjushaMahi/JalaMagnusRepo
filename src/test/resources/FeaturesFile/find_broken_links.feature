@test6
Feature: Find all broken links on Magnus website

  Scenario: Validate all links on the Magnus home page
    Given I am on home page for finding the broken links
    Then I should find all broken links on the page
