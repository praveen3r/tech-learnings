package com.demo.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MinLength {
	public static void main(String[] args) {
		// Creating a list of String 
        List<String> list = Arrays.asList("Mam", "Madam", "world", "Computer", "hello", "sam"); 
  
        // Using stream.min() to get minimum 
        // element according to provided Integer Comparator 
       String text = list.stream().min(Comparator.comparing(str -> str.length())).get(); 
  
        System.out.print(text); 
	}
}
