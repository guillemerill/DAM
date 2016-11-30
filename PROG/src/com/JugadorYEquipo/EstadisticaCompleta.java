package com.JugadorYEquipo;

/**
 * Created by DAM on 23/11/16.
 */
public class EstadisticaCompleta {

    // Atributos
    private String posicion;
    private int canastas;
    private int asistencias;
    private int rebotes;
    private int maxcanastas;
    private int maxasistencias;
    private int maxrebotes;
    private int mincanastas;
    private int minasistencias;
    private int minrebotes;
    private int jugadores;

    // Constructor
    public EstadisticaCompleta(String posicion, int canastas, int asistencias, int rebotes, int maxcanastas, int maxasistencias, int maxrebotes, int mincanastas, int minasistencias, int minrebotes, int jugadores) {
        this.posicion = posicion;
        this.canastas = canastas;
        this.asistencias = asistencias;
        this.rebotes = rebotes;
        this.maxcanastas = maxcanastas;
        this.maxasistencias = maxasistencias;
        this.maxrebotes = maxrebotes;
        this.mincanastas = mincanastas;
        this.minasistencias = minasistencias;
        this.minrebotes = minrebotes;
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

    public int getMaxcanastas() {
        return maxcanastas;
    }
    public void setMaxcanastas(int maxcanastas) {
        this.maxcanastas = maxcanastas;
    }

    public int getMaxasistencias() {
        return maxasistencias;
    }
    public void setMaxasistencias(int maxasistencias) {
        this.maxasistencias = maxasistencias;
    }

    public int getMaxrebotes() {
        return maxrebotes;
    }
    public void setMaxrebotes(int maxrebotes) {
        this.maxrebotes = maxrebotes;
    }

    public int getMincanastas() {
        return mincanastas;
    }
    public void setMincanastas(int mincanastas) {
        this.mincanastas = mincanastas;
    }

    public int getMinasistencias() {
        return minasistencias;
    }
    public void setMinasistencias(int minasistencias) {
        this.minasistencias = minasistencias;
    }

    public int getMinrebotes() {
        return minrebotes;
    }
    public void setMinrebotes(int minrebotes) {
        this.minrebotes = minrebotes;
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
