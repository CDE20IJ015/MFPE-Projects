package com.cts.retailproducteCommerceportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class WishlistNotFoundException extends Exception {

	public WishlistNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
