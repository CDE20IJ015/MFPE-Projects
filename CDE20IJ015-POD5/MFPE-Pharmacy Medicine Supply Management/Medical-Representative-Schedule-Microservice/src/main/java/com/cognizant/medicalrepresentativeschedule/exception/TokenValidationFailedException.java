package com.cognizant.medicalrepresentativeschedule.exception;

/**
 * This is the exception class which will handle the exception when token validation fails.
 */
public class TokenValidationFailedException extends Exception {
	private static final long serialVersionUID = 1L;

	public TokenValidationFailedException() {
		super();
	}

	public TokenValidationFailedException(String message) {
		super(message);
	}
}