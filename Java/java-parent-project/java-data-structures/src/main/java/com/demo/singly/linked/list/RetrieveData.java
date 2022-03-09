package com.demo.singly.linked.list;

public class RetrieveData {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		displayData();

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
		
		System.out.println(singlyLinkedList);
	}

	static void displayData() {
		SinglyLinkedList.ListNode current = singlyLinkedList.getHead();
		while(current != null) {
			System.out.println("value is "+ current.getData());
			current = current.getNext();
		}
	}
}
