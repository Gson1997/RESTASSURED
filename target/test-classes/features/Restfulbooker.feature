Feature: Restfulbooker

  @POST
  Scenario Outline: Create Booking
    Given I create the request body with <firstname> <lastname> <totalprice> <depositpaid> <checkindate> <checkoutdate> <additionalneeds>
    When I hit "CreateBooking" API using "POST" method
    Then I validate the status code with "200"
    And validate whether "firstname" in the response is the same as <firstname>
    And validate whether "lastname" in the response is the same as <lastname>

    Examples: 
      | firstname | lastname   | totalprice | depositpaid | checkindate  | checkoutdate | additionalneeds |
      | "Murali"  | "krishnan" | "100"      | "true"      | "2020-01-01" | "2019-01-01" | "yes"           |
      | "Mohan"   | "krishnan" | "100"      | "false"     | "2020-01-01" | "2019-01-01" | "yes"           |

  @GET
  Scenario: Get Booking
    Given I create "GET" request with placeID
    When I hit "GetBooking" API using "GET" method
    Then I validate the status code with "200"

  @PUT
  Scenario Outline: Put Booking
    Given I create the request body with <firstname> <lastname> <totalprice> <depositpaid> <checkindate> <checkoutdate> <additionalneeds>
    And I create "PUT" request with placeID
    When I hit "UpdateBooking" API using "PUT" method
    Then I validate the status code with "403"

    Examples: 
      | firstname | lastname   | totalprice | depositpaid | checkindate  | checkoutdate | additionalneeds |
      | "Murali"  | "krishnan" | "100"      | "true"      | "2020-01-01" | "2019-01-01" | "yes"           |

  @DELETE
  Scenario: Delete Booking
    Given I create "DELETE" request with placeID
    When I hit "DeleteBooking" API using "DELETE" method
    Then I validate the status code with "403"
