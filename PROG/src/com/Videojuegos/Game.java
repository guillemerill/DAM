package com.Videojuegos;

import java.io.Serializable;

/**
 * Created by DAM on 7/10/16.
 */
public class Game implements Serializable{
    private String nombre;
    private String genero;
    private int puntos;
    private double precio;
    private boolean enPropiedad;

    // Constructor sin parámetros
    public Game() {
    }

    public Game(String nombre, String genero, int puntos, double precio, boolean enPropiedad) {
        this.nombre = nombre;
        this.genero = genero;
        this.puntos = puntos;
        this.precio = precio;
        this.enPropiedad = enPropiedad;
    }

    public boolean isEnPropiedad() {
        return enPropiedad;
    }

    public void setEnPropiedad(boolean enPropiedad) {
        this.enPropiedad = enPropiedad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }


    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        String texto = "nombre=" + nombre + ", genero=" + genero
                + ", puntos=" + puntos + ", precio=" + precio;
//        if (enPropiedad) {
//            texto += " TENGUI";
//        } else {
//            texto += " FALTI";
//        }
        // Otro ejemplo
//        int x = 0;
//        x += (x%2==0)? 5: 6;

        texto += enPropiedad? " TENGUI" : " FALTI";
        return texto;
    }
}
