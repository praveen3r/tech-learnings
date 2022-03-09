package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class DeleteNodeAtTheLast {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtTheBeginning();

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

	static void deleteNodeAtTheBeginning() {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode previous = head;
		SinglyLinkedList.ListNode current = head;
		while(current.getNext() != null) {
			previous = current;
			current = current.getNext();
		}
		System.out.println(previous);
		previous.setNext(null);
      
		
		System.out.println(singlyLinkedList);
	}
}
