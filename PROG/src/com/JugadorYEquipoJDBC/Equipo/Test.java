package com.JugadorYEquipoJDBC.Equipo;

import com.JugadorYEquipoJDBC.Model.Jugador;
import com.JugadorYEquipoJDBC.Model.Equipo;
import com.JugadorYEquipoJDBC.Persistence.basquetJDBC;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

/*
 * Clase de Test
 */
public class Test {
    public static void main(String[] args) {
        basquetJDBC gestor = new basquetJDBC();
        try {
            System.out.println("Estableciendo conexión con la BBDD...");
            gestor.conectar();
            System.out.println("Conectado a la BBDD");

            gestor.deleteAll();

            // 1
            System.out.println("Creando los equipos...");
            Equipo eq1 = new Equipo("City 1", "Sabadell", LocalDate.of(2016, 11, 4));
            Equipo eq2 = new Equipo("City 2", "Barcelona", LocalDate.of(2016, 9, 4));

            gestor.insertEquipo(eq1);
            gestor.insertEquipo(eq2);
            System.out.println("Equipos creados correctamente!");
            System.out.println(gestor.obtenerTodosEquipos());

            // 2
            System.out.println("Creando los jugadores...");
            Jugador jug1 = new Jugador("Jugador 1", LocalDate.of(1996, 11, 25), 50, 30, 10, "alero", eq1);
            Jugador jug2 = new Jugador("Jugador 2", LocalDate.of(1996, 11, 26), 51, 31, 9, "pivot", eq1);
            Jugador jug3 = new Jugador("Jugador 3", LocalDate.of(1996, 11, 27), 52, 32, 8, "alero", eq1);
            Jugador jug4 = new Jugador("Jugador 4", LocalDate.of(1996, 11, 28), 53, 33, 7, "pivot", eq1);
            Jugador jug5 = new Jugador("Jugador 5", LocalDate.of(1996, 11, 29), 54, 34, 6, "base", eq1);
            Jugador jug6 = new Jugador("Jugador 6", LocalDate.of(1996, 11, 25), 50, 30, 10, "alero", eq2);
            Jugador jug7 = new Jugador("Jugador 7", LocalDate.of(1996, 11, 26), 51, 31, 9, "pivot", eq2);
            Jugador jug8 = new Jugador("Jugador 8", LocalDate.of(1996, 11, 27), 52, 32, 8, "alero", eq2);
            Jugador jug9 = new Jugador("Jugador 9", LocalDate.of(1996, 11, 28), 53, 33, 7, "pivot", eq2);
            Jugador jug10 = new Jugador("Jugador 10", LocalDate.of(1996, 11, 29), 54, 34, 6, "base", eq2);

            gestor.insertJugador(jug1);
            gestor.insertJugador(jug2);
            gestor.insertJugador(jug3);
            gestor.insertJugador(jug4);
            gestor.insertJugador(jug5);
            gestor.insertJugador(jug6);
            gestor.insertJugador(jug7);
            gestor.insertJugador(jug8);
            gestor.insertJugador(jug9);
            gestor.insertJugador(jug10);
            System.out.println("Jugadores creados correctamente!");
            System.out.println(gestor.obtenerTodosJugadores());

            // 3
            System.out.println("Modificando Jugador 1");
            gestor.updateJugador("Jugador 1", 53, 33, 15);
            System.out.println(gestor.obtenerJugador("Jugador 1"));

            // 4
            System.out.println("Modificando equipo del Jugador 1");
            gestor.updateEquipoJugador("Jugador 1", eq2);

            // 5
            System.out.println("Borrando Jugador 2");
            gestor.deleteJugador("Jugador 2");

            // 6
            System.out.println("Mostrando Jugador 1");
            System.out.println(gestor.obtenerJugador("Jugador 1"));

            // 7
            System.out.println("Mostrando jugadores que contienen 1...");
            System.out.println(gestor.obtenerJugadoresContainsEquipo("1"));

            // 8
            System.out.println("Mostrando jugadores con 54 canastas o mas...");
            System.out.println(gestor.obtenerJugadoresMasCanastas(54));

            // 9
            System.out.println("Mostrando jugadores con asistencias entre 31 y 32...");
            System.out.println(gestor.obtenerJugadoresAssistBetween(31, 33));

            // 10
            System.out.println("Mostrando jugadores pivot...");
            System.out.println(gestor.selectJugadoresPosicion("pivot"));

            // 11
            System.out.println("Mostrando jugadores nacidos antes de 27/11/1996...");
            System.out.println(gestor.selectJugadoresBirth(LocalDate.of(1996, 11, 27)));

            // 12
            System.out.println("Estadísticas por posición");
            System.out.println(gestor.obtenerEstadisticasPosicion());

            // 13
            System.out.println("Ranking de jugadores");
            System.out.println(gestor.obtenerRanking());

            // 14
            System.out.println("Posicion de Jugador 5 en el Ranking");
            System.out.println(gestor.buscarJugadorRanking("Jugador 5"));

            // 15
            System.out.println("Equipos de Sabadell");
            System.out.println(gestor.selectEquiposByLocalidad("Sabadell"));

            // 16
            System.out.println("Jugadores City 1");
            System.out.println(gestor.selectJugadoresByNombreEquipo("City 1"));

            // 17
            System.out.println("Jugadores pivot de City 1");
            System.out.println(gestor.selectJugadoresEquipoPosicion("City 1", "pivot"));

            // 18
            System.out.println("Jugador con más canastas del City 1");
            System.out.println(gestor.getJugadorMaxCanastas("City 1"));

            gestor.deleteAll();
            gestor.desconectar();
            System.out.println("Cerrada la conexión con la BBDD.");
        } catch (SQLException ex) {
            System.out.println("Error con la BBDD: "+ex.getMessage());
        }
    }
}
