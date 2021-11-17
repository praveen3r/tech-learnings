package com.demo.methodRef;

public class TestMethodReference {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 /*Function<Integer, String> func1  = x -> Integer.toBinaryString(x);
		    System.out.println(func1.apply(10));

		    // Using  a  method  reference
		    Function<Integer, String> func2  = Integer::toBinaryString;
		    System.out.println(func2.apply(10));*/
		
		 // Uses  Integer.valueOf(int)
	    /*Function<Integer, Integer> func1  = Integer::valueOf;

	    // Uses  Integer.valueOf(String)
	    Function<String, Integer> func2  = Integer::valueOf;

	    // Uses  Integer.valueOf(String, int)
	    BiFunction<String, Integer,  Integer> func3  = Integer::valueOf;

	    System.out.println(func1.apply(7)); 
	    System.out.println(func2.apply("7")); 
	    System.out.println(func3.apply("101010101010", 2));*/
	}

}
