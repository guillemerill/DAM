package com.JugadorYEquipo;

/*
Inicialmente , la entidad Equipo tendrá los siguientes a tributos: identificador ,
nombre, localidad y fecha de creación . Un equipo está formado por varios
jugadores , y un jugador sólo puede participar en un equipo .
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

// Clase contador
public class Equipo {

    // Atributos
    private static int contador = 0;

    private int identificador;
    private String nombre;
    private String localidad;
    private LocalDate creacion;
    private List<Jugador> jugadores;

    // Constructores
    public Equipo() {
    }
    public Equipo(String nombre, String localidad, LocalDate creacion) {
        contador++;
        identificador = contador;
        this.nombre = nombre;
        this.localidad = localidad;
        this.creacion = creacion;
        jugadores = new ArrayList<>();
    }

    // Getters y Setters
    public List<Jugador> getJugadores() {
        return jugadores;
    }
    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getIdentificador() {
        return identificador;
    }
    public void setIdentificador(int identificador) {
        this.identificador = identificador;
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

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
