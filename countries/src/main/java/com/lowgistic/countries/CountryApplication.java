package com.lowgistic.countries;

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
