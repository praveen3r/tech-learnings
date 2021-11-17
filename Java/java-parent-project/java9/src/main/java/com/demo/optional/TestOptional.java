package com.demo.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TestOptional {

	public static void main(String[] args) {
		OptionalStream();

	}

	private static void testIfPresentOrElse() {
		List<String> vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
		Optional<List> vegetablesOpt = Optional.ofNullable(vegetables);
		/*vegetablesOpt.ifPresentOrElse(  
				  this::publish,                       
				  this::notifyThatNothingWasPublished
				);*/
		vegetablesOpt.ifPresentOrElse( 
		            (value) 
		                -> { System.out.println( 
		                         "Value is present, its: "
		                         + value); }, 
		            () 
		                -> { System.out.println( 
		                         "Value is empty"); }); 
		
	}
	
	private static void testIfPresentOrElse1() {
		IntStream.of(1, 2, 4)
        .filter(i -> i % 3 == 0)
        .findFirst()
        .ifPresentOrElse(System.out::println, () -> {
            System.out.println("No multiple of 3 found");
        });
	}
	
	public static void testOr() {
	    Optional<String> value = Optional.of("some value");
	    Optional<String> defaultValue = Optional.of("default");
	 
	    Optional<String> result = value.or(() -> defaultValue);
	    
	    System.out.println(result.get());
	 
	}
	
	public static void testOr1() {
		
		char digit = Stream.of('a', 'b', 'c')
                .filter(c -> Character.isDigit(c))
                .findFirst()
                .or(() -> Optional.of('0')).get();
	}
	
	public static void OptionalStream() {
		OptionalInt opt1 = IntStream.of(2, 5, 6).max();
		 OptionalInt opt2 = IntStream.of(1, 3, 7).max();
		 IntStream.concat(opt1.stream(), opt2.stream())
		          .forEach(System.out::println);
	}
}
