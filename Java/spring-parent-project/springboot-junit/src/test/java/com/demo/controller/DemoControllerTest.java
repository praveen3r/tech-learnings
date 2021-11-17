package com.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import com.demo.service.DemoService;


@SpringBootTest(classes = DemoController.class)
public class DemoControllerTest extends AbstractRestControllerTest{

	@MockBean
    private DemoService service;
	
	@Test
	public void test() throws Exception{
		/*
		 * String uri = "/test1/"; MvcResult mvcResult =
		 * mvc.perform(MockMvcRequestBuilders.get(uri)
		 * .accept(MediaType.TEXT_PLAIN)).andReturn();
		 * 
		 * int status = mvcResult.getResponse().getStatus(); assertEquals(200, status);
		 * String content = mvcResult.getResponse().getContentAsString();
		 * assertEquals("test1", content);
		 */
		
		mvc.perform(get("/test1/").accept(MediaType.TEXT_PLAIN)).andExpect(status().isOk())
		.andExpect(content().string("test1"));

		
		
	}

}
