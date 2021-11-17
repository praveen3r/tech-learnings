package com.demo.concurrency.collections;

import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMapMethods {

	public static void main(String[] args) {
		putIfPresent();
	}

	public static void search() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		System.out.println(map);

		Integer keyVal = 2;
		String result = map.search(3, (key, value) -> {
			System.out.println("key is " + key);
			if (key.equals(keyVal)) {
				return new String("Key found");
			} else {
				return null;
			}
		});

		System.out.println(result);
	}

	public static void searchKeys() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		Integer keyVal = 2;
		Integer result1 = map.searchKeys(1, key -> key.equals(keyVal) ? key : null);

		System.out.println(result1);
	}

	public static void searchValues() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		Integer keyVal = 2;
		Integer result1 = map.searchValues(1, Value -> Value.equals(keyVal) ? Value : null);

		System.out.println(result1);
	}

	public static void searchEntries() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		Integer keyVal = 2;
		Integer result1 = map.searchEntries(1, entry -> entry.getKey().equals(keyVal) ? entry.getKey() : null);

		System.out.println(result1);
	}

	public static void compute() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		map.compute(10, (key, val) -> val + 100);
		System.out.println(map.get(10));
		
		map.compute(1010, (key, val) -> val + 100);
		System.out.println(map.get(1010));
	}
	
	public static void computeIfAbsent() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		map.computeIfAbsent(10, k -> 100);
		System.out.println(map.get(10));
		
		map.computeIfAbsent(1010, k -> 100);
		System.out.println(map.get(1010));
	}
	
	public static void computeIfPresent() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		map.computeIfPresent(10, (key, val) -> val + 100);
		System.out.println(map.get(10));
		
		map.computeIfPresent(1010, (key, val) -> val + 100);
		System.out.println(map.get(1010));
	}
	
	public static void putIfPresent() {

		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
		for (int i = 0; i < 100; i++) {
			map.put(i, i);
		}

		map.putIfAbsent(10, 1030);
		System.out.println(map.get(10));
		
		map.putIfAbsent(1010, 1030);
		System.out.println(map.get(1010));
	}

}
