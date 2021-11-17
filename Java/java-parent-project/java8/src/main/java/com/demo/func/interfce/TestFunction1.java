package com.demo.func.interfce;

import java.util.function.BiFunction;

public class TestFunction1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiFunction<String, String,String> bi = (x, y) -> {      
		      return x + y;
		    };

		    System.out.println(bi.apply("java", " tutorial"));
		    
		    String result = calc((a, b) -> ": " + (a * b),3,  5);
		    System.out.println(result);
		    
		  /*  IntFunction<String> i = (x)->Integer.toString(x);
		    System.out.println(i.apply(3).length());
		    
		     IntToDoubleFunction i = (x) -> Math.sin(x);
		    System.out.println(i.applyAsDouble(2));
		    
		    IntToLongFunction i = (x) -> Long.MAX_VALUE-x;
		    System.out.println(i.applyAsLong(2));
		    
		    ToIntFunction<String> i  = (x)-> Integer.parseInt(x);
    		System.out.println(i.applyAsInt("2"));
    		
    		ToIntBiFunction<String,String> i  = (x,y)-> Integer.parseInt(x) +Integer.parseInt(x);
    		System.out.println(i.applyAsInt("2","3"));*/
		    
		    /*LongFunction<String> i = (l) -> Long.toString(l);
		    System.out.println(i.apply(Long.MAX_VALUE));
		    
		    LongToDoubleFunction i = (l) -> Math.sin(l);
    		System.out.println(i.applyAsDouble(Long.MAX_VALUE)); 
    		
    		LongToIntFunction i = (l) -> (int)l;
    		System.out.println(i.applyAsInt(Long.MAX_VALUE));
    		
    		ToLongFunction<String> i  = (x)-> Long.parseLong(x);
    		System.out.println(i.applyAsLong("2"));
    		
    		ToLongBiFunction<String,String> i  = (x,y)-> Long.parseLong(x)+Long.parseLong(y);
    		System.out.println(i.applyAsLong("2","2"));*/
		    
		    /*DoubleFunction<String> df = (d) -> d +" is now a string";
		    System.out.println(df.apply(0.5));
		    
		     DoubleToIntFunction df = (x) -> {return (int)x+2;};
    		 System.out.println(df.applyAsInt(3.14));
    		 
    		DoubleToLongFunction dl = (x) -> {return Long.MAX_VALUE - (long)x;};
    		System.out.println(dl.applyAsLong(3.14));
    		
    		 ToDoubleFunction<Integer> i  = (x)-> Math.sin(x);
    		System.out.println(i.applyAsDouble(Integer.MAX_VALUE));
    		
    		 ToDoubleBiFunction<Integer,Long> i  = (x,y)-> Math.sin(x)+Math.sin(y);
    		System.out.println(i.applyAsDouble(Integer.MAX_VALUE, Long.MAX_VALUE));*/
		    
		   
		   

	}
	
	public static String calc(BiFunction<Integer, Integer, String> bi, Integer i1, Integer i2) {
	      return bi.apply(i1, i2);
	  }

}
