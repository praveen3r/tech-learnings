package com.demo.func.interfce;

import java.util.function.BooleanSupplier;

public class TestSupplier {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	/* Supplier<String> i  = ()-> "java";
	  System.out.println(i.get());*/
	  
	 /* IntSupplier i = ()-> Integer.MAX_VALUE;
	  System.out.println(i.getAsInt());*/
		
	/*DoubleSupplier pi = () -> {return 3.14d;};
    System.out.println(pi.getAsDouble());*/
		
	/* LongSupplier i = () -> Long.MAX_VALUE;
	 System.out.println(i.getAsLong());	*/
		
		BooleanSupplier bs = () -> true;
	    System.out.println(bs.getAsBoolean());

	    int x = 0, y= 1;
	    bs = () -> x > y;
	    System.out.println(bs.getAsBoolean());
	}

}
