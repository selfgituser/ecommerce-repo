package com.ecom.ecomapigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class EcomapigatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EcomapigatewayApplication.class, args);
	}

}
