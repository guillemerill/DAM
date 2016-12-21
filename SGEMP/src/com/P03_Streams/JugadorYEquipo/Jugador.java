package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;

public class Jugador {
    // Attributes
    private String nombre;
    private LocalDate nacim;
    private int canastas;
    private String posicion;
    private Equipo equipo;

    // Constructor
    public Jugador(String nombre, LocalDate nacim, int canastas, String posicion, Equipo equipo) {
        this.nombre = nombre;
        this.nacim = nacim;
        this.canastas = canastas;
        this.posicion = posicion;
        this.equipo = equipo;
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

    public Equipo getEquipo() {
        return equipo;
    }
    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
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
