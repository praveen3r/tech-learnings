package com.demo.array.one.directional;

import java.util.Arrays;

public class MergeTwoSortedArrays {

	public static void main(String[] args) {

		int[] arr1 = {2,3,5,10};
		int[] arr2 = {4,6,11,15};
		
		mergeTwoArrays(arr1, arr2);
	}
	
	private static void mergeTwoArrays(int[] input1,int[] input2) {
		int input1Size = input1.length;
		int input2Size = input2.length;
		int i=0, j=0, k=0;
		int[] result = new int[input1Size + input2Size];
		
		while(i < input1Size && j < input2Size) {
			if(input1[i] < input2[j]) {
				result[k] = input1[i];
				i++;
			}else {
				result[k] = input2[j];
				j++;
			}
			k++;
		}
		
		//copy the remaining values
		if(i == input1Size) {
			for(int l=j; l<input2Size; l++) {
				result[k] = input2[l];
				k++;
			}
		}else if(j == input2Size) {
			for(int l=i; l<input1Size; l++) {
				result[k] = input1[l];
				k++;
			}
		}
		System.out.println(Arrays.toString(result));
	}
	
	

}
