package com.JugadorYEquipo;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

/*
Diseña una aplicación donde tengas un tipo de dato que guarde todos los
Equipos y que incluya toda la información de la aplicación . Un jugador no
puede existir sino pertenece a un equipo.

Guarda los datos de la aplicación en un fichero llamado “basket.xml” .
Haz una aplicación que permita:
1. Dar de alta un equipo. Debe pedir todos los datos imprescindibles
para crear un equipo .
2. Dar de alta un jugador. Debe pedir a qué equipo pertenece. Si el
equipo está dado de alta pedirá los datos del jugador para
incorporarlo a él.
3. Menú de consultas de jugadores.
4. Menú de consultas de equipos.
5. Salir
 */

public class Main {

    public static void main(String[] args) {
        // Datos de prueba para probar las consultas, etc.
        List<Equipo> liga = new ArrayList<>();
        Equipo e1 = new Equipo("Stucom", "Barcelona", LocalDate.of(2012, Month.SEPTEMBER, 10));
        Jugador j1 = new Jugador("Super Mario", LocalDate.of(1995, Month.MARCH, 23), 10, 10, 0, "Alero");
        Jugador j2 = new Jugador("Luigi", LocalDate.of(1994, Month.JANUARY, 8), 15, 20, 0, "Pivot");
        e1.getJugadores().add(j1);
        e1.getJugadores().add(j2);

        Equipo e2 = new Equipo("Linkia", "Madrid", LocalDate.of(2013, Month.JUNE, 23));
        Jugador j3 = new Jugador("Kako Gazapo", LocalDate.of(1996, Month.FEBRUARY, 16), 8, 2, 0, "Base");
        Jugador j4 = new Jugador("Toad", LocalDate.of(1993, Month.MAY, 15), 3, 300, 0, "Alero");
        e2.getJugadores().add(j3);
        e2.getJugadores().add(j4);

        liga.add(e1);
        liga.add(e2);

        // Consultamos jugadores que contengan u
        List<Jugador> resultado = Consultas.buscarJugadoresPorNombre(liga, "u");
        System.out.println("Listado de jugadores con u en el nombre");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        // Jugadores que tengan más de 5 canastas
        resultado = Consultas.buscarJugadoresPorCanastasMayorOIgual(liga, 5);
        System.out.println("Listado de jugadores con más de 5 canastas");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        resultado = Consultas.buscarJugadoresEntreAsistencias(liga, 5, 300);
        System.out.println("Listado de jugadores por asistencias");
        for (Jugador j : resultado){
            System.out.println(j);
        }
    }
}
