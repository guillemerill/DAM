package com.AlquilerVehiculos;

/*
El precio del alquiler de cualquier vehículo tiene una componente base que depende de los días de alquiler a razón de 50 €/día.
En el caso de alquiler de un coche, al precio base se le suma la cantidad de 1.5 € por plaza y día.
 */
public class Coche extends Vehiculo {
    // Attributes
    private int plazas;

    // Constructor
    public Coche(String matricula, int plazas) {
        super(matricula);
        this.plazas = plazas;
    }

    // Getters & Setters
    public int getPlazas() {
        return plazas;
    }
    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    // Methods

    @Override
    public String toString() {
        return "Coche{" +
                "matricula=" + this.getMatricula() +
                ", plazas=" + plazas +
                '}';
    }

    @Override
    public double alquilar(int dias) {
        return (50 * dias) + (1.5 * this.getPlazas() * dias);
    }
}
