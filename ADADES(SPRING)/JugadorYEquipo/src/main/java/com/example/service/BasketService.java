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
    @Autowired
    private EquipoRepository equiporepository;


    public void creaJugadores(){
        Equipo eq1 = new Equipo("Equipo 1", "Sabadell", "04/11/2016");
        equiporepository.save(eq1);
        Equipo eq2 = new Equipo("Equipo 2", "Barcelona", "04/09/2016");
        equiporepository.save(eq2);
        Equipo eq3 = new Equipo("Equipo 3", "Hospitalet", "04/07/2016");
        equiporepository.save(eq3);
        Equipo eq4 = new Equipo("Equipo 4", "Manresa", "04/05/2016");
        equiporepository.save(eq4);
        Equipo eq5 = new Equipo("Equipo 5", "Barberà", "04/03/2016");
        equiporepository.save(eq5);

        Jugador jug1 = new Jugador ("Jugador 1", "24/11/1996", 50, 30, 10, "alero", eq1);
        jugadorRepository.save(jug1);
        Jugador jug2 = new Jugador ("Jugador 2", "25/11/1996", 51, 31, 9, "pivot", eq1);
        jugadorRepository.save(jug2);
        Jugador jug3 = new Jugador ("Jugador 3", "26/11/1996", 52, 32, 8, "alero", eq1);
        jugadorRepository.save(jug3);
        Jugador jug4 = new Jugador ("Jugador 4", "27/11/1996", 53, 33, 7, "pivot", eq1);
        jugadorRepository.save(jug4);
        Jugador jug5 = new Jugador ("Jugador 5", "28/11/1996", 54, 34, 6, "base", eq1);
        jugadorRepository.save(jug5);
        Jugador jug6 = new Jugador ("Jugador 6", "24/11/1996", 50, 30, 10, "alero", eq2);
        jugadorRepository.save(jug6);
        Jugador jug7 = new Jugador ("Jugador 7", "25/11/1996", 51, 31, 9, "pivot", eq2);
        jugadorRepository.save(jug7);
        Jugador jug8 = new Jugador ("Jugador 8", "26/11/1996", 52, 32, 8, "alero", eq2);
        jugadorRepository.save(jug8);
        Jugador jug9 = new Jugador ("Jugador 9", "27/11/1996", 53, 33, 7, "pivot", eq2);
        jugadorRepository.save(jug9);
        Jugador jug10 = new Jugador ("Jugador 10", "28/11/1996", 54, 34, 6, "base", eq2);
        jugadorRepository.save(jug10);
        Jugador jug11 = new Jugador ("Jugador 11", "24/11/1996", 50, 30, 10, "alero", eq3);
        jugadorRepository.save(jug11);
        Jugador jug12 = new Jugador ("Jugador 12", "25/11/1996", 51, 31, 9, "pivot", eq3);
        jugadorRepository.save(jug12);
        Jugador jug13 = new Jugador ("Jugador 13", "26/11/1996", 52, 32, 8, "alero", eq3);
        jugadorRepository.save(jug13);
        Jugador jug14 = new Jugador ("Jugador 14", "27/11/1996", 53, 33, 7, "pivot", eq3);
        jugadorRepository.save(jug14);
        Jugador jug15 = new Jugador ("Jugador 15", "28/11/1996", 54, 34, 6, "base", eq3);
        jugadorRepository.save(jug15);
        Jugador jug16 = new Jugador ("Jugador 16", "24/11/1996", 50, 30, 10, "alero", eq4);
        jugadorRepository.save(jug16);
        Jugador jug17 = new Jugador ("Jugador 17", "25/11/1996", 51, 31, 9, "pivot", eq4);
        jugadorRepository.save(jug17);
        Jugador jug18 = new Jugador ("Jugador 18", "26/11/1996", 52, 32, 8, "alero", eq4);
        jugadorRepository.save(jug18);
        Jugador jug19 = new Jugador ("Jugador 19", "27/11/1996", 53, 33, 7, "pivot", eq4);
        jugadorRepository.save(jug19);
        Jugador jug20 = new Jugador ("Jugador 20", "28/11/1996", 54, 34, 6, "base", eq4);
        jugadorRepository.save(jug20);
        Jugador jug21 = new Jugador ("Jugador 21", "24/11/1996", 50, 30, 10, "alero", eq5);
        jugadorRepository.save(jug21);
        Jugador jug22 = new Jugador ("Jugador 22", "25/11/1996", 51, 31, 9, "pivot", eq5);
        jugadorRepository.save(jug22);
        Jugador jug23 = new Jugador ("Jugador 23", "26/11/1996", 52, 32, 8, "alero", eq5);
        jugadorRepository.save(jug23);
        Jugador jug24 = new Jugador ("Jugador 24", "27/11/1996", 53, 33, 7, "pivot", eq5);
        jugadorRepository.save(jug24);
        Jugador jug25 = new Jugador ("Jugador 25", "28/11/1996", 54, 34, 6, "base", eq5);
        jugadorRepository.save(jug25);

        System.out.println(jugadorRepository.findBynombreContaining("Jugador 1"));
        System.out.println(jugadorRepository.findBynCanastasGreaterThanEqual(52));
        System.out.println(jugadorRepository.findBynAsistenciasBetween(31, 33));
        System.out.println(jugadorRepository.findByposicionIgnoreCase("alero"));
        System.out.println(jugadorRepository.findBynacimBefore("26/11/1996"));
        System.out.println(jugadorRepository.AvgnCanastasAndnAsistenciasAndnRebotesPerposicion());
        System.out.println(jugadorRepository.AvgAndMaxAndMinnCanastasAndnAsistenciasAndnRebotesPerposicion());
        System.out.println(equiporepository.findBylocalidad("Sabadell"));
        System.out.println(jugadorRepository.findByEquipoNombre("Equipo 5"));
        System.out.println(equiporepository.findJugadoresByequipoAndposicion("Equipo 5", "alero"));
        System.out.println(equiporepository.JugadorMaxCanastasEquipo("Equipo 3"));


    }
}
