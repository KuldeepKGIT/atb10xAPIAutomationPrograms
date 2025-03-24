package com.kuldeepkumar290497.ex01_RA_basics;

public class APITesting002_NoDesign {
    public void step1(){
        System.out.println("Step 1");
    }
    public void step2(){
        System.out.println("Step 2");
    }
    public  void step3(String s){
        System.out.println(s);
    }

    public static void main(String[] args) {
        APITesting002_NoDesign One = new APITesting002_NoDesign();
        System.out.println("No design pattern");
        One.step1();
        One.step2();
        One.step3("Kuldeep");
    }
}
