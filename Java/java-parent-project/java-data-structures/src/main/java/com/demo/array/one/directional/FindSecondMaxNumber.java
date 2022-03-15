package com.demo.array.one.directional;

import java.util.Arrays;

public class FindSecondMaxNumber {

	public static void main(String[] args) {
		int[] input = {13, 45, 14, 45, 16};
		findMinNumber(input);
	}
	
	private static void findMinNumber(int[] input){
		int max = -1;
		int secondMax = -1;
		for(int i=0; i<input.length; i++) {
			if(input[i] >  max) {
				secondMax = max;
				max = input[i];
			}else if(input[i] > secondMax && input[i] != max) {
				secondMax = input[i];
			}
		}
		
		System.out.println(secondMax);
	}
	
	
}
