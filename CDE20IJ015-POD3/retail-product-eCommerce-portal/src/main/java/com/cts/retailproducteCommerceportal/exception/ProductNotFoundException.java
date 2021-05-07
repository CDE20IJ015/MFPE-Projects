package com.cts.retailproducteCommerceportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductNotFoundException extends Exception {

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
