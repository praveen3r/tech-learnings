package com.demo.hash;

public class TestHashTable {

	static CustomHashTable<Integer, String> ht = new CustomHashTable<Integer, String>();
	
	
	public static void main(String[] args) {
 
		insertData();
		getData();
		removeData();
		printData();
	}
	
	private static void insertData() {
		ht.put(1, "test1");
		ht.put(2, "test2");
		ht.put(22, "test22");
		ht.put(42, "test42");
	}

	private static void getData() {
		System.out.println(ht.get(2));
	}
	
	private static void removeData() {
		System.out.println(ht.remove(22));
		System.out.println(ht.remove(42));
		System.out.println(ht.remove(2));
	}
	
	private static void printData() {
		System.out.println(ht);
	}
}
