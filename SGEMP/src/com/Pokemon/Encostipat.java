package com.Pokemon;

import java.util.Random;

/**
 * Created by DAM on 17/10/16.
 */
public class Encostipat extends Pokemon implements Capturable {
    private String tipus = "encostipat";
    private String efectiuContra = "aigua";
    private String debilContra = "foc";

    public Encostipat(String nom, String atac, String def, String PS) {
        super(nom, atac, def, PS);
    }

    @Override
    public String toString() {
        return "Encostipat{" +
                "nom='" + this.getName() + '\'' +
                ", atac='" + this.getAtk() + '\'' +
                ", def='" + this.getDef() + '\'' +
                ", PS='" + this.getPS() + '\'' +
                '}';
    }

    @Override
    public boolean capturar() {
        Random rn = new Random();
        int capt = rn.nextInt(120 - 60 + 1) + 60;
        System.out.println("Valor aleatori: " + capt);
        int atk = Integer.parseInt(this.getAtk());
        System.out.println("Vida: " +  atk);
        int def = Integer.parseInt(this.getDef());
        System.out.println("Defensa: " + def);
        System.out.println("Valor per capturar: " + (def+atk));
        if ((def + atk) < capt) {
            return true;
        }
        return false;
    }
}
