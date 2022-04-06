package com.demo.array.integer;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

	public static void main(String[] args) {
		int[] input = {1, 2, 3, 4};
		prodOfArray(input);
	}
	
	private static void prodOfArray(int[] input) {
		int temp=1;
		int[] result = new int[input.length];
		for(int i=0; i< input.length; i++) {
			result[i] = temp;
			temp = temp * input[i];
		}
		temp=1;
		
		for(int i=input.length-1; i >= 0 ; i--) {
			result[i] = temp * result[i];
			temp = temp * input[i];
		}
		System.out.println(Arrays.toString(result));
	}

}
