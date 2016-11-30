package com.JugadorYEquipo;

/**
 * Created by DAM on 23/11/16.
 */
public class Estadistica {
    // Atributos
    private String posicion;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private int jugadores;

    // Constructor
    public Estadistica(String posicion, int canastas, int asistencias, int rebotes, int jugadores) {
        this.posicion = posicion;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.jugadores = jugadores;
    }

    // Getters & Setters
    public String getPosicion() {
        return posicion;
    }
    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getCanastas() {
        return canastas;
    }
    public void setCanastas(int canastas) {
        this.canastas = canastas;
    }

    public int getAsistencias() {
        return asistencias;
    }
    public void setAsistencias(int asistencias) {
        this.asistencias = asistencias;
    }

    public int getRebotes() {
        return rebotes;
    }
    public void setRebotes(int rebotes) {
        this.rebotes = rebotes;
    }

    public int getJugadores() {
        return jugadores;
    }
    public void setJugadores(int jugadores) {
        this.jugadores = jugadores;
    }

    // Métodos

    @Override
    public String toString() {
        return "Estadistica{" +
                "posicion='" + posicion + '\'' +
                ", canastas=" + canastas +
                ", asistencias=" + asistencias +
                ", rebotes=" + rebotes +
                ", jugadores=" + jugadores +
                '}';
    }
}
