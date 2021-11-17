package com.demo.programs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountCharacterInString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		countAndPrintUsingMap("ragupathy");
		countAndPrintUsingJava8("ragupathy");
	}
	
	public static void countAndPrintUsingMap(String input) {
		
		HashMap<String, Integer> counter = new HashMap<>();
		Long start=System.currentTimeMillis();
		for(char c : input.toCharArray()){
			String str = c+"";
			if(!counter.containsKey(str)){
				counter.put(str, 1);
			}else{
				counter.put(str, counter.get(str)+1);
			}
		}
		System.out.println(counter+" Time: "+(System.currentTimeMillis()-start));
	}

	public static void countAndPrintUsingJava8(String input) {
		Long start=System.currentTimeMillis();
		Map<String, Long> countMap=Stream.of(input.toLowerCase().split("")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
		System.out.println(countMap+" Time: "+(System.currentTimeMillis()-start));
	}
}
