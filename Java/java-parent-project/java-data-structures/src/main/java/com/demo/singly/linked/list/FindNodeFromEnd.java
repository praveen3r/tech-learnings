package com.demo.singly.linked.list;

public class FindNodeFromEnd {

	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		findNode(2);

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode headNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode secondNode = new SinglyLinkedList.ListNode(11);
		SinglyLinkedList.ListNode thirdNode = new SinglyLinkedList.ListNode(12);
		SinglyLinkedList.ListNode fourthNode = new SinglyLinkedList.ListNode(13);
		SinglyLinkedList.ListNode fifthNode = new SinglyLinkedList.ListNode(14);
		SinglyLinkedList.ListNode sixthNode = new SinglyLinkedList.ListNode(15);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(fifthNode);
		fifthNode.setNext(sixthNode);
		
	}

	static void findNode(int position) {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode headPtr = head;
		SinglyLinkedList.ListNode refPtr = head;
		int count = 0;
		while(count < position) {
			refPtr = refPtr.getNext();
			count++;
		}
		
		while(refPtr != null) {
			refPtr = refPtr.getNext();
			headPtr = headPtr.getNext();
		}
		
		System.out.println(headPtr);
		
	}

}
