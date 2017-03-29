@sko
Feature: Check Perfecto PM site
  #Sample Test Scenario Description

  @sko
  Scenario: send details
    Given I open browser to webpage "http://www.google.com"
    Then I open browser to webpage "http://ec2-54-175-223-15.compute-1.amazonaws.com/perfecto-rwd/contact.php"
    Then I check window "Perfecto Test Home"
     And I enter "Uzi" to "name"
    And I enter "Uzi@perfecto.com" to "email"
    And I enter "Perfecto!!!" to "msg"
    Then I click on "send"
    Then I click on "main"
    Then I go to services menu
    Then I click on "servicesPage"
    Then I check window "Perfecto Test Services"
    #Then I must see text "PERFECTO SVS"
