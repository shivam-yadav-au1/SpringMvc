package com.kodecamp.validation.api;

/*
 * This is contract defined for setting status and message result after validation is done.
 */


public interface IValidationResult {

	public ValidationResult.Status status();

	public String message();
}
