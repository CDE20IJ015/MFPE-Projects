package com.cognizant.medicinestock.feignclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.medicinestock.model.JwtResponse;
/*
 * This Feign Client is used to connect to authorization-service present at port 8094.
 */

@FeignClient(name = "authorization-service", url ="http://172.31.38.112:8094")
public interface AuthenticationFeignClient {


	@GetMapping(path = "/api/auth/validate")
	public JwtResponse verifyToken(@RequestHeader(name = "Authorization", required = true) String token);

}
