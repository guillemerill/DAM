package com.Pokemon;

import java.util.Random;

/**
 * Created by DAM on 5/10/16.
 */
public class PokemonAigua extends Pokemon implements Capturable{
    private String tipus = "aigua";
    private String efectiuContra = "foc";
    private String debilContra = "planta";

    public PokemonAigua(String nom, String atac, String def, String PS) {
        super(nom, atac, def, PS);
    }

    @Override
    public String toString() {
        return "PokemonAigua{" +
                "nom='" + this.getName() + '\'' +
                ", atac='" + this.getAtk() + '\'' +
                ", def='" + this.getDef() + '\'' +
                ", PS='" + this.getPS() + '\'' +
                '}';
    }

    @Override
    public boolean capturar() {
        Random rn = new Random();
        int capt = rn.nextInt(120 - 20 + 1) + 20;
        System.out.println("Valor aleatori: " + capt);
        int ps = Integer.parseInt(this.getPS());
        System.out.println("Vida: " +  ps);
        int def = Integer.parseInt(this.getDef());
        System.out.println("Defensa: " + def);
        System.out.println("Valor per capturar: " + (capt-ps));
        if ((capt - ps) > def) {
            return true;
        }
        return false;
    }
}
