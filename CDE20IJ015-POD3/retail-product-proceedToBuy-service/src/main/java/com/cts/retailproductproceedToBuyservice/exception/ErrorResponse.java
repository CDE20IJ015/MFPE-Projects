package com.cts.retailproductproceedToBuyservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

public class ErrorResponse {
	
	private HttpStatus status;
	private String message;
	private LocalDateTime timeStamp;
	
	public ErrorResponse(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
		this.timeStamp = LocalDateTime.now();
	}
	public ErrorResponse() {
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}


	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimeStamp() {
		return timeStamp;
	}

}