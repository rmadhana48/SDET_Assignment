@ELSC_010
Feature: ELearning Testcase 10
  I want to use this template for my feature file

  @Scenario1
  Scenario: TO verify whether application allows admin to create an user & register user to the courseTitle of your scenario
    Given User should have launched the application
    And User should get logged in as admin "admin" and password "admin@123"
    And Admin has already created course
    When User Click on Administration tab
    And User Click on Add a user link
    And Enter valid credential in First name textbox "manzoor"
    And Enter valid credential in Last name textbox "mehadi"
    And Enter valid credential in e-mail textbox "manzoor@gmail.com"
    And Enter valid credential in phone textbox "9876543210"
    And Enter valid credential in Login textbox "manzoor1232"
    And Click on Enter password radio button
    And Enter valid credential in password textbox "manzoor"
    And Select Valid credentials from profile list box "Trainer"
    And Click on Add button
    And Click on Administration link
    And Click on Add users to course link
    And select user from the user list "manzoor1232"
    And select course from the course list "ELSC10Course"
    And click on Add to the course button
		Then Validate the message displayed