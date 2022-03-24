package com.demo.observer;

public class Website implements Observer {

	@Override
	public void updatePrice(Stock stock) {
		System.out.println("In website, Stock " + stock.getName() + "price is " + stock.getPrice());
	}

}
