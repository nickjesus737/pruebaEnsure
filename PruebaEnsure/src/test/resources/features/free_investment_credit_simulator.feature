Feature: Free Investment Credit Simulator
  As a web user
  I want to simulate a free investment credit
  So that I can test the Screenplay Ensure tool

  Scenario: The user checks that the fee is not greater than $800.000 pesos
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He makes a simulation with 10000000 of loan, 18 years old and 24 months of term
    Then He should see that the fee are not greater than 800000

  Scenario: The user checks that the maximum date of birth to select is before the actual date
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He selects the maximum date in the calendar
    Then He should see that the date selected is before the actual date

  Scenario: The user checks that the simulate button text is in upper case
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He clicks on the si option
    Then He should see that the simulate button text is in upper case

  Scenario: The user checks that the fees have the correct values
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He makes a simulation with 10000000 of loan, 18 years old and 24 months of term
    Then He should see that the fees values are
    |$486,579|
    |$483,727|
    |$551,667|

  Scenario: The user checks the fees first values
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He makes a simulation with 10000000 of loan, 18 years old and 24 months of term
    Then He should see that the fees firts value is
      |$486,579|

  Scenario: The user checks the fees last values
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He makes a simulation with 10000000 of loan, 18 years old and 24 months of term
    Then He should see that the fees last value is
      |$551,667|

  Scenario: The user checks that the fees text do not have blank spaces
    Given The actor "client" is in the Bancolombia Free Investment Credit Simulator page
    When He makes a simulation with 10000000 of loan, 18 years old and 24 months of term
    Then He should see that the fees text do not have blank spaces