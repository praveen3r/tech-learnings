package com.demo.bridge;

public class OldRemote implements Remote {

	@Override
	public void on() {
		System.out.println("on with old remote");
	}

	@Override
	public void off() {
		System.out.println("off with old remote");
	}

}
