package com.demo.graphs;

import javax.annotation.processing.Generated;

public class UndirectedGraphDto {

	private int[] connectedComp;
	
	private int count;

	public int[] getConnectedComp() {
		return connectedComp;
	}

	public void setConnectedComp(int[] connectedComp) {
		this.connectedComp = connectedComp;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
	
}
