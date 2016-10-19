package com.Pokemon;

/**
 * Created by DAM on 3/10/16.
 */
public class Pokemon {
    // Attributes
    private String nom;
    // atac (0 - 50)
    private String atac;
    // defensa (10 - 50)
    private String def;
    // punts de salut (20 - 100)
    private String PS;

    // Constructors
    public Pokemon() {}

    public Pokemon(String nom, String atac, String def, String PS) {
        this.nom = nom;
        this.atac = atac;
        this.def = def;
        this.PS = PS;
    }

    // Getters & Setters
    public String getName() {
        return nom;
    }
    public void setName(String nom) {
        this.nom = nom;
    }

    public String getAtk() {
        return atac;
    }
    public void setAtk(String atac) {
        this.atac = atac;
    }

    public String getDef() {
        return def;
    }
    public void setDef(String def) {
        this.def = def;
    }

    public String getPS() {
        return PS;
    }
    public void setPS(String PS) {
        this.PS = PS;
    }

    //Methods

    @Override
    public String toString() {
        return "Pokemon{" +
                "nom='" + nom + '\'' +
                ", atac='" + atac + '\'' +
                ", def='" + def + '\'' +
                ", PS='" + PS + '\'' +
                '}';
    }
}
