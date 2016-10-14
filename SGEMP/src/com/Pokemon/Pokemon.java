package com.Pokemon;

/**
 * Created by DAM on 3/10/16.
 */
public class Pokemon {
    // Attributes
    private String nom;
    private String atac;
    private String def;
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
    public void showAttr() {
        String ret = "Nom: " + nom + "; Attack: " + atac + "; Def: " + def + "; PS: " + PS;

        System.out.println(ret);
    }
}
