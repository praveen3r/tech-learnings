package com.demo.collections;

import java.util.LinkedHashMap;

public class TestLinkedHashMap {

	public void add(){
		LinkedHashMap<Integer, String> map = new LinkedHashMap<Integer, String>(); 
		
		map.put(1,"one"); 
		map.put(3, "three");
        map.put(2, "two"); 
        
		System.out.println(map); 
		
	}
}
