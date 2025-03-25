package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.annotations.Test;

public class API_testing_017_invocation {
    @Test (invocationCount = 5)
    public void Test_invocation(){
        System.out.println("test");
    }
}
