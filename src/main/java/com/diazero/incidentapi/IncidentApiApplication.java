package com.diazero.incidentapi;

import com.diazero.incidentapi.config.WebServerConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IncidentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServerConfig.class, args);
	}
}
