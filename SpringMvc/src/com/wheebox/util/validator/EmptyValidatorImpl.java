package com.wheebox.util.validator;

import com.wheebox.util.validator.ValidationResultImpl.Status;

public class EmptyValidatorImpl implements IValidate{

	private IValidate validate;
	
	public EmptyValidatorImpl() {
		
	}
	
	public EmptyValidatorImpl(final IValidate validate) {
		this.validate = validate;
	}
	
	
	@Override
	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValidationResult validate(Object obj) {
		System.out.println("EmptyVaidator executed ...");
		
		if(this.validate != null) {
			
			IValidationResult result  =  this.validate.validate(obj);
			if(result.status().equals(ValidationResultImpl.Status.FAIL)) {
				return result;
			}
		}
		String value =(String) obj;
		
		return "".equals(value.trim()) ? new ValidationResultImpl(Status.FAIL,"Field is empty") : new ValidationResultImpl(Status.PASS);
	}

}
