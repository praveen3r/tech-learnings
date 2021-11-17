package com.demo.common;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MinLengthWithRepeating {
	public static void main(String[] args) {
		// Creating a list of String
		List<String> list = Arrays.asList("Mam", "Madam", "world", "Computer", "hello", "sam");

		try{
		Map<Integer, List<String>> result = list.stream().collect(
				Collectors.groupingBy(String::length, HashMap::new, Collectors.toList()));
		
		//System.out.println(result);
		System.out.println("coming here0");	
		//List<String> strList = result.entrySet().stream().max((entry1, entry2) -> entry1.getKey() < entry2.getKey() ? 1 : -1).get().getValue();
		
		List<String> strList = result.entrySet().stream().sorted(Comparator.comparing(entry -> entry.getKey())).skip(1).max((entry1, entry2) -> entry1.getKey() < entry2.getKey() ? 1 : -1).get().getValue();
		
		
		System.out.println("coming here");		
				
		System.out.println(strList);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
