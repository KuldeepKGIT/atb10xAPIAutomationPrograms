package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class API_testing_AllAnotation {
    // PUT Request -
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT ( which will use the above two methods)
    // 4. closeAllThings
    @BeforeTest
    public void Test_GetToken(){
        System.out.println("1");
    }
    @BeforeTest
    public void Test_GetBookingId(){
        System.out.println("2");
    }
    @Test
    public void Test_Put(){
        System.out.println("3");
    }
    @AfterTest
    public void ClosAllThings(){
        System.out.println("close");
    }
}
