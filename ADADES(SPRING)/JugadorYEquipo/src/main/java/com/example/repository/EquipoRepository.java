package com.example.repository;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface EquipoRepository extends JpaRepository<Equipo, Long> {
    //Spring Data Queries
    // a. Consulta los equipos existentes en una localidad determinada.
    List<Equipo> findBylocalidad(String localidad);

    // b. Devuelve todos los jugadores de un equipo, a partir del nombre completo del equipo.
    @Query("SELECT jugador FROM Jugador jugador WHERE jugador.equipo.nombre is :nombre")
    List<Jugador> findJugadoresByEquipo(@Param("nombre") String nombre);

    // c. Devuelve todos los jugadores de un equipo, que además jueguen en la misma posición (parámetro adicional de la consulta), por ejemplo, alero.
    @Query("SELECT jugador FROM Jugador jugador WHERE jugador.equipo.nombre is :nombre AND jugador.posicion is :posicion")
    List<Jugador> findJugadoresByequipoAndposicion(@Param("nombre") String nombre, @Param("posicion") String posicion);

    // d. Devuelve el jugador que más canastas ha realizado de un equipo determinado como parámetro.
    @Query("SELECT jugador.nombre, MAX(jugador.canastasTotales) FROM Jugador jugador WHERE jugador.equipo.nombre = :nombre ")
    List<Object[]> findByJugadorByMAXnCanastasAndEquipo(@Param("nombre") String nombre);

}
