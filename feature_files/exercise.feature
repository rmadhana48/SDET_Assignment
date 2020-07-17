@CreateCourse
Feature: Elearning Create a course
  I want to use this template for my feature file

  @Createacourse
  Scenario: TO verify whether application allows admin to create course
    Given I launch the application
    Then I enter the username "admin" and password "admin@123"
    When I click the Create a Course link
    And Enter valid credential in Title textbox
    And Enter valid credential in code textbox
    Then I click on create course button
