package com.demo.service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.util.ResponseKeyConstants;

@Service
public class CourseService {

	public DemoResponse<CourseDto> getCourses() throws Exception{
		DemoResponse<CourseDto> response = null;
		
		List<CourseDto> courseList = new ArrayList<>();
		CourseDto courseDto = new CourseDto();
		courseDto.setAuthor("TestAuthor");
		courseDto.setName("TestName");
		courseDto.setType("TestType");
		courseDto.setId(new BigInteger("1"));
		courseList.add(courseDto);
		
		response = new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);
		return response;
		
	}
}
