package com.demo.others;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class PrimeNumber {

	public static void main(String[] args) {

		int input = 50;
		List<Integer> result = getPrimeNumbersUsingJava8(input);
		System.out.println(result);
	}

	private static List<Integer> getPrimeNumbers(int input) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		if (input > 2) {
			list.add(2);
			for (int i = 3; i < input; i++) {
				boolean isPrime = true;
				for(int j=2; j<i/2; j++) {
					if(i%j==0 ) {
						isPrime = false;
						break;
					}
				}
				if(isPrime) {
					list.add(i);
				}
			}
			
		}
		

		return list;
	}
	
	private static List<Integer> getPrimeNumbersUsingJava8(int input) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		if (input > 2) {
			
				Predicate<Integer> isPrime = number -> IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
				list = IntStream.range(3, input).filter(num -> isPrime.test(num)).boxed().collect(Collectors.toList());
				list.add(0, 2);
			
		}
		list.add(0, 1);
		

		return list;
	}

}
