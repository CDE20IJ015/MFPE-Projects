package com.cts.retailproducteCommerceportal.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.retailproducteCommerceportal.exception.PasswordNotMatchException;
import com.cts.retailproducteCommerceportal.model.LoginCustomer;
import com.cts.retailproducteCommerceportal.model.UserAuth;

@FeignClient(name = "authclient", url = "${feign.url.auth-ms}/", fallback = AuthClientFallback.class)
public interface AuthClient {

	@GetMapping("validate")
	public boolean getValidity(@RequestHeader("Authorization") String token);

	@PostMapping("login")
	public String login(@RequestBody LoginCustomer user);
	
	@PostMapping("register")
	public String register(@RequestBody UserAuth userAuth);
	
	@GetMapping("getId")
	public int getId(@RequestHeader("Authorization") String token);
	
	@GetMapping("getZip")
	public int getZip(@RequestHeader("Authorization") String token);
}
