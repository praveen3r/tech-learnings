package com.demo.array;

import java.util.Arrays;

public class RemoveDuplicate {

	public static void main(String[] args) {
		int[] arr = {1,3,4,1,5,3,6,8,3,9};
		removeDuplicates(arr);

	}
	
	public static int[] removeDuplicates(int[] arr){
	    int size = arr.length;
	    int[] temp = new int[size];
	    
	    temp[0] = arr[0];
	    
	    int count = 0;
	    
	    for(int i=1; i < size; i ++) {
	    	boolean isValid = true;
	    	for(int j=0; j<= count; j++) {
	    		if(arr[i] == arr[j]) {
	    			isValid = false;
	    			break;
	    		}
	    	}
	    	if(isValid) {
	    		count++;
	    		temp[count] = arr[i];
	    	}
	    }
	    
	    int[] result = new int[count];
	    
	    for(int i=0; i < count; i++) {
	    	result[i] = temp[i] ;
	    }
	    
	    System.out.println(Arrays.toString(result));
	    
		return result;
	}
	
	public static int[] copyArray(int[] origArr, int size) {
		int[] newArray = new int[origArr.length];
		for(int i = 0; i < size; i++) {
			newArray[i] = origArr[i];
		}
		return newArray;
	}

}
