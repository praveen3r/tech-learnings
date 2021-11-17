package com.demo.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberValidator implements ConstraintValidator<PhoneNumberConstraint, String> {

	private long minLen;
	
	@Override
	public void initialize(PhoneNumberConstraint phoneNumberConstraint) {
		this.minLen = phoneNumberConstraint.minLen();
	}

	@Override
	public boolean isValid(String field, ConstraintValidatorContext cxt) {
		boolean isValid = false;
		if(field != null && field.matches("[0-9]+") && (field.length() > minLen)
				&& (field.length() < 14))
			isValid = true;
		return isValid;
	}
}
