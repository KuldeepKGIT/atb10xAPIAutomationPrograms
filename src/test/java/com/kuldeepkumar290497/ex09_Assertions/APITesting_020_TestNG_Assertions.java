package com.kuldeepkumar290497.ex09_Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_020_TestNG_Assertions {
    @Test
    public void Test_hardAssertion(){
        System.out.println("Start the program");
        boolean isNeeruMale = false;
        Assert.assertEquals("kuldeep","Kuldeep");
        System.out.println("End of the program");
    }
    @Test
    public void Test_Soft_Assertion(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(false);
        System.out.println("End of the program");
        softAssert.assertAll();
    }
}
