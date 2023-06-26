Feature: As a user I expect to be able to switch between tabs

  @smoke
  @regression
  Scenario: As a user I expect to be able to see the header logo
    Given I am on the "Home" page
    Then "50" "contact item"s should be displayed
    When I type "Juarez" in the "search input"
    Then "1" "contact item" should be displayed
    When I type "Scooby Dooby Doo" in the "search input"
    Then "0" "contact item"s should be displayed