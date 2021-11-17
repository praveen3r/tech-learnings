package com.demo.methodRef;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class TestMethodReference4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		/* Supplier<String> func1  = () ->  new String();
		    System.out.println("Empty String:"+func1.get());
		    
		    Function<String,String> func2  = str ->  new String(str);
		    
		    System.out.println(func2.apply("java"));

		    Supplier<String> func3  = String::new;
		    System.out.println("Empty String:"+func3.get());
		    
		    Function<String,String> func4  = String::new;
		    System.out.println(func4.apply("java"));*/
		
		/*	IntFunction<int[]> arrayCreator1 = size ->  new int[size];
		    // Creates an  int array of  five  elements
		    int[] intArray1  = arrayCreator1.apply(5);
		    System.out.println(Arrays.toString(intArray1));
	
		    IntFunction<int[]> arrayCreator2 = int[]::new;
		    int[] intArray2 = arrayCreator2.apply(5); 
		    System.out.println(Arrays.toString(intArray2));*/
		
			Function<String[],List<String>> asList = Arrays::<String>asList;
		    System.out.println(asList.apply(new String[]{"a","b","c"}));
		  }
		}