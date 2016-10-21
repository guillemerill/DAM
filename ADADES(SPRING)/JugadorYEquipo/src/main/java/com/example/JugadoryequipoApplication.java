package com.example;

import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class JugadoryequipoApplication {

	public static void main(String[] args)
	{
		ConfigurableApplicationContext context= SpringApplication.run(JugadoryequipoApplication.class, args);

		JugadorService jugadorService=context.getBean(JugadorService.class);

		jugadorService.testJugadores();
	}
}