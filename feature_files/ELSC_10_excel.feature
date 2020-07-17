@ELSC_010_excel
Feature: ELearning Testcase 10
  I want to use this template for my feature file

  @Scenario1
  Scenario: TO verify whether application allows admin to create an user & register user to the courseTitle of your scenario
    Given User should have launched the application excel
    And User should get logged in as admin "admin" and password excel "admin@123"
    When User Click on Administration tab excel
    And User Click on Add a user link excel
    And Enter valid credential in First name textbox excel
    And Enter valid credential in Last name textbox excel
    And Enter valid credential in e-mail textbox excel
    And Enter valid credential in phone textbox excel
    And Enter valid credential in Login textbox excel
    And Click on Enter password radio button excel
    And Enter valid credential in password textbox excel 
    And Select Valid credentials from profile list box excel
    And Click on Add button excel
    And Click on Administration link excel
    And Click on Add users to course link excel
    And select user from the user list excel "manzoor1232"
    And select course from the course list excel "ELSC10Course"
    And click on Add to the course button excel
		Then Validate the message displayed excel