package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.demo.dto.CourseTypeMasterDto;
import com.demo.dto.DemoResponse;
import com.demo.repository.CourseTypeMasterRepository;
import com.demo.util.ResponseKeyConstants;

@Service
public class CourseTypeMasterService {
	
	@Autowired
	CourseTypeMasterRepository courseTypeMasterRepository;
	
	@Cacheable("CourseTypeList")
	public DemoResponse<CourseTypeMasterDto> getCourseTypeList() throws Exception {
		List<CourseTypeMasterDto> courseTypelist = courseTypeMasterRepository.getCourseTypeList();
		return new DemoResponse<CourseTypeMasterDto>(ResponseKeyConstants.COURSE_TYPES, courseTypelist);
	}

}
