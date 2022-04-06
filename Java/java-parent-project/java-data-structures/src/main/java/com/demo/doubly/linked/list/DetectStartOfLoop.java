package com.demo.doubly.linked.list;

public class DetectStartOfLoop {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		getStartOfLoop();

	}
	
	static void populateData() {

		
		DoublyLinkedList.ListNode<Integer> headNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> secondNode = new DoublyLinkedList.ListNode<>(12);
		DoublyLinkedList.ListNode<Integer> thirdNode = new DoublyLinkedList.ListNode<>(16);
		DoublyLinkedList.ListNode<Integer> fourthNode = new DoublyLinkedList.ListNode<>(16);
		DoublyLinkedList.ListNode<Integer> fifthNode = new DoublyLinkedList.ListNode<>(18);
		DoublyLinkedList.ListNode<Integer> sixthNode = new DoublyLinkedList.ListNode<>(20);
		DoublyLinkedList.ListNode<Integer> seventhNode = new DoublyLinkedList.ListNode<>(22);
		
		doublyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		
		secondNode.setPrev(headNode);
		secondNode.setNext(thirdNode);
		
		thirdNode.setPrev(secondNode);
		thirdNode.setNext(fourthNode);
		
		fourthNode.setPrev(thirdNode);
		fourthNode.setNext(fifthNode);
		
		fifthNode.setPrev(fourthNode);
		fifthNode.setNext(sixthNode);
		
		sixthNode.setPrev(fifthNode);
		sixthNode.setNext(seventhNode);
		
		seventhNode.setPrev(sixthNode);
		seventhNode.setNext(fourthNode);
		
		
		doublyLinkedList.setTail(seventhNode);
		
	}

	static void getStartOfLoop() {
		DoublyLinkedList.ListNode<Integer> tail = doublyLinkedList.getTail();
		DoublyLinkedList.ListNode<Integer> startNode = null;
		if(tail.getNext()!=null) {
			startNode = tail.getNext();
		}
		System.out.println(startNode);
	}
}
