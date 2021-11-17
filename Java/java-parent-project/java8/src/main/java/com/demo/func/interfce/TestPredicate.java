package com.demo.func.interfce;

import java.util.function.BiPredicate;

public class TestPredicate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//function accepting a single argument to evaluate to a boolean result
		
		String test="1234";
		// Lambda to check an empty string
		//Predicate<String> emptyStringChecker = s -> s.isEmpty();
		
		/*Predicate<String> stringLambda = s -> s.length() > 2;
		System.out.println(stringLambda.test(test));*/
		
		/*Predicate<String> emptyStringChecker = s -> s.isEmpty();
		
		Predicate<String> stringLambda = s -> s.length() > 2;
		
		System.out.println(emptyStringChecker.and(stringLambda).test("123"));*/
		
		/*IntPredicate intLambda = i -> i > 2;
		System.out.println(intLambda.test(123));*/
		
	/*	IntPredicate i = (x)-> x < 0;
	    IntPredicate j = (x)-> x == 0;
	    
	    System.out.println(i.and(j).test(123));*/
	    
		//Negate means opposite of the logical result i.e ! condition
	  /*  IntPredicate i = (x)-> x < 0;
	    System.out.println(i.negate().test(123));*/
		
		/*LongPredicate longLambda = i -> i > 2;    
		System.out.println(longLambda.test(123));*/
		
		BiPredicate<Integer, Integer> bi = (x, y) -> x > y;
		System.out.println(bi.test(2, 3));
	}

}
