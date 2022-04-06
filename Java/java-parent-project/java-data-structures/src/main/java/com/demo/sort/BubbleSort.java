package com.demo.sort;

import java.util.Arrays;

public class BubbleSort {

	public static void main(String[] args) {
		int[] input = {5, 2, 3, 9, 6};
		bubbleSort(input);
	}
	
	private static void bubbleSort(int[] input) {
		int size = input.length;
		for(int i=0; i<size-1; i++ ) {
			boolean isSorted = false;
			for(int j=0; j<size-1-i; j++) {
				System.out.println(j);
				if(input[j] > input[j+1]) {
					swap(input, j+1, j);
					isSorted = true;
				}
			}
			if(isSorted) break; //no swap means already sorted
		}
		
		System.out.println(Arrays.toString(input));
	}
	
	private static void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}

}
