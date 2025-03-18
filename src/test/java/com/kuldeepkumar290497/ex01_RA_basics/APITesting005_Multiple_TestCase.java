package com.kuldeepkumar290497.ex01_RA_basics;

import io.restassured.RestAssured;

public class APITesting005_Multiple_TestCase {
    public static void main(String[] args) {

            String pincode = "110048";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                    .when()
                    .get()
                    .then()
                    .log().all().statusCode(200);


            pincode = "@";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/IN/"+pincode)
                    .when()
                    .get()
                    .then()
                    .log().all().statusCode(200);



            pincode = " ";
            RestAssured
                    .given()
                    .baseUri("https://api.zippopotam.us")
                    .basePath("/USA/"+pincode)
                    .when()
                    .get()
                    .then()
                    .log().all().statusCode(200);




        }
    }


