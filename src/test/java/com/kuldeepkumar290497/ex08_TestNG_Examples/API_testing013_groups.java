package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;

public class API_testing013_groups {
    @Test(groups = {"reg","sanity"},priority = 3)
    public void Test_sanity(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(false);
    }
    @Test(groups = {"p1","reg"},priority = 2)
    public void Test_regression(){
        System.out.println("Reg");
        Assert.assertTrue(false);
    }
    @Test(groups = {"p1","reg"},priority = 1)
    public void Test_Smoke(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
