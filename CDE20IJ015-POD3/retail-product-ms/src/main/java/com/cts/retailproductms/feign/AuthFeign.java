package com.cts.retailproductms.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproductms.exception.UnauthorisedAccessException;

@FeignClient(name = "authapp",url = "${feign.url.retail-product-auth-ms}")
public interface AuthFeign {

	@GetMapping("/validate")
	public boolean getValidity(@RequestHeader("Authorization") String token) throws UnauthorisedAccessException;
}
