package com.demo.sort;

import java.util.Arrays;

public class InsertionSort {

	public static void main(String[] args) {
		int[] input = {1, 5, 9, 2, 11};
		insertionSort(input);
	}
	
	private static void insertionSort(int[] input) {
		int size = input.length;
		for(int i=1; i<size; i++) {
		  int temp = input[i];
		 int j = i-1;
		  while(j>=0 && input[j] > temp) {
			  input[j+1] = input[j];
			  j--;
		  }
		  input[j+1] = temp;
		}
		
		System.out.println(Arrays.toString(input));
	}
	

}
