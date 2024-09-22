@smoke
Feature: Create a new course

  Scenario Outline: Create a new course on Winjigo website
    Given login with email "<email>" and password "<pass>"
    When navigate to the courses page
    And create a course with name "<courseTitle>"
    Then user should see the course title "<courseTitle>" displayed in the courses list

    Examples:
      | email                | pass       | courseTitle |
      | testregister@aaa.com | Wakram_123 | 1TestingCourse5631 |
