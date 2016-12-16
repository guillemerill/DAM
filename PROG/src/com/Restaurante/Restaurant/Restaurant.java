package com.Restaurante.Restaurant;

import com.Restaurante.Model.Cocinero;
import com.Restaurante.Persistence.RestaurantJDBC;

import java.sql.SQLException;

/*
 * Clase de Test
 */
public class Restaurant {
    public static void main(String[] args) {
        RestaurantJDBC gestor = new RestaurantJDBC();
        try {
            System.out.println("Estableciendo conexión con la BBDD...");
            gestor.conectar();
            System.out.println("Conectado a la BBDD");
            Cocinero c;
            // Crear cocinero
            c = new Cocinero("Ferran Adria", "888888888", "hombre", 56, 22, "Platos principales");
            gestor.insertCocinero(c);
            System.out.println(c.getNombre() + " dado de alta.");
            c = new Cocinero("Karlos Arguiñano", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c);
            System.out.println(c.getNombre() + " dado de alta.");
            c = new Cocinero("Karlos Arguiñano2", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c);
            System.out.println(c.getNombre() + " dado de alta.");

            // Modificar cocinero
            c = new Cocinero("Ferran Adria", "888888888", "hombre", 68, 22, "Entrantes");
            gestor.updateCocinero(c);
            System.out.println(c.getNombre() + " modificado.");

            // Eliminar cocinero
            String cnombre = "Karlos Arguiñano2";
            gestor.deleteCocinero(cnombre);
            System.out.println(cnombre + " eliminado.");

            gestor.desconectar();
            System.out.println("Cerrada la conexión con la BBDD.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: "+ex.getMessage());
        }
    }
}
