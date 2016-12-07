package com.Lambdas.LOL;

/**
 Volem crear una aplicació que treballi amb les estadístiques dels objectes de LOL.
 Les estadístiques a tenir en compte seràn (inicialment totes a 0):
     •	Vida
     •	Daño de Ataque
     •	Velocidad de Ataque
     •	Velocidad de Movimiento
     •	Regeneración de Vida
     •	Armadura
     •	Resisténcia Mágica
     •	Maná
 */
public class ObjetoLOL {
    // Attributes
    private String nombre;
    private int hp;
    private int atkDmg;
    private double atkSpeed;
    private int movSpeed;
    private double HPregen;
    private int armor;
    private double magRes;
    private int mana;

    // Constructor
    public ObjetoLOL(String nombre, int hp, int atkDmg, double atkSpeed, int movSpeed, double HPregen, int armor, double magRes, int mana) {
        this.nombre = nombre;
        this.hp = hp;
        this.atkDmg = atkDmg;
        this.atkSpeed = atkSpeed;
        this.movSpeed = movSpeed;
        this.HPregen = HPregen;
        this.armor = armor;
        this.magRes = magRes;
        this.mana = mana;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtkDmg() {
        return atkDmg;
    }
    public void setAtkDmg(int atkDmg) {
        this.atkDmg = atkDmg;
    }

    public double getAtkSpeed() {
        return atkSpeed;
    }
    public void setAtkSpeed(double atkSpeed) {
        this.atkSpeed = atkSpeed;
    }

    public int getMovSpeed() {
        return movSpeed;
    }
    public void setMovSpeed(int movSpeed) {
        this.movSpeed = movSpeed;
    }

    public double getHPregen() {
        return HPregen;
    }
    public void setHPregen(double HPregen) {
        this.HPregen = HPregen;
    }

    public int getArmor() {
        return armor;
    }
    public void setArmor(int armor) {
        this.armor = armor;
    }

    public double getMagRes() {
        return magRes;
    }
    public void setMagRes(double magRes) {
        this.magRes = magRes;
    }

    public int getMana() {
        return mana;
    }
    public void setMana(int mana) {
        this.mana = mana;
    }

    // Methods

    @Override
    public String toString() {
        return  nombre +
                ": hp=" + hp +
                ", atkDmg=" + atkDmg +
                ", atkSpeed=" + atkSpeed +
                ", movSpeed=" + movSpeed +
                ", HPregen=" + HPregen +
                ", armor=" + armor +
                ", magRes=" + magRes +
                ", mana=" + mana;
    }
}
