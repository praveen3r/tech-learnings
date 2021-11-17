package com.demo.controller;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.not;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.demo.dto.TestJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTest {

	@Test
	public void testJsonInject() throws JsonProcessingException {
	  ObjectMapper objectMapper = new ObjectMapper();
	  String jsonString = objectMapper.writeValueAsString(new TestJson());
	  System.out.println(jsonString);
	  assertThat(jsonString, containsString("newDept"));
	  assertThat(jsonString, not(containsString("dept")));
	}
}
