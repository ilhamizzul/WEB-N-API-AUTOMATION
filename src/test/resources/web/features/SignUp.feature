Feature: SignUp

  Scenario: Open signup modal
    Given the user is on the main page
    When the user click sign up
    Then sign up modal will be shown

#  Scenario: Close signup modal
#    Given the user is on the main page
#    When the user click sign up
#    And user cancel the sign up process
#    Then sign up modal will be closed

  Scenario Outline: Failed SignUp
    Given the user is on the main page
    When the user click sign up
    And the user enters "<test_type>" username "<username>" and password "<password>"
    And clicks the sign up button
    Then the error message "<message>" should be displayed

    Examples:
    | test_type | username | password | message |
#    | valid     | random   | random   | Sign up successful.                    |
    | invalid   |          | fhbyduji | Please fill out Username and Password. |
    | invalid   | random   |          | Please fill out Username and Password. |
    | invalid   |          |          | Please fill out Username and Password. |
