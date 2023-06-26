Feature: As a user I expect to be able to delete contacts

  @smoke
  @regression
  Scenario: As a user I expect to be able to delete existing contacts
    Given I am on the "Home" page
    When I type "Shaggy Doo" in the "search" input
    Then "0" "contact item"s should be displayed

    When I click the "create button"
    Then I am redirected to the "CreateContact" page
    When I type "Shaggy Doo" in the "name" input
    And I select "Male" in the "gender" dropdown
    And I type "0123456789" in the "phone" input
    And I type "12 Scooby Street" in the "street" input
    And I type "Somewhere Ville" in the "city" input
    And I click the "save button"
    Then I am redirected to the "Home" page

    When I type "Shaggy Doo" in the "search" input
    Then "1" "contact item"s should be displayed

    When I click the "delete button"
    And I accept the alert
    When I type "Shaggy Doo" in the "search" input
    Then "0" "contact item"s should be displayed