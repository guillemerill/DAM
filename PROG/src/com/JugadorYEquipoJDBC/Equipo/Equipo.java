package com.JugadorYEquipoJDBC.Equipo;

import com.JugadorYEquipoJDBC.Model.Jugador;
import com.JugadorYEquipoJDBC.Persistence.basquetJDBC;

import java.sql.SQLException;
import java.util.List;

/*
 * Clase de Test
 */
public class Equipo {
    public static void main(String[] args) {
        basquetJDBC gestor = new basquetJDBC();
        try {
            System.out.println("Estableciendo conexión con la BBDD...");
            gestor.conectar();
            System.out.println("Conectado a la BBDD");
            gestor.deleteCocinero("Ferran Adria");
            gestor.deleteCocinero("Karlos Arguiñano");
            gestor.deleteCocinero("Karlos Arguiñano2");

            // Crear cocineros
            Jugador c1 = new Jugador("Ferran Adria", "888888888", "hombre", 56, 22, "Platos principales");
            gestor.insertCocinero(c1);
            System.out.println(c1.getNombre() + " dado de alta.");
            Jugador c2 = new Jugador("Karlos Arguiñano", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c2);
            System.out.println(c2.getNombre() + " dado de alta.");
            Jugador c3 = new Jugador("Karlos Arguiñano2", "999999999", "hombre", 68, 35, "Platos principales");
            gestor.insertCocinero(c3);
            System.out.println(c3.getNombre() + " dado de alta.");

            // Crear platos
            com.JugadorYEquipoJDBC.Model.Equipo p;
            p = new com.JugadorYEquipoJDBC.Model.Equipo("Macarrones", "Equipo principal", 6.53, c1);
            gestor.insertPlato(p);
            System.out.println(p.getNombre() + " dado de alta.");

            // Modificar cocinero
            Jugador c4 = new Jugador("Ferran Adria", "888888888", "hombre", 68, 22, "Entrantes");
            gestor.updateCocinero(c4);
            System.out.println(c4.getNombre() + " modificado.");

            // Eliminar cocinero
            String cnombre = "Karlos Arguiñano2";
            gestor.deleteCocinero(cnombre);
            System.out.println(cnombre + " eliminado.");


            List<Jugador> todosJugadors = gestor.selectAllCocineros();
            System.out.println("Listado de cocineros");
            for (Jugador co : todosJugadors) {
                System.out.println(co);
            }
            List<com.JugadorYEquipoJDBC.Model.Equipo> todosEquipos = gestor.selectAllPlatos();
            System.out.println("Listado de platos");
            for (com.JugadorYEquipoJDBC.Model.Equipo pl : todosEquipos) {
                System.out.println(pl);
            }

            gestor.desconectar();
            System.out.println("Cerrada la conexión con la BBDD.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: "+ex.getMessage());
        }
    }
}
