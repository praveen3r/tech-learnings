package com.demo.bridge;

public class TestBridge {

	public static void main(String[] args) {
		TV sonyTV = new Sony(new OldRemote());
		sonyTV.on();
		sonyTV.off();
		
		TV samsungTV = new Sony(new NewRemote());
		samsungTV.on();
		samsungTV.off();
		
	}

}
