package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MainLiga {
    public static void main (String[] args) {
        List<Equipo> liga = new ArrayList<>();


        Jugador jug1 = new Jugador("Jugador 1", LocalDate.of(1996, 11, 24), 50, "alero");
        Jugador jug2 = new Jugador("Jugador 2", "25/11/1996", 51, 31, 9, "pivot", eq1);
        Jugador jug3 = new Jugador("Jugador 3", "26/11/1996", 52, 32, 8, "alero", eq1);
        Jugador jug4 = new Jugador("Jugador 4", "27/11/1996", 53, 33, 7, "pivot", eq1);
        Jugador jug5 = new Jugador("Jugador 5", "28/11/1996", 54, 34, 6, "base", eq1);
        Jugador jug6 = new Jugador("Jugador 6", "24/11/1996", 50, 30, 10, "alero", eq2);
        Jugador jug7 = new Jugador("Jugador 7", "25/11/1996", 51, 31, 9, "pivot", eq2);
        Jugador jug8 = new Jugador("Jugador 8", "26/11/1996", 52, 32, 8, "alero", eq2);
        Jugador jug9 = new Jugador("Jugador 9", "27/11/1996", 53, 33, 7, "pivot", eq2);
        Jugador jug10 = new Jugador("Jugador 10", "28/11/1996", 54, 34, 6, "base", eq2);
        Jugador jug11 = new Jugador("Jugador 11", "24/11/1996", 50, 30, 10, "alero", eq3);
        Jugador jug12 = new Jugador("Jugador 12", "25/11/1996", 51, 31, 9, "pivot", eq3);
        Jugador jug13 = new Jugador("Jugador 13", "26/11/1996", 52, 32, 8, "alero", eq3);
        Jugador jug14 = new Jugador("Jugador 14", "27/11/1996", 53, 33, 7, "pivot", eq3);
        Jugador jug15 = new Jugador("Jugador 15", "28/11/1996", 54, 34, 6, "base", eq3);
        Jugador jug16 = new Jugador("Jugador 16", "24/11/1996", 50, 30, 10, "alero", eq4);
        Jugador jug17 = new Jugador("Jugador 17", "25/11/1996", 51, 31, 9, "pivot", eq4);
        Jugador jug18 = new Jugador("Jugador 18", "26/11/1996", 52, 32, 8, "alero", eq4);
        Jugador jug19 = new Jugador("Jugador 19", "27/11/1996", 53, 33, 7, "pivot", eq4);
        Jugador jug20 = new Jugador("Jugador 20", "28/11/1996", 54, 34, 6, "base", eq4);
        Jugador jug21 = new Jugador("Jugador 21", "24/11/1996", 50, 30, 10, "alero", eq5);
        Jugador jug22 = new Jugador("Jugador 22", "25/11/1996", 51, 31, 9, "pivot", eq5);
        Jugador jug23 = new Jugador("Jugador 23", "26/11/1996", 52, 32, 8, "alero", eq5);
        Jugador jug24 = new Jugador("Jugador 24", "27/11/1996", 53, 33, 7, "pivot", eq5);
        Jugador jug25 = new Jugador("Jugador 25", "28/11/1996", 54, 34, 6, "base", eq5);

        List<Jugador> jeq1 = new ArrayList<>();
        jeq1.add(jug1);
        jeq1.add(jug2);
        jeq1.add(jug3);
        jeq1.add(jug4);
        jeq1.add(jug5);
        Equipo eq1 = new Equipo("Equipo 1", LocalDate.of(1996, 11, 24), "Sabadell", jeq1);
        liga.add(eq1);
        Equipo eq2 = new Equipo("Equipo 2", "Barcelona", "04/09/2016");
        liga.add(eq2);
        Equipo eq3 = new Equipo("Equipo 3", "Hospitalet", "04/07/2016");
        liga.add(eq3);
        Equipo eq4 = new Equipo("Equipo 4", "Manresa", "04/05/2016");
        liga.add(eq4);
        Equipo eq5 = new Equipo("Equipo 5", "Barberà", "04/03/2016");
        liga.add(eq5);


    }
}
