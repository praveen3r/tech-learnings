package com.demo.array.one.directional;

import java.util.Arrays;

public class RemoveElementAtSpecificIndex {

		public static void main(String[] args) {
			int[] input = {1,2,4,5, 7, 14};
			removeElement(input, 4);
		}
		
		public static void removeElement(int[] input, int index) {
			int temp[] = new int[input.length - 1];
			int arrIndex = 0;
			for(int i=0; i< input.length; i++ ) {
				if(i != index-1) {
					temp[arrIndex] = input[i];
					arrIndex++;
				}
			}
			
			input = temp;
			System.out.println(Arrays.toString(input));
			
		}
		
		

	}


