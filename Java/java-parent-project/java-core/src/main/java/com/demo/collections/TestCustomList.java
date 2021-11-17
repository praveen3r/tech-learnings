package com.demo.collections;

public class TestCustomList {
	public static void main(String[] args) throws Exception{
		CustomList<Integer> customList = new CustomList<Integer>();
		customList.add(1);
		System.out.println(customList);
		customList.add(1);
		System.out.println(customList);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.add(1);
		customList.remove(2);
		System.out.println(customList);
	}
}
