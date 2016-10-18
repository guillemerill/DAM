package com.Discografia;


import java.util.ArrayList;

/**
 * Created by DAM on 20/9/16.
 */
public class Discografia {

    private static ArrayList<Disco> misDiscos;

    public static void main(String[] args) {
        misDiscos = new ArrayList<Disco>();
    }

    private void mostrarMenu() {
        System.out.println("***** Discografía *****");
        System.out.println("1. Alta disco");
        System.out.println("Modificar disco");
    }
}
