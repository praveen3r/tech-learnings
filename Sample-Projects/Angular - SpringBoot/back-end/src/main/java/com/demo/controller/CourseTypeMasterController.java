package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.CourseTypeMasterDto;
import com.demo.dto.DemoResponse;
import com.demo.service.CourseTypeMasterService;

@RestController
@RequestMapping(value = "/v1/course/types")
public class CourseTypeMasterController {

	@Autowired
	CourseTypeMasterService courseTypeMasterService;
	
	@GetMapping
	public DemoResponse<CourseTypeMasterDto> getCourseTypeList() throws Exception {
		return courseTypeMasterService.getCourseTypeList();
	}
}
