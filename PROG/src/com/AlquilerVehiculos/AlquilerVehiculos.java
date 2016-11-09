package com.AlquilerVehiculos;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/*
Desarrollar una aplicación que permita calcular los precios de alquiler de una empresa de alquiler de vehículos.

Crear las clases necesarias para implementar en java esta información. Hay que tener en cuenta posibles herencias, polimorfismos y atributos y métodos estáticos.
Realizar una clase que contenga el método main. Desde él se podrán realizar las siguientes acciones:
La empresa dispone de un vehículo de cada tipo. Éstos se almacenarán en un array de 4 posiciones.
Obtener precio alquiler: se pide al usuario la matrícula del vehículo y los días que ha durado el alquiler. La aplicación mostrará el precio del alquiler.
 */
public class AlquilerVehiculos {

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Coche("1234ABC", 4));
        vehiculos.add(new MicroBus("4567ASD", 31));
        vehiculos.add(new VehiculoCarga("9874QWE", 50));
        vehiculos.add(new Camion("8521POI"));
        try {
            System.out.println("Introduce la matrícula: ");
            String matricula = br.readLine();
            System.out.println("Cuantos días ha durado el alquiler?");
            int dias = Integer.parseInt(br.readLine());

            for (Vehiculo v : vehiculos) {
                if (v.getMatricula().equals(matricula)) {
                    if (v.getClass().equals(Coche.class)) {
                        System.out.println("El alquiler ha costado: ");
                        System.out.println(v.alquilar(dias));
                    } else if (v.getClass().equals(MicroBus.class)) {
                        System.out.println("El alquiler ha costado: ");
                        System.out.println(v.alquilar(dias));
                    } else if (v.getClass().equals(VehiculoCarga.class)) {
                        System.out.println("El alquiler ha costado: ");
                        System.out.println(v.alquilar(dias));
                    } else if (v.getClass().equals(Camion.class)) {
                        System.out.println("El alquiler ha costado: ");
                        System.out.println(v.alquilar(dias));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR: " + e);
        }

    }
}
