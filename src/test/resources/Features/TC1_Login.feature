@Login
Feature: Verifying Adactin Hotel login details
  
  @smoke
  Scenario Outline: Verifying Adactin Hotel login valid
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"

    Examples: 
      | userName      | password   |
      | TamilSiva5674 | Tamil@5674 |

  Scenario Outline: Verifying Adactin Hotel login using Enter
    Given User is on the adactin page
    When User perform login "<userName>","<password>" with Entry Key
    Then User should verify after login success message "Hello TamilSiva5674!"

    Examples: 
      | userName      | password   |
      | TamilSiva5674 | Tamil@5674 |

  Scenario Outline: Verifying Adactin Hotel login using Invalid credentials
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login with invalid credentials error message contains "Invalid Login details or Your Password might have expired."

    Examples: 
      | userName     | password   |
      | Greens8767fb | Tamil@5674 |
