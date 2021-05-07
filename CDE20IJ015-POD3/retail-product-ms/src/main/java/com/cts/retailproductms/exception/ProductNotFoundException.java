package com.cts.retailproductms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class ProductNotFoundException extends Exception{

	public ProductNotFoundException(String msg) {
		super(msg);
	}
}
