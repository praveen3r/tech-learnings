package com.demo.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/webtestclient/")
public class WebClientSubscriberController {

	@Autowired
	WebClient webClient;
	
	@RequestMapping(value = "rest1", method = RequestMethod.GET)
	public Mono<String> rest1() {
		
		/*return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest1")
				.retrieve()
				.bodyToMono(String.class);*/
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest1")
				.exchange()
				.doOnSuccess(response -> System.out.println("response.headers() = " + response.headers().asHttpHeaders()))
				.doOnSuccess(response -> System.out.println("response.statusCode() = " + response.statusCode()))
				.flatMap(response -> response.bodyToMono(String.class));
		
				
	}
	
	@RequestMapping(value = "rest2", method = RequestMethod.GET)
	public Flux<String> rest2() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest2")
				.retrieve()
				.onStatus(HttpStatus::is4xxClientError, clientResponse ->  Mono.error(new RuntimeException()))
		        .onStatus(HttpStatus::is5xxServerError, clientResponse -> Mono.error(new RuntimeException()))
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest3", method = RequestMethod.GET)
	public Flux<String> getWithParams() {
		
		return webClient
				.get()
				.uri(uriBuilder -> uriBuilder.scheme("http").host("localhost").port("8080").path("/webclient/rest3")
	                    .queryParam("id", "Id world")
	                    .build())
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest4", method = RequestMethod.GET)
	public Flux<String> getWithHeaders() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest4")
				//.header("id", "Header World")
				.headers(headers -> headers.add("id", "Header World"))
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest5", method = RequestMethod.GET)
	public Flux<String> post() {
		
		return webClient
				.post()
				.uri("http://localhost:8080/webclient/rest5")
				//.syncBody("Test Post World")
				.body(BodyInserters.fromObject("Test Post Body world"))
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest6", method = RequestMethod.GET)
	public Flux<String> postWithFormData() {
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
		map.add("id", "Test Post Form data");
		
		return webClient
				.post()
				.uri("http://localhost:8080/webclient/rest6")
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE)
				.syncBody(map)
				//.body(BodyInserters.fromFormData("id", "Test Post Form data"))
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest7", method = RequestMethod.GET)
	public Mono<String> getMonoData() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest41")
				.retrieve()
				.bodyToMono(String.class);
		
	}
	
	@RequestMapping(value = "rest8", method = RequestMethod.GET)
	public Flux<String> getFluxData() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest42")
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest9", method = RequestMethod.GET)
	public Flux<String> postWithMono() {
		
		return webClient
				.post()
				.uri("http://localhost:8080/webclient/rest72")
				.body(Mono.just("Test Mono Post"), String.class)
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest10", method = RequestMethod.GET)
	public Flux<String> postWithFlux() {
		
		return webClient
				.post()
				.uri("http://localhost:8080/webclient/rest7")
				.body(Flux.just("Test Mono Post1","Test Mono Post2"), String.class)
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	@RequestMapping(value = "rest11", method = RequestMethod.GET, produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> getWithStream() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest9")
				.retrieve()
				.bodyToFlux(Long.class);
		
	}
	
	@RequestMapping(value = "rest12", method = RequestMethod.GET, produces=MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Long> getNestedStream() {
		
		return webClient
				.get()
				.uri("http://localhost:8080/webclient/rest9")
				.retrieve()
				.bodyToFlux(Long.class)
				.flatMap(value -> {
					return webClient
					.get().uri(uriBuilder -> uriBuilder.scheme("http").host("localhost").port("8080").path("/webclient/rest10")
		                    .queryParam("id", value)
		                    .build())
					.retrieve()
					.bodyToFlux(Long.class);
				});
		
	}
	
	@RequestMapping(value = "rest13", method = RequestMethod.GET)
	public Flux<String> postWithMultipart() throws IOException{
		
		MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();
		Resource resource = getUserFileResource();
		map.add("file", resource);
		
		/*MultipartBodyBuilder builder = new MultipartBodyBuilder();
	    builder.part("fieldPart", "fieldValue");
	    builder.part("file", new FileSystemResource(new File("C:/Users/e3013838/Desktop/URL.txt")));*/
		
		return webClient
				.post()
				.uri("http://localhost:8080/webclient/rest71")
				.contentType(MediaType.MULTIPART_FORM_DATA)
				.body(BodyInserters.fromMultipartData(map))
				//.syncBody(builder.build())
				.retrieve()
				.bodyToFlux(String.class);
		
	}
	
	public static Resource getUserFileResource() throws IOException {
	      File file = new File("C:/Users/e3013838/Desktop/URL.txt");
	      return new FileSystemResource(file);
	  }
}
