package com.demo.singly.linked.list;

public class FindMiddleNode {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		findMiddleNode();

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

	static SinglyLinkedList.ListNode<Integer> findMiddleNode() {
		SinglyLinkedList.ListNode<Integer> head = singlyLinkedList.getHead();
		SinglyLinkedList.ListNode<Integer> slowItr = head;
		SinglyLinkedList.ListNode<Integer> fastItr = head;
		while(fastItr!=null && fastItr.getNext()!=null) {
			slowItr = slowItr.getNext();
			fastItr = fastItr.getNext().getNext();
		}
		return slowItr;
	}
}
