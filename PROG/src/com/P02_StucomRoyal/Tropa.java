package com.P02_StucomRoyal;

/**
 * Las cartas de tipo “tropa”, tendrán un nivel de ataque. Cuando una carta de tipo tropa ataca descuenta su nivel de ataque / 2 la vida de la carta a la que hayan atacado.
 */
public class Tropa extends Carta {
    // Attributes
    private int ataque;

    // Constructor
    public Tropa(String nombre, int coste, int vida, int ataque) {
        super(nombre, coste, vida);
        this.ataque = ataque;
    }

    // Getters & Setters
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    // Methods
    public int atacar(int vida) {
        return vida - (this.ataque / 2);
    }

    @Override
    public String toString() {
        return "Tropa{" +
                "nombre='" + this.getNombre() + '\'' +
                ", coste=" + this.getCoste() +
                ", vida=" + this.getVida() +
                ",ataque=" + ataque +
                '}';
    }
}
