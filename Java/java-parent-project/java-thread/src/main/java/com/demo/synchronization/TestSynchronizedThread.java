package com.demo.synchronization;

public class TestSynchronizedThread {

	public static void main(String[] args) {
		Train train = new Train(2, "Thoothukudi express");
		
		TrainBooking ticketBooking = new TrainBooking();
		ticketBooking.setTrain(train);
		
		Thread thoothukudi = new Thread(ticketBooking, "Trisha");
		Thread nagercoil = new Thread(ticketBooking, "Tapasee");
		
		thoothukudi.start();
		nagercoil.start();
	}
	
}
