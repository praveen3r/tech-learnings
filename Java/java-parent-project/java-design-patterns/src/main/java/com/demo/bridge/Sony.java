package com.demo.bridge;

public class Sony implements TV {

	private Remote remote;
	
	
	public Sony(Remote remote) {
		this.remote = remote;
	}

	@Override
	public void on() {
		System.out.println("switching on sony tv");
		this.remote.on();

	}

	@Override
	public void off() {
		System.out.println("switching off sony tv");
		this.remote.off();

	}

}
