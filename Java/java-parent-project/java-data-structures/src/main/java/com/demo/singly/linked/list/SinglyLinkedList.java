package com.demo.singly.linked.list;

public class SinglyLinkedList<T> {
	
	private ListNode<T> head;
	
	static class ListNode<T> {
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

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}
	
	

}
