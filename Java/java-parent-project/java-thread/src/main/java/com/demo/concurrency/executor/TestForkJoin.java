package com.demo.concurrency.executor;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class TestForkJoin {

	public static void main(String[] args) {

		int times = 10;
		
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Integer> task = new Fibonacci(10);
		long start = System.nanoTime();
		System.out.println(String.format("fib(%d) = %d", times, pool.invoke(task)));
		System.out.println(String.format("%f [msec]", (System.nanoTime() - start) / 1000000.0));
		
	}

	public static class Fibonacci extends RecursiveTask<Integer> {

		private final int n;

		public Fibonacci(int n) { 
			this.n = n;
		}

		public Integer compute() {
			if (n <= 1)
				return n;
			Fibonacci f1 = new Fibonacci(n - 1);
			f1.fork();
			Fibonacci f2 = new Fibonacci(n - 2);
			f2.fork();
			/*
			 * Integer result1 = f2.join(); Integer result2 = f1.join();
			 * System.out.println(result1); System.out.println(result2);
			 */
			return  f2.join() + f1.join();
		}

	}
}
