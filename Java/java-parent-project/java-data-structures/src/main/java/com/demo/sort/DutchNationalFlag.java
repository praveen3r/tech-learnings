package com.demo.sort;

import java.util.Arrays;

public class DutchNationalFlag {

	public static void main(String[] args) {

		int[] input = { 2, 1, 0, 2, 1, 0, 1 };
		sort(input);
	}

	private static void sort(int[] input) {
		int i = 0;
		int j = 0;
		int k = input.length - 1;
		while (i < k) {
			if (input[i] == 0) {
				swap(input, i, j);
				i++;
				j++;
			} else if (input[i] == 1) {
				i++;
			} else if (input[i] == 2) {
				swap(input, i, k);
				k--;
			}
		}
		System.out.println(Arrays.toString(input));
	}

	private static void swap(int[] input, int a, int b) {
		int temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}
}
