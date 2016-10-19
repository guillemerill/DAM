package com.Pokemon;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DAM on 3/10/16.
 */
public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            Pokemon p1 = new Pokemon("Pikachu","29","13", "36");
            Pokemon p2 = new Pokemon("Charmander","49","27", "40");
            System.out.println(p1);
            System.out.println(p2);

            PokemonAigua pa1 = new PokemonAigua("Squirtle", "13", "15", "45");
            PokemonAigua pa2 = new PokemonAigua("Blastoise", "44", "50", "74");
            PokemonFoc pf1 = new PokemonFoc("Torchic", "10", "13", "33");
            PokemonFoc pf2 = new PokemonFoc("Blaziken", "40", "39", "65");
            PokemonPlanta pp1 = new PokemonPlanta("Chikorita", "7", "20", "40");
            PokemonPlanta pp2 = new PokemonPlanta("Meganium", "37", "48", "100");
            Encostipat e1 = new Encostipat("Encostipat", "50", "50", "100");
            List<Capturable> pkmn = new ArrayList<>();
            pkmn.add(pa1);
            pkmn.add(pa2);
            pkmn.add(pf1);
            pkmn.add(pf2);
            pkmn.add(pp1);
            pkmn.add(pp2);
            pkmn.add(e1);
            for (Capturable p: pkmn) {
                System.out.println(p);
                if (p.capturar()) {
                    System.out.println("Capturat!");
                } else {
                    System.out.println("S'ha escapat!");
                }
            }




        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
