package com.carrera.repository;

import com.carrera.domain.Atleta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtletaRepository extends JpaRepository<Atleta, Long> {

    @Query("SELECT DISTINCT a.nacionalidad FROM Atleta a")
    List<String> getAllNacionalidades();

}