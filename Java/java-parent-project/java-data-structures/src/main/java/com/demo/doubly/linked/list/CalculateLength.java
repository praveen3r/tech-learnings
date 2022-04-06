package com.demo.doubly.linked.list;

public class CalculateLength {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		calculateLength();

	}
	
	static void populateData() {

		
		DoublyLinkedList.ListNode<Integer> headNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> secondNode = new DoublyLinkedList.ListNode<>(12);
		DoublyLinkedList.ListNode<Integer> thirdNode = new DoublyLinkedList.ListNode<>(16);
		DoublyLinkedList.ListNode<Integer> tailNode = new DoublyLinkedList.ListNode<>(18);
		
		doublyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		
		secondNode.setPrev(headNode);
		secondNode.setNext(thirdNode);
		
		thirdNode.setPrev(secondNode);
		thirdNode.setNext(tailNode);
		
		tailNode.setPrev(thirdNode);
		doublyLinkedList.setTail(tailNode);
		
		System.out.println(doublyLinkedList);
	}

	static void calculateLength() {
		DoublyLinkedList.ListNode<Integer> current = doublyLinkedList.getHead();
		int count = 0;
		while(current != null) {
			current = current.getNext();
			count++;
		}
		System.out.println("count is "+count);
	}
}
