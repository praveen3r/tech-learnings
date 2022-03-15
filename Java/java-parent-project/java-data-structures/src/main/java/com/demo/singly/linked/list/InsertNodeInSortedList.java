package com.demo.singly.linked.list;

import com.demo.singly.linked.list.SinglyLinkedList.ListNode;

public class InsertNodeInSortedList {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		SinglyLinkedList.ListNode<Integer> newNode = new SinglyLinkedList.ListNode<>(13);
		insertNode(newNode);

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

	static void insertNode(ListNode<Integer> newNode) {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		
		SinglyLinkedList.ListNode<Integer> prev = head;
		SinglyLinkedList.ListNode<Integer> current = head;
		
		while(current != null && newNode.getData() > current.getData()) {
			prev = current;
			current = current.getNext();
		}
		
		prev.setNext(newNode);
		newNode.setNext(current);
		
		
		System.out.println(singlyLinkedList);
	}
}
