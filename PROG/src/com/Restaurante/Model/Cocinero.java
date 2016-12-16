package com.Restaurante.Model;

/*
 * Entity Cocinero (nombre, tfno, sexo, edad, exp, esp.)
 */

public class Cocinero {
    // Atributos
    private String nombre;
    private String telefono;
    private String sexo;
    private int edad;
    private int experiencia;
    private String especialidad;

    // Constructores
    public Cocinero() {
    }
    public Cocinero(String nombre, String telefono, String sexo, int edad, int experiencia, String especialidad) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.sexo = sexo;
        this.edad = edad;
        this.experiencia = experiencia;
        this.especialidad = especialidad;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }
    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getExperiencia() {
        return experiencia;
    }
    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public String getEspecialidad() {
        return especialidad;
    }
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
}
