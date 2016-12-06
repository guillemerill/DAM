package com.P02_StucomRoyal;

/**
 * Todas las cartas tienen un nombre, un coste de elixir (que estará entre 1 y 5) y un nivel de vida (entre 1 y 100).

 */
public class Carta {
    // Attributes
    private String nombre;
    private int coste; // entre 1 y 5
    private int vida; // entre 1 y 100

    // Constructor
    public Carta(String nombre, int coste, int vida) {
        this.nombre = nombre;
        this.coste = coste;
        this.vida = vida;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCoste() {
        return coste;
    }
    public void setCoste(int coste) {
        this.coste = coste;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    // Methods
    public void utilizar(Carta c) {}

    @Override
    public String toString() {
        return "Carta{" +
                "nombre='" + nombre + '\'' +
                ", coste=" + coste +
                ", vida=" + vida +
                '}';
    }
}
