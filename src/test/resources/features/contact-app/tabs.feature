Feature: As a user I expect to be able to switch between tabs

  @smoke
  @regression
    Scenario: As a user I expect to be able to open, close, and switch between tabs
    Given I am on the "Home" page
    Then the "contacts header" should contain the text "Conta"
    Then the "contacts header" should not contain the text "Bloop bloop"
    Then the "contacts header" should equal the text "Contacts"
    Then the "contacts header" should not equal the text "contact"
    When I click the "playground button"
    Then I am redirected to the "Playground" page
    And I click the "new tab button" the "Home" page is opened in a new tab
    When I click the "playground button"
    When I switch to the "1st" tab
    And I click the "header logo"
    Then I am redirected to the "Home" page
    When I click the "create button"
    Then I am redirected to the "CreateContact" page


