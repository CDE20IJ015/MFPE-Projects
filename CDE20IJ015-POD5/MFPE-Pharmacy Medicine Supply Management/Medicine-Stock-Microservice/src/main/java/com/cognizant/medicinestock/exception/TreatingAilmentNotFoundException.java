package com.cognizant.medicinestock.exception;

import lombok.NoArgsConstructor;
/**
 * This is the exception class which will handle the exceptions if treatment aliment is not found by giving run time exception.
 */
@NoArgsConstructor
public class TreatingAilmentNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public TreatingAilmentNotFoundException(String message) {
		super(message);
	}

}
