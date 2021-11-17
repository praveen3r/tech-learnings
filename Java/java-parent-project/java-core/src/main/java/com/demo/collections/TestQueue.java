package com.demo.collections;

import java.util.Deque;
import java.util.LinkedList;

public class TestQueue {
	
	public void accessList(){
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		// Retrieving element at the first position	
		System.out.println(list.getFirst()); 
		
		// Retrieving element at the last position	
		System.out.println(list.getLast());
	}
	
	public void modifyList(){
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
		
		// Adding element at the first position	
		list.addFirst(1123);
		System.out.println(list);
		
		// Adding element at the last position	
		list.addLast(1123);
		System.out.println(list);
	}
	
	public void listWithRemove(){
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
		
		// removing element at the first position	
		list.removeFirst();
		System.out.println(list);
		
		// removing element at the last position	
		list.removeLast();
		System.out.println(list);
	}
	
	//This method retrieves, but does not remove, the element of this list.
	public void peekExample(){
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list);
		
		System.out.println(list.peek()); 
		System.out.println(list);
		
		System.out.println(list.peekFirst());
		System.out.println(list);
		
		System.out.println(list.peekLast());
		System.out.println(list);
		
	}
	
	//This method retrieves and removes the element of this list.
	public void pollExample(){
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list);
		
		System.out.println(list.poll()); 
		System.out.println(list);
		
		System.out.println(list.pollFirst());
		System.out.println(list);
		
		System.out.println(list.pollLast());
		System.out.println(list);
		
	}
	
	public void listOtherMethods(){
		
		Deque<Integer> list = new LinkedList<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list);
		
		//Pops an element from the stack
		list.pop();
		System.out.println(list);
		
		//Push an element from the stack
		list.push(1234);
		System.out.println(list);
		
		
	}
}
