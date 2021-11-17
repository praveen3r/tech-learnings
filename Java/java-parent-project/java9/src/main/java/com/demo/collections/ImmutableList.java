package com.demo.collections;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableList {

	public static void main(String[] args) {

		List<String> list = List.of("test","test1","test2");
		System.out.println(list);
		
		Map<String, String> map = Map.of("Key", "value1", "key2", "value2");
		System.out.println(map);
				
		Set<String> set = Set.of("test","test1","test2");
		System.out.println(set);
		
		

	}

}
