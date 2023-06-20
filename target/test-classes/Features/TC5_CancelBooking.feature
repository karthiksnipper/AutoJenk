@CancelBooking
Feature: Verifying Adactin Hotel Booking Cancel details

  Scenario Outline: Verifying adactin hotel Booking cancel
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
      | 5456987258145623 | American Express | August     |      2020 |   586 |
    Then User should verify after enter book now success message "Booking Confirmation" and save the orderId
    When User cancel the booking order id
    Then User should verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName      | password   | location  | hotels      | roomType | numOfRooms | checkInDate | checkOutDate | noOfAdults | noOfChild | firstName | lastName   | address             |
      | TamilSiva5674 | Tamil@5674 | Melbourne | Hotel Creek | Standard | 2 - Two    | 10/06/2023  | 11/06/2023   | 2 - Two    | 2 - Two   | Praveen   | kumarasamy | mettukuppam,chennai |

  Scenario Outline: Verifying Adactin hotel cancel existing booking
    Given User is on the adactin page
    When User perform login "<userName>","<password>"
    Then User should verify after login success message "Hello TamilSiva5674!"
    When User cancel existing order id "<orderId>"
    Then User should verify after cancel order id success message "The booking has been cancelled."

    Examples: 
      | userName      | password   | orderId    |
      | TamilSiva5674 | Tamil@5674 | WAHV6H7011 |
