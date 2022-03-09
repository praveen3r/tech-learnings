package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class DetectStartOfLoop {
	
	static SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

	public static void main(String[] args) {
		populateData();
		
		detectLoop();

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode headNode = new SinglyLinkedList.ListNode(10);
		SinglyLinkedList.ListNode secondNode = new SinglyLinkedList.ListNode(12);
		SinglyLinkedList.ListNode thirdNode = new SinglyLinkedList.ListNode(14);
		SinglyLinkedList.ListNode fourthNode = new SinglyLinkedList.ListNode(16);
		SinglyLinkedList.ListNode fifthNode = new SinglyLinkedList.ListNode(18);
		SinglyLinkedList.ListNode sixthNode = new SinglyLinkedList.ListNode(20);
		SinglyLinkedList.ListNode seventhNode = new SinglyLinkedList.ListNode(22);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(fifthNode);
		fifthNode.setNext(sixthNode);
		sixthNode.setNext(seventhNode);
		seventhNode.setNext(fourthNode);
		
	}

	static void detectLoop() {
		SinglyLinkedList.ListNode head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode slowPtr = head;
		SinglyLinkedList.ListNode fastPtr = head;
		while(fastPtr!=null && fastPtr.getNext()!=null) {
			slowPtr = slowPtr.getNext();
			fastPtr = fastPtr.getNext().getNext();
			if(slowPtr == fastPtr) {
				getStartOfLoop(head, slowPtr);
				return;
			}
		}
		System.out.println("end of method");
	}
	
	static void getStartOfLoop(SinglyLinkedList.ListNode head, SinglyLinkedList.ListNode slowPtr) {
		SinglyLinkedList.ListNode temp = head;
		while(temp != slowPtr) {
			temp = temp.getNext();
			slowPtr = slowPtr.getNext();
		}
		System.out.println("start of loop is "+temp);
	}
}
