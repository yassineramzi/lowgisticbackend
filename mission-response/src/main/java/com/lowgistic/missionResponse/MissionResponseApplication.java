package com.lowgistic.missionResponse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MissionResponseApplication {
	public static void main(String[] args) {
		SpringApplication.run(MissionResponseApplication.class, args);
	}
}
