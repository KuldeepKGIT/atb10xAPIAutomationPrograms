package com.kuldeepkumar290497.ex08_TestNG_Examples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class API_Testing016_Enabled {
    @Test
    public void test01() {
        Assert.assertTrue(true);
    }

    @Test(enabled = false)
    public void test02() {
        Assert.assertTrue(true);
    }

    @Test
    public void test03() {
        Assert.assertTrue(true);
    }
}
