package com.cognizant.medicinestock.exception;

import lombok.NoArgsConstructor;

/**
 * This is the exception class which will handle the exceptions if medicine is not found by giving run time exception.
 */
@NoArgsConstructor
public class MedicineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MedicineNotFoundException(String message) {
		super(message);
	}

}
