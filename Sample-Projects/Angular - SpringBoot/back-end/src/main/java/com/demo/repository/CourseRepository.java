package com.demo.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dto.CourseDto;
import com.demo.entity.Course;

public interface CourseRepository extends JpaRepository<Course, BigInteger> {

	@Query("select new com.demo.dto.CourseDto(cs.id, cs.name, cs.type, cs.author) from Course cs ORDER BY cs.name")
	List<CourseDto> getCourseList();
	
	@Transactional
	@Modifying
	@Query("DELETE from Course cs WHERE cs.id=:id ")
	public void deleteCourse(@Param("id") final BigInteger id);
	
}
