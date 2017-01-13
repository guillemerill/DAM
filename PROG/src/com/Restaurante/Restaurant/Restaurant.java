package com.Restaurante.Restaurant;

import com.Restaurante.Model.Cocinero;
import com.Restaurante.Model.Plato;
import com.Restaurante.Persistence.RestaurantJDBC;

import java.sql.SQLException;
import java.util.List;

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
            gestor.deleteCocinero("Ferran Adria");
            gestor.deleteCocinero("Karlos Arguiñano");
            gestor.deleteCocinero("Karlos Arguiñano2");

            // Crear cocineros
            Cocinero c1 = new Cocinero("Ferran Adria", "888888888", "hombre", 56, 22, "Platos principales");
            gestor.insertCocinero(c1);
            System.out.println(c1.getNombre() + " dado de alta.");
            Cocinero c2 = new Cocinero("Karlos Arguiñano", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c2);
            System.out.println(c2.getNombre() + " dado de alta.");
            Cocinero c3 = new Cocinero("Karlos Arguiñano2", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c3);
            System.out.println(c3.getNombre() + " dado de alta.");

            // Crear platos
            Plato p;
            p = new Plato("Macarrones", "Equipo principal", 6.53, c1);
            gestor.insertPlato(p);
            System.out.println(p.getNombre() + " dado de alta.");

            // Modificar cocinero
            Cocinero c4 = new Cocinero("Ferran Adria", "888888888", "hombre", 68, 22, "Entrantes");
            gestor.updateCocinero(c4);
            System.out.println(c4.getNombre() + " modificado.");

            // Eliminar cocinero
            String cnombre = "Karlos Arguiñano2";
            gestor.deleteCocinero(cnombre);
            System.out.println(cnombre + " eliminado.");


            List<Cocinero> todosCocineros = gestor.selectAllCocineros();
            System.out.println("Listado de cocineros");
            for (Cocinero co : todosCocineros) {
                System.out.println(co);
            }
            List<Plato> todosPlatos = gestor.selectAllPlatos();
            System.out.println("Listado de platos");
            for (Plato pl : todosPlatos) {
                System.out.println(pl);
            }

            gestor.desconectar();
            System.out.println("Cerrada la conexión con la BBDD.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: "+ex.getMessage());
        }
    }
}
