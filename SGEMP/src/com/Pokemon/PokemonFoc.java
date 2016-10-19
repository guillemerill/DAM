package com.Pokemon;

import java.util.Random;

/**
 * Created by DAM on 10/10/16.
 */
public class PokemonFoc extends Pokemon implements Capturable {
    private String tipus = "foc";
    private String efectiuContra = "planta";
    private String debilContra = "aigua";

    public PokemonFoc(String nom, String atac, String def, String PS) {
        super(nom, atac, def, PS);
    }

    public String getTipus() {
        return tipus;
    }

    public String getEfectiuContra() {
        return efectiuContra;
    }

    public String getDebilContra() {
        return debilContra;
    }

    @Override
    public String toString() {
        return "PokemonFoc{" +
                "nom='" + this.getName() + '\'' +
                ", atac='" + this.getAtk() + '\'' +
                ", def='" + this.getDef() + '\'' +
                ", PS='" + this.getPS() + '\'' +
                '}';
    }

    @Override
    public boolean capturar() {
        // Si el valor aleatori menys l'atac és més petit que la defensa, captura
        Random rn = new Random();
        int capt = rn.nextInt(75 - 45 + 1) + 45;
        System.out.println("Valor aleatori: " + capt);
        int atk = Integer.parseInt(this.getAtk());
        System.out.println("Atac: " +  atk);
        int def = Integer.parseInt(this.getDef());
        System.out.println("Defensa: " + def);
        System.out.println("Valor per capturar: " + (capt-atk));
        if ((capt - atk) < def) {
            return true;
        }
        return false;
    }
}
