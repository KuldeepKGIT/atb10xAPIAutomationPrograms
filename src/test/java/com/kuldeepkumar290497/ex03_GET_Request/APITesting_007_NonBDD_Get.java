package com.kuldeepkumar290497.ex03_GET_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_007_NonBDD_Get {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    @Description("Verify the Positive GET request")
    public void test_nonBDD_GET(){
r = RestAssured.given();
r.baseUri("https://api.zippopotam.us");
r.basePath("/IN/110048");           //part 1

        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(200);

    }

    @Description("Verify the Negative GET request")
    @Test
    public void test_nonBDD_GET_negative(){
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/$");
        response = r.when().log().all().get();
        vr = response.then().log().all().statusCode(404);
    }
}
