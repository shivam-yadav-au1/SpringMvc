package com.kodecamp.validation.impl;

import com.kodecamp.validation.api.IValidationResult;
import com.kodecamp.validation.api.IValidator;

import com.kodecamp.validation.api.ValidationResult;

/*
 * This class is implementaion of IValidator 
 * which is used to check null value of object in any fields.
 */

public class NullValidator implements IValidator {

	/*
	 * validate() takes object as argument checkes it whether is null or not if it
	 * is null then it put Status FAIL and message or puts Status PASS.
	 */

	@Override
	public IValidationResult validate(Object object) {

		return object == null ? new ValidationResult(ValidationResult.Status.FAIL, "Object is null")
				: new ValidationResult(ValidationResult.Status.PASS);
	}

}
