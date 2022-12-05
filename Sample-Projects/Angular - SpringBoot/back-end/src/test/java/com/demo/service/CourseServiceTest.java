package com.demo.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.demo.config.DemoConfig;
import com.demo.dto.CourseDto;
import com.demo.entity.Course;
import com.demo.repository.CourseRepository;
import com.demo.util.CommonUtil;
import com.demo.util.ResponseKeyConstants;

@SpringBootTest(classes = {DemoConfig.class, CourseService.class})
public class CourseServiceTest {

	@MockBean
	private CourseRepository courseRepository;
	
	@Autowired
	CourseService courseService;
	

	@Test
	public void getCourses() throws Exception{
		var courseDto1 = new CourseDto();
		courseDto1.setId(new BigInteger("1"));
		courseDto1.setAuthor("Test1");
		courseDto1.setName("Angular");
		
		List<CourseDto> courseMockList = new ArrayList<>();
		courseMockList.add(courseDto1);
		
		when(courseRepository.getCourseList()).thenReturn(courseMockList);
		
		var demoResponse = courseService.getCourses();
		
		assertThat(demoResponse.getProperties().get(ResponseKeyConstants.COURSES),hasSize(1));
		
	}
	
	
	@Test
	public void testAddCourse() throws Exception {
		var courseDto1 = new CourseDto();
		courseDto1.setId(new BigInteger("1"));
		courseDto1.setAuthor("Test1");
		courseDto1.setName("Angular");
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto1, course);

		when(courseRepository.save(any(Course.class))).thenReturn(course);

		Boolean isSuccess = courseService.addCourse(courseDto1);
		
		assertThat(isSuccess,is(Boolean.TRUE));
	}
	
	@Test
	public void testModifyCourse() throws Exception {
		var courseDto1 = new CourseDto();
		courseDto1.setId(new BigInteger("1"));
		courseDto1.setAuthor("Test1");
		courseDto1.setName("Angular");
		
		var course = new Course();
		CommonUtil.copyNonNullProperties(courseDto1, course);

		when(courseRepository.save(any(Course.class))).thenReturn(course);

		Boolean isSuccess = courseService.modifyCourse(courseDto1);
		
		assertThat(isSuccess,is(Boolean.TRUE));
	}
	 
	@Test
	public void testDeleteCourse() throws Exception {
		
		doNothing().when(courseRepository).deleteCourse(isA(BigInteger.class));

		Boolean isSuccess = courseService.deleteCourse(isA(BigInteger.class));
		
		assertThat(isSuccess,is(Boolean.TRUE));
	}
}
