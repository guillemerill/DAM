package com.carrera.repository;

import com.carrera.domain.Medalla;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MedallaRepository extends JpaRepository<Medalla, Long> {


}