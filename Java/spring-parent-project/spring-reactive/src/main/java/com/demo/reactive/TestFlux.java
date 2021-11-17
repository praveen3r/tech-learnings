package com.demo.reactive;

import java.time.Duration;

import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class TestFlux {

	/*@Test
	public void testFlux(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3");
		testFlux.subscribe(System.out::println);
	}*/
	
	/*@Test
	public void testFluxError(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3")
				.concatWith(Flux.error(new RuntimeException("throwing exception")));
		
		testFlux.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testFluxWithLog(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3").log();
		
		testFlux.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testFluxErrorWithLog(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3")
				.concatWith(Flux.error(new RuntimeException("throwing exception")))
				.concatWith(Flux.just("TestNew1","TestNew2","TestNew3")).log();
		
		testFlux.subscribe(System.out::println,
				(e) -> System.err.println(e));
	}*/
	
	/*@Test
	public void testFluxWithCompletionEventWithLog(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3").log();
		
		testFlux.subscribe(System.out::println,
				(e) -> System.err.println(e),
				() -> System.out.println("completed"));
	}*/
	
	/*@Test
	public void testFluxWithJunit(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3").log();
		
		StepVerifier.create(testFlux)
					.expectNext("Test1")
					.expectNext("Test2")
					.expectNext("Test3")
					.verifyComplete();
	}*/
	
	/*public Flux<Long> runWithInfiteLoop(){
		return Flux.interval(Duration.ofSeconds(1)).log();
	}*/
	
	/*@Test
	public void testFluxWithJunit1(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3").log();
		
		StepVerifier.create(testFlux)
					.expectNext("Test1","Test2","Test3")
					.verifyComplete();
	}*/
	
	/*@Test
	public void testFluxWithErrorJunit(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3")
				.concatWith(Flux.error(new RuntimeException("throwing exception"))).log();
		
		StepVerifier.create(testFlux)
					.expectNext("Test1")
					.expectNext("Test2")
					.expectNext("Test3")
					.expectError(RuntimeException.class)
					.verify();
	}*/
	
	/*@Test
	public void testFluxWithErrorMsgJunit(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3")
				.concatWith(Flux.error(new RuntimeException("throwing exception"))).log();
		
		StepVerifier.create(testFlux)
					.expectNext("Test1")
					.expectNext("Test2")
					.expectNext("Test3")
					.expectErrorMessage("throwing exception")
					.verify();
	}*/
	
	/*@Test
	public void testFluxWithElementCnt_ErrorMsgJunit(){
		Flux<String> testFlux = Flux.just("Test1","Test2","Test3")
				.concatWith(Flux.error(new RuntimeException("throwing exception"))).log();
		
		StepVerifier.create(testFlux)
					.expectNextCount(3)
					.expectErrorMessage("throwing exception")
					.verify();
	}*/

}
