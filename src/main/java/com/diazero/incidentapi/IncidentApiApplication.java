package com.diazero.incidentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IncidentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncidentApiApplication.class, args);
	}

}
