package com.demo.observer;

public interface Observable {

	void registerObservers(Observer observer);
	void deregisterObservers(Observer observer);
	void notifyObservers();
}
