package com.demo.doubly.linked.list;

public class DoublyLinkedList<T> {
	
	private ListNode<T> head;
	private ListNode<T> tail;
	
	static class ListNode<T> {
		private T data;
		private ListNode<T> prev;
		private ListNode<T> next;
		
		public ListNode(T data) {
			this.data = data;
			this.next = null;
		}
		
		public T getData() {
			return data;
		}
		
		public ListNode<T> getPrev() {
			return prev;
		}

		public void setPrev(ListNode<T> prev) {
			this.prev = prev;
		}

		public ListNode<T> getNext() {
			return next;
		}

		public void setNext(ListNode<T> next) {
			this.next = next;
		}
		
		
	}

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}
	
	public ListNode<T> getTail() {
		return tail;
	}

	public void setTail(ListNode<T> tail) {
		this.tail = tail;
	}

	
	public boolean isEmpty() {
		return head == null;
	}
	
	

}
