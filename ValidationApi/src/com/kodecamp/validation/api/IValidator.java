package com.kodecamp.validation.api;
/*
 * This is contract defined for implementation class for validating any object on 
 * different criteria.
 */

public interface IValidator {

	public IValidationResult validate(Object object);

}
