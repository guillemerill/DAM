package com.example.repository;

import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {
    /*
    a. Buscar jugadores por nombre, de manera que no sea necesario introducir el nombre completo.
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

    //Spring Data Queries
    List<Jugador> findByName(Integer yearOfFab);
    List<Jugador> findByYCanastasGreaterOrEqual(Integer nCanastas);

    List<Car> findByYearOfFabBetween(Integer min, Integer max);

    List<Car> findByPriceGreaterThanEqual(Double price);

    List<Car> findByPriceBetween(Double min, Double max);

    Car findByPlateNumber(String plateNumber);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandAndPrice(String brand, Double price);

    List<Car> findByBrandAndModelAndPriceGreaterThanEqual(String brand, String model, Double price);

    List<Car> findByBrand(String brand);

    List<Car> findByYearOfFab(Integer yearOfFab);

    //JPQL Queries

    @Query("SELECT * from Jugador jug WHERE jug.nombre LIKE '%:nombre%' ")
    Jugador findByName(@Param("nombre") String nombre);

    @Query("SELECT car FROM Car car WHERE car.plateNumber LIKE CONCAT('%',:plateNumberPart,'%')")
    List<Car> findCarByPlateNumberSubstring(@Param("plateNumberPart") String plateNumberPart);

    //Forma2. Con Spring Data Query

    List<Car> findByPlateNumberContains(String plateNumberPart);

    @Query("SELECT car.brand, AVG(car.price), MIN(car.price), MAX(car.price) " +
            "FROM Car car " +
            "GROUP BY car.brand")
    List<Object[]> AvgAndMaxAndMinPricesPerBrand();

    //Si no especificamos es asc por defecto
    @Query("SELECT car.brand, AVG(car.price), MIN(car.price), MAX(car.price) " +
            "FROM Car car " +
            "GROUP BY car.brand " +
            "ORDER BY AVG(car.price) DESC ")
    List<Object[]> AvgAndMaxAndMinPricesPerBrandOrderedByAVGPrice();


    @Query("SELECT car.yearOfFab, COUNT(car) " +
            "FROM Car car " +
            "GROUP BY car.yearOfFab")
    List<Object[]> CarsMadeByYear();

}
