package com.demo.common;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharCount {

	public static void main(String[] args) {
		String str = "This is my country";
		
		Map<String, Long> frequentChars = Arrays.stream(
				str.toLowerCase().split("")).collect(
	            Collectors.groupingBy(Function.identity(), Collectors.counting()));

	    frequentChars.forEach((k, v) -> System.out.println(k + ":" + v));
	}
}
