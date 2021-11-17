package com.demo.singleton;

public class Singleton {

	private static volatile Singleton singleton = null;

	private Singleton() {

	}

	public Singleton getInstance() {

		if (singleton == null) {
			synchronized (this) {
				if (singleton == null) {
					singleton = new Singleton();
				}
			}
		}
		return singleton;

	}

}
