
package com.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import com.demo.config.DemoConfig;
import com.demo.config.WebMvcConfig;
import com.demo.dto.CourseDto;
import com.demo.dto.DemoResponse;
import com.demo.service.CourseService;
import com.demo.util.GeneralUtil;
import com.demo.util.ResponseKeyConstants;

@SpringBootTest(classes = { CourseController.class, DemoConfig.class, WebMvcConfig.class })

@AutoConfigureMockMvc(addFilters = false)
public class CourseControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CourseService courseServiceMock;

	@Test
	public void testGetCourses() throws Exception {
		var courseDto1 = new CourseDto();
		courseDto1.setId(new BigInteger("1"));
		courseDto1.setAuthor("Test1");
		courseDto1.setName("Angular");

		var courseDto2 = new CourseDto();
		courseDto2.setId(new BigInteger("2"));
		courseDto2.setAuthor("Test2");
		courseDto2.setName("ReactJS");

		final List<CourseDto> courseList = new ArrayList<>();
		courseList.add(courseDto1);
		courseList.add(courseDto2);

		var demoResponse = new DemoResponse<CourseDto>(ResponseKeyConstants.COURSES, courseList);

		when(courseServiceMock.getCourses()).thenReturn(demoResponse);

		mockMvc.perform(get("/v1/courses/")).andExpect(status().isOk())
				.andExpect(content().contentType("application/json")).andDo(MockMvcResultHandlers.print())
				.andExpect(jsonPath("$.courses[0].author").value("Test1"));

		Mockito.verify(courseServiceMock).getCourses();
	}

	@Test
	public void testAddCourse() throws Exception {

		var courseDto = new CourseDto();
		courseDto.setId(new BigInteger("1"));
		courseDto.setTypeId(1);
		courseDto.setAuthor("Test1");
		courseDto.setName("Angular");

		mockMvc.perform(post("/v1/courses/course").contentType(MediaType.APPLICATION_JSON)
				.content(GeneralUtil.convertObjectToJsonBytes(courseDto))).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testUpdateCourse() throws Exception {

		var courseDto = new CourseDto();
		courseDto.setId(new BigInteger("1"));
		courseDto.setTypeId(1);
		courseDto.setAuthor("Test1");
		courseDto.setName("Angular");

		mockMvc.perform(put("/v1/courses/course/{id}", new BigInteger("1")).contentType(MediaType.APPLICATION_JSON)
				.content(GeneralUtil.convertObjectToJsonBytes(courseDto))).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

	@Test
	public void testDeleteCourse() throws Exception {

		mockMvc.perform(delete("/v1/courses/course/{id}", new BigInteger("1"))).andExpect(status().isOk())
				.andDo(MockMvcResultHandlers.print());
	}

}
