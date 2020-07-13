package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Sunil
 * @version 1.0 {@link }
 * 
 */

@EnableMongoRepositories(basePackages = "com.Spring.Repository")
@SpringBootApplication
public class Ignite {

	public static void main(String[] args) {
		SpringApplication.run(Ignite.class, args);
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
