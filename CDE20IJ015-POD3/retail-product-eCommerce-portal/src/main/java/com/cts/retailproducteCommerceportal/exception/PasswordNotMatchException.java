package com.cts.retailproducteCommerceportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "Password is Incorrect")
public class PasswordNotMatchException extends Exception {
	
	public PasswordNotMatchException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
