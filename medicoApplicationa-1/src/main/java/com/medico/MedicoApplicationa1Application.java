package com.medico;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MedicoApplicationa1Application {

	public static void main(String[] args) {
		SpringApplication.run(MedicoApplicationa1Application.class, args);
	}

}
