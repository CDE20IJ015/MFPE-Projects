package com.cts.retailproductms.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import feign.FeignException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(FeignException.class)
	public ResponseEntity<?> feignExceptionHandler(FeignException f){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("You dont have access to enter");
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<?> productNotFoundExceptionHandler(ProductNotFoundException p){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(p.getMessage());
	}
	
	@ExceptionHandler(UnauthorisedAccessException.class)
	public ResponseEntity<?> unauthorizedAccessExceptionHandler(UnauthorisedAccessException u){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(u.getMessage());
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<?> internalServerErrorExceptionHandler(InternalServerErrorException i){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(i.getMessage());
	}
}
