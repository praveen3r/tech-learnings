package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class DeleteNodeWithTheGivenKey {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeWithGivenKey(14);

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

	static void deleteNodeWithGivenKey(int key) {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		
		SinglyLinkedList.ListNode prev = head;
		SinglyLinkedList.ListNode current = head;
		
		while(current != null && key != current.getData()) {
			prev = current;
			current = current.getNext();
		}
		if(current == null) return;
		
		prev.setNext(current.getNext());
      
		
		System.out.println(singlyLinkedList);
	}
}
