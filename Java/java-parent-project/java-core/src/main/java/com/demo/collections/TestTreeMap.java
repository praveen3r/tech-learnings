package com.demo.collections;

import java.util.TreeMap;

public class TestTreeMap {

	public void add(){
		TreeMap<Integer, String> map = new TreeMap<Integer, String>(); 
		
		map.put(1,"one"); 
		map.put(3, "three");
        map.put(2, "two"); 
        
		System.out.println(map); 
		
	}
	
	public void otherMethods(){
		
		TreeMap<Integer, String> map = new TreeMap<Integer, String>(); 
		
		map.put(1,"one"); 
		map.put(3, "three");
        map.put(2, "two"); 
        map.put(4, "four");
        map.put(5, "five");
        
		System.out.println("map->"+map); 
		
		System.out.println("map.firstEntry()->"+map.firstEntry()); 
		
		System.out.println("map.firstKey()->"+map.firstKey()); 
		
		System.out.println("map.lastEntry()->"+map.lastEntry()); 
		
		System.out.println("map.lastKey()->"+map.lastKey());  
		
		//get all the pairs or portion of the map strictly less than the parameter key_value.
		System.out.println("map.headMap()->"+map.headMap(3));  
		
		System.out.println("map.subMap(1,3)->"+map.subMap(1,3));  
		
	}
}
