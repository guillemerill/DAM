package com.LambdaExample;


public class CountString implements ICountString {

    @Override
    public String count(String palabra) {
        return "La longitud es de: " + palabra.length();
    }
}
