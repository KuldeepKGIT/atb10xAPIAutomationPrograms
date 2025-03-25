package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class API_testing015_parameter {
    @Parameters("browser")
    @Test
    public void demo1(String value) {
        System.out.println("Demo 1 TC");

        if(value.equalsIgnoreCase("chrome")){
            System.out.println("Start the Chrome Browser");
        }
        if(value.equalsIgnoreCase("firefox")){
            System.out.println("Start the Firefox Browser");
        }

    }

}
