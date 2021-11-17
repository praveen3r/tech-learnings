package com.demo.rest.template;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.dto.RestTemplateVO;
import com.demo.utils.RestClientGet;

public class TestRestTemplateGet {

	public static void getNothingWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest1";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getStringWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest2";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getJsonStringWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest3";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}

	public static void getObjectWithExchange() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest3";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<RestTemplateVO> entity = new HttpEntity<RestTemplateVO>(headers);

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<RestTemplateVO> response = restTemplate.exchange(uri, HttpMethod.GET, entity, RestTemplateVO.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithExchangePathParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4/{id}";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithExchangePathParam1() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);

		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> response = restTemplate.exchange(uri + "/12", HttpMethod.GET, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithExchangeRequestParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4?id={id}";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		

		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	//Get id from map itself
	public static void getStringWithExchangeRequestParam1() {
		String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		

		RestTemplate restTemplate = new RestTemplate();
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
	    uri = expandUrl(uri,params);

		ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class, params);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithExchangeUriComponentsBuilder() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4";

		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(uri)
		        						.queryParam("id", "123");

		RestTemplate restTemplate = new RestTemplate();

		ResponseEntity<String> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, String.class);

		System.out.println(response);
		System.out.println(response.getBody());
	}
	
	public static void getStringWithGetForObject() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest2";

		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		String result = restTemplate.getForObject(uri, String.class);

		System.out.println(result);
	}
	
	public static void getObjectWithGetForObject() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest2";

		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		RestTemplateVO result = restTemplate.getForObject(uri, RestTemplateVO.class);

		System.out.println(result);
	}
	
	public static void getStringWithGetForObjectPathParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4/{id}";

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		String result = restTemplate.getForObject(uri, String.class,params);

		System.out.println(result);
	}
	
	public static void getStringWithGetForObjectRequestParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4";

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		String result = restTemplate.getForObject(uri, String.class,params);

		System.out.println(result);
	}
	
	public static void getStringWithGetForEntity() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest2";

		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getObjectWithGetForEntity() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest2";

		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		ResponseEntity<RestTemplateVO> result = restTemplate.getForEntity(uri, RestTemplateVO.class);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getStringWithGetForEntityPathParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4/{id}";

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class,params);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getStringWithGetForEntityRequestParam() {
		final String uri = "http://localhost:8080/spring-mvc/restTemplate1/rest4";

		Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	    
		RestTemplate restTemplate = new RestTemplate();
		
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
		MappingJackson2HttpMessageConverter map = new MappingJackson2HttpMessageConverter();
		messageConverters.add(map);
		restTemplate.setMessageConverters(messageConverters);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class,params);

		System.out.println(result);
		System.out.println(result.getBody());
	}
	
	public static void getWithRestClient(){
		RestClientGet restClient = new RestClientGet();
		String result = restClient.doGET("http://localhost:8080/spring-mvc/restTemplate1/rest2", String.class);
		System.out.println(result);
	}
	
	public static String expandUrl(final String url, final Map<String, String> uriVariables) {
		final StringBuffer buffer = new StringBuffer(url);
		if(!uriVariables.isEmpty()){
			buffer.append("?");
			uriVariables.keySet().forEach(k -> buffer.append(k).append("={").append(k).append("}&"));
		}
		return buffer.toString();
	}
	
}
