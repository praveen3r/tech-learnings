package com.demo.array.one.directional;

import java.util.Arrays;

public class CopyArray {

	public static void main(String[] args) {
		int[] input = {1,2,4,5};
		copyArray(input, input.length);
	}
	
	public static void copyArray(int[] input, int capacity) {
		int result[] = new int[capacity];
		for(int i=0; i<capacity; i++) {
			result[i] = input[i];
		}
		
		System.out.println(Arrays.toString(result));
	}

}
