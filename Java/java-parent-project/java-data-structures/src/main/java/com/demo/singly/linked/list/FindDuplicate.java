package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class FindDuplicate {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		findDuplicate();

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode headNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode secondNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode thirdNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode fourthNode = new SinglyLinkedList.ListNode(11);
		SinglyLinkedList.ListNode fifthNode = new SinglyLinkedList.ListNode(12);
		SinglyLinkedList.ListNode sixthNode = new SinglyLinkedList.ListNode(12);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(fifthNode);
		fifthNode.setNext(sixthNode);
		
	}

	static void findDuplicate() {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode current = head;
		while(current != null && current.getNext()!=null) {
			if(current.getData() == current.getNext().getData()) {
				current.setNext(current.getNext().getNext());
			}else {
			current = current.getNext();
			}
		}
		System.out.println(singlyLinkedList);
	}
}
