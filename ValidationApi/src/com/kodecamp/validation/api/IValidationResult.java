package com.kodecamp.validation.api;



public interface IValidationResult {

	public ValidationResult.Status status();

	public String message();
}
