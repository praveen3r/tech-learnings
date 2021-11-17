package com.demo.sleep;

public class TestSleepThread {

	public static void main(String[] args) {
		SleepTrain train = new SleepTrain();
		
		Thread thoothukudi = new Thread(train, "Thoothukudi Express");
		Thread nagercoil = new Thread(train, "Nagercoil Express");
		
		thoothukudi.start();
		nagercoil.start();
	}
	
}
