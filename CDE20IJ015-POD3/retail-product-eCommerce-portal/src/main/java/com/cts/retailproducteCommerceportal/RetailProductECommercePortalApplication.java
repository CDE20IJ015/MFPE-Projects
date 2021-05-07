package com.cts.retailproducteCommerceportal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RetailProductECommercePortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailProductECommercePortalApplication.class, args);
	}

}
