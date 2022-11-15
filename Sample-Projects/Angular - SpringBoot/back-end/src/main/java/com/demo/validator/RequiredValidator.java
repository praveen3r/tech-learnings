package com.demo.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.demo.util.CommonUtil;

public class RequiredValidator implements ConstraintValidator<Required, Object> {

	@Override
	public boolean isValid(final Object value, final ConstraintValidatorContext context) {
		if (value instanceof String) {
			final String str = (String) value;
			return CommonUtil.isNotEmpty(str);
		}

		return CommonUtil.isNotEmpty(value);
	}

}
