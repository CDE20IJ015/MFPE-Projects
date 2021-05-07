package com.cts.retailproductproceedToBuyservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cts.retailproductproceedToBuyservice.exception.AccessUnauthorizedException;

//@Headers("Content-Type: application/json")
@FeignClient(name = "authclient", url = "${feign.url.auth-ms}", fallback = AuthClientFallback.class)
//@FeignClient(url="http://localhost:8081/api/")
public interface AuthClient {
	
	@GetMapping("/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token) throws AccessUnauthorizedException;

	@GetMapping("/getId")
	public long getId(@RequestHeader("Authorization") String token);
	
	@GetMapping("/getZip")
	public int getZip(@RequestHeader("Authorization") String token);

	@GetMapping("/test")
	public String test();
}
