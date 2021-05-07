package com.cts.retailproductvendor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccessUnauthorizedException.class)
	public ResponseEntity<?> unauthorizedAccessExceptionHandler(AccessUnauthorizedException u){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(u.getMessage());
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<?> internalServerErrorExceptionHandler(InternalServerErrorException i){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(i.getMessage());
	}
}
