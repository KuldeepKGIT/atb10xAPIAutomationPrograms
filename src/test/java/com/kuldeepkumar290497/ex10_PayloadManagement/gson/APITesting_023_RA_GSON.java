package com.kuldeepkumar290497.ex10_PayloadManagement.gson;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting_023_RA_GSON {
    // GSON - is Google Lib - which will convert your class to JSON
    // JSON to class -
    // JSON - is a plain text in key and value pair to transfer from client to server.
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void Test_Post_CreateBooking(){
// Step2 - POST
    // URL -> Base URI + base Path
    // HEADER
    // BODY
    // Auth - NO

    // Step 1
    // prepare the Payload ( Object -> JSON String)
    // send the request

    //Step 3
    // Validate Response ( JSON String -> Object)
    // FirstName,
    // Status Code
    // Time Response
        Booking booking  = new Booking();
        booking.setFirstname("Kuldeep");
        booking.setLastname("Kumar");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-01");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        // Java Object -> JSON
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        response = requestSpecification.when().post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Case1 - extract() - Direct Extraction
        String firstname1 = response.then().extract().path("booking.firstname");
        System.out.println(firstname1);

        Assert.assertEquals(firstname1,"Kuldeep"); //Hard assertions

        assertThat(firstname1).isNotEmpty().isNotNull().isNotBlank().isEqualTo("Kuldeep");

        // Case 2 - jsonPath.getString("")  JSON Path Extraction
        JsonPath jsonPath = new JsonPath(response.asString());
        String bookingId = jsonPath.getString("bookingid");
        String Firstname = jsonPath.getString("firstname");
        String checkin = jsonPath.getString("booking.bookingdates.checkin");
        System.out.println(bookingId);
        System.out.println(Firstname);
        System.out.println(checkin);

        String jsonResponseString1  = response.asString();

        // Server - JSONString> Java Object( BookingResponse) - getter to verify

        // Case 3 - DeSer - Extraction
        //  Response - De Ser another Response Class

        BookingResponse bookingResponse = gson.fromJson(jsonResponseString1, BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());

        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Pramod").isNotNull().isNotEmpty();


    }

}
