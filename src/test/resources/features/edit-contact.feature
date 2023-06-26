Feature: As a user I expect to be able to be able to edit contacts

  @smoke
  @regression
  Scenario: As a user I expect to be able to edit contacts
    Given I am on the "Home" page
    Then a "contact item" with the "name" "Alvin Hamilton" should be displayed
    And the "gender value" on the aforementioned "contact item" should be "Male"
