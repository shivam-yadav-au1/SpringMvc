package com.kodecamp.validation.api;

public class ValidationResult implements IValidationResult {

	private Status status;
	private String message;

	public ValidationResult(final Status status, final String message) {

		this.status = status;
		this.message = message;
	}

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
