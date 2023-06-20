@Booking
Feature: Verifying Adactin Hotel Booking details

  Scenario Outline: Verifying adactin hotel Booking details
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User continue with select hotel
    Then User should verify after continue success message "Book A Hotel"
    When User enter booking details "<firstName>","<lastName>" and "<address>"
      | ccNum            | ccType           | ccExpMonth | ccExpYear | ccCvv |
      | 1235467895213450 | VISA             | July       |      2022 |   236 |
      | 5456987258145623 | Master Card      | May        |      2021 |   564 |
      | 4456987258145623 | American Express | August     |      2020 |   586 |
    Then User should verify after enter book now success message "Booking Confirmation" and save the orderId

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild | firstName | lastName   | address             |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   | Praveen   | kumarasamy | mettukuppam,chennai |

  Scenario Outline: Verifying adactin hotel without enter Booking details
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User search hotel "<location>","<hotels>","<roomType>","<numOfRooms>","<checkInDate>","<checkOutDate>","<noOfAdults>" and "<noOfChild>"
    Then User should verify after search hotel success message "Select Hotel"
    When User continue with select hotel
    Then User should verify after continue success message "Book A Hotel"
    When User click book now button without enter booking details
    Then User should verify after click book now button error message contains "Please Enter your First Name","Please Enter you Last Name","Please Enter your Address","Please Enter your 16 Digit Credit Card Number","Please Select your Credit Card Type","Please Select your Credit Card Expiry Month" and "Please Enter your Credit Card CVV Number"

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   |
