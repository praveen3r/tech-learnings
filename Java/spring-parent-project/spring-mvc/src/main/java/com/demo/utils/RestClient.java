package com.demo.utils;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestClient {
	
	@Autowired
	RestTemplate restTemplate;
	
	public <T> T doGET(final String url, final Class<T> responseType){
		return restTemplate.getForObject(url, responseType);
	}
	
	public <T> T doGET(final String url, final Class<T> responseType, final Map<String, String> urlVariables){
		return restTemplate.getForObject(url, responseType, urlVariables);
	}
	
	public <T> ResponseEntity<T> doGETEntity(final String url, final Class<T> responseType){
		final ResponseEntity<T> response = restTemplate.getForEntity(url, responseType);
		return response;
	}
	
	public <T> ResponseEntity<T> doGETEntity(final String url, final Class<T> responseType, final Map<String, String> urlVariables){
		final ResponseEntity<T> response = restTemplate.getForEntity(url, responseType, urlVariables);
		return response;
	}

	public <T> T doGET(final String url, final HttpHeaders headers, final Class<T> responseType){
		return doExchange(url, headers, responseType, HttpMethod.GET);
	}
	
	public <T> T doGET(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headers, urlVariables, responseType, isReqParam, HttpMethod.GET);
	}
	
	public <T> T doGET(final String url, final Map<String, String> headerVariables, final Class<T> responseType){
		return doExchange(url, headerVariables, responseType, HttpMethod.GET);
	}
	
	public <T> T doGET(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headerVariables, urlVariables, responseType, isReqParam, HttpMethod.GET);
	}
	
	public <T> T doPOST(final String url, final Object request, final Class<T> responseType){
		return restTemplate.postForObject(url, request, responseType);
	}
	
	public <T> T doPOST(final String url, final Object request, final Class<T> responseType, final Map<String, String> urlVariables){
		return restTemplate.postForObject(url, request, responseType, urlVariables);
	}
	
	public <T> ResponseEntity<T> doPOSTEntity(final String url, final Object request, final Class<T> responseType){
		final ResponseEntity<T> response = restTemplate.postForEntity(url, request, responseType);
		return response;
	}
	
	public <T> ResponseEntity<T> doPOSTEntity(final String url, final Object request, final Class<T> responseType, final Map<String, String> urlVariables){
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
	
	public void doPUT(final String url, final Object request){
		restTemplate.put(url, request);
	}
	
	public void doPUT(final String url, final Object request, final Map<String, String> urlVariables){
		restTemplate.put(url, request, urlVariables);
	}
	
	public <T> T doPUT(final String url, final HttpHeaders headers, final Class<T> responseType){
		return doExchange(url, headers, responseType, HttpMethod.PUT);
	}
	
	public <T> T doPUT(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headers, urlVariables, responseType, isReqParam, HttpMethod.PUT);
	}
	
	public <T> T doPUT(final String url, final Map<String, String> headerVariables, final Class<T> responseType){
		return doExchange(url, headerVariables, responseType, HttpMethod.PUT);
	}
	
	public <T> T doPUT(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headerVariables, urlVariables, responseType, isReqParam, HttpMethod.PUT);
	}
	
	public void doDELETE(final String url){
		restTemplate.delete(url);
	}
	
	public void doDELETE(final String url, final Map<String, String> urlVariables){
		restTemplate.delete(url, urlVariables);
	}
	
	public <T> T doDELETE(final String url, final HttpHeaders headers, final Class<T> responseType){
		return doExchange(url, headers, responseType, HttpMethod.DELETE);
	}
	
	public <T> T doDELETE(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headers, urlVariables, responseType, isReqParam, HttpMethod.PUT);
	}
	
	public <T> T doDELETE(final String url, final Map<String, String> headerVariables, final Class<T> responseType){
		return doExchange(url, headerVariables, responseType, HttpMethod.PUT);
	}
	
	public <T> T doDELETE(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam){
		return doExchange(url, headerVariables, urlVariables, responseType, isReqParam, HttpMethod.PUT);
	}
	
	public <T> T doExchange(final String url, final HttpHeaders headers, final Class<T> responseType, HttpMethod httpMethod){
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		final ResponseEntity<T> response = restTemplate.exchange(url, httpMethod, entity, responseType); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final HttpHeaders headers, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam, HttpMethod httpMethod){
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		ResponseEntity<T> response = null;
		if(isReqParam)
			response = restTemplate.exchange(expandUrl(url,urlVariables), httpMethod, entity, responseType, urlVariables); 
		else
			response = restTemplate.exchange(url, httpMethod, entity, responseType, urlVariables); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final Map<String, String> headerVariables, final Class<T> responseType, HttpMethod httpMethod){
		final HttpHeaders headers = new HttpHeaders();
		headerVariables.keySet().stream().forEach(k -> headers.add(k, headerVariables.get(k)));
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		final ResponseEntity<T> response = restTemplate.exchange(url, httpMethod, entity, responseType); 
		return response.getStatusCode().is2xxSuccessful() ? response.getBody() : null;
	}
	
	public <T> T doExchange(final String url, final Map<String, String> headerVariables, final Map<String, String> urlVariables, final Class<T> responseType,boolean isReqParam, HttpMethod httpMethod){
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
