package com.baloncesto;

import com.baloncesto.service.PlayerService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class RestControllersApplication {

	public static void main(String[] args) {
		// SpringApplication.run(RestControllersApplication.class, args);
		ConfigurableApplicationContext context= SpringApplication.run(RestControllersApplication.class, args);
		PlayerService playerService=context.getBean(PlayerService.class);

		playerService.testPlayers();
	}
}
