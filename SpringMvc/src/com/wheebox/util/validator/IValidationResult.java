package com.wheebox.util.validator;

public interface IValidationResult {
	
	public ValidationResultImpl.Status status();
	public String message();

}
