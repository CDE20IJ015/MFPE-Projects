package com.cts.retailproductvendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN, reason = "user not authorized")
public class AccessUnauthorizedException extends Exception {
	
	public AccessUnauthorizedException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
