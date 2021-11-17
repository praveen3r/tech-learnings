package com.demo.collections;

import java.util.ArrayList;
import java.util.List;

public class TestArrayList {
	
	public static void main(String[] args) {
		TestArrayList testArrayList = new TestArrayList();
		testArrayList.listWithRemove();
	}

	public void listWithAdd(){
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
	}
	
	public void accessList(){
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list.get(2)); 
	}
	
	public void modifyList(){
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
		
		//replace the element
		list.set(2, 22);
		
		System.out.println(list);
		
		//add an element
		list.add(2, 245);
		
		System.out.println(list);
	}
	
	public void listWithRemove(){
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
		
		// Remove element at index 3 
		list.remove(3);
		
		System.out.println(list); 
		
		//Remove all
		
		list.clear();
		
		System.out.println(list); 
	}
	
	public void listOtherMethods(){
		
		List<Integer> list = new ArrayList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		//size
		System.out.println("Size->" + list.size()); 
		
		//isEmpty
		System.out.println("list.isEmpty()->" + list.isEmpty()); 
		
		// Creating an ArrayList from another collection
		List<Integer> list1 = new ArrayList<Integer>(list); 
		System.out.println("list1->" + list1); 
		
		// Creating an ArrayList from another collection
		ArrayList<Integer> list2 = new ArrayList<Integer>(list);
		ArrayList<Integer> list3 = (ArrayList<Integer>)list2.clone();
		System.out.println("list3->" + list3); 
		
		// Check if an ArrayList contains a given element
		System.out.println("list.contains(5)->" + list.contains(5)); 
		
		// Find the index of the first occurrence of an element in an ArrayList
		System.out.println("list.indexOf(5)->" + list.indexOf(5)); 
		
		// Find the index of the last occurrence of an element in an ArrayList
		System.out.println("list.lastIndexOf(5)->" + list.lastIndexOf(5)); 
		
		// Sublist
		List<Integer> list4 = list.subList(0, 2); 
		System.out.println("list4->" + list4); 
		
	}
}
