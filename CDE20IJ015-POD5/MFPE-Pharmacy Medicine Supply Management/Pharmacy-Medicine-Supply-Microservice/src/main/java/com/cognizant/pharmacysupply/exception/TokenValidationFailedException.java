package com.cognizant.pharmacysupply.exception;

import lombok.NoArgsConstructor;

/**
 * This is the exception class which will handle the exception when token validation fails.
 */
@NoArgsConstructor
public class TokenValidationFailedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TokenValidationFailedException(String message) {
		super(message);
	}

}
