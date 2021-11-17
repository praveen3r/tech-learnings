package com.demo.generics;

public class Bar {

	public <J,W> void mix(J juice, W water) {
		
	}
	
	public <J extends ILiquid> String mixPropertly(J juice) {
		return juice.taste();
	}
}
