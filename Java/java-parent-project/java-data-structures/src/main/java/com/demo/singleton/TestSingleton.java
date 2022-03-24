package com.demo.singleton;

public class TestSingleton {

	public static void main(String[] args) {
		SingletonEager singletonEager = SingletonEager.getInstance();
		
		System.out.println(singletonEager);
		
		SingletonEager singletonEager1 = SingletonEager.getInstance();
		
		System.out.println(singletonEager1);
	}

}
