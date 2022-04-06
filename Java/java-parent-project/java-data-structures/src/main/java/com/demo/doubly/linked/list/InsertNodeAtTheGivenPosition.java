package com.demo.doubly.linked.list;

import com.demo.doubly.linked.list.DoublyLinkedList.ListNode;

public class InsertNodeAtTheGivenPosition {
	
	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		DoublyLinkedList.ListNode<Integer> newNode = new DoublyLinkedList.ListNode<>(1);
		insertNodeAtTheGivenPosition(newNode, 3);

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

	static void insertNodeAtTheGivenPosition(ListNode<Integer> newNode,int position) {
		DoublyLinkedList.ListNode<Integer> current = doublyLinkedList.getHead();
		
		int count = 1;
		
		while(count < position-1) {
			count++;
			current = current.getNext();
		}
		
		DoublyLinkedList.ListNode<Integer> next = current.getNext();
		current.setNext(newNode);
		next.setPrev(newNode);
		newNode.setNext(next);
		newNode.setPrev(current);
		
		System.out.println(doublyLinkedList);
	}
}
