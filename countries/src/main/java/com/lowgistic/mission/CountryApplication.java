package com.lowgistic.mission;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class CountryApplication {
	public static void main(String[] args) {
		SpringApplication.run(CountryApplication.class, args);
	}
}
