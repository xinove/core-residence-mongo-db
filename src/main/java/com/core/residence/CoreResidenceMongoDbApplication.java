package com.core.residence;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.core.residence.config", "com.core.residence"})
public class CoreResidenceMongoDbApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoreResidenceMongoDbApplication.class, args);
	}

}
