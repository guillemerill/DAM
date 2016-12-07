package com.Lambdas.EjemploLambdas;


import java.io.BufferedReader;
import java.io.InputStreamReader;

public class UtilizaLambdas {
    public static void main(String[] args) {
        ITallaString tallaString = (text) -> {
            return text.substring(0, 3);
        };

        ISumaNumero sumaNumero = (num1, num2) -> {
            return num1 + num2;
        };

        IReadNumero readNumero = () -> {
            do {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    System.out.println("Introduce un número");
                    int numero = Integer.parseInt(br.readLine());
                    return numero;
                } catch (Exception e) {
                }
            } while (true);

        };

        System.out.println(tallaString.tallaString("Hola"));
        System.out.println(sumaNumero.sumaNumbers(2, 5));
        System.out.println(readNumero.readNumber());
    }
}
