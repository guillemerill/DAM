package com.P02_StucomRoyal;

/**
 * Las cartas de tipo “hechizo”, tendrán un nivel de alcance y un modo. El modo puede ser ataque o defensa.
 * Cuando un jugador utiliza una de estas cartas en la batalla estás afectarán descontando vida a todas las cartas del contrincante en su nivel de alcance * 2 / 3, en caso de ser de modo ataque.
 Si el hechizo es modo defensa subirá la vida de todas las cartas del jugador que la ha utilizado en la misma cantidad anterior (nivel de alcance * 2 / 3) .

 */
public class Hechizo extends Carta{
    // Attributes
    private int alcance;
    private String modo; // ataque o defensa

    // Constructor
    public Hechizo(String nombre, int coste, int vida, int alcance, String modo) {
        super(nombre, coste, vida);
        this.alcance = alcance;
        this.modo = modo;
    }

    // Getters & Setters
    public int getAlcance() {
        return alcance;
    }
    public void setAlcance(int alcance) {
        this.alcance = alcance;
    }

    public String getModo() {
        return modo;
    }
    public void setModo(String modo) {
        this.modo = modo;
    }

    // Methods
    public int utilizar(int vida) {
        if (this.modo.equals("ataque")) {
            return vida - (this.alcance * 2 / 3);
        } else {
            return vida + (this.alcance * 2 / 3);
        }
    }

    @Override
    public String toString() {
        return "Hechizo{" +
                "nombre='" + this.getNombre() + '\'' +
                ", coste=" + this.getCoste() +
                ", vida=" + this.getVida() +
                "alcance=" + alcance +
                ", modo='" + modo + '\'' +
                '}';
    }
}
