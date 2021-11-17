package com.demo.common;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurances {
	
	public static void main(String[] args) {
		int data[] = { 1, 5, 7, 4, 6, 2, 0, 1, 3, 2, 2 };
		Map<Integer, Long> count = Arrays.stream(data)
		    .boxed()
		    .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		int max = count.entrySet().stream()
		    .max((first, second) -> {
		        return (int) (first.getValue() - second.getValue());
		    })
		    .get().getKey();

		System.out.println(max);
	}
}
