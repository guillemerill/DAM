package com.Pokemon;

import java.util.Random;

/**
 * Created by DAM on 10/10/16.
 */
public class PokemonPlanta extends Pokemon implements Capturable {
    private String tipus = "planta";
    private String efectiuContra = "aigua";
    private String debilContra = "foc";

    public PokemonPlanta(String nom, String atac, String def, String PS) {
        super(nom, atac, def, PS);
    }

    @Override
    public String toString() {
        return "PokemonPlanta{" +
                "nom='" + this.getName() + '\'' +
                ", atac='" + this.getAtk() + '\'' +
                ", def='" + this.getDef() + '\'' +
                ", PS='" + this.getPS() + '\'' +
                '}';
    }

    @Override
    public boolean capturar() {
        // Si el PS menys el valor aleatori es mes petit que l'atac, captura
        Random rn = new Random();
        int capt = rn.nextInt(80 - 20 + 1) + 20;
        System.out.println("Valor aleatori: " + capt);
        int ps = Integer.parseInt(this.getPS());
        System.out.println("PS: " +  ps);
        int atk = Integer.parseInt(this.getAtk());
        System.out.println("Atac: " + atk);
        System.out.println("Valor per capturar: " + (capt-ps));
        if ((capt - ps) < atk) {
            return true;
        }
        return false;
    }
}
