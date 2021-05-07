package com.cts.retailproductauthms.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import io.jsonwebtoken.JwtException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UsernameNotFoundException.class)
	public ResponseEntity<?> userNameNotFoundExceptionHandler(UsernameNotFoundException u){
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(u.getMessage());
	}
	
	@ExceptionHandler(PasswordNotMatchException.class)
	public ResponseEntity<?> passwordNotMatchExceptionHandler(PasswordNotMatchException p){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(p.getMessage());
	}
	
	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<?> userAlreadyExistExceptionHandler(UserAlreadyExistsException p){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(p.getMessage());
	}
	
	@ExceptionHandler(JwtException.class)
	public ResponseEntity<?> jwtExceptionHandler(JwtException j){
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(j.getMessage());
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationException(MethodArgumentNotValidException m){
		Map<String,String> errors = new HashMap<>();
		m.getBindingResult().getAllErrors().forEach((error)->{
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			errors.put(fieldName, errorMessage);
		});
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errors);
	}
}
