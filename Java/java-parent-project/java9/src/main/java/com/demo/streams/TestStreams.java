package com.demo.streams;

import java.util.List;
import java.util.stream.Stream;

public class TestStreams {

	public static void main(String[] args) {
		ofNullableMethod();
		
	}
	
	public static void takeAndDropWhile() {
		//ordered stream
		
				/* Stream.of(2, 4, 6, 8, 9, 10, 12)
			    .takeWhile(n -> n % 2 == 0)
			    .forEach(System.out::println);*/
				
				/* Stream.of(2, 4, 6, 8, 9, 10, 12)
			    .dropWhile(n -> n % 2 == 0)
			    .forEach(System.out::println); */
				
				/* unordered stream - According to the docs, if some of the elements in the stream 
				match the predicate (but not all) then the operation is nondeterministic and an 
				arbitrary subset of matching elements is returned or removed.
				Meaning that you’ll get different results for each execution.*/
				
				/*Set<Integer> numbers = Set.of(2, 4, 6, 3, 8);
				numbers.stream()
				    .takeWhile(n -> n % 2 == 0)
				    .forEach(System.out::println);*/
				
				Stream<String> stream = Stream.iterate("", s -> s + "s")
						  .takeWhile(s -> s.length() < 10);
				stream.forEach(System.out::println);
				
				Stream.of("apple", "banana", "cat", "", "elephant","","Dog")
				.dropWhile(s->!s.isEmpty()).forEach(System.out::println);
	}
	
	public static void IterateMethod() {
		Stream.iterate(0, i -> i < 10, i -> i + 1)
		  .forEach(System.out::println);
	}
	
	public static void ofNullableMethod() {
		long count = Stream.ofNullable(100).count();
	      System.out.println(count);
	  
	      count = Stream.ofNullable(null).count();
	      System.out.println(count);
	      
	      System.out.println("123");
	      Stream.ofNullable(null).forEach(System.out::println);
	      System.out.println("1234");
	      
	      List<String> testList = null;
	      Stream.ofNullable(testList).forEach(System.out::println);
	}

}
