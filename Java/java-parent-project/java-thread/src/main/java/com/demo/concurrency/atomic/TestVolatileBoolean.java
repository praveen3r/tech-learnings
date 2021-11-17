package com.demo.concurrency.atomic;

public class TestVolatileBoolean implements Runnable{

	volatile boolean flag = true;
	
	public TestVolatileBoolean(boolean flag) {
		this.flag = flag;
	}

	public void run() {
		System.out.println(" running " + Thread.currentThread().getName() + " with flag value "+ flag);
		if(Thread.currentThread().getName().equals("Volatile thread 2"))
			flag = false;
		while(flag) {
			System.out.println(Thread.currentThread().getName() + " flag is set to true");
		}
	}
}
