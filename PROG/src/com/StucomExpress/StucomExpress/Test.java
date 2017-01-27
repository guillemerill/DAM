package com.StucomExpress.StucomExpress;

import com.StucomExpress.Model.City;
import com.StucomExpress.Model.Package;
import com.StucomExpress.Model.Truckdriver;
import com.StucomExpress.Persistence.TransportJDBC;

import java.sql.SQLException;
import java.time.LocalDate;

// Clase Test
public class Test {
    public static void main(String[] args) {
        TransportJDBC gestor = new TransportJDBC();
        try {
            System.out.println("Conectando a la base de datos...");
            gestor.connect();
            System.out.println("Conexión establecida. \n");

            // 4
            System.out.println("Testeando métodos que inserta un paquete en la bbdd...");
            Package p1 = new Package("Guillem Erill", new Truckdriver("12345678C"), new City("08200"));

            gestor.insertPackage(p1);
            System.out.println("Paquete insertado correctamente. \n");

            // 5
            System.out.println("Modificando el salario del Truckdriver con DNI 12345678A.");
            gestor.updateTruckdriverSalary(2700, "12345678A");
            System.out.println("Salario modificado correctamente. \n");

            // 6
            System.out.println("Obteniendo la lista de camiones que conduce 12345678A.");
            System.out.println(gestor.getTruckListByDriver("12345678A") + "\n");

            // 7
            System.out.println("Obteniendo la lista de paquetes enviados a 08200.");
            System.out.println(gestor.getPackageListByCity("08200") + "\n");

            // 8
            System.out.println("Obteniendo el ranking de ciudades con los paquetes que se han enviado.");
            System.out.println(gestor.getEnvios() + "\n");

            System.out.println("Desconectando de la base de datos...");
            gestor.disconnect();
            System.out.println("Conexión cerrada con éxito.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: " + ex.getMessage());
        }
    }
}
