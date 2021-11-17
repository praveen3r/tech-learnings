package com.demo.collections;

import java.util.LinkedHashSet;

public class TestLinkedHashSet {
	
	public void add(){
		LinkedHashSet<Integer> list = new LinkedHashSet<Integer>(); 
		for (int i=1; i<=5; i++) 
			list.add(i); 
		
		System.out.println(list); 
		
	}
	
	
}
