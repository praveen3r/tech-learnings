package com.demo.observer;

public class TestObserverPattern {

	public static void main(String[] args) {
		Observer mobile = new Mobile();
		Observer website = new Website();

		WiproStock wiproStock = new WiproStock();
		InfyStock infyStock = new InfyStock();

		wiproStock.registerObservers(mobile);
		wiproStock.registerObservers(website);

		infyStock.registerObservers(mobile);
		infyStock.registerObservers(website);

		for (int i = 1; i < 5; i++) {
			wiproStock.setPrice(i);
			infyStock.setPrice( i + 25);
		}
	}

}
