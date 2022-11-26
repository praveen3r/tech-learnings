package com.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.dto.CourseTypeMasterDto;
import com.demo.entity.CourseTypeMaster;

public interface CourseTypeMasterRepository extends JpaRepository<CourseTypeMaster, Integer> {
	
	@Query("select new com.demo.dto.CourseTypeMasterDto(ctm.id, ctm.value) from CourseTypeMaster ctm ORDER BY ctm.value")
	List<CourseTypeMasterDto> getCourseTypeList();
	 
}
