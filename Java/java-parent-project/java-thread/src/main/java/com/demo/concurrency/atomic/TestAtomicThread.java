package com.demo.concurrency.atomic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.demo.concurrency.executor.TestExecutor;
import com.demo.runnable.RunnableTrain;

public class TestAtomicThread {
	
	public static void main(String[] args) {

		//TestVolatileBoolean volatile1 = new TestVolatileBoolean(true);
		//TestVolatileCounter volatile1 = new TestVolatileCounter();
		TestAtomic volatile1 = new TestAtomic();
		
		Thread volatileThread1 = new Thread(volatile1, "Volatile thread 1");
		Thread volatileThread2 = new Thread(volatile1, "Volatile thread 2");

		volatileThread1.start();
		volatileThread2.start();
		
	}

	
}
