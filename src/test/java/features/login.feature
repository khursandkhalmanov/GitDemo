
@tag
Feature: Login into Application
  

  @tag1
  Scenario Outline: Positive test validating login
    Given Initialize the browser with chrome
    And Navigate to "http://qaclickacademy.com" Site
    And Click on Login link in home page to land on Secure sighn in Page
    When User enters <Username> and <Password> and logs in
    Then Verify that user successfully logged in
    And Close browsers
    
  Examples:
  |Username |Password |
  |nonrestricteduser@qw.com |12345 |
  |test99@gmail.com |1234 |
  |restricteduser@gmail.com |123 |
  


