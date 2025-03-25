package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.annotations.Test;

public class APITesting_Priority {
    @Test(priority = 3)
    public void T1(){
        System.out.println("1");
    }
    @Test(priority = 1)
    public void T2(){
        System.out.println("2");
    }
    @Test(priority = 2)
    public void T3(){
        System.out.println("3");
    }
}
