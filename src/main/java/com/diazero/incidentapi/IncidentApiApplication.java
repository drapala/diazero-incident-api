package com.diazero.incidentapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
@ComponentScan({"com.diazero.incidentapi.domain.repository.IncidentRepository"})
public class IncidentApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(IncidentApiApplication.class, args);
	}
	//deu na mesma T_T só que aqui é maven por requisito do desafio
}
