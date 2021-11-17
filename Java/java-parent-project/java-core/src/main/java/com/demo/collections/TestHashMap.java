package com.demo.collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestHashMap {

	public void add(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
		System.out.println(map); 
		
	}
	
	public void retrieve(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
		System.out.println(map.get("two")); 
	}
	
	public void remove(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
		System.out.println(map);
		
		map.remove("two");
		
		System.out.println(map);
	}
	
	public void displayAll(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
        for (String key : map.keySet()) {
		  System.out.println("key is " + key + " and value is "+ map.get(key));
		}
	}
	
	public void displayAllLatest(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
        for (Map.Entry<String, Integer> entry: map.entrySet()) {
		  System.out.println("key is " + entry.getKey() + " and value is "+ entry.getValue());
		}
	}
	
	public void otherMethods(){
		HashMap<String, Integer> map = new HashMap<String, Integer>(); 
		map.put("one", 1); 
        map.put("two", 2); 
        map.put("three", 3);
		
		System.out.println(map); 
		
		System.out.println("map.containsKey()->" + map.containsKey("one")); 
		
		System.out.println("map.containsKey()->" + map.containsValue(1)); 
		
		
		
	}
}
