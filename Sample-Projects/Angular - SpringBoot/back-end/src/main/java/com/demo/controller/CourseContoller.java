package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.service.CourseService;

@RestController
@RequestMapping(value = "/v1/courses/")
public class CourseContoller {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "", method = {RequestMethod.GET})
	public DemoResponse<CourseDto> getCourses() throws Exception{
		return courseService.getCourses();
	}
}
