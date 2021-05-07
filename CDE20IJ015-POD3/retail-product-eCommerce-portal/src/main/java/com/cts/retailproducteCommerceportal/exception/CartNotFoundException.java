package com.cts.retailproducteCommerceportal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class CartNotFoundException extends Exception {

	public CartNotFoundException(String msg) {
		// TODO Auto-generated constructor stub
		super(msg);
	}
}
