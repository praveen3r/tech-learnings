package com.demo.concurrency.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class TrainQueue {

	ReentrantLock lock = new ReentrantLock();
	Queue<Integer> list = new LinkedList<Integer>();
	Condition removed = lock.newCondition();
	Condition added = lock.newCondition();
	private static final int CAPACITY = 1;

	public void getDistanceCovered() throws Exception{
		lock.lock();
		if (list.size() == 0) {
			System.out.println(Thread.currentThread().getName() + " - List is empty. Lets wait");
			try {
				added.await();
				System.out.println(Thread.currentThread().getName() + " - List has some value now");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Integer result = list.poll();
		System.out.println(Thread.currentThread().getName() + " - Got value from list - " + result);
 
		removed.signalAll();
		lock.unlock();
	}

	public void setDistanceCovered(int distanceCovered) throws Exception{
		lock.lock();
		if (list.size() == CAPACITY) {
			System.out.println(Thread.currentThread().getName() + " - List is full. Lets wait");
			 
			try {
				removed.await();
				System.out.println(Thread.currentThread().getName() + " - List is not full now");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		list.add(distanceCovered);
		System.out.println(Thread.currentThread().getName() + " - Added value to list - " + distanceCovered);	
		added.signalAll();
		lock.unlock();
		
	}
	
	
}
