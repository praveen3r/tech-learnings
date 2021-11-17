package com.demo.sampleprog.common;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MaxOccurances {
	
	public static void main(String[] args) {
		List<String> list = Arrays.asList("1", "1","1","1","5","5","12","12","12","12","12","12","8");
	      int max = 0;
	      int curr = 0;
	      String currKey =  null;
	      Set<String> unique = new HashSet<String>(list);

	          for (String key : unique) {
	                curr = Collections.frequency(list, key);

	               if(max < curr){
	                 max = curr;
	                 currKey = key;
	                }
	            }

	          System.out.println("The number "  + currKey + " happens " + max + " times");
	}
}
