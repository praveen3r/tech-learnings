package com.demo.stream;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class SortTreeMapByValue {

	public static void main(String[] args) {
		final Map<String, Integer> wordCounts = new HashMap<>();
		wordCounts.put("USA", 100);
		wordCounts.put("jobs", 200);
		wordCounts.put("software", 50);
		wordCounts.put("technology", 70);
		wordCounts.put("opportunity", 200);
		
		final Map<String, Integer> sortedByCount = wordCounts.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		
		System.out.println(sortedByCount);

	}

}
