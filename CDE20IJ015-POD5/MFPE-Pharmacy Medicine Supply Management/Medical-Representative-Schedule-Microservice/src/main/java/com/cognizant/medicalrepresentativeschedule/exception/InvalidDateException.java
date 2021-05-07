package com.cognizant.medicalrepresentativeschedule.exception;

/**
 * This is the exception class which will handle the exceptions for invalid date.
 */
public class InvalidDateException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidDateException() {
		super();
	}

	public InvalidDateException(String message) {
		super(message);
	}
}