package com.demo.func.interfce;

import java.util.function.LongUnaryOperator;

public class TestUnaryOperator {

	public static void main(String[] args) {
		//produces a result of the same type as its operand
		
	/*	UnaryOperator<String> i  = (x)-> x.toUpperCase();
	    System.out.println(i.apply("java"));*/
	    
		/* IntUnaryOperator i = (x) -> x*x;
		 System.out.println(i.applyAsInt(2));*/
		
	/*	IntUnaryOperator i = (x) -> x*x;
		IntUnaryOperator i1 = (x) -> x+x;
	    System.out.println(i.compose(i1).applyAsInt(3));
	    System.out.println(i.andThen(i1).applyAsInt(3));*/
	    
	    /*IntUnaryOperator i = IntUnaryOperator.identity();
	    System.out.println(i.compose(i).applyAsInt(2));
		
		 /*DoubleUnaryOperator dl = (x) -> {return x*x;};
	    System.out.println(dl.applyAsDouble(3.14));*/
		
		 LongUnaryOperator i = (l) -> -l;
		 System.out.println(i.applyAsLong(Long.MAX_VALUE));
	}

}
