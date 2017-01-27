package com.JugadorYEquipo;


import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import static com.JugadorYEquipo.EntradaDatos.*;

/*
Diseña una aplicación donde tengas un tipo de dato que guarde todos los Equipos y que incluya toda la información de la aplicación.
Un jugador no puede existir sino pertenece a un equipo.

Guarda los datos de la aplicación en un fichero llamado “basket.xml” .
Haz una aplicación que permita:
1. Dar de alta un equipo. Debe pedir todos los datos imprescindibles para crear un equipo .
2. Dar de alta un jugador. Debe pedir a qué equipo pertenece. Si el equipo está dado de alta pedirá los datos del jugador para incorporarlo a él.
3. Menú de consultas de jugadores.
4. Menú de consultas de equipos.
5. Salir
 */

public class Main {

    public static void main(String[] args) {
        // Datos de prueba para probar las consultas, etc.
        List<Equipo> liga = new ArrayList<>();
        List<Jugador> jugadores = new ArrayList<>();
        Equipo e1 = new Equipo("Stucom", "Barcelona", LocalDate.of(2012, Month.SEPTEMBER, 10));
        Jugador j1 = new Jugador("Super Mario", LocalDate.of(1995, Month.MARCH, 23), 10, 10, 0, "Alero", e1);
        Jugador j2 = new Jugador("Luigi", LocalDate.of(1994, Month.JANUARY, 8), 15, 20, 0, "Pivot", e1);

        Equipo e2 = new Equipo("Linkia", "Madrid", LocalDate.of(2013, Month.JUNE, 23));
        Jugador j3 = new Jugador("Kako Gazapo", LocalDate.of(1996, Month.FEBRUARY, 16), 8, 2, 0, "Base", e2);
        Jugador j4 = new Jugador("Toad", LocalDate.of(1993, Month.MAY, 15), 3, 300, 0, "Alero", e2);

        jugadores.add(j1);
        jugadores.add(j2);
        jugadores.add(j3);
        jugadores.add(j4);

        liga.add(e1);
        liga.add(e2);

        int opcion;
        do {
            menuPrincipal();
            opcion = inputInt("Escoge una opción");
            switch (opcion) {
                case 1:
                    altaEquipo(liga);
                    break;
                case 2:
                    altaJugador(liga, jugadores);
                    break;
                case 3:
                    consultasJugador();
                    break;
                case 4:
                    consultasEquipos();
                    break;
                case 5:
                    System.out.println("Hasta la próxima");
                    break;
                default:
                    System.out.println("Opción incorrecta.");
            }
        } while (opcion != 4);

        /**
         * TODO: cambiar todo a partir de aqui, crear menú y guardar datos
         */
        // Consultamos jugadores que contengan u
        List<Jugador> resultado = Consultas.buscarJugadoresPorNombre(jugadores, "u");
        System.out.println("Listado de jugadores con u en el nombre");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        // Jugadores que tengan más de 5 canastas
        resultado = Consultas.buscarJugadoresPorCanastasMayorOIgual(jugadores, 5);
        System.out.println("Listado de jugadores con más de 5 canastas");
        for (Jugador j : resultado) {
            System.out.println(j);
        }

        resultado = Consultas.buscarJugadoresEntreAsistencias(jugadores, 5, 300);
        System.out.println("Listado de jugadores por asistencias");
        for (Jugador j : resultado){
            System.out.println(j);
        }
    }

    /*
    1. Dar de alta un equipo. Debe pedir todos los datos imprescindibles para crear un equipo .
    2. Dar de alta un jugador. Debe pedir a qué equipo pertenece. Si el equipo está dado de alta pedirá los datos del jugador para incorporarlo a él.
    3. Menú de consultas de jugadores.
    4. Menú de consultas de equipos.
    5. Salir
     */
    private static void menuPrincipal() {
        System.out.println("------ Liga de Baloncesto ------");
        System.out.println("1. Dar de alta un equipo");
        System.out.println("2. Dar de alta un jugador");
        System.out.println("3. Menú de consultas de jugadores");
        System.out.println("4. Menú de consultas de equipos");
        System.out.println("5. Salir");
    }
    private static void altaEquipo(List<Equipo> liga) {
        String nombre = inputString("Introduce el nombre del equipo: ");
        String localidad = inputString("Introduce la localidad: ");

        //liga.add(new Test(nombre, localidad, TODO));
    }
    private static void altaJugador(List<Equipo> liga, List<Jugador> jugadores) {
        String nombre = inputString("Introduce el nombre del jugador: ");
        //String nacimiento = localdate;
        int canastas = inputInt("Introduce el número de canastas: ");
        int asistencias = inputInt("Introduce el número de asistencias: ");
        int rebotes = inputInt("Introduce el número de rebotes: ");
        String posicion = inputString("Introduce la posición: ");
        String nombreEq = inputString("Introduce el nombre del equipo: ");
        Equipo eq = new Equipo();

        boolean encontrado = false;
        for (Equipo e : liga) {
            if (e.getNombre().toLowerCase().equals(nombreEq.toLowerCase())) {
                encontrado = true;
                eq = e;
            }
        }

        //if (encontrado)
            //jugadores.add(new Jugador(nombre, nacimiento, canastas, asistencias, rebotes, posicion, eq);
    }
    private static void consultasJugador() {
        System.out.println("------ Consultas Jugadores ------");
        System.out.println("1. Buscar jugadores por nombre.");
        System.out.println("2. Buscar jugadores con un númrero de canastas igual o superior al introducido.");
        System.out.println("3. Buscar jugadores por asistencias en un rango.");
        System.out.println("4. Buscar jugadores por posición.");
        System.out.println("4. Buscar jugadores menores a la fecha introducida.");
        System.out.println("5. Salir");
    }
    private static void consultasEquipos() {
    }
}
