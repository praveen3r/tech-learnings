package com.demo.synchronization;

public class Train {

	private int seats;
	
	private String name;

	public Train(int seats, String name) {
		this.seats = seats;
		this.name = name;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
