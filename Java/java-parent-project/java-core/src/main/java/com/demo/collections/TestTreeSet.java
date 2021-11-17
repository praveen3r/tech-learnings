package com.demo.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class TestTreeSet {
	
	public void add(){
		SortedSet<Integer> set = new TreeSet<Integer>(); 
		set.add(1); 
		set.add(2); 
		set.add(1); 
		set.add(3); 
		set.add(23);
		set.add(11);
		
		System.out.println(set); 
	}
	
	public void otherMethods(){
		TreeSet<Integer> set = new TreeSet<Integer>(); 
		set.add(1); 
		set.add(2); 
		set.add(1); 
		set.add(3); 
		set.add(23);
		set.add(11);
		
		System.out.println("set->" +set); 
		
		System.out.println("set.first()->" +set.first()); 
		
		System.out.println("set.last()->" +set.last()); 
		
		// Retrieve and remove the first element
		System.out.println("set.first()->" +set.pollFirst()); 
		
		// Retrieve and remove the last element
		System.out.println("set.last()->" +set.pollLast());
		
		//will return elements ranging from fromElement to toElement
		System.out.println("set.subSet(2, 4)->" +set.subSet(2, 4));
		
		//will return elements of TreeSet which are less than the specified element
		System.out.println("set.subSet(2, 4)->" +set.headSet(6));
		
		//will return elements of TreeSet which are greater than or equal to the specified element
		System.out.println("set.subSet(2, 4)->" +set.tailSet(3));
		
		//returns the least element in this set greater than or equal to the given element, or null if there is no such element
		System.out.println("set.ceiling(3)->" +set.ceiling(3));
		
		//returns the greatest element in this set less than or equal to the given element, or null if there is no such element
		System.out.println("set.floor(3)->" +set.floor(3));
		
		//returns the least element in this set strictly greater than the given element, or null if there is no such element
		System.out.println("set.higher(3)->" +set.higher(3));
		
		//returns the greatest element in this set strictly less than the given element, or null if there is no such element
		System.out.println("set.lower(3)->" +set.lower(3));
		
		//returns a reverse order view of the elements contained in this set
		System.out.println("set.descendingSet->" +set.descendingSet());
		
	}
}
