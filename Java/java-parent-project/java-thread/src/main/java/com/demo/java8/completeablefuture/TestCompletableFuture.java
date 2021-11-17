package com.demo.java8.completeablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestCompletableFuture {

	public static void main(String[] args) {
		handleException2();
	}

	public static void simpleExample() {
		CompletableFuture<String> completableFuture = new CompletableFuture<String>();
		completableFuture.complete("Future's Result");
		try {
			String result = completableFuture.get();
			System.out.println(result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void runAsync() {
		// Using Lambda Expression
		CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
			// Simulate a long-running Job
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			System.out.println("I'll run in a separate thread than the main thread.");
		});
		// Block and wait for the future to complete
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void supplyAsync() {
		// Run a task specified by a Supplier object asynchronously
		CompletableFuture<String> future = CompletableFuture.supplyAsync(new Supplier<String>() {
			@Override
			public String get() {
				try {
					TimeUnit.SECONDS.sleep(1);
				} catch (InterruptedException e) {
					throw new IllegalStateException(e);
				}
				return "Result of the asynchronous computation";
			}
		});

		// Block and get the result of the Future
		String result;
		try {
			result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	public static void supplyAsyncWithThreadPool() {
		Executor executor = Executors.newFixedThreadPool(10);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Result of the asynchronous computation";
		}, executor);

		// Block and get the result of the Future
		String result;
		try {
			result = future.get();
			System.out.println(result);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/*
	 * You can use thenApply() method to process and transform the result of a
	 * CompletableFuture when it arrives. Executed in the same thread where the
	 * supplyAsync() task is executed
	 */
	public static void thenApply() {
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Raghu";
		});

		// Attach a callback to the Future using thenApply()
		CompletableFuture<String> greetingFuture = whatsYourNameFuture.thenApply(name -> {
			return "Hello " + name;
		}).thenApply(greeting -> {
			return greeting + ", Welcome to the CalliCoder Blog";
		});

		// Block and get the result of the future.
		try {
			String value = greetingFuture.get();
			System.out.println(value);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/*
	 * If you don’t want to return anything from your callback function and just
	 * want to run some piece of code after the completion of the Future, then you
	 * can use thenAccept() and thenRun() methods. These methods are consumers and
	 * are often used as the last callback in the callback chain
	 */
	public static void thenAccept() {
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Raghu";
		});

		// Attach a callback to the Future using thenApply()
		CompletableFuture<Void> greetingFuture = whatsYourNameFuture.thenApply(name -> {
			return "Hello " + name;
		}).thenAccept(s -> System.out.println("Computation returned: " + s));

		// Block and get the result of the future.
		try {
			greetingFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/*
	 * While thenAccept() has access to the result of the CompletableFuture on which
	 * it is attached, thenRun() doesn’t even have access to the Future’s result. It
	 * takes a Runnable and returns CompletableFuture<Void>
	 */
	public static void thenRun() {
		// Create a CompletableFuture
		CompletableFuture<String> whatsYourNameFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return "Raghu";
		});

		// Attach a callback to the Future using thenApply()
		CompletableFuture<Void> greetingFuture = whatsYourNameFuture.thenApply(name -> {
			return "Hello " + name;
		}).thenAccept(s -> System.out.println("Computation returned: " + s))
				.thenRun(() -> System.out.println("Computation finished."));

		// Block and get the result of the future.
		try {
			greetingFuture.get();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public static void thenApplyAsync() {
		Executor executor = Executors.newFixedThreadPool(2);
		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
			System.out.println("Runnig in " + Thread.currentThread().getName());
			return "Some result";
		}).thenApplyAsync(result -> {
			// Executed in a thread obtained from the executor
			System.out.println("Runnig in " + Thread.currentThread().getName());
			return result + " Processed Result";
		}, executor);

		try {
			String value = future.get();
			System.out.println(value);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	// combiningFuturesInOrder
	public static void thenCompose() {

		CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello")
				.thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

		try {
			String value = future.get();
			System.out.println(value);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	// combiningFuturesIndependently
	public static void thenCombine() {

		System.out.println("Retrieving weight.");
		CompletableFuture<Double> weightInKgFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return 65.0;
		});

		System.out.println("Retrieving height.");
		CompletableFuture<Double> heightInCmFuture = CompletableFuture.supplyAsync(() -> {
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				throw new IllegalStateException(e);
			}
			return 177.8;
		});

		System.out.println("Calculating BMI.");
		CompletableFuture<Double> combinedFuture = weightInKgFuture.thenCombine(heightInCmFuture,
				(weightInKg, heightInCm) -> {
					Double heightInMeter = heightInCm / 100;
					return weightInKg / (heightInMeter * heightInMeter);
				});

		try {
			System.out.println("Your BMI is - " + combinedFuture.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}

	}

	// when you want to do something with two Futures‘ results, but don’t need to
	// pass any resulting value down a Future chain
	public static void thenAcceptBoth() {
		CompletableFuture future = CompletableFuture.supplyAsync(() -> "Hello")
				.thenAcceptBoth(CompletableFuture.supplyAsync(() -> " World"), (s1, s2) -> System.out.println(s1 + s2));

		try {
			System.out.println(future.get());
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/*
	 * allows to wait for completion of all of the Futures provided as a var-arg.
	 * The limitation of this method is that it does not return the combined results
	 * of all Futures. Instead you have to manually get results from Futures
	 */

	public static void allOf() {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

		CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

		try {
			System.out.println(combinedFuture.get());

			// get combined results
			String combined = Stream.of(future1, future2, future3).map(CompletableFuture::join)
					.collect(Collectors.joining(" "));

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	/*
	 * allows to wait for completion of all of the Futures provided as a var-arg.
	 * The limitation of this method is that it does not return the combined results
	 * of all Futures. Instead you have to manually get results from Futures
	 */

	public static void anyOf() {
		CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
		CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
		CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

		CompletableFuture<Object> combinedFuture = CompletableFuture.anyOf(future1, future2, future3);

		try {
			System.out.println(combinedFuture.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	public static void handleException1() {
		String name = null;
		 
		CompletableFuture<String> completableFuture  = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
			return "Some result";
		}).thenApply(result -> {
			return "processed result";
		}).thenApply(result -> {
			return "result after further processing";
		});
		
		/* If an error occurs in the original supplyAsync() task, then none of the thenApply() callbacks will be called
		 *  and future will be resolved with the exception occurred. 
		 * If an error occurs in first thenApply() callback then 2nd and 3rd callbacks won’t be called and the 
		 * future will be resolved with the exception occurred, and so on
		 */
		
		try {
			System.out.println(completableFuture.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/* The exceptionally() callback gives you a chance to recover from errors generated from the original Future
	. You can log the exception here and return a default value.*/
	public static void handleException2() {
		String name = null;
		 
		CompletableFuture<String> completableFuture  = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
			return "Some result";
		}).exceptionally(ex -> {
		    System.out.println("Oops! We have an exception - " + ex.getMessage());
		    return "Unknown!";
		}).thenApply(result -> {
			return "processed result";
		}).thenApply(result -> {
			return "result after further processing";
		});
		
		try {
			System.out.println(completableFuture.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
	/* 
	 * The API also provides a more generic method - handle() to recover from exceptions. It is called whether or not an exception occurs
	 */
	public static void handleException3() {
		String name = null;
		 
		CompletableFuture<String> completableFuture  = CompletableFuture.supplyAsync(() -> {
			if (name == null) {
		          throw new RuntimeException("Computation error!");
		      }
			return "Some result";
		}).handle((res, ex) -> {
		    if(ex != null) {
		        System.out.println("Oops! We have an exception - " + ex.getMessage());
		        return "Unknown!";
		    }
		    return res;
		}).thenApply(result -> {
			return "processed result";
		}).thenApply(result -> {
			return "result after further processing";
		});
		
		/* If an exception occurs, then the res argument will be null, otherwise, the ex argument will be null.
		 */
		
		try {
			System.out.println(completableFuture.get());

		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}
	
}
