Feature: As a user I expect to be able to add a new contact and search for it

  @smoke
  @regression
  Scenario: As a user I expect to be able to add and search for new contacts
    Given I am on the "Home" page
    When I type "Robbalicious Rex" in the "search" input
    Then "0" "contact item"s should be displayed
    When I click the "create button"
    Then I am redirected to the "CreateContact" page
    When I type "Robbalicious Rex" in the "name" input
    And I type "0123456789" in the "phone" input
    And I type "12 My Street" in the "street" input
    And I type "Guisborough" in the "city" input
    And I select "Male" in the "gender" dropdown
    And I click the "save button"
    Then I am redirected to the "Home" page
    And I type "Robbalicious Rex" in the "search" input
    Then "1" "contact item" should be displayed

