package com.example.repository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by DAM on 20/10/16.
 */
public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    /*
    a. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre
    completo.
    b. Buscar jugadores que hayan conseguido un número mayor o igual a un número de canastas
    especificado como parámetro.
    c. Buscar jugadores que hayan efectuado un número de asistencias dentro de un rango
    especificado como parámetro.
    d. Buscar jugadores que pertenezcan a una posición específica, por ejemplo: base
    e. Buscar jugadores que hayan nacido en una fecha anterior a una fecha especificada como
    parámetro.
    f. Agrupar los jugadores por la posición del campo y devolver para cada grupo la siguiente
    información: la media de canastas, asistencias y rebotes.
    g. Lo mismo que el punto anterior pero devolviendo la media, el máximo y el mínimo de
    canastas, asistencias y rebotes.
     */

    // Spring Data Queries
    List<Jugador> findByYearOfFabGreaterThanEqual(Integer yearOfFab);

    List<Jugador> findByYearOfFabLessThan(Integer yearOfFab);

    List<Jugador> findByYearOfFabBetween(Integer min, Integer max);

    List<Jugador> findByPriceGreaterThanEqual(Double price);

    List<Jugador> findByPriceBetween(Double min, Double max);

    Jugador findByPlateNumber(String plateNumber);

    List<Jugador> findByBrandAndModel(String brand, String model);

    List<Jugador> findByBrandAndPrice(String brand, Double price);

    List<Jugador> findByBrandAndModelAndPriceGreaterThanEqual(String brand, String model, Double price);

    List<Jugador> findByBrand(String brand);

    List<Jugador> findByYearOfFab(Integer yearOfFab);


    //JPQL Queries

    @Query("SELECT AVG(jug.price) from Jugador jug WHERE jug.brand = :brand ")
    Double findAveragePerBrand(@Param("brand") String brand);

    @Query("SELECT jug FROM Jugador jug WHERE jug.plateNumber LIKE CONCAT('%',:plateNumberPart,'%')")
    List<Jugador> findCarByPlateNumberSubstring(@Param("plateNumberPart") String plateNumberPart);

    //Forma2. Con Spring Data Query

    List<Jugador> findByPlateNumberContains(String plateNumberPart);

    @Query("SELECT jug.brand, AVG(jug.price), MIN(jug.price), MAX(jug.price) " +
            "FROM Jugador jug " +
            "GROUP BY car.brand")
    List<Object[]> AvgAndMaxAndMinPricesPerBrand();

    //Si no especificamos es asc por defecto
    @Query("SELECT jug.brand, AVG(jug.price), MIN(jug.price), MAX(jug.price) " +
            "FROM Jugador jug " +
            "GROUP BY jug.brand " +
            "ORDER BY AVG(jug.price) DESC ")
    List<Object[]> AvgAndMaxAndMinPricesPerBrandOrderedByAVGPrice();


    @Query("SELECT jug.yearOfFab, COUNT(jug) " +
            "FROM Jugador jug " +
            "GROUP BY jug.yearOfFab")
    List<Object[]> CarsMadeByYear();
}
