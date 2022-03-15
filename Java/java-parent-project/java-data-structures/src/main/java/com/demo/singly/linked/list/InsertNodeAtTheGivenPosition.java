package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeAtTheGivenPosition {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode<Integer> newNode = new SinglyLinkedList.ListNode<>(1);
		insertNodeAtTheGivenPosition(newNode, 3);

	}
	
	static void populateData() {

		
		SinglyLinkedList.ListNode<Integer> headNode = new SinglyLinkedList.ListNode<>(10);
		SinglyLinkedList.ListNode<Integer> secondNode = new SinglyLinkedList.ListNode<>(12);
		SinglyLinkedList.ListNode<Integer> thirdNode = new SinglyLinkedList.ListNode<>(16);
		SinglyLinkedList.ListNode<Integer> fourthNode = new SinglyLinkedList.ListNode<>(16);
		
		singlyLinkedList.setHead(headNode);
		
		headNode.setNext(secondNode);
		secondNode.setNext(thirdNode);
		thirdNode.setNext(fourthNode);
		
	}

	static void insertNodeAtTheGivenPosition(ListNode<Integer> newNode,int position) {
		SinglyLinkedList.ListNode<Integer> previous = singlyLinkedList.getHead();
		
		int count = 1;
		
		while(count < position -1) {
			count++;
			previous = previous.getNext();
		}
		
		SinglyLinkedList.ListNode<Integer> next = previous.getNext();
		previous.setNext(newNode);
		newNode.setNext(next);
		
		System.out.println(singlyLinkedList);
	}
}
