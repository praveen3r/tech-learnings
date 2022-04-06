package com.demo.queue;

public class CustomQueue<T> {

	private ListNode<T> front;
	private ListNode<T> rear;
	private int length;
	
	private class ListNode<T> {
		private T data;
		private ListNode<T> next;
		
		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
		
		public ListNode<T> getNext() {
			return next;
		}

		public void setNext(ListNode<T> next) {
			this.next = next;
		}
		
		
	}

	public ListNode<T> getFront() {
		return front;
	}

	public void setFront(ListNode<T> front) {
		this.front = front;
	}

	public ListNode<T> getRear() {
		return rear;
	}

	public void setRear(ListNode<T> rear) {
		this.rear = rear;
	}
	
	public void enQueue(T data) {
		ListNode<T> node = new ListNode<>(data);
		if(isEmpty()) {
			front = node;
		}else {
			rear.next = node;
		}
		rear = node;
		this.length++;
	}
	
	public T deQueue() throws Exception{
		if(isEmpty()) {
			throw new Exception("No element exists");
		}
		ListNode<T> node = front;
		front = front.next;
		if(front == null) {
			rear = null;
		}
		this.length--;
		return node.data;
	}
	
	public boolean isEmpty() {
		return this.length==0;
	}

}
