package com.demo.reactive;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebFluxTest
@SpringBootTest
@AutoConfigureWebTestClient
public class TestController {

	@Autowired
	WebTestClient webTestClient;
	
	/*@Test
	public void test1(){
		Flux<String> fluxStr = webTestClient
		.get()
		.uri("/fluxtest/rest1")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.returnResult(String.class)
		.getResponseBody();
		
		StepVerifier.create(fluxStr)
					.expectSubscription()
					.expectNext("Test1","Test2","Test3","Test4")
					.verifyComplete();
	}*/
	
	@Test
	public void test2(){
		webTestClient
		.get()
		.uri("/fluxtest/rest1")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(String.class)
		.hasSize(4);
	}
	
	@Test
	public void test3(){
		List<String> testList = Arrays.asList("Test1","Test2","Test3","Test4");
		
	EntityExchangeResult<List<String>>	entityExchangeResult = webTestClient
		.get()
		.uri("/fluxtest/rest1")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(String.class)
		.returnResult();
	
	assertEquals(testList, entityExchangeResult.getResponseBody());
	
	}
	
	@Test
	public void test4(){
		List<String> testList = Arrays.asList("Test1","Test2","Test3","Test4");
		
	webTestClient
		.get()
		.uri("/fluxtest/rest1")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.expectBodyList(String.class)
		.consumeWith((response) -> {
			assertEquals(testList, response.getResponseBody());
		});
	
	
	}
	
	@Test
	public void test5(){
		Flux<Long> fluxLong = webTestClient
		.get()
		.uri("/fluxtest/rest1")
		.accept(MediaType.APPLICATION_STREAM_JSON)
		.exchange()
		.expectStatus().isOk()
		.returnResult(Long.class)
		.getResponseBody();
		
		StepVerifier.create(fluxLong)
					.expectSubscription()
					.expectNext(0l,1l,2l).thenCancel()
					.verify();
	}
	
	/*@Test
	public void test1(){
		Flux<String> fluxStr = webTestClient
		.get()
		.uri("/monotest/rest1")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.returnResult(String.class)
		.getResponseBody();
		
		StepVerifier.create(fluxStr)
					.expectNext("Test1")
					.verifyComplete();
	}*/
	
	/*@Test
	public void test1(){
		Flux<Integer> fluxStr = webTestClient
		.get()
		.uri("/functional/flux")
		.accept(MediaType.APPLICATION_JSON_UTF8)
		.exchange()
		.expectStatus().isOk()
		.returnResult(Integer.class)
		.getResponseBody();
		
		StepVerifier.create(fluxStr)
					.expectNext(1,2,3,4)
					.verifyComplete();
	}*/
}
