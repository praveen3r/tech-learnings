package com.demo.singly.linked.list;

public class DetectStartOfLoop {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		detectLoop();

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode<Integer> headNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(12);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fifthNode = new SinglyLinkedList.ListNode<>(18);
		SinglyLinkedList.ListNode<Integer> sixthNode = new SinglyLinkedList.ListNode<>(20);
		SinglyLinkedList.ListNode<Integer> seventhNode = new SinglyLinkedList.ListNode<>(22);
		
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
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> slowPtr = head;
		SinglyLinkedList.ListNode<Integer> fastPtr = head;
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
	
	static void getStartOfLoop(SinglyLinkedList.ListNode<Integer> head, SinglyLinkedList.ListNode<Integer> slowPtr) {
		SinglyLinkedList.ListNode<Integer> temp = head;
		while(temp != slowPtr) {
			temp = temp.getNext();
			slowPtr = slowPtr.getNext();
		}
		System.out.println("start of loop is "+temp);
	}
}
