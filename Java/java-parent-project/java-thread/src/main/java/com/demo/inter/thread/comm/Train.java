package com.demo.inter.thread.comm;

public class Train {

	int distanceCovered;

	public int getDistanceCovered() {
		System.out.println("getDistanceCovered->"+distanceCovered);
		return distanceCovered;
	}

	public void setDistanceCovered(int distanceCovered) {
		System.out.println("setDistanceCovered->"+distanceCovered);
		this.distanceCovered = distanceCovered;
	}
	
	
}
