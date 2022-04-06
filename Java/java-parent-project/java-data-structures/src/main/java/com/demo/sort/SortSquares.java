package com.demo.sort;

import java.util.Arrays;

public class SortSquares {

	public static void main(String[] args) {
		int[] input = {-4, -1, 0, 3, 10};
		int[] result = sort(input);
		System.out.println(Arrays.toString(result));
	}
	
	public static int[] sort(int[] input) {
		int i=0;
		int size = input.length-1;
		int j=size;
		int[] result = new int[size+1];
		for(int k=size; k>=0; k--) {
			if(Math.abs(input[i])> Math.abs(input[j])) {
				result[k] = input[i] * input[i];
				i++;
			}else {
				result[k] = input[j] * input[j];
				j--;
			}
		}
		return result;
	}

}
