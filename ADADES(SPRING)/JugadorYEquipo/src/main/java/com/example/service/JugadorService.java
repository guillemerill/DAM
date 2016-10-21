package com.example.service;

import com.example.domain.Jugador;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugRepository;


    public void testJugadores(){

        Jugador jug1 = new Jugador ("Jugador 1", "24/11/1996", 50, 30, 10, "alero");
        jugRepository.save(jug1);
        Jugador jug2 = new Jugador ("Jugador 2", "25/11/1996", 51, 31, 9, "pivot");
        jugRepository.save(jug2);
        Jugador jug3 = new Jugador ("Jugador 3", "26/11/1996", 52, 32, 8, "alero");
        jugRepository.save(jug3);
        Jugador jug4 = new Jugador ("Jugador 4", "27/11/1996", 53, 33, 7, "pivot");
        jugRepository.save(jug4);
        Jugador jug5 = new Jugador ("Jugador 5", "28/11/1996", 54, 34, 6, "base");
        jugRepository.save(jug5);



        System.out.println("Cars made since 2016 ");
        System.out.println(jugRepository.findByYearOfFabGreaterThanEqual(2016));

        System.out.println("Cars made before 2014 ");
        System.out.println(jugRepository.findByYearOfFabLessThan(2016));


        System.out.println("Cars made between 2014 and 2016");
        System.out.println(jugRepository.findByYearOfFabBetween(2014,2016));

        System.out.println("Cars that cost more than 25000 Euros");
        System.out.println(jugRepository.findByPriceGreaterThanEqual(25000.00));

        System.out.println("Cars that cost between 50000 and 6000000 Euros ");
        System.out.println(jugRepository.findByPriceBetween(50000.00,100000.00));

        System.out.println("Car with plate number 3564GER ");
        System.out.println(jugRepository.findByPlateNumber("3564GER"));

        System.out.println("Cars of brand Jaguar and model FPACE");
        System.out.println(jugRepository.findByBrandAndModel("Jaguar","FPACE"));

        System.out.println("Cars of brand BMW and price less than 80000 Euros");
        System.out.println(jugRepository.findByBrandAndPrice("BMW",80000.00));

        System.out.println("Cars of brand Aston Martin, model of James Bond of the movie Spectrum,DB10, that costs more than 3100000 Euros ");
        System.out.println(jugRepository.findByBrandAndModelAndPriceGreaterThanEqual("Aston Martin","DB10",3100000.00));

        /* código que calcula la media
        List<Car> carList = carRepository.findByBrand("BMW");

        int sum=0;
        int numCars=0;
        for(Car car : carList)
        {
            numCars++;
            sum=sum+car.getPrice();
        }

        int average= sum/numCars;
        */

        System.out.println("List of Jaguar brand cars");
        System.out.println(jugRepository.findByBrand("Jaguar"));

        System.out.println("The average price all of Lexus cars is: " + jugRepository.findAveragePerBrand("Lexus"));


        //Querys con JPQL

        System.out.println("All cars which plate number contains 'ENG': " + jugRepository.findCarByPlateNumberSubstring("ENG"));

        System.out.println("All cars wich plate number contains letter 'E' " + jugRepository.findByPlateNumberContains("E"));

        System.out.println("Statistics");
        showStatistics(jugRepository.AvgAndMaxAndMinPricesPerBrand());

        System.out.println("Statistics sorted by AvgPrice descendant");
        showStatistics(jugRepository.AvgAndMaxAndMinPricesPerBrandOrderedByAVGPrice());


        System.out.println("Number of cars made each year: ");

        List<Object[]> carList = jugRepository.CarsMadeByYear();

        for (Object[] car : carList)
        {
            Integer year = (Integer)car[0];
            System.out.println("Year: "+car[0]);
            System.out.println("Quantity: "+ car[1]);
            System.out.println("List of cars: "+ jugRepository.findByYearOfFab(year)+System.lineSeparator());
        }


    }

    private void showStatistics(List<Object[]> statisticsList) {
        for ( Object[] statistic: statisticsList)
        {
            System.out.println("Brand: "+statistic[0]);
            System.out.println("AVG = "+statistic[1] +" euros");
            System.out.println("MIN = "+statistic[2]+" euros");
            System.out.println("MAX = "+statistic[3]+" euros"+System.lineSeparator());
        }

        // el objeto es cada una de las líneas de la tabla que muestra al hacer la query. statistic[] son las columnas
    }
}
