package com.cts.retailproductvendor.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproductvendor.exception.AccessUnauthorizedException;

@FeignClient(name = "authclient", url = "${feign.url.auth-ms}", fallback = AuthClientFallback.class)
public interface AuthClient {

	@GetMapping("/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token) throws AccessUnauthorizedException;
	
	@GetMapping("/getId")
	public int getId(@RequestHeader("Authorization") String token);
}
