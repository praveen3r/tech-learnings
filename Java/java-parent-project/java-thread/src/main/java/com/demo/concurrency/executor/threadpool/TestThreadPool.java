package com.demo.concurrency.executor.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class TestThreadPool {

	private static int count = 0;
	
	public static void main(String[] args) {
		TestThreadPool testSingleThreadPool = new TestThreadPool();
		testSingleThreadPool.scheduledExecutorWithScheduleAtFixedRateShutdown();
		
	}
	
	public void fixedSingleThreadPool(){
		ExecutorService executor = Executors.newSingleThreadExecutor();
		
		for(int i =0; i<=5 ; i++) {
			executor.submit(new TrainPool("Express"+ i));
		}
		
		executor.shutdown();
		
		System.out.println("tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //timeout function so if executor doesn't finish in 1 day it terminates.
		
		System.out.println("tasks completed");
	}
	
	public void fixedThreadPool(){
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		for(int i =0; i<=5 ; i++) {
			executor.submit(new TrainPool("Express"+ i));
		}
		
		executor.shutdown();
		
		System.out.println("tasks submitted");
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //timeout function so if executor doesn't finish in 1 day it terminates.
		
		System.out.println("tasks completed");
	}
	
	/*The java.util.concurrent.ScheduledExecutorService is an ExecutorService which can schedule tasks to run after a delay, or to execute 
	repeatedly with a fixed interval of time in between each execution. 
	Tasks are executed asynchronously by a worker thread, and not by the thread handing the task to the ScheduledExecutorService.*/
	
	public void scheduledExecutorWithSchedule(){
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		
		Callable<String> callable = new Callable<String>(){
			public String call() throws Exception {
				System.out.println("Executed!");
				return "Called!";
			}
		};
		
		//schedule (Runnable task, long delay, TimeUnit timeunit)
		ScheduledFuture<String> scheduledFuture = scheduledExecutorService.schedule(callable, 5, TimeUnit.SECONDS);
		
		try {
			scheduledFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduledExecutorService.shutdown();
	}
	
	/*This method schedules a task to be executed periodically. The task is executed the first time after the initialDelay, 
	 * and then recurringly every time the period expires.If any execution of the given task throws an exception, the task is 
	 * no longer executed. If no exceptions are thrown, the task will continue to be executed until the ScheduledExecutorService
	 *  is shut down.If a task takes longer to execute than the period between its scheduled executions, 
	 *  the next execution will start after the current execution finishes. The scheduled task will not be executed by more than one thread at a time.
	 */
	public void scheduledExecutorWithScheduleAtFixedRate(){
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		
		Runnable runnable = new Runnable(){
			public void run() {
	          System.out.println("running");
	          try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
		
		// init Delay = 5, repeat the task every 1 second
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleAtFixedRate(runnable, 5, 5 , TimeUnit.SECONDS);
		
		try {
			scheduledFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduledExecutorService.shutdown();
	}
	
	public void scheduledExecutorWithScheduleAtFixedRateShutdown(){
		ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);

		
        Runnable task1 = () -> {
            count++;
            System.out.println("Running...task1 - count : " + count);
        };

        // init Delay = 5, repeat the task every 1 second
        ScheduledFuture<?> scheduledFuture = ses.scheduleAtFixedRate(task1, 5, 1, TimeUnit.SECONDS);

        while (true) {
            System.out.println("count :" + count);
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            if (count == 5) {
                System.out.println("Count is 5, cancel the scheduledFuture!");
                scheduledFuture.cancel(true);
                ses.shutdown();
                break;
            }
        }

	}
	
	/*This method works very much like scheduleAtFixedRate() except that the period is interpreted differently.

	In the scheduleAtFixedRate() method the period is interpreted as a delay between the start of the previous execution, 
	until the start of the next execution. In this method, however, the period is interpreted as the delay between the end of the previous execution, 
	until the start of the next. The delay is thus between finished executions, not between the beginning of executions.*/
	
	public void scheduledExecutorWithScheduleAtFixedDelay(){
		
		ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);

		
		Runnable runnable = new Runnable(){
			public void run() {
	            System.out.println("Running...task1 ");
			}
		};
		
		// init Delay = 5, repeat the task every 1 second
		ScheduledFuture<?> scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(runnable, 5, 1 , TimeUnit.SECONDS);
		
		try {
			scheduledFuture.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduledExecutorService.shutdown();
	}
	
	/*creates an expandable thread pool executor. New threads are created as needed, and previously constructed threads are reused when they are available. 
	 * Idle threads are kept in the pool for one minute. This executor is suitable for applications that launch many short-lived concurrent tasks.
	 * 
	 */
	public void scheduledExecutorWithCachedPool(){
		ExecutorService pool = Executors.newCachedThreadPool();
		 
		Runnable runnable = new Runnable(){
			public void run() {
				String threadName = Thread.currentThread().getName();
				for (int i = 5; i >= 0; i--) {
					 
		            System.out.printf("%s : %d\n", threadName, i);
		 
		            try {
		                Thread.sleep(1000);
		            } catch (InterruptedException ex) {
		                ex.printStackTrace();
		            }
		        }
			}
		};
		
		//you will see that there are 4 threads executing the 4 clocks at the same time
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
        pool.execute(runnable);
 
        pool.shutdown();
	}
	
}
