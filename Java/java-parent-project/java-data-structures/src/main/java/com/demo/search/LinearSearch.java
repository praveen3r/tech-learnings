package com.demo.search;

public class LinearSearch {

	public static void main(String[] args) {
		int[] input = {1,2,4,5,7,9,11,15,16,17};
		search(input, 15);
	}

	private static void search(int[] input, int value) {
		for(int i=0; i<input.length; i++) {
			if(input[i] == value) {
				System.out.println("value found");
				break;
			}
		}
	}
}
