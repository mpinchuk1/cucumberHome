Feature: MyFeature
  Scenario: Logo in header has valid link
    Given I open the browser
    When I open Epam website
    Then Logo in header should be clickable

  Scenario: "How we do it" header is visible and has valid text
    Given I open the browser
    When I open How we do it page
    Then How we do it title should be visible and has valid text

  Scenario: Search button at the header is visible
    Given I open the browser
    When I open Epam website
    Then Search button at the header should be visible

  Scenario: I press Tab on the main page, cookies banner button "here" has valid href
    Given I open the browser
    When I open Epam website
    When Press Tab
    Then Cookies banner button here has valid href

  Scenario: Rollover tiles block is visible at the main page
    Given I open the browser
    When I open Epam website
    Then Rollover tiles block should be visible

  Scenario: Main should be visible at the main page
    Given I open the browser
    When I open Epam website
    Then Main is visible

  Scenario: In this section on Our work page is not visible
    Given I open the browser
    When I open Our work page
    Then In this section is not visible

  Scenario: Filter by on Our work page has valid text
    Given I open the browser
    When I open Our work page
    Then Filter by should have valid text