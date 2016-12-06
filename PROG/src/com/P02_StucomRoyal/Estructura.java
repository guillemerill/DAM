package com.P02_StucomRoyal;

/**
 * Las cartas tipo “estructura”, tendrán un nivel de defensa. Cuando se utiliza una carta de tipo estructura, sube la vida de las cartas del jugador que la utiliza en su nivel de defensa + 8 .
 */
public class Estructura extends Carta {
    // Attributes
    private int defensa;

    // Constructor
    public Estructura(String nombre, int coste, int vida, int defensa) {
        super(nombre, coste, vida);
        this.defensa = defensa;
    }

    // Getters & Setters
    public int getDefensa() {
        return defensa;
    }
    public void setDefensa(int defensa) {
        this.defensa = defensa;
    }

    // Methods

    @Override
    public void utilizar(Carta c) {
        c.setVida(c.getVida() + (this.defensa + 8));
    }

    @Override
    public String toString() {
        return "Estructura{" +
                "nombre='" + this.getNombre() + '\'' +
                ", coste=" + this.getCoste() +
                ", vida=" + this.getVida() +
                ", defensa=" + defensa +
                '}';
    }
}
