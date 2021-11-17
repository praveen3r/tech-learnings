package com.demo.common;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntersectingList {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("red", "blue", "blue", "green", "red");
		List<String> otherList = Arrays.asList("red", "green", "green", "yellow");
		
		List<String> result = list.stream()
				  .distinct()
				  .filter(otherList::contains)
				  .collect(Collectors.toList());
		
		System.out.println(result);
	}
}
