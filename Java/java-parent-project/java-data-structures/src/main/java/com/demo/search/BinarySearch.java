package com.demo.search;

public class BinarySearch {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,7,9,11,15,16,17};
		search(input, 11);
	}

	private static void search(int[] input, int value) {
		int low =0;
		int high = input.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(input[mid] == value) {
				System.out.println("value found");
			}
			if(value < input[mid]) {
				high = mid -1;
			}else {
				low = mid +1;
			}
		}
	}
}
