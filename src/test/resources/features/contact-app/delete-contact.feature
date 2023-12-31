Feature: As a user I expect to be able to delete contacts

  @smoke
  @regression
  Scenario: As a user I expect to be able to delete existing contacts
    Given I am on the "Home" page
    Then a "contact item" with the "name" "Alvin Hamilton" should be displayed
    When on the "contact item" I click on the "delete button"
    When I type "Alvin Hamilton" in the "search" input
    Then "0" "contact item"s should be displayed