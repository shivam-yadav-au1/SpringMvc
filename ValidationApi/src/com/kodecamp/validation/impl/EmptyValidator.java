package com.kodecamp.validation.impl;

import com.kodecamp.validation.api.IValidationResult;
import com.kodecamp.validation.api.IValidator;
import com.kodecamp.validation.api.ValidationResult;
import com.kodecamp.validation.api.ValidationResult.Status;

public class EmptyValidator implements IValidator {

	private IValidator validator;

	public EmptyValidator(final IValidator validator) {
		this.validator = validator;

	}

	public EmptyValidator() {
		this(null);
	}

	@Override
	public IValidationResult validate(Object object) {

		if (this.validator != null) {
			IValidationResult vr = this.validator.validate(object);
			if (vr.status().equals(ValidationResult.Status.FAIL)) {
				return vr;
			}
		}
		String value = (String)object;
		

		return "".equals(value.trim()) ? new ValidationResult(Status.FAIL, "Object is empty.")
				: new ValidationResult(Status.PASS);
	}

}
