package com.demo.service;

import java.math.BigInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.entity.Course;
import com.demo.entity.CourseTypeMaster;
import com.demo.repository.CourseRepository;
import com.demo.util.CommonUtil;
import com.demo.util.EntityUtil;
import com.demo.util.ResponseKeyConstants;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;

	public DemoResponse<CourseDto> getCourses() throws Exception{
		var courseList = courseRepository.getCourseList();
		
		return new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);
	}
	
	@Transactional
	public Boolean addCourse(final CourseDto courseDto) throws Exception{
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto, course);
		EntityUtil.populateDefaultColumns(course);
		
		var courseTypeMaster = new CourseTypeMaster();
		courseTypeMaster.setId(courseDto.getTypeId());
		course.setCourseTypeMaster(courseTypeMaster);
		
		courseRepository.save(course);
		
		return Boolean.TRUE;
	}
	
	@Transactional
	public Boolean modifyCourse(final CourseDto courseDto) throws Exception{
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto, course);
		EntityUtil.populateDefaultColumns(course);
		courseRepository.save(course);
		
		return Boolean.TRUE;
		
	}

	public Boolean deleteCourse(final BigInteger id) {
		courseRepository.deleteCourse(id);
		return Boolean.TRUE;
	}
	
	public DemoResponse<CourseDto> getCourses(final String name, final String startDate, final String endDate) throws Exception{
		
		var courseList = courseRepository.getSearchData(name, startDate, endDate);
		
		return  new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);
		
	}
}
