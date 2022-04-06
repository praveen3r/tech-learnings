package com.demo.sort;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int[] input = { 2, 10, 5, 3, 6, 4, 11 };
		mergeSort(input, input.length);
		System.out.println(Arrays.toString(input));
	}

	public static void mergeSort(int[] input, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = input[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = input[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(input, l, r, mid, n - mid);
		
	}

	public static void merge(int[] input, int[] l, int[] r, int left, int right) {

		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				input[k++] = l[i++];
			} else {
				input[k++] = r[j++];
			}
		}
		while (i < left) {
			input[k++] = l[i++];
		}
		while (j < right) {
			input[k++] = r[j++];
		}
	}

}
