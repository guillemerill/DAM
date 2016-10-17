package com.Pokemon;

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
                "tipus='" + tipus + '\'' +
                ", efectiuContra='" + efectiuContra + '\'' +
                ", debilContra='" + debilContra + '\'' +
                '}';
    }

    @Override
    public boolean capturar() {
        return false;
    }
}
