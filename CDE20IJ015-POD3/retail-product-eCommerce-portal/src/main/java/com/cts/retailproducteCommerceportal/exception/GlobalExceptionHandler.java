package com.cts.retailproducteCommerceportal.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CartNotFoundException.class)
	public ModelAndView handleCartNotFoundException(CartNotFoundException c) {
		return new ModelAndView("cartEmpty");
	}
	
	@ExceptionHandler(UnauthorisedAccessException.class)
	public ModelAndView handleUnauthorisedException(UnauthorisedAccessException u) {
		return new ModelAndView("login");
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ModelAndView handleInternalServerException(InternalServerErrorException ie) {
		return new ModelAndView("error");
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	public ModelAndView handleProductNotFoundException(ProductNotFoundException p) {
		return new ModelAndView("index","message",p.getMessage());
	}
}
