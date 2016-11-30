package com.carrera.service;

import com.carrera.domain.Atleta;
import com.carrera.domain.Medalla;
import com.carrera.domain.TipoMedalla;
import com.carrera.repository.AtletaRepository;
import com.carrera.repository.MedallaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AtletaService {

    @Autowired
    private MedallaRepository medallas;
    @Autowired
    private AtletaRepository atletas;



    public void creaJugadores() {
        Medalla m1e1 = new Medalla(TipoMedalla.Oro, "Maratón", "Rio 2016");
        medallas.save(m1e1);
        Medalla m2e1 = new Medalla(TipoMedalla.Plata, "Maratón", "Rio 2016");
        medallas.save(m2e1);
        Medalla m3e1 = new Medalla(TipoMedalla.Bronce, "Maratón", "Rio 2016");
        medallas.save(m3e1);
        Medalla m1e2 = new Medalla(TipoMedalla.Oro, "Vallas", "Rio 2016");
        medallas.save(m1e2);
        Medalla m2e2 = new Medalla(TipoMedalla.Plata, "Vallas", "Rio 2016");
        medallas.save(m2e2);
        Medalla m3e2 = new Medalla(TipoMedalla.Bronce, "Vallas", "Rio 2016");
        medallas.save(m3e2);
        Medalla m1e3 = new Medalla(TipoMedalla.Oro, "Marcha", "Rio 2016");
        medallas.save(m1e3);
        Medalla m2e3 = new Medalla(TipoMedalla.Plata, "Marcha", "Rio 2016");
        medallas.save(m2e3);
        Medalla m3e3 = new Medalla(TipoMedalla.Bronce, "Marcha", "Rio 2016");
        medallas.save(m3e3);

        Atleta a1e1 = new Atleta("Eliud", "Kipchoge", "Kenia", LocalDate.of((1984, 11, 5), m1e1);
        atletas.save(a1e1);
        Atleta a2e1 = new Atleta("Feyisa", "Lilesa", "Etiopía", LocalDate.of((1990, 2, 1), m2e1);
        atletas.save(a2e1);
        Atleta a3e1 = new Atleta("Galen", "Rupp", "EEUU", LocalDate.of((1986, 5, 8), m3e1);
        atletas.save(a3e1);
        Jugador jug2 = new Jugador("Jugador 2", "25/11/1996", 51, 31, 9, "pivot", eq1);
        jugadorRepository.save(jug2);
        Jugador jug3 = new Jugador("Jugador 3", "26/11/1996", 52, 32, 8, "alero", eq1);
        jugadorRepository.save(jug3);
        Jugador jug4 = new Jugador("Jugador 4", "27/11/1996", 53, 33, 7, "pivot", eq1);
        jugadorRepository.save(jug4);
        Jugador jug5 = new Jugador("Jugador 5", "28/11/1996", 54, 34, 6, "base", eq1);
        jugadorRepository.save(jug5);
        Jugador jug6 = new Jugador("Jugador 6", "24/11/1996", 50, 30, 10, "alero", eq2);
        jugadorRepository.save(jug6);
        Jugador jug7 = new Jugador("Jugador 7", "25/11/1996", 51, 31, 9, "pivot", eq2);
        jugadorRepository.save(jug7);
        Jugador jug8 = new Jugador("Jugador 8", "26/11/1996", 52, 32, 8, "alero", eq2);
        jugadorRepository.save(jug8);
        Jugador jug9 = new Jugador("Jugador 9", "27/11/1996", 53, 33, 7, "pivot", eq2);
        jugadorRepository.save(jug9);
        Jugador jug10 = new Jugador("Jugador 10", "28/11/1996", 54, 34, 6, "base", eq2);
        jugadorRepository.save(jug10);
        Jugador jug11 = new Jugador("Jugador 11", "24/11/1996", 50, 30, 10, "alero", eq3);
        jugadorRepository.save(jug11);
        Jugador jug12 = new Jugador("Jugador 12", "25/11/1996", 51, 31, 9, "pivot", eq3);
        jugadorRepository.save(jug12);
        Jugador jug13 = new Jugador("Jugador 13", "26/11/1996", 52, 32, 8, "alero", eq3);
        jugadorRepository.save(jug13);
        Jugador jug14 = new Jugador("Jugador 14", "27/11/1996", 53, 33, 7, "pivot", eq3);
        jugadorRepository.save(jug14);
        Jugador jug15 = new Jugador("Jugador 15", "28/11/1996", 54, 34, 6, "base", eq3);
        jugadorRepository.save(jug15);
        Jugador jug16 = new Jugador("Jugador 16", "24/11/1996", 50, 30, 10, "alero", eq4);
        jugadorRepository.save(jug16);
        Jugador jug17 = new Jugador("Jugador 17", "25/11/1996", 51, 31, 9, "pivot", eq4);
        jugadorRepository.save(jug17);
        Jugador jug18 = new Jugador("Jugador 18", "26/11/1996", 52, 32, 8, "alero", eq4);
        jugadorRepository.save(jug18);
        Jugador jug19 = new Jugador("Jugador 19", "27/11/1996", 53, 33, 7, "pivot", eq4);
        jugadorRepository.save(jug19);
        Jugador jug20 = new Jugador("Jugador 20", "28/11/1996", 54, 34, 6, "base", eq4);
        jugadorRepository.save(jug20);
        Jugador jug21 = new Jugador("Jugador 21", "24/11/1996", 50, 30, 10, "alero", eq5);
        jugadorRepository.save(jug21);
        Jugador jug22 = new Jugador("Jugador 22", "25/11/1996", 51, 31, 9, "pivot", eq5);
        jugadorRepository.save(jug22);
        Jugador jug23 = new Jugador("Jugador 23", "26/11/1996", 52, 32, 8, "alero", eq5);
        jugadorRepository.save(jug23);
        Jugador jug24 = new Jugador("Jugador 24", "27/11/1996", 53, 33, 7, "pivot", eq5);
        jugadorRepository.save(jug24);
        Jugador jug25 = new Jugador("Jugador 25", "28/11/1996", 54, 34, 6, "base", eq5);
        jugadorRepository.save(jug25);

        System.out.println(jugadorRepository.findBynombreContaining("Jugador 1"));
        System.out.println(jugadorRepository.findBynCanastasGreaterThanEqual(52));
        System.out.println(jugadorRepository.findBynAsistenciasBetween(31, 33));
        System.out.println(jugadorRepository.findByposicionIgnoreCase("alero"));
        System.out.println(jugadorRepository.findBynacimBefore("26/11/1996"));
        showStatistics(jugadorRepository.AvgnCanastasAndnAsistenciasAndnRebotesPerposicion());
        showStatistics2(jugadorRepository.AvgAndMaxAndMinnCanastasAndnAsistenciasAndnRebotesPerposicion());
        System.out.println(equiporepository.findBylocalidad("Sabadell"));
        System.out.println(jugadorRepository.findByEquipoNombre("Equipo 5"));
        System.out.println(equiporepository.findJugadoresByequipoAndposicion("Equipo 5", "alero"));
        System.out.println(equiporepository.JugadorMaxCanastasEquipo("Equipo 3"));


    }

    private void showStatistics(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posición: " + statistic[0]);
            System.out.println("Canastas = " + statistic[1]);
            System.out.println("Asistencias = " + statistic[2]);
            System.out.println("Rebotes = " + statistic[3] + System.lineSeparator());
        }
    }

    private void showStatistics2(List<Object[]> statisticsList) {
        for (Object[] statistic : statisticsList) {
            System.out.println("Posición: " + statistic[0]);
            System.out.println("AVGCanastas = " + statistic[1]);
            System.out.println("MAXCanastas = " + statistic[2]);
            System.out.println("MINCanastas = " + statistic[3]);
            System.out.println("AVGAsistencias = " + statistic[4]);
            System.out.println("MAXAsistencias = " + statistic[5]);
            System.out.println("MINAsistencias = " + statistic[6]);
            System.out.println("AVGRebotes = " + statistic[7]);
            System.out.println("MAXRebotes = " + statistic[8]);
            System.out.println("MINRebotes = " + statistic[9] + System.lineSeparator());
        }
    }
}