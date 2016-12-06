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

        List<checkEstadistica> estadisticas = new ArrayList<>();
        estadisticas.add(modificaVida);
        estadisticas.add(modificaAtaque);
        estadisticas.add(modificaMovimiento);
        estadisticas.add(modificaRegeneraVida);
        estadisticas.add(modificaArmadura);
        estadisticas.add(modificaResistenciaMagica);
        estadisticas.add(modificaMana);

        // 5.3 Guarda els objectes dins un arrayList, y crea una funció que pugui rebre l’arrayList y el lambda de qualsevol estadística.
        List<ObjetoLOL> objetos = new ArrayList<>();
        objetos.add(obj1);
        objetos.add(obj2);
        objetos.add(obj3);
        objetos.add(obj4);

        System.out.println("Objetos que modifican la vida");
        ejecutaLambda(objetos, modificaVida);
        /*for (ObjetoLOL obj : objetos) {
            if (modificaVida.check(obj)) {
                System.out.println(obj);
            }
        }*/


        System.out.println("Objetos que modifican el ataque");
        ejecutaLambda(objetos, modificaAtaque);

        System.out.println("Objetos que modifican el movimiento");
        ejecutaLambda(objetos, modificaMovimiento);

        System.out.println("Objetos que modifican la regeneración de vida");
        ejecutaLambda(objetos, modificaRegeneraVida);

        System.out.println("Objetos que modifican la armadura");
        ejecutaLambda(objetos, modificaArmadura);

        System.out.println("Objetos que modifican la resistencia mágica");
        ejecutaLambda(objetos, modificaResistenciaMagica);

        System.out.println("Objetos que modifican el maná");
        ejecutaLambda(objetos, modificaMana);

        // 7.3	Crea dos Personatges, afegeixi tres nous objectes als personatges  i mostra les estadístiques dels objectes i dels usuaris abans i després d’afegir-hi els objectes
        CampeonLOL p1 = new CampeonLOL("Fiora", 550, 60, 0.625, 345, 8.25, 24, 32.1, 0, new ArrayList<>());
        System.out.println(p1.toString());
        List<ObjetoLOL> p1_objetos = new ArrayList<>();
        p1_objetos.add(obj1);
        p1_objetos.add(obj3);
        p1_objetos.add(obj4);
        for (ObjetoLOL obj : p1_objetos) {
            System.out.println(obj.toString());
            p1.addObject(obj);
        }
        System.out.println(p1.toString());

        CampeonLOL p2 = new CampeonLOL("Poppy", 540, 56, 0.625, 345, 8, 29, 32, 0, new ArrayList<>());
        System.out.println(p2.toString());
        List<ObjetoLOL> p2_objetos = new ArrayList<>();
        p2_objetos.add(obj1);
        p2_objetos.add(obj2);
        p2_objetos.add(obj4);
        for (ObjetoLOL obj : p2_objetos) {
            System.out.println(obj.toString());
            p2.addObject(obj);
        }
        System.out.println(p2.toString());




    }

    public static void ejecutaLambda(List<ObjetoLOL> objetos, checkEstadistica lambda){
        // 5.4 Programa la funció perquè recorri l’arraylist mostrant només aquells objectes en que l’execució del lambda retorni true.
        for (ObjetoLOL obj: objetos) {
            if (lambda.check(obj)) {
                System.out.println(obj);
            }
        }

    }
}
