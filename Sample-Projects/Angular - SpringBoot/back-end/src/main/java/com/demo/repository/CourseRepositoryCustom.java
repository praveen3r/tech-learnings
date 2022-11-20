package com.demo.repository;

import java.util.List;

import com.demo.dto.CourseDto;

public interface CourseRepositoryCustom {

	List<CourseDto> getSearchData(final String name, 
					final String startDate, final String endDate);
}
