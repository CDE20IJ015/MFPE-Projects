package com.cts.retailproducteCommerceportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class UnauthorisedAccessException extends Exception {

	public UnauthorisedAccessException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
