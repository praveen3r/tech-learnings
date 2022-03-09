package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeInSortedList {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode newNode = new SinglyLinkedList.ListNode(13);
		insertNode(newNode);

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

	static void insertNode(ListNode newNode) {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		
		SinglyLinkedList.ListNode prev = head;
		SinglyLinkedList.ListNode current = head;
		
		while(current != null && newNode.getData() > current.getData()) {
			prev = current;
			current = current.getNext();
		}
		
		prev.setNext(newNode);
		newNode.setNext(current);
		
		
		System.out.println(singlyLinkedList);
	}
}
