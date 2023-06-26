Feature: As a user I expect to be able to be able to edit contacts

  @smoke
  @regression
  Scenario: As a user I expect to be able to edit contacts
    Given I am on the "Home" page
    Then a "contact item" with the "name" "Alvin Hamilton" should be displayed
    Then a "contact item" with the "name" "Alvinssss Hamilton" should be displayed
