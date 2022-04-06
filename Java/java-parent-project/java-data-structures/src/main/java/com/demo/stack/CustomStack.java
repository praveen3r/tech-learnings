package com.demo.stack;

public class CustomStack<T> {
	
	private ListNode<T> top;
	private int length;
	
	private class ListNode<T> {
		private T data;
		private ListNode<T> next;
		
		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
		
		public T getData() {
			return data;
		}

		public ListNode<T> getNext() {
			return next;
		}

		public void setNext(ListNode<T> next) {
			this.next = next;
		}
		
		
	}

	public void push(T data) {
		ListNode<T> node = new ListNode<>(data);
		node.next = top;
		top = node;
		this.length++;
	}
	
	public T peek() {
		return top.data;
	}
	
	public T pop() {
		ListNode<T> topNode = top;
		top = topNode.next;
		this.length--;
		return topNode.data;
	}
	
	public boolean isEmpty() {
		return this.length==0;
	}
	

}
