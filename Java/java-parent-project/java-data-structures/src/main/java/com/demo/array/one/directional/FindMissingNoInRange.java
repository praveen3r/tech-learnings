package com.demo.array.one.directional;

public class FindMissingNoInRange {

	public static void main(String[] args) {
		int[] input = {1,2,3,5};
		findMissingNo(input);
	}

	public static void findMissingNo(int[] input) {
		int n = input.length + 1;
		int sumOfAllNo = n * (n + 1)/2;
		int sumOfInput = 0;
		for(int i=0; i<input.length; i++) {
			sumOfInput = sumOfInput+ input[i];
		}
		int missingNo = sumOfAllNo -  sumOfInput;
		System.out.println(missingNo);
	}
}
