package com.demo.doubly.linked.list;

public class DeleteNodeAtTheLast {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtTheLast();

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
		
	}

	static void deleteNodeAtTheLast() {
		DoublyLinkedList.ListNode<Integer> tail = doublyLinkedList.getTail();
		DoublyLinkedList.ListNode<Integer> previous = tail.getPrev();
		
		doublyLinkedList.setTail(previous);
		previous.setNext(null);
      
		
		System.out.println(doublyLinkedList);
	}
}
