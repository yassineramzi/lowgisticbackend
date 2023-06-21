package com.lowgistic.mission;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@OpenAPIDefinition
public class MissionApplication {
	public static void main(String[] args) {
		SpringApplication.run(MissionApplication.class, args);
	}
}
