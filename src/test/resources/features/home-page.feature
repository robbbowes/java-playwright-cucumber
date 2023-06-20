Feature: As a user I expect to be able to navigate to the home page

  @smoke
  @regression
    Scenario: As a user I expect to be able to see the header logo
    Given I am on the "Home" page
    Then the "contacts header" should contain the text "Conta"
    Then the "contacts header" should not contain the text "Bloop bloop"
    Then the "contacts header" should equal the text "Contacts"
    Then the "contacts header" should not equal the text "contact"
    When I click the "playground button"
    Then I am redirected to the "Playground" page
    And I click the "new tab button" a new tab is opened
    When I switch to the "2nd" tab