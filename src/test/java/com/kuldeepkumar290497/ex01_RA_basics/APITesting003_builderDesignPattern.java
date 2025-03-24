package com.kuldeepkumar290497.ex01_RA_basics;

public class APITesting003_builderDesignPattern {
    public APITesting003_builderDesignPattern Step1(){
        System.out.println("Step1");
        return this;
    }
    public APITesting003_builderDesignPattern Step2(){
        System.out.println("Step2");
        return this;
    }
    public APITesting003_builderDesignPattern Step3(String s){
        System.out.println(s);
        return this;
    }

    public static void main(String[] args) {
        APITesting003_builderDesignPattern ref = new APITesting003_builderDesignPattern();
        ref.Step1().Step2().Step3("Kuldeep");

    }
}
