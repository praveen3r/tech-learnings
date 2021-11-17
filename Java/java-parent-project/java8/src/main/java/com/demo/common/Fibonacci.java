package com.demo.common;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Fibonacci {

	public static void main(String[] args) {
		
		generate(5);
	}
	
	 public static void generate(int series) {
	        Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
	                .limit(series)
	                .map(i -> i[0]).forEach(System.out::println);
	    }
	 
	 public static void generateLegacy(int series){
		 int i = 1, t1 = 0, t2 = 1;
		 while (i <= series)
		    {
		        System.out.println(t1);

		        int sum = t1 + t2;
		        t1 = t2;
		        t2 = sum;

		        i++;
		    }
	 }
}
