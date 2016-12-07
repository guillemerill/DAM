package com.Lambdas.Zoo;

import java.util.ArrayList;


public class LambdasZoo {
    public static void main(String[] args) {
        Animal a1 = new Animal(true, true, true, true);
        Animal a2 = new Animal(true, false, true, false);
        Animal a3 = new Animal(false, true, false, true);

        checkAtribut checkSalta = (a)->{
            if (a.potSaltar()) {
                System.out.println(" pot saltar");
            } else {
                System.out.println(" no pot saltar");
            }
        };
        checkAtribut checkNada = (a)->{
            if (a.potNadar()) {
                System.out.println(" pot nadar");
            } else {
                System.out.println(" no pot nadar");
            }
        };
        checkAtribut checkVola = (a)->{
            if (a.potVolar()) {
                System.out.println(" pot volar");
            } else {
                System.out.println(" no pot volar");
            }
        };
        checkAtribut checkCamina = (a)->{
            if (a.potCaminar()) {
                System.out.println(" pot caminar");
            } else {
                System.out.println(" no pot caminar");
            }
        };

        ArrayList<checkAtribut> arr= new ArrayList<>();
        arr.add(checkSalta);
        arr.add(checkNada);
        arr.add(checkVola);
        arr.add(checkCamina);

        for (checkAtribut att: arr) {
            System.out.print("L'Animal 1");
            att.check(a1);
            System.out.print("L'Animal 2");
            att.check(a2);
            System.out.print("L'Animal 3");
            att.check(a3);
        }
    }
}
