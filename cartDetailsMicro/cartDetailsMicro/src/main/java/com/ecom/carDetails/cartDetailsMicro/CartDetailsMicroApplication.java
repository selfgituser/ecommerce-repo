package com.ecom.carDetails.cartDetailsMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CartDetailsMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(CartDetailsMicroApplication.class, args);
	}

}
