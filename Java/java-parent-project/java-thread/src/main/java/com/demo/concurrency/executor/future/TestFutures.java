package com.demo.concurrency.executor.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class TestFutures {
	
	public static void main(String[] args) throws Exception {
		TestFutures testFutures = new TestFutures();
		testFutures.futuresCancel2();
	}
	
	public void futuresGet(){
		ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        String result = null;
		try {
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(result);

        executorService.shutdown();
	}
	
	public void futuresIsDone() throws InterruptedException{
		ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
        }

        System.out.println("Task completed! Retrieving the result");
        
        String result = null;
		try {
			result = future.get();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(result);

        executorService.shutdown();
	}
	
	/* The cancel() method accepts a boolean argument - mayInterruptIfRunning. 
	If you pass the value true for this argument, then the thread that is currently executing the task will be interrupted, 
	otherwise in-progress tasks will be allowed to complete. You can use isCancelled() method to check if a task is cancelled or not. 
	Also, after the cancellation of the task, isDone() will always true.*/
	
	public void futuresCancel1() throws Exception{
		ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;

            if(elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }

        System.out.println("Task completed! Retrieving the result");
        
        // it will throw an exception, because future.get() method throws CancellationException if the task is cancelled
        String result = future.get();
        System.out.println(result);

        executorService.shutdown();
	}
	
	public void futuresCancel2() throws Exception{
		ExecutorService executorService = Executors.newSingleThreadExecutor();

        long startTime = System.nanoTime();
        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        while(!future.isDone()) {
            System.out.println("Task is still not done...");
            Thread.sleep(200);
            double elapsedTimeInSec = (System.nanoTime() - startTime)/1000000000.0;

            if(elapsedTimeInSec > 1) {
                future.cancel(true);
            }
        }

        if(!future.isCancelled()) {
            System.out.println("Task completed! Retrieving the result");
            String result = future.get();
            System.out.println(result);
        } else {
            System.out.println("Task was cancelled");
        }

        executorService.shutdown();
	}
	
	public void futuresGetWithTimeOut() throws Exception{
		ExecutorService executorService = Executors.newSingleThreadExecutor();

        Future<String> future = executorService.submit(() -> {
            Thread.sleep(2000);
            return "Hello from Callable";
        });

        String result = null;
		try {
			result = future.get(1, TimeUnit.SECONDS);;
		} catch (InterruptedException | ExecutionException e) {
			System.out.println();
			e.printStackTrace();
		}catch (TimeoutException e) {
			System.out.println("timeout");
		}
        System.out.println(result);

        executorService.shutdown();
	}
}
