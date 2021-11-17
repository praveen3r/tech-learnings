package com.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.demo.DemoApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(
		  classes = {DemoApplication.class})
@AutoConfigureMockMvc
public class UserControllerSpringBootTest {

	@Autowired
	  private MockMvc mockMvc;

	  /*@Autowired
	  private ObjectMapper objectMapper;*/
	  
	  @Test
	  public void registrationWorksThroughAllLayers() throws Exception {
		  mockMvc.perform(MockMvcRequestBuilders.get("/test23")
		            .contentType("application/json")
		            .accept("application/json"))
		            .andExpect(MockMvcResultMatchers.status().isOk());
	  }
}
