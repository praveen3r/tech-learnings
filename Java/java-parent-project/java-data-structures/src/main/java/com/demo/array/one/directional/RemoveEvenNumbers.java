package com.demo.array.one.directional;

import java.util.Arrays;

public class RemoveEvenNumbers {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,11,24,32,33};
		removeEvenNumbers1(input);
	}
	
	private static void removeEvenNumbers1(int[] input){
		int count = 0;
		int size = input.length;
		for(int i=0; i<size; i++) {
			if(input[i]%2 != 0) {
				count++;
			}
		}
		
		int[] result = new int[count];
		int index = 0;
		for(int i=0; i<size; i++) {
			if(input[i]%2 != 0) {
				result[index] = input[i];
				index ++;
			}
		}
		System.out.println(Arrays.toString(result));
	}
}
