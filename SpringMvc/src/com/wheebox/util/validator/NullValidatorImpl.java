package com.wheebox.util.validator;

import com.wheebox.util.validator.ValidationResultImpl.Status;

public class NullValidatorImpl implements IValidate {

	public IValidate validate;
	
	public NullValidatorImpl() {
		
	}
	
	public NullValidatorImpl(final IValidate validate) {
		this.validate = validate;
	}
	
	@Override
	public IValidationResult validate() {
	
		return null;
	}

	@Override
	public IValidationResult validate(Object obj) {
		System.out.println("NUllValidator executed...");
		IValidationResult result = null;
		if(this.validate !=null) {
			
		}
		if(obj != null) {
				result = new ValidationResultImpl(Status.PASS);
		}
		else{
			result = new ValidationResultImpl(Status.FAIL,"Field is null");
		}
		return (ValidationResultImpl) result;
	}

}
