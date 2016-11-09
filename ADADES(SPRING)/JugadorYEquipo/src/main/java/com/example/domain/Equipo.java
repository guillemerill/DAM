package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Equipo {
    /*
     * La entidad Equipo tendrá los siguientes atributos:
     * identificador, nombre, localidad y fecha de creación.
     */

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String localidad;
    private String fechaCreacion;

    // Constructors
    public Equipo() {
    }

    public Equipo(String nombre, String localidad, String fechaCreacion) {
        this.nombre = nombre;
        this.localidad = localidad;
        this.fechaCreacion = fechaCreacion;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }


    // Methods

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                '}'+System.lineSeparator();
    }
}
