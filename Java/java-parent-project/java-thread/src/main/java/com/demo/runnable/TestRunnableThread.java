package com.demo.runnable;

public class TestRunnableThread {

	public static void main(String[] args) {
		RunnableTrain train = new RunnableTrain();
		
		Thread thoothukudi = new Thread(train, "Thoothukudi Express");
		Thread nagercoil = new Thread(train, "Nagercoil Express");
		
		thoothukudi.start();
		nagercoil.start();
	}
	
}
