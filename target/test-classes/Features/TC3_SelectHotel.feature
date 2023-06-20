@Select
Feature: Verifying Adactin Hotel Select details

  Scenario Outline: Verifying adactin hotel select details
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User continue with select hotel
    Then User should verify after continue success message "Book A Hotel"

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   |

  Scenario Outline: Verifying adactin hotel without select any hotels
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User continue without select hotel
    Then User should verify after continue error message contains "Please Select a Hotel"

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   |
