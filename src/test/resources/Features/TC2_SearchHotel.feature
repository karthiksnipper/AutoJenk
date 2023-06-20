@Search
Feature: Verifying Adactin Hotel Search details

  Scenario Outline: Verifying Adactin Hotel search by selecting all fields with valid details
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   |

  Scenario Outline: Verifying Adactin Hotel search with mandatory fields
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search only mandatory fields "<location>","<numOfRooms>","<checkInDate>","<checkOutDate>" and "<noOfAdults>"
    Then User should verify after search hotel success message "Select Hotel"

    Examples: 
      | userName      | password   | location  | numOfRooms | checkInDate | checkOutDate | noOfAdults |
      | TamilSiva5674 | Tamil@5674 | Melbourne | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    |

  Scenario Outline: Verifying Adactin Hotel by checking invalid date details
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search invalid checkin date and checkout date "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel error message contains "Check-In Date shall be before than Check-Out Date" and "Check-Out Date shall be after than Check-In Date"

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 11/06/2023  | 10/06/2023   | 2 - Two    | 2 - Two   |

  Scenario Outline: Verifying Adactin Hotel search without enter any fields
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search without enter any fields
    Then User should verify after search with error message contains "Please Select a Location"

    Examples: 
      | userName      | password   |
      | TamilSiva5674 | Tamil@5674 |
