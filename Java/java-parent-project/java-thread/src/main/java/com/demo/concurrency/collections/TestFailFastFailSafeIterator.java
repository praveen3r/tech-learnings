package com.demo.concurrency.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class TestFailFastFailSafeIterator {

	public static void main(String[] args) {
		failSafeList();
	}
	
	public static void failFastMap() {
		HashMap<Integer, Integer> map = new HashMap();
		map.put(1, 1);
		map.put(2, 2);
		
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			map.put(3, 3);
		}
	}
	
	public static void failSafeMap() {
		ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap();
		map.put(1, 1);
		map.put(2, 2);
		
		Iterator<Integer> iterator = map.keySet().iterator();
		while(iterator.hasNext()) {
			System.out.println(iterator.next());
			map.put(3, 3);
		}
	}
	
	public static void failFastList() {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer value = iterator.next();
			System.out.println(value);
			if(value == 2)
				list.remove(1);
			System.out.println(list);
		}
	}
	
	public static void failSafeList() {
		List<Integer> list = new CopyOnWriteArrayList<>();
		list.add(1);
		list.add(2);
		
		Iterator<Integer> iterator = list.iterator();
		while(iterator.hasNext()) {
			Integer value = iterator.next();
			System.out.println(value);
			if(value == 2)
				list.remove(1);
			System.out.println(list);
		}
	}

}
