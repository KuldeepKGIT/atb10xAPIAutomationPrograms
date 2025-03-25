package com.kuldeepkumar290497.ex09_Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.assertj.core.api.Assertions.*;

public class APITesting_021_Assertj {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
    Response response;
    String token;
    Integer bookingId;

    @Test
    public void test_POST() {

        String payload_POST = "{\n" +
                "    \"firstname\" : \"Kuldeep\",\n" +
                "    \"lastname\" : \"Kumar\",\n" +
                "    \"totalprice\" : 123,\n" +
                "    \"depositpaid\" : false,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2024-01-01\",\n" +
                "        \"checkout\" : \"2024-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Lunch\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload_POST).log().all();

        Response response = requestSpecification.when().post();


        // Get Validatable response to perform validation
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Rest Assured -> import org.hamcrest.Matchers;
        // Matchers.equalto()

        validatableResponse.body("booking.firstname", Matchers.equalTo("Kuldeep"));
        validatableResponse.body("booking.lastname",Matchers.equalTo("Kumar"));
        validatableResponse.body("booking.depositpaid",Matchers.equalTo(false));
        validatableResponse.body("bookingid",Matchers.notNullValue());

        // TestNG Assertions
        // SoftAssert vs
        // HardAssert -
        // This means that if any assertion fails,
        // the remaining statements in that test method will not be executed.
        bookingId = response.then().extract().path("bookingid");
        String firstname = response.then().extract().path("booking.firstname");

        //hardAssertions
        Assert.assertNotNull(bookingId);
        Assert.assertEquals(firstname,"Kuldeep");

        //SoftAssertions
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(firstname,"Kuldeep");
        softAssert.assertAll();

        //AssertjAssertions
        assertThat(bookingId).isNotNull().isNotZero().isPositive();
        assertThat(firstname).isEqualTo("Kuldeep").isNotEmpty();


    }
}


