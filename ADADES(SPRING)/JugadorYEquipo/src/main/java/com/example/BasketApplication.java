package com.example;

import com.example.service.BasketService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BasketApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context= SpringApplication.run(BasketApplication.class, args);
        BasketService basketService=context.getBean(BasketService.class);

        basketService.creaJugadores();

    }
}
