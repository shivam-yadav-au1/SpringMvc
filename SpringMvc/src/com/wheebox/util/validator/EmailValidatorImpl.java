package com.wheebox.util.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.wheebox.util.validator.ValidationResultImpl.Status;

public class EmailValidatorImpl implements IValidate {

	private IValidate validator;

	public EmailValidatorImpl() {

	}

	public EmailValidatorImpl(final IValidate validator) {
		this.validator = validator;
	}

	@Override
	public IValidationResult validate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IValidationResult validate(Object obj) {
		System.out.println("Email Validation executed....");
		if (this.validator != null) {
			IValidationResult result = this.validator.validate(obj);
			if (result.equals(ValidationResultImpl.Status.FAIL)) {
				return result;
			}
		}
		// String email = (String)obj;

		Pattern p = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher m = p.matcher((CharSequence) obj);
		boolean b = m.find();

		return b == true ? new ValidationResultImpl(Status.PASS)
				: new ValidationResultImpl(Status.FAIL, "Email is invalid .");
	}

}
