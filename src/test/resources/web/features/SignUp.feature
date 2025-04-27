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

  Scenario Outline: SignUp Success
    Given the user is on the main page
    When the user click sign up
    And the user enters "<test_type>" username "<username>" and password "<password>"
    And clicks the sign up button
    Then the success message should be displayed

    Examples:
      | test_type | username | password |
      | valid     | random   | random   |

  Scenario Outline: SignUp Failed
    Given the user is on the main page
    When the user click sign up
    And the user enters "<test_type>" username "<username>" and password "<password>"
    And clicks the sign up button
    Then the error message "<message>" should be displayed

    Examples:
    | test_type | username | password | message |
    | invalid   |          | fhbyduji | Please fill out Username and Password. |
    | invalid   | random   |          | Please fill out Username and Password. |
    | invalid   |          |          | Please fill out Username and Password. |
    | existing  | existing_user | fhbyduji | This user already exist.          |
