package com.Spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author Sunil016
 * @version 1.0 {@link }
 * 
 */

@EnableMongoRepositories(basePackages = "com.Spring.Repository")
@SpringBootApplication
public class OrderIgnite {

	public static void main(String[] args) {
		SpringApplication.run(OrderIgnite.class, args);
	}

	@Bean
	public RestTemplate restClient() {
		return new RestTemplate();
	}
}
