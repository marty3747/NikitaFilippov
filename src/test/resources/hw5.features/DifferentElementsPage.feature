Feature: Interacting with UI elements on Different Elements page. Page feature for exercise #1.
  Scenario: Interact with the elements and check Logs section
    Given I open JDI GitHub site on 'Home Page'
    And I login as user Roman Iovlev
    When I click on "Service" button in Header
    And I click on 'Different elements' button in Service dropdown
    And I select 'Water' checkbox on Different Elements Page
    And I select 'Wind' checkbox on Different Elements Page
    And I select 'Selen' radio on Different Elements Page
    And I select 'Yellow' color in dropdown on Different Elements Page
    Then There are 4 logs in Log section on Different Elements Page
    And There is 'Colors: value changed to Yellow' text in the row #1
    And There is 'metal: value changed to Selen' text in the row #2
    And There is 'Wind: condition changed to true' text in the row #3
    And There is 'Water: condition changed to true' text in the row #4