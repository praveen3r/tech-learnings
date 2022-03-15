package com.demo.array.one.directional;

import java.util.Arrays;

public class AddElementsToArray {

		public static void main(String[] args) {
			int[] input = {1,2,4,5};
			addElement(input, 46);
		}
		
		public static void addElement(int[] input, int element) {
			int size = input.length;
			int[] temp = new int[size + 1];
			copyArray(input, temp, size);
			temp[size] = element;
			input = temp;
			System.out.println(Arrays.toString(input));
			
		}
		
		public static void copyArray(int[] input, int[] result, int capacity) {
			for(int i=0; i<capacity; i++) {
				result[i] = input[i];
			}
			
		}

	}


