package com.AlquilerVehiculos;

/*
El precio del alquiler de cualquier vehículo tiene una componente base que depende de los días de alquiler a razón de 50 €/día.
El precio de los vehículos de carga es el precio base más 20 € * PMA (PMA = peso máximo autorizado en toneladas).
 */
public class VehiculoCarga extends Vehiculo {
    // Attributes
    private int PMA;

    // Constructor
    public VehiculoCarga(String matricula, int PMA) {
        super(matricula);
        this.PMA = PMA;
    }

    // Getters & Setters
    public int getPMA() {
        return PMA;
    }
    public void setPMA(int PMA) {
        this.PMA = PMA;
    }

    // Methods

    @Override
    public String toString() {
        return "VehiculoCarga{" +
                "matricula=" + this.getMatricula() +
                ", PMA=" + PMA +
                '}';
    }

    @Override
    public double alquilar(int dias) {
        return (50 * dias) + (20 * PMA);
    }
}
