package com.demo.sort;

import java.util.Arrays;

public class SortMaxMin {

	public static void main(String[] args) {

		int[] input = {2, 3, 5, 6, 8, 9}; // sort so that max and min will be alternate to each other
		sort(input);
	}
	
	public static void sort(int[] input) {
		int maxIndex = input.length-1;
		int minIndex = 0;
		int size = input.length;
		int max = input[maxIndex] + 1;
		for(int i=0; i<size; i++) {
			if(i%2==0) {
				input[i] = input[i] + (input[maxIndex] % max) * max;
				maxIndex--;
			}else {
				input[i] = input[i] + (input[minIndex] % max) * max;
				minIndex++;
			}
		}
		
		for(int i=0; i<size; i++) {
			input[i] = input[i] / max;
		}
		System.out.println(Arrays.toString(input));
	}

}
