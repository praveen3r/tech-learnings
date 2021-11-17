package com.demo.custom.validation;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.dto.RestfulValidationVO1;

public class RestfulValidationVOValidator1 implements Validator{

	@Override
	public boolean supports(Class<?> arg0) {
		// TODO Auto-generated method stub
		return RestfulValidationVO1.class.equals(arg0);
	}

	@Override
	public void validate(Object arg0, Errors errors) {
		// TODO Auto-generated method stub`
		RestfulValidationVO1 request = (RestfulValidationVO1) arg0;
		
		if(StringUtils.isEmpty(request.getId())){
			errors.rejectValue("id", "Id is Mandatory");
		} 
		
	}

}
