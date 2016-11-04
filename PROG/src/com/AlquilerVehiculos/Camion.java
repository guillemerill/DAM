package com.AlquilerVehiculos;

/*
El precio del alquiler de cualquier vehículo tiene una componente base que depende de los días de alquiler a razón de 50 €/día.
Además, en el caso de los camiones, al precio se suma un fijo de 40 € independientemente de los días de alquiler.
 */
public class Camion extends Vehiculo {
    // Constructor
    public Camion(String matricula) {
        super(matricula);
    }

    // Methods
    public double alquilerCamion(int dias) {
        return (50 * dias) + 40;
    }
}
