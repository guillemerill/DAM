package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;
import java.util.List;

public class Equipo {
    // Attributes
    private String nombre;
    private LocalDate creacion;
    private String localidad;

    // Constructor
    public Equipo(String nombre, LocalDate creacion, String localidad) {
        this.nombre = nombre;
        this.creacion = creacion;
        this.localidad = localidad;
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

    // Métodos
    @Override
    public String toString() {
        return nombre +
                ": creacion=" + creacion +
                ", localidad=" + localidad;
    }
}
