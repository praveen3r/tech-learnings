package com.demo.sort;

import java.util.Arrays;

public class SelectionSort {

	public static void main(String[] args) {
		int[] input = {1, 5, 9, 2, 11};
		insertionSort(input);
	}
	
	private static void insertionSort(int[] input) {
		int size = input.length;
		for(int i=0; i<size;i++) {
			int min = i;
			for(int j=i+1; j<size;j++) {
				if(input[j] < input[min]) {
					min = j;
				}
			}
			swap(input, i, min);
		}
		
		System.out.println(Arrays.toString(input));
	}
	
	private static void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
	

}
