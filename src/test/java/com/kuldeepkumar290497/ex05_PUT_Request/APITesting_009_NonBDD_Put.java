package com.kuldeepkumar290497.ex05_PUT_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_009_NonBDD_Put {
@Description("Verify the Put Request for restful Booker API")
    @Test
    public void Test_Put_request_nonBDD(){
    String Token = "fe3a5721647026a";
    String bookingId = "1585";
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

    RequestSpecification requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking/"+bookingId);
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token",Token);
    //requestSpecification.auth().basic("sajsks","dgdgaigd");
            requestSpecification.body(payload).log().all();

    Response response = requestSpecification.when().put();

    ValidatableResponse vr = response.then().log().all();
    vr.statusCode(200);

}
}
