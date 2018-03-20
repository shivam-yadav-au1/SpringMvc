package com.wheebox.util.validator;

public class ValidationResultImpl implements IValidationResult {

	private ValidationResultImpl.Status status;
	private String message;

	public ValidationResultImpl(final Status status, final String message) {
		this.status = status;
		this.message = message;
	}
	
	public ValidationResultImpl(final Status status) {
		this(status,null);
		
	}

	

	public ValidationResultImpl.Status getStatus() {
		return status;
	}



	public static enum Status {
		PASS, FAIL
	}

	public String message() {
	
		return message;
	}

	public Status status() {
		
		return status;
	}
	
}