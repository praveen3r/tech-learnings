package com.demo.array.one.directional;

import java.util.Arrays;

public class ResizeArray {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,11,24,32,33, 55};
		resize(input, 12);
	}
	
	private static void resize(int[] input, int capacity){
		int[] temp = new int[capacity];
		for(int i=0; i<input.length; i++) {
			temp[i] = input[i];
		}
		
		input = temp;
		
		System.out.println(Arrays.toString(input));
	}
	
	
}
