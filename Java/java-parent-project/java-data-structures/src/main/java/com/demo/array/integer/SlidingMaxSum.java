package com.demo.array.integer;

public class SlidingMaxSum {

	public static void main(String[] args) {
		int[] input = {2, 7, 3, 5, 8, 1};
		maxSlidingArray(input, 3);
	}
	
	private static void maxSlidingArray(int[] input, int slider) {
		int start = 0;
		int windowSum = 0;
		int maxSum = 0;
		
		for(int end=0; end< input.length; end++) {
			windowSum = windowSum + input[end];
			if(end >= slider-1) {
				maxSum = Math.max(maxSum, windowSum);
				windowSum = windowSum - input[start];
				start++;
			}
		}
		System.out.println(maxSum);
	}

}
