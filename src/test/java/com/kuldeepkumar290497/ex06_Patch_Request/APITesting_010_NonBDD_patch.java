package com.kuldeepkumar290497.ex06_Patch_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_010_NonBDD_patch {
    @Description("Verify the Put Request for restful Booker API")
    @Test
public void Test_Put_request_nonBDD(){
  String Token = "a64f907e39d19ef";
    String bookingId = "1";
    String payload = "{\n" +
            "    \"firstname\" : \"Kuldeep\",\n" +
            "    \"lastname\" : \"Brown\"\n" +
            "}";

    RequestSpecification requestSpecification = RestAssured.given();
    requestSpecification.baseUri("https://restful-booker.herokuapp.com");
    requestSpecification.basePath("/booking/"+bookingId);
    requestSpecification.contentType(ContentType.JSON);
    requestSpecification.cookie("token",Token);
    requestSpecification.body(payload).log().all();

    Response response = requestSpecification.when().patch();

    ValidatableResponse vr = response.then().log().all();
    vr.statusCode(200);

}
}

