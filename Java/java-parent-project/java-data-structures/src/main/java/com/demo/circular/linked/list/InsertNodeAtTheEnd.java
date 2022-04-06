package com.demo.circular.linked.list;

import com.demo.circular.linked.list.CircularLinkedList.ListNode;

public class InsertNodeAtTheEnd {
	
	static CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		CircularLinkedList.ListNode<Integer> newNode = new CircularLinkedList.ListNode<>(1);
		insertNodeAtTheEnd(newNode);

	}
	
	static void populateData() {

		
		CircularLinkedList.ListNode<Integer> firstNode = new CircularLinkedList.ListNode<>(10);
		CircularLinkedList.ListNode<Integer> secondNode = new CircularLinkedList.ListNode<>(12);
		CircularLinkedList.ListNode<Integer> thirdNode = new CircularLinkedList.ListNode<>(16);
		CircularLinkedList.ListNode<Integer> fourthNode = new CircularLinkedList.ListNode<>(18);
		
		firstNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		fourthNode.setNext(firstNode);
		
		circularLinkedList.setTail(fourthNode);
		
	}

	static void insertNodeAtTheEnd(ListNode<Integer> newNode) {
		
		  CircularLinkedList.ListNode<Integer> tail = circularLinkedList.getTail();
		  newNode.setNext(tail.getNext());
		  tail.setNext(newNode);
		  circularLinkedList.setTail(newNode);
		
		System.out.println(circularLinkedList);
	}
}
