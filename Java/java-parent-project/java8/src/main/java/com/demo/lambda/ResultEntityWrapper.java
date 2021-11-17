package com.demo.lambda;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ResultEntityWrapper {

	static <T, E extends Exception> Consumer<ResultEntity> wrapExceptions(Consumer<ResultEntity> consumer) {
		  
	    return resultEntity -> {
	        try {
	            consumer.accept(resultEntity);
	            resultEntity.setSuccess(true);
	        } catch (Exception ex) {
	        	resultEntity.setSuccess(false);
	        	System.err.println("Exception occured : " + ex.getMessage());
	        }
	    };
	}
	
	static <T, E extends Exception> Supplier<ResultEntity> wrapExceptions1(Processor supplier) {
		  
	    return () -> {
	    	ResultEntity resultEntity = new ResultEntity();
	        try {
	        	supplier.run();
	        	resultEntity.setSuccess(true);
	        } catch (Exception ex) {
	        	resultEntity.setSuccess(false);
	        	System.err.println("Exception occured : " + ex.getMessage());
	        }
	        return resultEntity;
	    };
	}
}
