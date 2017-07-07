package com.kodecamp.validation.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.kodecamp.validation.api.IValidationResult;
import com.kodecamp.validation.api.IValidator;
import com.kodecamp.validation.api.ValidationResult;
import com.kodecamp.validation.api.ValidationResult.Status;

public class SpecialCharacter implements IValidator {

	private IValidator validator;

	public SpecialCharacter(final IValidator validator) {
		this.validator = validator;
	}

	public SpecialCharacter() {
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
		Pattern p = Pattern.compile("[^A-Za-z0-9]");
		Matcher m = p.matcher((CharSequence) object);
		boolean b = m.find();
		return b == true ? new ValidationResult(Status.FAIL,"Object contains some special Character.") : new ValidationResult(Status.PASS);
	}

}
