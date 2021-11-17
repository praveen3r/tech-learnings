package com.demo.concurrency.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestCopyOnWriteArrayListMethods {

	public static void main(String[] args) {
		addAllAbsent();
	}

	/*
	 * The function accepts a single mandatory parameter element which specifies the
	 * element to be appended to the list if it is not present.
	 */

	public static void addIfAbsent() {

		// create object of CopyOnWriteArrayList
		CopyOnWriteArrayList<Integer> ArrLis = new CopyOnWriteArrayList<Integer>();

		// Add elements
		ArrLis.addIfAbsent(2);
		ArrLis.addIfAbsent(3);
		ArrLis.addIfAbsent(4);
		ArrLis.addIfAbsent(7);

		// print CopyOnWriteArrayList
		System.out.println("CopyOnWriteArrayList: " + ArrLis);

		System.out.println("On adding 4 it returns " + ArrLis.addIfAbsent(4) + " as it is present");
	}
	
	

	public static void addAllAbsent() {

		// create object of CopyOnWriteArrayList
		CopyOnWriteArrayList<Integer> ArrLis = new CopyOnWriteArrayList<Integer>();

		// Add elements
		ArrLis.addIfAbsent(2);
		ArrLis.addIfAbsent(3);
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(2);
		list.add(4);
		list.add(5);
		
		ArrLis.addAllAbsent(list);

		// print CopyOnWriteArrayList
		System.out.println("CopyOnWriteArrayList: " + ArrLis);

	}
}
