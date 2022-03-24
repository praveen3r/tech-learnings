package com.demo.observer;

public class Mobile implements Observer {

	@Override
	public void updatePrice(Stock stock) {
		System.out.println("In mobile, Stock " + stock.getName() + " price is " + stock.getPrice());
	}

}
