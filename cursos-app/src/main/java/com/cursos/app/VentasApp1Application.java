package com.cursos.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class VentasApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(VentasApp1Application.class, args);
	}

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(VentasApp1Application.class);
	}
}
