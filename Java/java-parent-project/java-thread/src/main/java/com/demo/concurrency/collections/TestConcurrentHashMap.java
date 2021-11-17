package com.demo.concurrency.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TestConcurrentHashMap {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * Map<String, Integer> hashMap = new HashMap<>(); Map<String, Integer> map =
		 * Collections.synchronizedMap(hashMap);
		 */
		Map<String, Integer> map = new ConcurrentHashMap<>(); 
		WriterThreadOne WriterThreadOne = new WriterThreadOne(map);
		WriterThreadTwo WriterThreadTwo = new WriterThreadTwo(map);
		WriterThreadThree WriterThreadThree = new WriterThreadThree(map);
		WriterThreadFour WriterThreadFour = new WriterThreadFour(map);
		
		for (Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.println(e.getKey() + "=" + e.getValue());
		}
	}
}

	class WriterThreadOne implements Runnable {
		
		Map<String, Integer> map;
		
		WriterThreadOne(Map<String, Integer> map){
			this.map = map;
			new Thread(this, "WriterThreadOne").start();
		}
		
		@Override
		public void run() {
			
			map.put("One", 1);
			try {
				System.out.println("WriterThreadOne sleeping");
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}

		}
	  }
	
	  class WriterThreadTwo implements Runnable {
		  
	  Map<String, Integer> map;
		
	  WriterThreadTwo(Map<String, Integer> map){
			this.map = map;
			new Thread(this, "WriterThreadTwo").start();
		}
		
		@Override
		public void run() {
			
			map.put("Two", 2);
			try {
				System.out.println("WriterThreadTwo sleeping");
				Thread.sleep(100);
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	  }  
	  
	  class WriterThreadThree implements Runnable {
		  
		  Map<String, Integer> map;
			
		  WriterThreadThree(Map<String, Integer> map){
				this.map = map;
				new Thread(this, "WriterThreadThree").start();
			}
			
			@Override
			public void run() {
				
				map.put("Three", 3);
				try {
					System.out.println("WriterThreadThree sleeping");
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		  }  
	  
	  class WriterThreadFour implements Runnable {
		  
		  Map<String, Integer> map;
			
		  WriterThreadFour(Map<String, Integer> map){
				this.map = map;
				new Thread(this, "WriterThreadFour").start();
			}
			
			@Override
			public void run() {
				
				map.put("Four", 4);
				try {
					System.out.println("WriterThreadFour sleeping");
					Thread.sleep(100);
				} catch (Exception e) {
					System.out.println(e);
				}
			}
		  }  
	  
	  class ReadThread implements Runnable {
		  
		  Map<Integer, String> map;
			
		  ReadThread(Map<Integer, String> map){
				this.map = map;
			}
		  
		@Override
		public void run() {
		   Iterator<Integer> ite = map.keySet().iterator();
	  	   while(ite.hasNext()){
	  		   Integer key = ite.next();
	  		 System.out.println("Thread " + Thread.currentThread().getName() + " is reading " + key);
	  		   System.out.println(key+" : " + map.get(key));
		  }
		}
	  }	  

