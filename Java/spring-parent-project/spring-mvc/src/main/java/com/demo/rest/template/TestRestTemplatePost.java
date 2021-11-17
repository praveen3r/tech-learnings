package com.demo.rest.template;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.RestTemplateVO;
import com.demo.utils.RestClientPost;

public class TestRestTemplatePost {

	public static void getNothingWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest1";
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getStringWithExchange() {
		
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest2";
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getJsonStringWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getObjectWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(restTemplateVO, headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RestTemplateVO> response = restTemplate.exchange(uri, HttpMethod.POST, entity, RestTemplateVO.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithPostForObject() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		RestTemplate restTemplate = new RestTemplate();
		
		String result = restTemplate.postForObject(uri, restTemplateVO, String.class);

		System.out.println(result);
	}
	
	public static void getObjectWithPostForObject() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplate restTemplate = new RestTemplate();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		RestTemplateVO result = restTemplate.postForObject(uri, restTemplateVO, RestTemplateVO.class);

		System.out.println(result);
	}
	
	public static void getStringWithPostForEntity() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplate restTemplate = new RestTemplate();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		ResponseEntity<String> result = restTemplate.postForEntity(uri, restTemplateVO, String.class);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getObjectWithPostForEntity() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest3";

		RestTemplate restTemplate = new RestTemplate();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		ResponseEntity<RestTemplateVO> result = restTemplate.postForEntity(uri, restTemplateVO, RestTemplateVO.class);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getWithRestClient(){
		RestClientPost restClient = new RestClientPost();
		
		RestTemplateVO restTemplateVO = new RestTemplateVO();
		restTemplateVO.setId("test");
		restTemplateVO.setDept("Clerk");
		
		String result = restClient.doPOST("http://localhost:8080/spring-mvc/restTemplate2/rest3", restTemplateVO, String.class);
		System.out.println(result);
	}
	
	public static void getStringWithApplicationFormUrlEncoded() {
		
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest4";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("id", "1");
		
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity<MultiValueMap<String, String>>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithMultipartFormData() throws IOException{
		
		final String uri = "http://localhost:8080/spring-mvc/restTemplate2/rest5";

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.MULTIPART_FORM_DATA);
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		Resource resource = getUserFileResource();
		map.add("file", resource);
		
		HttpEntity<MultiValueMap<String, Object>> entity = new HttpEntity<MultiValueMap<String, Object>>(map, headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.POST, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static Resource getUserFileResource() throws IOException {
	      File file = new File("C:/Users/e3013838/Desktop/URL.txt");
	      return new FileSystemResource(file);
	  }
	
	/*public static Resource getUserFileResource() throws IOException {
	      File file = new File("C:/Users/e3013838/Desktop/URL.txt");
	      return new InputStreamResource(new FileInputStream(file));
	  }*/
	
	/*public static Resource getUserFileResource() throws IOException {
		 File file = new File("C:/Users/e3013838/Desktop/URL.txt");
	      return new ByteArrayResource(IOUtils.toByteArray(new FileInputStream(file)));
	  }*/
	
	
}
