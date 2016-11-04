package com.AlquilerVehiculos;

/*
Cada vehículo se identifica inequívocamente por medio de su matrícula.
La empresa alquila distintos tipos de vehículos, tanto para transporte de personas como de carga.
En la actualidad los vehículos alquilados por la empresa son: coches, microbuses, furgonetas de carga y camiones.
 */
public class Vehiculo {
    // Attributes
    private String matricula;

    // Constructor
    public Vehiculo(String matricula) {
        this.matricula = matricula;
    }

    // Getters & Setters
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
}
