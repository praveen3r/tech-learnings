package com.demo.array.one.directional;

import java.util.Arrays;

public class RemoveElementFromArray {

		public static void main(String[] args) {
			int[] input = {1,2,4,5, 7, 14};
			removeElement(input, 4);
		}
		
		public static void removeElement(int[] input, int element) {
			int temp[] = new int[input.length - 1];
			int index = 0;
			for(int i=0; i< input.length; i++ ) {
				if(input[i] != element) {
					temp[index] = input[i];
					index++;
				}
					
				
			}
			
			input = temp;
			System.out.println(Arrays.toString(input));
			
		}
		
		

	}


