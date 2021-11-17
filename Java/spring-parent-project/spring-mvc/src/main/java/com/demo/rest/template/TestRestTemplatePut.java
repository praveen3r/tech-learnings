package com.demo.rest.template;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.RestTemplateVO;
import com.demo.utils.RestClientPut;

public class TestRestTemplatePut {

	public static void getJsonStringWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate3/rest1/{id}";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, String.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getObjectWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate3/rest1/{id}";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RestTemplateVO> response = restTemplate.exchange(uri, HttpMethod.PUT, entity, RestTemplateVO.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void updateWithPut() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate3/rest1/{id}";

		RestTemplate restTemplate = new RestTemplate();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		restTemplate.put(uri, restTemplateVO, params);
		
		System.out.println("success");

	}
	
	public static void testWithRestClient(){
		RestClientPut restClient = new RestClientPut();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		restClient.doPUT("http://localhost:8080/spring-mvc/restTemplate3/rest1/{id}", restTemplateVO, params);
		
		System.out.println("success");
	}
	
	
	
}
