package com.demo.array.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MaxSumOfSubArray {

	public static void main(String[] args) {

		int[] input = {4, 3, -2, 6, -12, 7, -1, 6};
		calculateMaxWithList(input);
	}

	private static void  calculateMax(int[] input) {
		int max = input[0];
		int currentMax = input[0];
		for(int i=1; i< input.length; i++) {
			currentMax = currentMax + input[i];
			if(currentMax < input[i]) {
				currentMax = input[i];
			}
			if(max < currentMax) {
				max = currentMax;
			}
		}
		System.out.println("max is "+ max);
	}
	
	private static void  calculateMaxWithList(int[] input) {
		int max = input[0];
		int currentMax = input[0];
		List<Integer> maxArrElements = new ArrayList<>();
		for(int i=1; i< input.length; i++) {
			currentMax = currentMax + input[i];
			maxArrElements.add(input[i]);
			if(currentMax < input[i]) {
				currentMax = input[i];
				maxArrElements.clear();
				maxArrElements.add(input[i]);
			}
			if(max < currentMax) {
				max = currentMax;
			}
		}
		System.out.println("max is "+ max);
		System.out.println("max elements are "+ Arrays.toString(maxArrElements.toArray()));
	}
}
