package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * 
 * @author Sunil016
 * @version 1.0 {@link }
 * 
 */

@EnableMongoRepositories(basePackages = "com.Spring.Repository")
@SpringBootApplication
public class Ignite {

	public static void main(String[] args) {
		SpringApplication.run(Ignite.class, args);
	}

}
