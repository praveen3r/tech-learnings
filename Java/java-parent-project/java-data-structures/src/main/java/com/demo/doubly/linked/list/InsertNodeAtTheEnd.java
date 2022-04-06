package com.demo.doubly.linked.list;

import com.demo.doubly.linked.list.DoublyLinkedList.ListNode;

public class InsertNodeAtTheEnd {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		DoublyLinkedList.ListNode<Integer> newNode = new DoublyLinkedList.ListNode<>(1);
		insertNodeAtTheEnd(newNode);

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

	static void insertNodeAtTheEnd(ListNode<Integer> newNode) {
		DoublyLinkedList.ListNode<Integer> tail = doublyLinkedList.getTail();
		
		DoublyLinkedList.ListNode<Integer> prev = tail.getPrev();
		prev.setNext(newNode);
		newNode.setPrev(prev);
		
		doublyLinkedList.setTail(newNode);
		
		System.out.println(doublyLinkedList);
	}
}
