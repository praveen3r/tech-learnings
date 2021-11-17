package com.demo.func.interfce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;


public class TestFunction {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//return any result by working on a single input argument
		
		// String to an integer
		Function<Integer,String> converter = i -> Integer.toString(i);
	    System.out.println(converter.apply(3).length());
		
	    String result = calc((a) -> "Result: " + (a * 2), 10);
	    System.out.println(result);
	    
	    
	   // Function<String, Integer> reverse = (s)-> Integer.parseInt(s);
	    System.out.println(converter.apply(3).length());
	    
	    Function<Integer, Integer> times2 = e -> e * 2;
	    Function<Integer, Integer> squared = e -> e * e;  
	    
	    System.out.println(times2.compose(squared).apply(4));  
	    System.out.println(times2.andThen(squared).apply(4));  
	    
	    //always returns its input argument
	    Function<Integer,Integer> id = Function.identity();
	    System.out.println(id.apply(3));
		/*List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cat", "dog"));
		Function<List<String>,Integer> funcLamda = t -> {
			int testInt = 1;
			for (String Str: t){
				testInt = testInt+testInt;
			}
			return testInt;
		};
		System.out.println(funcLamda.apply(alphabets));*/
		
		/*List<String> alphabets = new ArrayList<>(Arrays.asList("aa", "bbb", "cat", "dog"));
		System.out.println(alphabets.stream().map(t -> t.length()));*/
		//System.out.println(alphabets.stream().map(t -> t.length()).anyMatch(t -> t.intValue()>2));
		//System.out.println(alphabets.stream().mapToInt(t -> t.length()).sum());
	}
	
	public static String calc(Function<Integer, String> bi, Integer i) {
	    return bi.apply(i);
	  } 
	

}
