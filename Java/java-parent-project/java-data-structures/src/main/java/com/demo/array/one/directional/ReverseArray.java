package com.demo.array.one.directional;

import java.util.Arrays;

public class ReverseArray {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,11,24,32,33, 55};
		reverseArrayWithoutTemp(input, 0, input.length-1);
	}
	
	private static void reverseArrayWithTemp(int[] input, int start, int end){
		while(start < end) {
			int temp = input[start];
			input[start] = input[end];
			input[end] = temp;
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(input));
	}
	
	private static void reverseArrayWithoutTemp(int[] input, int start, int end){
		while(start < end) {
			int sum = input[start] + input[end];
			input[start] = sum - input[start];
			input[end] = sum - input[end];
			start++;
			end--;
		}
		
		System.out.println(Arrays.toString(input));
	}
}
