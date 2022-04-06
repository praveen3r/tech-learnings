package com.demo.binary.heap;

public class DeleteMaxPriorityQueue {

	public static void main(String[] args) {
		MaxPriorityQueue mpq = new MaxPriorityQueue(10);
		mpq.insert(9);
		mpq.insert(3);
		mpq.insert(5);
		mpq.insert(2);
		mpq.insert(1);
		mpq.insert(4);
		mpq.insert(6);
		
		mpq.display();
		
		mpq.deleteMax();
		
		mpq.display();
	}
	
	
	
	

}
