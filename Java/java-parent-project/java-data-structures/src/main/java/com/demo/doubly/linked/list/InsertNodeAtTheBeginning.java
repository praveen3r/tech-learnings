package com.demo.doubly.linked.list;

import com.demo.doubly.linked.list.DoublyLinkedList.ListNode;

public class InsertNodeAtTheBeginning {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		DoublyLinkedList.ListNode<Integer> newNode = new DoublyLinkedList.ListNode<>(1);
		insertNodeAtTheBeginning(newNode);

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

	static void insertNodeAtTheBeginning(ListNode<Integer> newNode) {
		DoublyLinkedList.ListNode<Integer> head = doublyLinkedList.getHead();
		newNode.setNext(head);
		head.setPrev(newNode);
		doublyLinkedList.setHead(newNode);
		
		System.out.println(doublyLinkedList);
	}
}
