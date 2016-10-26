package com.EjemploLambdas;

public class EjemploLambdas {
    public static void main(String[] args) {
        ITallaString talla = (palabra)->{
            return palabra.substring(0, 3);
        };
        System.out.println(talla.tallaString("hola"));

        ISumaNumero suma = (num1, num2)->{
            return num1 + num2;
        };
        System.out.println(suma.sumaNumbers(2, 2));

        IReadNumero read = (num)->{
            try {
                int ret = Integer.parseInt(num);
            } catch (Exception e) {
                return "ERROR";
            }
            return num;
        };
        System.out.println(read.readNumber("7"));
    }
}
