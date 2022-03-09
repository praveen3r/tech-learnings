package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeAtTheGivenPosition {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode newNode = new SinglyLinkedList.ListNode(1);
		insertNodeAtTheGivenPosition(newNode, 3);

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

	static void insertNodeAtTheGivenPosition(ListNode newNode,int position) {
		SinglyLinkedList.ListNode previous = singlyLinkedList.getHead();
		
		int count = 1;
		
		while(count < position -1) {
			count++;
			previous = previous.getNext();
		}
		
		SinglyLinkedList.ListNode next = previous.getNext();
		previous.setNext(newNode);
		newNode.setNext(next);
		
		System.out.println(singlyLinkedList);
	}
}
