package com.cts.retailproductproceedToBuyservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
	
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExceptionProductNotFound(ProductNotFoundException e1)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(e1.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExceptionCartNotFoundException(CartNotFoundException e1)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(e1.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExceptionWishlistNotFoundException(WishlistNotFoundException e1)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(e1.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleExceptionAuthorization(AccessUnauthorizedException e1)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.FORBIDDEN);
		error.setMessage(e1.getMessage());
		return new ResponseEntity<>(error,HttpStatus.FORBIDDEN);
	}
	
	@org.springframework.web.bind.annotation.ExceptionHandler
	public ResponseEntity<ErrorResponse> handleException(NullPointerException e2)
	{
		ErrorResponse error=new ErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND);
		error.setMessage(e2.getMessage());
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}
