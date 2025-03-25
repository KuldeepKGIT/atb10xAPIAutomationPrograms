package com.kuldeepkumar290497.ex09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import org.hamcrest.Matchers;

public class APITesting019_RA_assertions {
RequestSpecification requestSpecification;
Response response;
ValidatableResponse validatableResponse;
//Integer BookingId;
//String Token;
@Test
public void Test_Post_request(){
    String payload = "{\n" +
            "    \"firstname\" : \"Kuldeep\",\n" +
            "    \"lastname\" : \"Kumar\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";
    requestSpecification = RestAssured.given();
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking");
    requestSpecification.body(payload).log().all();

    response = requestSpecification.when().post();

    validatableResponse = response.then().log().all();
    validatableResponse.statusCode(200);

    // Rest Assured -> import org.hamcrest.Matchers;

    validatableResponse.body("booking.firstname", Matchers.equalTo("Kuldeep"));
    validatableResponse.body("booking.lastname", Matchers.equalTo("Kumar"));
    validatableResponse.body("booking.depositpaid", Matchers.equalTo(true));
    validatableResponse.body("bookingid", Matchers.notNullValue());

}
}
