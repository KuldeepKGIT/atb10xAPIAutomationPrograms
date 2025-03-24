package com.kuldeepkumar290497.ex07_Delete_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_011_Delete_request_nonBDD {
    @Description("Deleting a booking")
    @Test
    public void test_delete_request(){
        String Token = "7c6bc6cc9b9d27e";
        String bookingId ="4557";
        RequestSpecification requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking/"+bookingId);
        requestSpecification.cookie("token",Token);
        requestSpecification.contentType(ContentType.JSON);

        Response response = requestSpecification.when().delete();

        ValidatableResponse validatableResponse = response.then().log().all();
                validatableResponse.statusCode(201);
    }
}
