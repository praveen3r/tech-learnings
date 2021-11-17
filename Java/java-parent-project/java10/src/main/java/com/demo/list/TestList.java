package com.demo.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestList {

	public static void main(String[] args) {
		ofNullableMethod();
	}
	
	private static void testUnmodifiableList() {
		var vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
		var unmodifiable = Collections.unmodifiableList(vegetables);
		vegetables.set(0, "Radish");
		//unmodifiable.set(0, "Radish123");
		var v = unmodifiable.get(0);
		System.out.println(v);
	}
	
	private static void testUnmodifiableList1() {
		var vegetables = new ArrayList<>(List.of("Brocolli", "Celery", "Carrot"));
		List<String> collect = vegetables.stream().collect(Collectors.toUnmodifiableList());
		// collect.add("lady's finger"); // 
	}
	
	private static void testCopyOf() {
		var vegetables = List.of("Brocolli", "Celery", "Carrot");
		var unmodifiable = List.copyOf(vegetables);
		vegetables.set(0, "Radish");
		//unmodifiable.set(0, "Radish123");
		var v = unmodifiable.get(0);
		System.out.println(v);
	}
	
	public static void ofNullableMethod() {
		var vegetables = List.of("Brocolli", "Celery", "Carrot");
		Stream.ofNullable(vegetables).flatMap(s -> s.stream()).forEach(System.out::println);
		
	}
	
	
	
	

}
