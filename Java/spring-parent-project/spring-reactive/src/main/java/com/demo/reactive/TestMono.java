package com.demo.reactive;

import org.junit.Test;

import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

public class TestMono {

	/*@Test
	public void testMono(){
		Mono<String> testMono = Mono.just("Test1");
		testMono.subscribe(System.out::println);
	}*/
	
	/*@Test
	public void testMonoError(){
		Mono<Object> testMono = Mono.error(new RuntimeException("throwing exception"));
		
		testMono.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testMonoWithLog(){
		Mono<String> testMono = Mono.just("Test1").log();
		
		testMono.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testMonoErrorWithLog(){
		Mono<Object> testMono = Mono.error(new RuntimeException("throwing exception")).log();
		
		testMono.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testMonoWithCompletionEventWithLog(){
		Mono<String> testMono = Mono.just("Test1").log();
		
		testMono.subscribe(System.out::println,
				(e) -> System.err.println(e),
				() -> System.out.println("completed"));
	}*/
	
	/*@Test
	public void testMonoWithJunit(){
		Mono<String> testMono = Mono.just("Test1").log();
		
		StepVerifier.create(testMono)
					.expectNext("Test1")
					.verifyComplete();
	}*/
	
	/*@Test
	public void testMonoWithErrorJunit(){
		Mono<Object> testMono = Mono.error(new RuntimeException("throwing exception")).log();
		
		StepVerifier.create(testMono)
					.expectError(RuntimeException.class)
					.verify();
	}*/
	
	/*@Test
	public void testMonoWithErrorMsgJunit(){
		Mono<Object> testMono = Mono.error(new RuntimeException("throwing exception")).log();
		
		StepVerifier.create(testMono)
					.expectErrorMessage("throwing exception")
					.verify();
	}*/
	
	@Test
	public void testMonoWithElementCnt_ErrorMsgJunit(){
		Mono<String> testMono = Mono.just("Test1");
		
		StepVerifier.create(testMono)
					.expectNextCount(1)
					.verifyComplete();
	}

}
