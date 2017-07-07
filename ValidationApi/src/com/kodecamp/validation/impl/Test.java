package com.kodecamp.validation.impl;

import com.kodecamp.validation.api.IValidationResult;
import com.kodecamp.validation.api.IValidator;
import com.kodecamp.validation.api.ValidationResult;

public class Test {

	public static void main(String args[]) {

		String name ="shivam&";
		IValidationResult validationResult = new SpecialCharacter(new EmptyValidator(new NullValidator())).validate(name);
		System.out.println("Status : "+validationResult.status());
		System.out.println("Message : "+validationResult.message());
		
		
	/*	IValidationResult nullValidation = new NullValidator().validate(name);
		if(nullValidation.status().equals(ValidationResult.Status.PASS)) {
			IValidationResult vr = new EmptyValidator().validate(name);
			System.out.println("Status : " + vr.status());
			System.out.println("Message : " + vr.message());
		}
		else {
			System.out.println("NullValidation Failed ");
		}*/
		
	

	}

}
