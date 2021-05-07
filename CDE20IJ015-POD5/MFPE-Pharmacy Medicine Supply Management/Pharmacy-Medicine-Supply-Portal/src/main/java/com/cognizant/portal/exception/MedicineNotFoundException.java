package com.cognizant.portal.exception;

import lombok.NoArgsConstructor;
/**
 * This is the exception class which will handle exception if medicine not found.
 */
@NoArgsConstructor
public class MedicineNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public MedicineNotFoundException(String message) {
		super(message);
	}

}
