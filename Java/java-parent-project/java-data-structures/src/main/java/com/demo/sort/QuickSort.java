package com.demo.sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		
		int[] input = {9, -3, 5, 2, 6, 8, -6, 1, 3};
		sort(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
	}
	
	private static void sort(int[] input, int low, int high){
		if(low < high) {
			int p = partition(input, low, high);
			sort(input, low, p-1);
			sort(input, p+1, high);
		}
		
	}
	
	
	
	private static int partition(int[] input, int low, int high) {
		int i=low;
		int j=low;
		int pivot = input[high];
		while(i<=high) {
			if(input[i]<=pivot) {
			  swap(input, i, j);
			  j++;
			}
			i++;
		}
		return j-1;
	}
	
	private static void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}

}
