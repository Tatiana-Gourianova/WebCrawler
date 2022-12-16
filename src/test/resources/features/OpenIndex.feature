Feature: As a user I want to get anability to use WebCrawler

  @smoke
    Scenario: Index page should be displayed
    When the user opens index page
    Then page with Webcrawler title is displayed
