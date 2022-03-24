package com.demo.singleton;

public class SingletonEager {
	
	private static SingletonEager instance = new SingletonEager();
	
	private SingletonEager() {
		
	}

	public static synchronized SingletonEager getInstance() {
		return instance;
	}
}
