package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.entity.Course;
import com.demo.repository.CourseRepository;
import com.demo.util.CommonUtil;
import com.demo.util.EntityUtil;
import com.demo.util.ResponseKeyConstants;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public DemoResponse<CourseDto> getCourses() throws Exception{
		DemoResponse<CourseDto> response = null;
		
		var courseList = courseRepository.getCourseList();
		
		response = new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);
		return response;
		
	}
	
	@Transactional
	public void addCourse(final CourseDto courseDto) throws Exception{
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto, course);
		EntityUtil.populateDefaultColumns(course);
		courseRepository.save(course);
		
	}
	
	@Transactional
	public void modifyCourse(final CourseDto courseDto) throws Exception{
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto, course);
		EntityUtil.populateDefaultColumns(course);
		courseRepository.save(course);
		
	}

	public void deleteCourse(final BigInteger id) {
		courseRepository.deleteCourse(id);
	}
	
	public DemoResponse<CourseDto> getCourses(final String name, final String startDate, final String endDate) throws Exception{
		DemoResponse<CourseDto> response = null;
		
		var courseList = courseRepository.getSearchData(name, startDate, endDate);
		
		response = new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);
		return response;
		
	}
}
