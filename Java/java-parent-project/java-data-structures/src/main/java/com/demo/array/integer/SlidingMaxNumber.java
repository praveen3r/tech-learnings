package com.demo.array.integer;

import java.util.Arrays;

public class SlidingMaxNumber {

	public static void main(String[] args) {
		int[] input = {1, 3, 1, 3, 5, 3, 6, 7};
		maxSlidingArrayWithOneLoop(input, 3);
	}
	
	private static void maxSlidingArrayWithOneLoop(int[] input, int slider) {
		int max = 0;
		int start=0;
		int[] result = new int[input.length - slider+1];
		
		for(int end=0; end< input.length; end++) {
			if(end == slider-1) {
				result[start] = max;
			}
			else if(end > slider-1) {
				max = Math.max(max, input[end]);
				start++;
				result[start] = max;
			}else {
				if(max < input[end]) {
					max = input[end];
				}
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	private static void maxSlidingArray(int[] input, int slider) {
		int max = 0;
		int[] result = new int[input.length - slider+1];
		for(int i=0; i< slider; i++) {
			if(max < input[i]) {
				max = input[i];
			}
		}
		 
		int index = 0;
		result[index] = max;
		for(int i=slider; i< input.length; i++) {
			if(max < input[i]) {
				max = input[i];
			}
			index++;
			result[index] = max;
		}
		
		System.out.println(Arrays.toString(result));
	}

}
