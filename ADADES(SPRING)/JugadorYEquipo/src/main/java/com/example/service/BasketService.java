package com.example.service;

import com.example.domain.Jugador;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {


    @Autowired
    private JugadorRepository jugadorRepository;


    public void creaJugadores(){

        Jugador jug1 = new Jugador ("Jugador 1", "24/11/1996", 50, 30, 10, "alero");
        jugadorRepository.save(jug1);
        Jugador jug2 = new Jugador ("Jugador 2", "25/11/1996", 51, 31, 9, "pivot");
        jugadorRepository.save(jug2);
        Jugador jug3 = new Jugador ("Jugador 3", "26/11/1996", 52, 32, 8, "alero");
        jugadorRepository.save(jug3);
        Jugador jug4 = new Jugador ("Jugador 4", "27/11/1996", 53, 33, 7, "pivot");
        jugadorRepository.save(jug4);
        Jugador jug5 = new Jugador ("Jugador 5", "28/11/1996", 54, 34, 6, "base");
        jugadorRepository.save(jug5);


        // el objeto es cada una de las líneas de la tabla que muestra al hacer la query. statistic[] son las columnas
    }
}
