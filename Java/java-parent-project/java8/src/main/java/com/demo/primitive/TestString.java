package com.demo.primitive;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class TestString {
	public static void main(String[] args) {
		StringJoiner joiner = new StringJoiner(",");
        joiner.add("one");
        joiner.add("two");
        joiner.add("three");
 
        System.out.println("Comma separated String : " + joiner.toString());
 
        // You can combine all three lines into one because
        // StringJoiner provides a fluent interface
        StringJoiner delimitedString = new StringJoiner("|").add("id").add("name"); 
        System.out.println("Pipe delimited String : " + delimitedString);
 
        // 2nd Example: You can also join String by String.join() method
        // By far, this is the most convenient method to join Strings
        // in Java.    
 
        String csv = String.join(":", "abc", "bcd", "def");
        System.out.println("colon separated String : " + csv);
 
 
        // You can even use String.join() method to join contents of
        // ArrayList, Array, LinkedList or any collection, actually
        // any container which implements Iterable interface
        List mylist = Arrays.asList("London", "Paris", "NewYork");
        String joined = String.join("||", mylist);
        System.out.println("Joined String : " + joined); 

		/*String test="745,746,747,748,749,750";
		//Stream.of(test).map(w -> w.split(",")).forEach(System.out::println);
		//Pattern.compile(",").splitAsStream(test).forEach(System.out::println);
		Stream.of(test.split(",")).forEach(System.out::println);*/
	}
}
