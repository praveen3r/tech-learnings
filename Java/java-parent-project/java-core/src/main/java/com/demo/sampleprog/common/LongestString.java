package com.demo.sampleprog.common;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class LongestString {

	public static void main(String[] args) {
		List<String> randomStrings = new ArrayList<>();
		 randomStrings.add("XVxOPHS");
		    randomStrings.add("ttnBGouocZ");
		    randomStrings.add("yHYQbXq");
		    randomStrings.add("fkanCo");
		    randomStrings.add("cxBuL");

		    findWithJava8(randomStrings);
	}
	
	private static void findWithNormalWay(List<String> randomStrings) {
		String longestString = randomStrings.get(0);
	    for (String element : randomStrings) {
	        if (element.length() > longestString.length()) {
	            longestString = element;
	        }
	    }
	    System.out.println(longestString);
	}
	
	private static void findWithJava8(List<String> randomStrings) {
	/*	Optional<String> longest = randomStrings.stream()
	            .sorted((e1, e2) -> e1.length() > e2.length() ? -1 : 1)
	            .findFirst();*/
		
		String max = randomStrings.stream().max(Comparator.comparing(String::length)).get();
		 System.out.println(max);
	}

}
