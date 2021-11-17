package com.demo.optional;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class TestOptional {

	public static void main(String[] args) {
		testOptionalChaning();		
	}

	static void testOptionalOf() {
		display(Optional.of("1"));
		display(Optional.empty());
	}
	
	static void testOptionalOrElse() {
		  /* The orElse() method is used to retrieve the value wrapped inside an Optional instance.
	     It takes one parameter which acts as a default value.The orElse() method returns the wrapped value if it’s present and
	      its argument otherwise
	      
	     when using orElse(), whether the wrapped value is present or not, the orElse() is called */
		
		String name = null;
	     String value = Optional.ofNullable(name).orElse("It is null");
	     
	     display(value);
	}
	
	static void testOptionalOrElseGet() {
		  /* The orElseGet() method is similar to orElse(). However, instead of taking a value 
		   * to return if the Optional value is not present, it takes a supplier functional interface
		   *  which is invoked and returns the value of the invocation*/
		
		String name = null;
	     String value = Optional.ofNullable(name).orElseGet(() -> "It is null");
	     
	     display(value);
	}
	
	static void testOptionalOrElseThrow() {
		
		String name = null;
	     String value = Optional.ofNullable(name).orElseThrow(IllegalArgumentException::new);
	     
	     display(value);
	}
	
   static void testOptionalGet() {
		
	   //get() can only return a value if the wrapped object is not null, otherwise, it throws a no such element exception
	   Optional<String> opt = Optional.of("Test");
	    String name = opt.get();
	    System.out.println(name);
	}
	
   static void testOptionalFilter() {
		
	   //String str = "Hello World";
	   String str = null;
	    Optional<String> strOptional = Optional.ofNullable(str);
	    boolean isValid = strOptional.filter(str1 -> str1.length() > 4).isPresent();
	    System.out.println(isValid);
	}
   
   static void testOptionalMap(){
	   
	   //List<String> companyNames = Arrays.asList("paypal", "oracle", "", "microsoft", "", "apple");
	   List<String> companyNames = null;
	   Optional<List<String>> listOptional = Optional.ofNullable(companyNames);
			 
	    int size = listOptional.map(List::size).orElse(0);
	    System.out.println(size);
   }
   
   static void testOptionalChaning(){
	   
	   //In case of chaining, it returns the first non-empty one
	   /*Optional<String> found =
			      Stream.<Supplier<Optional<String>>>of(this::getEmpty, this::getHello, this::getBye)
			        .map(Supplier::get)
			        .filter(Optional::isPresent)
			        .map(Optional::get)
			        .findFirst();*/
	   
	   Optional<String> found = Stream.of(getEmpty(), getHello(), getBye())
			      .filter(Optional::isPresent)
			      .map(Optional::get)
			      .findFirst();
	   
	   System.out.println(found.get());
   }
   
   static Optional<String> getEmpty() {
	    return Optional.empty();
	}
	 
   static Optional<String> getHello() {
	    return Optional.of("hello");
	}
	 
   static Optional<String> getBye() {
	    return Optional.of("bye");
	}
   
	static void display(Optional<String> param){
		System.out.println("param.isPresent() "+param.isPresent());
		param.ifPresent(a -> System.out.println(a));
	}
	
	static void display(String param){
		System.out.println("param "+param);
	}
	
	/*static void report(@Default("Hello") String message) {
	    System.out.println("Message: " + message);
	}*/
}
