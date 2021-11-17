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
import com.demo.utils.RestClientDelete;

public class TestRestTemplateDelete {

	public static void getNothingWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate4/rest1/{id}";
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<Void> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, Void.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getJsonStringWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate4/rest2/{id}";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, String.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getObjectWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate4/rest2/{id}";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RestTemplateVO> response = restTemplate.exchange(uri, HttpMethod.DELETE, entity, RestTemplateVO.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void deleteWithDelete() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate4/rest1/{id}";

		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		restTemplate.delete(uri, params);
		
		System.out.println("success");

	}
	
	public static void testWithRestClient(){
		RestClientDelete restClient = new RestClientDelete();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		restClient.doDELETE("http://localhost:8080/spring-mvc/restTemplate4/rest1/{id}", params);
		
		System.out.println("success");
	}
	
	
	
}
