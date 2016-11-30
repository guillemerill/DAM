package com.Lambdas.LOL;

import java.util.ArrayList;
import java.util.List;

/**
 * 5. Crea un programa que contingui una funció que a partir d’un arraylist i un lambda checkEstadistica ens retorni tots elements que modifiquin una estadistica:

 La classe ObjetoLOL ha de guardar el valor de cada estadística i contenir les següents funcions que retornin true o false segons si l’objecte modifica o no cada estadística:
 •	modificaVida()
 •	modificaAtaque()
 •	modificaMovimiento()
 •	modificaRegeneraVida()
 •	modificaArmadura()
 •	modificaResistenciaMagica()
 •	modificaMana()

 */
public class mainLOL {


    public static void main(String[] args) {
        // 5.1 Crea 4 objectes de LOL amb diferents estadístiques.
        ObjetoLOL obj1 = new ObjetoLOL("Coraza del muerto", 500, 0, 0, 0, 0, 50, 0, 0);
        ObjetoLOL obj2 = new ObjetoLOL("Guantelete de hielo", 65, 0, 0, 0, 0, 0, 0, 200);
        ObjetoLOL obj3 = new ObjetoLOL("Hidra titanica", 450, 35, 0, 0, 0, 0, 0, 0);
        ObjetoLOL obj4 = new ObjetoLOL("Fuerza de trinidad", 250, 25, 0, 5, 0, 0, 0, 250);

        // 7.3	Crea dos Personatges , afegeixi tres nous objectes als personatges  i mostra les estadístiques dels objectes i dels usuaris abans i després d’afegir-hi els objectes
        CampeonLOL p1 = new CampeonLOL("Fiora", 550, 60, 0.625, 345, 8.25, 24, 32.1, 0);
        // 5.2 Crea un lambda (amb interfície CheckEstadistica) per cada estadística que retorni true o false segons si l’objecte modifica o no l’estadística.
        checkEstadistica modificaVida = (obj) -> {
            if (obj.getHp() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaAtaque = (obj) -> {
            if (obj.getAtkDmg() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaMovimiento = (obj) -> {
            if (obj.getMovSpeed() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaRegeneraVida = (obj) -> {
            if (obj.getHPregen() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaArmadura = (obj) -> {
            if (obj.getArmor() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaResistenciaMagica = (obj) -> {
            if (obj.getMagRes() != 0) {
                return true;
            }
            return false;
        };
        checkEstadistica modificaMana = (obj) -> {
            if (obj.getMana() != 0) {
                return true;
            }
            return false;
        };

        // 5.3 Guarda els objectes dins un arrayList, y crea una funció que pugui rebre l’arrayList y el lambda de qualsevol estadística.
        List<ObjetoLOL> objetos = new ArrayList<>();
        objetos.add(obj1);
        objetos.add(obj2);
        objetos.add(obj3);
        objetos.add(obj4);

        System.out.println("Objetos que modifican la vida");
        for (ObjetoLOL obj : objetos) {
            if (modificaVida.check(obj)) {
                System.out.println(obj);
            }
        }

        System.out.println("Objetos que modifican el ataque");
        for (ObjetoLOL obj : objetos) {
            if (modificaAtaque.check(obj)) {
                System.out.println(obj);
            }
        }

        System.out.println("Objetos que modifican el movimiento");
        for (ObjetoLOL obj : objetos) {
            if (modificaMovimiento.check(obj)) {
                System.out.println(obj);
            }
        }

        System.out.println("Objetos que modifican la regeneración de vida");
        for (ObjetoLOL obj : objetos) {
            if (modificaRegeneraVida.check(obj)) {
                System.out.println(obj);
            }
        }
        System.out.println("Objetos que modifican la armadura");
        for (ObjetoLOL obj : objetos) {
            if (modificaArmadura.check(obj)) {
                System.out.println(obj);
            }
        }
        System.out.println("Objetos que modifican la resistencia mágica");
        for (ObjetoLOL obj : objetos) {
            if (modificaResistenciaMagica.check(obj)) {
                System.out.println(obj);
            }
        }
        System.out.println("Objetos que modifican el maná");
        for (ObjetoLOL obj : objetos) {
            if (modificaMana.check(obj)) {
                System.out.println(obj);
            }
        }





    }

    public void ejecutaLambda(ArrayList<ObjetoLOL> objetos, checkEstadistica lambda){
        // 5.4 Programa la funció perquè recorri l’arraylist mostrant només aquells objectes en que l’execució del lambda retorni true.
        for (ObjetoLOL obj: objetos) {
            if (lambda.check(obj)) {
                System.out.println(obj);
            }
        }

    }
}
