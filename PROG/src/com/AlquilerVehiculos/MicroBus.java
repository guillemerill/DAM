package com.AlquilerVehiculos;

/*
El precio del alquiler de cualquier vehículo tiene una componente base que depende de los días de alquiler a razón de 50 €/día.
El precio de alquiler de los microbuses es igual que el de los coches, salvo que se le añade una cantidad de 2 €/plaza independientemente de los días de alquiler.
 */
public class MicroBus extends Vehiculo {
    // Attributes
    private int plazas;

    // Constructor
    public MicroBus(String matricula, int plazas) {
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
        return "MicroBus{" +
                "matricula=" + this.getMatricula() +
                ", plazas=" + plazas +
                '}';
    }

    @Override
    public double alquilar(int dias) {
        return (50 * dias) + (2 * this.getPlazas());
    }
}
