package com.demo.observer;

import java.util.ArrayList;
import java.util.List;

public class Stock implements Observable {

	List<Observer> observerList = new ArrayList<>();
	
	int price;
	
	String name;
	
	public Stock() {
	}

	@Override
	public void registerObservers(Observer observer) {
		observerList.add(observer);

	}

	@Override
	public void deregisterObservers(Observer observer) {
		observerList.remove(observer);

	}

	@Override
	public void notifyObservers() {
		System.out.println("Notifying observer");
		observerList.forEach(observer -> {
			observer.updatePrice(this);
		});

	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("stock " + this.getName() + " is updated with price " + this.getPrice());
		notifyObservers();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	

}
