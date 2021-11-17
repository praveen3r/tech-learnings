package com.demo.concurrency.executor;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class TestExecutor {
	
	public static void main(String[] args) {
		
		TestExecutor testExecutor = new TestExecutor();
		testExecutor.executorWithInvokeAny();
		
	}
	
	public void executorWithExecuteMethod() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		//execute method takes a runnable command
				
		executor.execute(new Runnable() {
			public void run() {
				for (int i = 0; i <= 10; i++) {
					System.out.println("task running " + i);
				}
			}
		});
				 
	}
	
	public void executorWithSubmitRunnableMethod() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		/* submit method has two parameters, one with runnable and other with callable. Both returns a future object
		 * 
		 * Below is runnable
		 * 
		 */
				
		Future future = executor.submit(new Runnable() {
			public void run() {
				for(int i =0 ; i<10;  i++) { 
					/*
					 * try { Thread.sleep(1000); } catch (InterruptedException e) {
					 * e.printStackTrace(); }
					 */
					System.out.println("task running "+i); 
				} 
			}
		});
		
		Future future1 = executor.submit(new Runnable() {
			public void run() {
				for(int i =10 ; i<20;  i++) { 
					System.out.println("task running "+i); 
				} 
			}
		});
		
		
		executor.shutdown();
		
		try {
			if(future.isDone())
				future.get();
			if(future1.isDone())
				future1.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
				 
	}
	
	public void executorWithSubmitCallableMethod() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		/* submit method has two parameters, one with runnable and other with callable. Both returns a future object
		 * 
		 * Below is callable
		 * 
		 */
				
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			public Integer call() {
				int sum = 0;
				for(int i =1 ; i<10;  i++) { 
					System.out.println("task running "+i); 
					sum = sum + i;
				} 
				return sum;
			}
		});
		
		
		executor.shutdown();
		
		Integer returnVal = 0;
		try {
				returnVal = future.get();
				System.out.println("returnVal->"+returnVal);
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
				 
	}
	
	public void executorWithSubmitCallableMethodAndException() {
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		/* submit method has two parameters, one with runnable and other with callable. Both returns a future object
		 * 
		 * Below is callable
		 * 
		 */
				
		Future<Integer> future = executor.submit(new Callable<Integer>() {
			public Integer call() throws Exception{
				int sum = 0;
				for(int i =1 ; i<10;  i++) { 
					System.out.println("task running "+i); 
					if(i==5)
						throw new Exception("Exception thrown");
					sum = sum + i;
				} 
				return sum;
			}
		});
		
		
		executor.shutdown();
		
		Integer returnVal = 0;
		try {
				returnVal = future.get();
				System.out.println("returnVal->"+returnVal);
			
		} catch (InterruptedException e) {
			System.out.println("InterruptedException->"+e.getMessage());
		} catch (ExecutionException e) {
			System.out.println("ExecutionException->"+e.getMessage());
		}
				 
	}
	
	public void executorWithInvokeAny() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		String result=null;
		try {
			result = executorService.invokeAny(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("result = " + result);

		executorService.shutdown();
	}
	
	public void executorWithInvokeAll() {
		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Set<Callable<String>> callables = new HashSet<Callable<String>>();

		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 1";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 2";
		    }
		});
		callables.add(new Callable<String>() {
		    public String call() throws Exception {
		        return "Task 3";
		    }
		});

		List<Future<String>> futures = null;
		try {
			futures = executorService.invokeAll(callables);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		for(Future<String> future : futures){
		    try {
				System.out.println("future.get = " + future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		executorService.shutdown();
	}
}
