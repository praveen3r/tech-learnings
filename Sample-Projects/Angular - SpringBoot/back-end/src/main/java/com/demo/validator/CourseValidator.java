package com.demo.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.demo.dto.CourseDto;
import com.demo.util.CommonUtil;

@Component
public class CourseValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}

	@Override
	public void validate(Object target, Errors errors) {

		//Business validation
		 final CourseDto courseDto = (CourseDto) target;
		 
		 if(!CommonUtil.isNotEmpty(courseDto)) {
			 errors.rejectValue("name", "DEMO-0001", new String[]
		               {"dummy"}, "DEMO-0001");
		 }
	}

}
