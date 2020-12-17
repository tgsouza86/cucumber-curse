Feature: Login Funtionality
	  In order to do internet banking
	  As a valid Para Bank customer
	  I want to login sucessfully

  Scenario: Login Successful
   Given I am in the login page of the Para Bank Application
   When I enter valid credentials
   Then I shoud be taken to the Overview page
   
   Scenario Outline: Login Successful
   Given I am in the login page of the Para Bank Application
   When I enter valid <username> and <password>
   Then I shoud be taken to the Overview page
   
   Examples:
   |username|password|
   |"autotester"| "password"|
   |"tautester"| "password"|
   
   Scenario: Login Successful - Inline Parameters

   Given I am in the login page of the Para Bank Application
   When I enter valid credentials
   |autotester|password|
   Then I should be taken to the Overview page
   
   
    Scenario Outline: Login Successful
   Given I am in the login page of the Para Bank Application
   When I enter valid <username> and <password> with <userFullName>
   Then I shoud be taken to the Overview page
   
   Examples:
   |username|password|userFullName|
   |"autotester"| "password"|Auto Tester|
   |"tautester"| "password"|Tau Tester|
   
   

