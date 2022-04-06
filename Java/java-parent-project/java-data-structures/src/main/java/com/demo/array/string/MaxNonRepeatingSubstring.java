package com.demo.array.string;

import java.util.HashMap;
import java.util.Map;

/*
 * Find out maximum length of non repeating substring i.e substring 
 * with non repeating characters
 */
public class MaxNonRepeatingSubstring {

	public static void main(String[] args) {
		maxLengthOfNonRepeatingSubstring("pwwkew");
	}

	private static int maxLengthOfNonRepeatingSubstring(String input) {
		int start = 0;
		int maxLength = 1;
		Map<Character, Integer> map = new HashMap<>();
		char[] charArr = input.toCharArray();
		for (int end = 0; end < charArr.length; end++) {
			char ch = input.charAt(end);
			if (map.containsKey(ch)) {
				start = Math.max(start, map.get(ch) + 1);
			}
			map.put(ch,  map.getOrDefault(ch,0) + 1);
			maxLength = Math.max(maxLength, end-start+1);
		}
		System.out.println(maxLength);
		return maxLength;
	}
}
