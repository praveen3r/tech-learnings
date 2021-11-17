package com.demo.bridge;

public class Samsung implements TV {

	private Remote remote;
	
	
	public Samsung(Remote remote) {
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
