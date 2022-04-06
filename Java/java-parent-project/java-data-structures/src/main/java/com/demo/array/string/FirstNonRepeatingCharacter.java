package com.demo.array.string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {

	public static void main(String[] args) {
		int index = firstNonRepeatingCharacter("aabbc");
		System.out.println(index);
	}

	private static int firstNonRepeatingCharacter(String input) {
		Map<Character, Integer> map = new HashMap<>();
		char[] charArr = input.toCharArray();
		for(char ch: charArr) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		for(int i=0; i< charArr.length; i++) {
			if(map.get(input.charAt(i)) == 1) {
				return i;
			}
		}
		return -1;
	}
}
