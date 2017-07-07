package com.kodecamp.validation.impl;

import com.kodecamp.validation.api.IValidationResult;
import com.kodecamp.validation.api.IValidator;

import com.kodecamp.validation.api.ValidationResult;

public class NullValidator implements IValidator {

	@Override
	public IValidationResult validate(Object object) {

		return object == null ? new ValidationResult(ValidationResult.Status.FAIL, "Object is null")
				: new ValidationResult(ValidationResult.Status.PASS);
	}

}
