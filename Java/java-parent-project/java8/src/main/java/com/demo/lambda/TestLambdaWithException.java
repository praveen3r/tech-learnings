package com.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class TestLambdaWithException {

	public static void main(String[] args) {
		List<Integer> integers = Arrays.asList(3, 9, 7, 0, 10, 20);
		//process(integers, 0, (val1, val2) -> System.out.println(val1 / val2));
		//process(integers, 0, lambdaWrapper((val1, val2) -> System.out.println(val1 / val2)));
		
		/*
		 * Consumer<String> consume = ExceptionWrapper.wrapExceptions((val) -> {
		 * System.out.println("coming here"); System.out.println(1/0); });
		 * consume.accept("value");
		 */
		
		/*
		 * ResultEntity resultEntity = new ResultEntity(); Consumer<ResultEntity>
		 * consume = ResultEntityWrapper.wrapExceptions((val) -> {
		 * System.out.println("coming here"); //System.out.println(1/0); });
		 * 
		 * consume.accept(resultEntity); System.out.println(resultEntity.isSuccess());
		 */
		
			Supplier<ResultEntity> supplier = ResultEntityWrapper.wrapExceptions1(() -> {
			 System.out.println("coming here"); 
			// System.out.println(1/0); 
		});
		
			System.out.println(supplier.get().isSuccess());
	}
	
	public static void process(List<Integer> integers , int key, BiConsumer<Integer,Integer> biConsumer) {
		integers.forEach(value -> {
			biConsumer.accept(value, key);
		});
	}
	
	public static BiConsumer<Integer,Integer> lambdaWrapper(BiConsumer<Integer,Integer> consumer) {
	    return (val1, value2) -> {
	        try {
	            consumer.accept(val1, value2);
	        } catch (ArithmeticException e) {
	            System.err.println(
	              "Arithmetic Exception occured : " + e.getMessage());
	        }
	    };
	}
}
