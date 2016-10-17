package com.Pokemon;

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
            List<Pokemon> pkmn = new ArrayList<>();


            Pokemon p1 = new Pokemon("Pikachu","29","13", "36");
            PokemonFoc p2 = new PokemonFoc("Charmander","49","27", "40");

            p1.showAttr();
            p2.showAttr();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
