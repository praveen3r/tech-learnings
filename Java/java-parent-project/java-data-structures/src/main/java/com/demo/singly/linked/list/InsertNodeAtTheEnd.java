package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeAtTheEnd {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode newNode = new SinglyLinkedList.ListNode(1);
		insertNodeAtTheEnd(newNode);

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode headNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode secondNode = new SinglyLinkedList.ListNode(12);
		SinglyLinkedList.ListNode thirdNode = new SinglyLinkedList.ListNode(14);
		SinglyLinkedList.ListNode fourthNode = new SinglyLinkedList.ListNode(16);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		
	}

	static void insertNodeAtTheEnd(ListNode newNode) {
		SinglyLinkedList.ListNode current = singlyLinkedList.getHead();
		
		while(current.getNext() !=null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		
		System.out.println(singlyLinkedList);
	}
}
