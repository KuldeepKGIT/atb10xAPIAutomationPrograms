package com.kuldeepkumar290497.ex10_PayloadManagement;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_022_Payload_map {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    String Token;
    Integer bookingId;

    @Test
    public void Test_Post(){
        Map<String,Object> payloadMap = new LinkedHashMap<>();
        payloadMap.put("firstname", "Kuldeep");
        payloadMap.put("lastname", "Kumar");
        payloadMap.put("totalprice", 123);
        payloadMap.put("depositpaid", false);

        Map<String,Object> bookingDatesMap = new LinkedHashMap<>();
        bookingDatesMap.put("checkin", "2018-01-01");
        bookingDatesMap.put("checkout","2019-01-01");

        payloadMap.put("bookingdates",bookingDatesMap);
        System.out.println(payloadMap );

    }
}
