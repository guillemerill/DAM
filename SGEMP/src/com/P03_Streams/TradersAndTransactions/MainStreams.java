package com.P03_Streams.TradersAndTransactions;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DAM on 12/12/16.
 */
public class MainStreams {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");

        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950)
        );

        /*
        2.2	Devolver con una lista  todos los jugadores que hayan obtenido más de 500 canastas.
        2.3	Devolver con una lista  todos los jugadores que hayan obtenido entre 200 y 500 canastas.
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
         */
    }
}
