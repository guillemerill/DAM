package com.carrera.repository;

import com.carrera.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {
    @Query("SELECT a FROM Atleta a WHERE a.nacionalidad = :nacionalidad")
    List<Atleta> getByNacionalidad(@Param("nacionalidad") String nacionalidad);

    @Query("SELECT a FROM Atleta a WHERE a.nacimiento < :fecha")
    List<Atleta> getByNacimientoBefore(@Param("fecha") LocalDate fecha);



}