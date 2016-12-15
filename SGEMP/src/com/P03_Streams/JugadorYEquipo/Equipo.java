package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by DAM on 14/12/16.
 */
public class Equipo {
    // Attributes
    private String nombre;
    private LocalDate creacion;
    private String localidad;
    private List<Jugador> jugadores;

    // Constructor
    public Equipo(String nombre, LocalDate creacion, String localidad, List<Jugador> jugadores) {
        this.nombre = nombre;
        this.creacion = creacion;
        this.localidad = localidad;
        this.jugadores = jugadores;
    }

    // Getters & Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getCreacion() {
        return creacion;
    }
    public void setCreacion(LocalDate creacion) {
        this.creacion = creacion;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    // Métodos

    @Override
    public String toString() {
        return nombre +
                ": creacion=" + creacion +
                ", localidad='" + localidad + '\'' +
                ", jugadores=" + jugadores;
    }
}
