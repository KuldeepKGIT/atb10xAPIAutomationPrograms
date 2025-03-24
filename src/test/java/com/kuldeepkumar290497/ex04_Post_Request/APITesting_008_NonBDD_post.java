package com.kuldeepkumar290497.ex04_Post_Request;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class
APITesting_008_NonBDD_post {
    RequestSpecification R;
    Response response;
    ValidatableResponse vr;
    @Test
    @Description("Verify Post request: Create token")
    public void Test_post_NonBDD_CreateToken(){
        // URL, Method, Payload/ body / headers
        // Auth?
String payload = "{\n" +
        "    \"username\" : \"admin\",\n" +
        "    \"password\" : \"password123\"\n" +
        "}";
//Preconditions
R = RestAssured.given();
R.baseUri("https://restful-booker.herokuapp.com");
R.basePath("/auth");
R.contentType(ContentType.JSON);
R.body(payload);

//Making the request
response = R.when().log().all().post();
//Verification Part
vr = response.then().log().all();
        vr.statusCode(200);
    }

}
