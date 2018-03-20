package com.wheebox.util.validator;

public class Test {
	
	public static void main(String[] args) {
		IValidationResult validate =  new EmailValidatorImpl(new EmptyValidatorImpl(new NullValidatorImpl())).validate("shivamcsgmail.com");
//		IValidationResult validate2 = new EmptyValidatorImpl().validate(" ");
		System.out.println(validate.status()+" "+validate.message());
//		System.out.println(validate2.status()+" "+validate2.message());
		
		
	}
}
