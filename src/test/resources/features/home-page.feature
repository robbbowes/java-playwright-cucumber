Feature: As a user I expect to be able to navigate to the home page

  @smoke
  @regression
    Scenario: As a user I expect to be able to see the header logo
    Given I am on the "Home" page
    Then the "contacts header" should contain the text "Contacts"