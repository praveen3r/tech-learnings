package com.demo.inter.thread.comm;

public class Train1 {

	int distanceCovered;
	boolean valueSet = false;

	public synchronized int getDistanceCovered() {
		while(!valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("getDistanceCovered->"+distanceCovered);
		valueSet = false;
		notify();
		return distanceCovered;
	}

	public synchronized void setDistanceCovered(int distanceCovered) {
		System.out.println("setDistanceCovered->"+distanceCovered + " by " + Thread.currentThread().getName());
		while(valueSet) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.distanceCovered = distanceCovered;
		valueSet = true;
		notify();
	}
	
	
}
