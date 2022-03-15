package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeAtTheEnd {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode<Integer> newNode = new SinglyLinkedList.ListNode<>(1);
		insertNodeAtTheEnd(newNode);

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

	static void insertNodeAtTheEnd(ListNode<Integer> newNode) {
		SinglyLinkedList.ListNode<Integer> current = singlyLinkedList.getHead();
		
		while(current.getNext() !=null) {
			current = current.getNext();
		}
		current.setNext(newNode);
		
		System.out.println(singlyLinkedList);
	}
}
