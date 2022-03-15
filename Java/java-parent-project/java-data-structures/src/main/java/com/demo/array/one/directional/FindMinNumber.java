package com.demo.array.one.directional;

import java.util.Arrays;

public class FindMinNumber {

	public static void main(String[] args) {
		int[] input = {2,4,5,11,24,32,33, 55,1};
		findMinNumber(input);
	}
	
	private static void findMinNumber(int[] input){
		int min = input[0];
		for(int i=1; i<input.length; i++) {
			if(min > input[i]) {
				min = input[i];
			}
		}
		
		System.out.println(min);
	}
	
	
}
