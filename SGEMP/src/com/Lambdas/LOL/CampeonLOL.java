package com.Lambdas.LOL;

import java.util.ArrayList;
import java.util.List;

/**
 * 7.2	Crea una classe que representi les estadístiques d’un personatge de LOL que al qual li puguem afegir o treure objectes a partir d’un array d’objectes LOL.
 •	Mantingui un llistat d’atributs corresponents a les estadístiques del jugador (inicialment totes a 0).
 •	Contingui una llista d’objectesLOL
 */
public class CampeonLOL {
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
    private List<ObjetoLOL> objetos;

    // Constructor
    public CampeonLOL(String nombre, int hp, int atkDmg, double atkSpeed, int movSpeed, double HPregen, int armor, double magRes, int mana, List<ObjetoLOL> objetos) {
        this.nombre = nombre;
        this.hp = hp;
        this.atkDmg = atkDmg;
        this.atkSpeed = atkSpeed;
        this.movSpeed = movSpeed;
        this.HPregen = HPregen;
        this.armor = armor;
        this.magRes = magRes;
        this.mana = mana;
        this.objetos = new ArrayList<>();
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

    public List<ObjetoLOL> getObjetos() {
        return objetos;
    }
    public void setObjetos(List<ObjetoLOL> objetos) {
        this.objetos = objetos;
    }

    // Methods

    @Override
    public String toString() {
        return "CampeonLOL{" +
                "nombre='" + nombre + '\'' +
                ", hp=" + hp +
                ", atkDmg=" + atkDmg +
                ", atkSpeed=" + atkSpeed +
                ", movSpeed=" + movSpeed +
                ", HPregen=" + HPregen +
                ", armor=" + armor +
                ", magRes=" + magRes +
                ", mana=" + mana +
                ", objetos=" + objetos +
                '}';
    }
}
