package com.demo.synchronization;

public class TrainBooking implements Runnable {
	
	private int totalSeatsAvailable = 2;
	
	private Train train;

	public void run() {
		boolean isTicketBooked = bookticket();
		if(isTicketBooked)
			System.out.println("Ticket booked for "+ Thread.currentThread().getName());
		else
			System.out.println("Sorry ticket not available");
	}
	
	public synchronized Boolean bookticket() {
		Train train = getTrain();
		int seatsNeeded = train.getSeats();
		System.out.println("Seats available for " + Thread.currentThread().getName() + " in " + train.getName() + " is " + totalSeatsAvailable);
		if(totalSeatsAvailable < seatsNeeded)
			return false;
		else {
			totalSeatsAvailable = totalSeatsAvailable - seatsNeeded;
			return true;
		}
	}
	
	public Boolean cancelticket() {
		System.out.println(totalSeatsAvailable);
		return true;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}
	
	
}
