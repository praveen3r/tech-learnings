package com.demo.concurrency.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Increment {

	//fairness constructor
	private Lock lock = new ReentrantLock();
	  private int count = 0;

	  public int inc(){
		try {
			 //trylock will return true if lock is available. Based on this you can write logic if lock is available or not
			//boolean isLockAvailable = lock.tryLock();
		    lock.lock();
		    for(int i = 0; i< 100; i ++) {
		    	count++;
		    }
		}finally {
			lock.unlock();
		}
	    System.out.println(count);
	    return count;
	  }
	  
	  public void incrementByFirstThread() {
		  inc();
	  }
	  
	  public void incrementBySecondThread() {
		  inc();
	  }
}
