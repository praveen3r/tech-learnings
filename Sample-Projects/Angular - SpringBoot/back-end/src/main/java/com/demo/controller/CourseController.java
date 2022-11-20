package com.demo.controller;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.service.CourseService;

@RestController
@RequestMapping(value = "/v1/courses/")
@Validated
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping(value = "")
	public DemoResponse<CourseDto> getCourses() throws Exception{
		Thread.sleep(1500);
		return courseService.getCourses();
	}
	
	@PostMapping(value = "course")
	public void addCourse(@Valid @RequestBody final CourseDto courseDto) throws Exception{
		courseService.addCourse(courseDto);
	}
	
	@PutMapping(value = "course/{id}")
	public void modifyCourse(@Valid @RequestBody final CourseDto courseDto, @PathVariable(name = "id") final BigInteger id) throws Exception{
		courseService.modifyCourse(courseDto);
	}
	
	@DeleteMapping("course/{id}")
	public void deleteCourse(@PathVariable(name = "id") final BigInteger id) {
		courseService.deleteCourse(id);
	}
	
	@GetMapping(value = "course/search")
	public DemoResponse<CourseDto> getCourseSearchData(@RequestParam(name = "name", required = true) final String name,
			@RequestParam(name = "startDate", required = false) final String startDate,
			@RequestParam(name = "endDate", required = false) final String endDate) throws Exception{
		return courseService.getCourses(name, startDate, endDate);
	}
}
