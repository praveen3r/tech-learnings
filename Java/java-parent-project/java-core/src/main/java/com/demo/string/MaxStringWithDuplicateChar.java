package com.demo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MaxStringWithDuplicateChar {

	public static void main(String[] args) {
		String str = "gebcexy";

		Map<Character, Integer> map = new HashMap<>();
		List<String> dupString = new ArrayList<>();
		int index = 0;
		String newStr = null;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			if (map.size() > 0 && Optional.ofNullable(map.get(ch)).isPresent()) {
				if (!dupString.isEmpty()) {

					newStr = str.substring(index, i);
					dupString.add(newStr);
				} else {
					newStr = str.substring(0, i);
					dupString.add(newStr);
					index = map.get(ch);
				}
			}
			map.put(ch, i);
		}
		System.out.println("dupString is " + dupString);

		// alternatively sort the string and get the last one
		if (!dupString.isEmpty()) {
			int prevLength = 0;

			int maxIndex = 0;
			int index1 = 0;
			for (String str1 : dupString) {
				index1++;
				int length = str1.length();
				if (length > prevLength) {
					maxIndex = index1;
				}

			}
			String outputValue = dupString.get(maxIndex - 1);
			System.out.println("Output is " + outputValue);

		}
	}

}
