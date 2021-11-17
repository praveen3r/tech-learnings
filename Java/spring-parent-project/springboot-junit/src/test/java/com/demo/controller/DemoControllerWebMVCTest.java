package com.demo.controller;

import static org.mockito.Mockito.when;

import java.net.URISyntaxException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.demo.service.DemoService;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(DemoController.class)
public class DemoControllerWebMVCTest {

	@Autowired
    private MockMvc mvc;
 
    @MockBean
    private DemoService service;
	
	
	@Test
	public void test() throws Exception{
		
		when(service.test()).thenReturn("test11");
	     
		MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.get("/test")
			      .contentType(MediaType.TEXT_PLAIN)).andReturn();
		
		int status = mvcResult.getResponse().getStatus();
		
		   assertEquals(200, status);
		   
		   String content = mvcResult.getResponse().getContentAsString();
		   
		   assertEquals("test11", content);
		   
	}

}
