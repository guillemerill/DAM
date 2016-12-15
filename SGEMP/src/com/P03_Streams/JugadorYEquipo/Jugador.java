package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;

public class Jugador {
    // Attributes
    private String nombre;
    private LocalDate nacim;
    private int canastas;
    private String posicion;

    // Constructor
    public Jugador(String nombre, LocalDate nacim, int canastas, String posicion) {
        this.nombre = nombre;
        this.nacim = nacim;
        this.canastas = canastas;
        this.posicion = posicion;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getNacim() {
        return nacim;
    }
    public void setNacim(LocalDate nacim) {
        this.nacim = nacim;
    }

    public int getCanastas() {
        return canastas;
    }
    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    // Métodos
    @Override
    public String toString() {
        return nombre +
                ": nacim=" + nacim +
                ", canastas=" + canastas +
                ", posicion=" + posicion;
    }
}
