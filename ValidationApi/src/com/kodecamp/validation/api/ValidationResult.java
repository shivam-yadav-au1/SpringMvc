package com.kodecamp.validation.api;

/*
 * This is implementation  class of IValidationResult for setting 
 * result .
 * This class has got two fields or properties for any result which is "status" and "message"
 * Message is not put if status is PASS (achieve by using copy constructor) but in case of FAIL message is put 
 * 
 */

public class ValidationResult implements IValidationResult {

	private Status status;
	private String message;

	// Primary constructor
	public ValidationResult(final Status status, final String message) {

		this.status = status;
		this.message = message;
	}
	
	// Copy constructor
	
	public ValidationResult(final Status status) {
		this(status, null);

	}

	@Override
	public Status status() {

		return status;
	}

	@Override
	public String message() {

		return message;
	}

	public static enum Status {

		PASS, FAIL

	}

}
