Feature: Trainline Search
  As a Trainline user
  I want to be able to search for journeys from Brighton to London
  So that I can find a range of train tickets to book.

  @smoke
  Scenario Outline: Trainline search
    Given I'm on https://www.thetrainline.com/ main page
    When I enter origin station <originStation>
    And I enter destination station <destinationStation>
    And I click search
    Then train times <trainTimes> should be displayed

    Examples:
      | originStation   |   destinationStation     | trainTimes     |
      | "Brighton"      |   "London"               | #tickets       |