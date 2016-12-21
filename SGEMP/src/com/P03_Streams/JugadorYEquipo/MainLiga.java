package com.P03_Streams.JugadorYEquipo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/*
2.4	Devolver en una lista exclusivamente los nombres de los jugadores que satisfacen  los requisitos del 1.3
2.5	Devolver con una lista todos los jugadores ordenados por la fecha de nacimiento.
2.6	Devolver con una lista todos los jugadores ordenados por número de canastas.
2.7	Devolver con una lista con los cinco jugadores que hayan realizado más canastas.
2.8	Devolver con una lista todos los jugadores que satisfacen el punto 1.3 ordenados por la fecha de nacimiento de manera descendente.
2.9	Devolver con una lista todos los jugadores que satisfacen el filtro del punto 1.3 ordenados, en primer lugar por número de canastas y en segundo lugar (si tienen el mismo número de canastas) por la fecha de nacimiento.
2.10	Devolver el jugador que ha realizado el mínimo número de canastas.
2.11	Devolver el jugador que ha realizado el máximo número de canastas.
2.12	Devolver la media de canastas de todos los jugadores.
2.13	Devolver con una lista todos los jugadores que pertenezcan a equipos cuya localidad sea Barcelona.
2.14	Devolver con un boolean si hay algún jugador que ha conseguido más de 4.000 canastas
2.15	Devolver con un boolean si todos los jugadores han conseguido más de 50 canastas.
2.16	Devolver con un boolean si todos los jugadores del primer equipo añadido han conseguido más de 50 canastas.
2.17	Devolver un Map<String, List<Equipo>> agrupando los equipos que pertenecen a una misma localidad. Hay un ejemplo similar en la página 172 (6.3 Grouping)
2.18	Devolver la suma del número de canastas de todos los jugadores. Utilizar la operación Reduce (página 132,  5.4)
Extra: todos los jugadores de un equipo en concreto.

 */
public class MainLiga {
    public static void main (String[] args) {
        List<Jugador> jugadores = creaJugadores();

        // 2.2	Devolver con una lista todos los jugadores que hayan obtenido más de 500 canastas.
        System.out.println(jugadores.stream().filter(j -> j.getCanastas() > 500));
        // 2.3	Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.

        return atletaRepository
                .findAll()
                .parallelStream()
                .collect(Collectors.groupingBy(atleta -> {
                    if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Oro)){
                        return TipoMedalla.Oro;
                    } else if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Plata)){
                        return TipoMedalla.Plata;
                    } else if (atleta.getMedallas().stream().anyMatch(medalla -> medalla.getTipoMedalla() == TipoMedalla.Bronce)){
                        return TipoMedalla.Bronce;
                    } else {
                        return TipoMedalla.Ninguna;
                    }
                }));




    }

    public static List<Jugador> creaJugadores() {
        Equipo eq1 = new Equipo("Equipo 1", LocalDate.of(1996, 11, 24), "Sabadell");
        Equipo eq2 = new Equipo("Equipo 2", LocalDate.of(1996, 11, 25), "Barcelona");
        Equipo eq3 = new Equipo("Equipo 3", LocalDate.of(1996, 11, 26), "Hospitalet");
        Equipo eq4 = new Equipo("Equipo 4", LocalDate.of(1996, 11, 27), "Barberà");

        List<Jugador> jugadores = new ArrayList<>();
        Jugador jug1 = new Jugador("Jugador 1", LocalDate.of(1996, 11, 24), 50, "alero", eq1);
        Jugador jug2 = new Jugador("Jugador 2", LocalDate.of(1996, 11, 25), 51, "pivot", eq1);
        Jugador jug3 = new Jugador("Jugador 3", LocalDate.of(1996, 11, 26), 52, "alero", eq1);
        Jugador jug4 = new Jugador("Jugador 4", LocalDate.of(1996, 11, 27), 53, "pivot", eq1);
        Jugador jug5 = new Jugador("Jugador 5", LocalDate.of(1996, 11, 28), 54, "base", eq1);
        Jugador jug6 = new Jugador("Jugador 6", LocalDate.of(1996, 11, 29), 55, "alero", eq2);
        Jugador jug7 = new Jugador("Jugador 7", LocalDate.of(1996, 11, 30), 55, "pivot", eq2);
        Jugador jug8 = new Jugador("Jugador 8", LocalDate.of(1996, 12, 1), 55, "alero", eq2);
        Jugador jug9 = new Jugador("Jugador 9", LocalDate.of(1996, 12, 2), 55, "pivot", eq2);
        Jugador jug10 = new Jugador("Jugador 10", LocalDate.of(1996, 12, 3), 55, "base", eq2);
        Jugador jug11 = new Jugador("Jugador 11", LocalDate.of(1996, 12, 4), 55, "alero", eq3);
        Jugador jug12 = new Jugador("Jugador 12", LocalDate.of(1996, 12, 5), 55, "pivot", eq3);
        Jugador jug13 = new Jugador("Jugador 13", LocalDate.of(1996, 12, 6), 55, "alero", eq3);
        Jugador jug14 = new Jugador("Jugador 14", LocalDate.of(1996, 12, 7), 55, "pivot", eq3);
        Jugador jug15 = new Jugador("Jugador 15", LocalDate.of(1996, 12, 8), 55, "base", eq3);
        Jugador jug16 = new Jugador("Jugador 16", LocalDate.of(1996, 12, 9), 55, "alero", eq4);
        Jugador jug17 = new Jugador("Jugador 17", LocalDate.of(1996, 12, 10), 55, "pivot", eq4);
        Jugador jug18 = new Jugador("Jugador 18", LocalDate.of(1996, 12, 11), 55, "base", eq4);
        Jugador jug19 = new Jugador("Jugador 19", LocalDate.of(1996, 12, 12), 55, "alero", eq4);
        Jugador jug20 = new Jugador("Jugador 20", LocalDate.of(1996, 12, 13), 55, "pivot", eq4);

        jugadores.add(jug1);
        jugadores.add(jug2);
        jugadores.add(jug3);
        jugadores.add(jug4);
        jugadores.add(jug5);
        jugadores.add(jug6);
        jugadores.add(jug7);
        jugadores.add(jug8);
        jugadores.add(jug9);
        jugadores.add(jug10);
        jugadores.add(jug11);
        jugadores.add(jug12);
        jugadores.add(jug13);
        jugadores.add(jug14);
        jugadores.add(jug15);
        jugadores.add(jug16);
        jugadores.add(jug17);
        jugadores.add(jug18);
        jugadores.add(jug19);
        jugadores.add(jug20);



        return jugadores;
    }
}
