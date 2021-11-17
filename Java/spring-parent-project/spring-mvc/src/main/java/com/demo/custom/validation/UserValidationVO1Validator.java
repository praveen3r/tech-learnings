package com.demo.custom.validation;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.demo.dto.UserValidationVO1;

@Component
public class UserValidationVO1Validator implements Validator{
	//which objects can be validated by this validator
		@Override
		public boolean supports(Class<?> paramClass) {
			return UserValidationVO1.class.equals(paramClass);
		}

		@Override
		public void validate(Object obj, Errors errors) {
			ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "firstName.required");
			
			UserValidationVO1 userValidationVO1 = (UserValidationVO1) obj;
			if(StringUtils.isEmpty(userValidationVO1.getLastName())){
				errors.rejectValue("lastName", "lastName.required", "lastName can't be null");
			}
			
			if(StringUtils.isEmpty(userValidationVO1.getEmailId())){
				errors.rejectValue("lastName", "email.required", new Object[]{"eMail"}, "lastName can't be null");
			}
		}
}
