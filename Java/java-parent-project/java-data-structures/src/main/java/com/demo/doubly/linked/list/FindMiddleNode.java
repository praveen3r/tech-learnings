package com.demo.doubly.linked.list;

public class FindMiddleNode {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		findMiddleNode();

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

	static DoublyLinkedList.ListNode<Integer> findMiddleNode() {
		DoublyLinkedList.ListNode<Integer> head = doublyLinkedList.getHead();
		DoublyLinkedList.ListNode<Integer> slowItr = head;
		DoublyLinkedList.ListNode<Integer> fastItr = head;
		while(fastItr!=null && fastItr.getNext()!=null) {
			slowItr = slowItr.getNext();
			fastItr = fastItr.getNext().getNext();
		}
		return slowItr;
	}
}
