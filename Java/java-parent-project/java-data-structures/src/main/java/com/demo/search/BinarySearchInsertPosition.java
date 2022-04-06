package com.demo.search;

public class BinarySearchInsertPosition {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,7,9,11,15,16,17};
		int index = search(input, 12);
		System.out.println(index);
	}

	private static int search(int[] input, int value) {
		int low =0;
		int high = input.length-1;
		while(low<=high) {
			int mid = low+(high-low)/2;
			if(input[mid] == value) {
				return mid;
			}
			if(value < input[mid]) {
				high = mid -1;
			}else {
				low = mid +1;
			}
		}
		return low;
	}
}
