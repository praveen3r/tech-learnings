package com.demo.threadlocal;

import java.text.SimpleDateFormat;
import java.util.Random;

public class TestThreadLocal {

	public static void main(String[] args) throws Exception{
		MyRunnable obj = new MyRunnable();
        for(int i=0 ; i<10; i++){
            Thread t = new Thread(obj, ""+i);
            Thread.sleep(new Random().nextInt(1000));
            t.start();
        }

	}
	
	public static class MyRunnable implements Runnable {

		private static final ThreadLocal<SimpleDateFormat> formatter = new ThreadLocal<SimpleDateFormat>(){
	        @Override
	        protected SimpleDateFormat initialValue()
	        {
	            return new SimpleDateFormat("yyyyMMdd HHmm");
	        }
	    };

        @Override
        public void run() {
        	System.out.println("Thread Name= "+Thread.currentThread().getName()+" default Formatter = "+formatter.get().toPattern());
            try {
                Thread.sleep(new Random().nextInt(1000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //formatter pattern is changed here by thread, but it won't reflect to other threads
            formatter.set(new SimpleDateFormat());
            
            System.out.println("Thread Name= "+Thread.currentThread().getName()+" formatter = "+formatter.get().toPattern());
        }
    }

}
