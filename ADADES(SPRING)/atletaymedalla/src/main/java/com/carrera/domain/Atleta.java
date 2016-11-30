package com.carrera.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Atleta {
    /**
     * Un atleta tendrá los siguiente atributos: Id, Nombre, Apellidos, Nacionalidad, Fecha nacimiento.
     * Existirá una asociación OneToMany entre el atleta y sus correspondientes medallas.
     */

    // Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private LocalDate nacimiento;
    @OneToMany
    private Medalla medalla;

    // Constructors
    public Atleta(String nombre, String apellidos, String nacionalidad, LocalDate nacimiento, Medalla medalla) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.nacimiento = nacimiento;
        this.medalla = medalla;
    }

    public Atleta(){
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

    public String getApellidos() {
        return apellidos;
    }
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }
    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }
    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    // Methods
    @Override
    public String toString() {
        return "Atleta{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nacionalidad='" + nacionalidad + '\'' +
                ", nacimiento=" + nacimiento +
                '}';
    }
}