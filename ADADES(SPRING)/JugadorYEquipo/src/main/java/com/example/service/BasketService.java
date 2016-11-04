package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasketService {


    @Autowired
    private JugadorRepository jugadorRepository;
    private EquipoRepository equipoRepository;


    public void creaJugadores(){
        Equipo eq1 = new Equipo("Polinico's", "Sabadell", "04/11/2016");
        Equipo eq2 = new Equipo("Polinico's", "Barcelona", "04/09/2016");
        Equipo eq3 = new Equipo("Polinico's", "Hospitalet", "04/07/2016");
        Equipo eq4 = new Equipo("Polinico's", "Manresa", "04/05/2016");
        Equipo eq5 = new Equipo("Polinico's", "Barberà", "04/03/2016");

        Jugador jug1 = new Jugador ("Jugador 1", "24/11/1996", 50, 30, 10, "alero", eq1);
        jugadorRepository.save(jug1);
        Jugador jug2 = new Jugador ("Jugador 2", "25/11/1996", 51, 31, 9, "pivot", eq2);
        jugadorRepository.save(jug2);
        Jugador jug3 = new Jugador ("Jugador 3", "26/11/1996", 52, 32, 8, "alero", eq3);
        jugadorRepository.save(jug3);
        Jugador jug4 = new Jugador ("Jugador 4", "27/11/1996", 53, 33, 7, "pivot", eq4);
        jugadorRepository.save(jug4);
        Jugador jug5 = new Jugador ("Jugador 5", "28/11/1996", 54, 34, 6, "base", eq5);
        jugadorRepository.save(jug5);

        System.out.println(jugadorRepository.findBynombreContaining("Jugador 1"));
        System.out.println(jugadorRepository.findBynCanastasGreaterThanEqual(52));
        System.out.println(jugadorRepository.findBynAsistenciasBetween(31, 33));
        System.out.println(jugadorRepository.findByposicionIgnoreCase("alero"));
        System.out.println(jugadorRepository.findBynacimBefore("26/11/1996"));
        System.out.println(jugadorRepository.AvgnCanastasAndnAsistenciasAndnRebotesPerposicion());
        System.out.println(jugadorRepository.AvgAndMaxAndMinnCanastasAndnAsistenciasAndnRebotesPerposicion());
    }
}
