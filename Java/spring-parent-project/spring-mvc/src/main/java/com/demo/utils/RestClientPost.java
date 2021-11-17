package com.demo.utils;

import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClientPost {
	
	public <T> T doPOST(final String url, final Object request, final Class<T> responseType){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, request, responseType);
	}
	
	public <T> T doPOST(final String url, final Object request, final Class<T> responseType, final Map<String, String> urlVariables){
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(url, request, responseType, urlVariables);
	}
	
	public <T> ResponseEntity<T> doPOSTEntity(final String url, final Object request, final Class<T> responseType){
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<T> response = restTemplate.postForEntity(url, request, responseType);
		return response;
	}
	
	public <T> ResponseEntity<T> doPOSTEntity(final String url, final Object request, final Class<T> responseType, final Map<String, String> urlVariables){
		RestTemplate restTemplate = new RestTemplate();
		final ResponseEntity<T> response = restTemplate.postForEntity(url, request, responseType, urlVariables);
		return response;
	}

	public <T> T doPOST(final String url, final HttpHeaders headers, final Class<T> responseType){
		return doExchange(url, headers, responseType, HttpMethod.POST);
	}
	
	public <T> T doPOST(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headers, urlVariables, responseType, isReqParam, HttpMethod.POST);
	}
	
	public <T> T doPOST(final String url, final Map<String, String> headerVariables, final Class<T> responseType){
		return doExchange(url, headerVariables, responseType, HttpMethod.POST);
	}
	
	public <T> T doPOST(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headerVariables, urlVariables, responseType, isReqParam, HttpMethod.POST);
	}
	
	public <T> T doExchange(final String url, final HttpHeaders headers, final Class<T> responseType, HttpMethod httpMethod){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		final ResponseEntity<T> response = restTemplate.exchange(url, httpMethod, entity, responseType); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam, HttpMethod httpMethod){
		RestTemplate restTemplate = new RestTemplate();
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<T> response = null;
		if(isReqParam)
			response = restTemplate.exchange(expandUrl(url,urlVariables), httpMethod, entity, responseType, urlVariables); 
		else
			response = restTemplate.exchange(url, httpMethod, entity, responseType, urlVariables); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final Map<String, String> headerVariables, final Class<T> responseType, HttpMethod httpMethod){
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headerVariables.keySet().stream().forEach(k -> headers.add(k, headerVariables.get(k)));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		final ResponseEntity<T> response = restTemplate.exchange(url, httpMethod, entity, responseType); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam, HttpMethod httpMethod){
		RestTemplate restTemplate = new RestTemplate();
		final HttpHeaders headers = new HttpHeaders();
		headerVariables.keySet().stream().forEach(k -> headers.add(k, headerVariables.get(k)));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<T> response = null;
		if(isReqParam)
			response = restTemplate.exchange(expandUrl(url,urlVariables), httpMethod, entity, responseType, urlVariables); 
		else
			response = restTemplate.exchange(url, httpMethod, entity, responseType, urlVariables); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	private String expandUrl(final String url) {
		final StringBuffer buffer = new StringBuffer(url);
		buffer.append("http://localhost:8080/").append("?");
		return buffer.toString();
	}
	
	private String expandUrl(final String url, final Map<String, String> uriVariables) {
		final StringBuffer buffer = new StringBuffer(url);
		if(!uriVariables.isEmpty()){
			buffer.append("?");
			uriVariables.keySet().forEach(k -> buffer.append(k).append("={").append(k).append("}&"));
		}
		return buffer.toString();
	}
}
