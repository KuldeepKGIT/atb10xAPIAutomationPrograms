package com.kuldeepkumar290497.ex10_PayloadManagement.jackson;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import com.fasterxml.jackson.core.JsonProcessingException;
import static org.assertj.core.api.Assertions.*;



public class APITesting_024_RA {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void Test_CreateBooking_jackson(){
        Booking booking = new Booking();
        booking.setFirstname("Kuldeep");
        booking.setLastname("Kumar");
        booking.setTotalprice(111);
        booking.setDepositpaid(false);

        Bookingdates bookingdates =new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-10");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("breakfast");
        System.out.println(booking);

        String jsonStringBooking;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            jsonStringBooking = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        System.out.println(jsonStringBooking);
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        response =requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        BookingResponse bookingResponse = null;
        try {
            bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
        System.out.println(bookingResponse.getBooking().getLastname());
        assertThat(bookingResponse.getBookingid()).isNotZero().isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Kuldeep").isNotNull().isNotEmpty();
    }
}
