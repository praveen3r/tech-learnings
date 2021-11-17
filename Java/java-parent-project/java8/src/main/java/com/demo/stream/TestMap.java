package com.demo.stream;

import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		
		Map<String, String> jbtObj = new HashMap<String, String>();
		 jbtObj.put("Website Name","Java Beginners Tutorial");
		 jbtObj.put("Language", "Java");
		 jbtObj.put("Topic", "Collection");
		 
		 jbtObj.forEach((key,value) -> System.out.println(key+" :"+value));
	}
}
