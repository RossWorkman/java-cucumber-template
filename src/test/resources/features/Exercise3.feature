Feature: Trainline Search
  As a Trainline user
  I want to be able to search for journeys from Brighton to London
  So that I can find a range of train tickets to book.

  @smoke
  Scenario Outline: Trainline search
    Given I'm on the https://www.thetrainline.com/ main page
    When I enter the origin station <originStation>
    And I enter the destination station <destinationStation>
    And I select return
    And I select Tomorrow and Next day
    And I click search button
    Then the train times should be displayed
    And I should have option to change my choices

    Examples:
      | originStation   |   destinationStation     |
      | "Brighton"      |   "London"               |