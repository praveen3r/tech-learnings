package com.demo.array.one.directional;

import java.util.Arrays;

public class MoveZeroesToEnd {

	public static void main(String[] args) {
		int[] input = {8, 2, 4, 0, 1, 5, 0};
		moveZeroesToEnd(input);
	}
	
	public static void moveZeroesToEnd(int[] input) {
		int j=0;
		for(int i=0; i<input.length; i++) {
			if(input[i] !=0 && input[j] == 0) {
				int temp = input[i];
				input[i] = input[j];
				input[j] = temp;
			}
			if(input[j] !=0) {
				j++;
			}
		}
		System.out.println(Arrays.toString(input));
	}
	
	

}
