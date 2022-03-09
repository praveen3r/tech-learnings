package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class FindMiddleNode {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		findMiddleNode();

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

	static SinglyLinkedList.ListNode findMiddleNode() {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode slowItr = head;
		SinglyLinkedList.ListNode fastItr = head;
		while(fastItr!=null && fastItr.getNext()!=null) {
			slowItr = slowItr.getNext();
			fastItr = fastItr.getNext().getNext();
		}
		return slowItr;
	}
}
