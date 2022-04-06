package com.demo.circular.linked.list;

public class DeleteNodeAtTheBeginning {
	
	static CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();

	public static void main(String[] args) {
		populateData();
		
		deleteNodeAtTheEnd();

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

	static void deleteNodeAtTheEnd() {
		
		  CircularLinkedList.ListNode<Integer> tail = circularLinkedList.getTail();
		  CircularLinkedList.ListNode<Integer> firstNode = tail.getNext();
		  tail.setNext(firstNode.getNext());
		  firstNode.setNext(null);
		 
		
		System.out.println(circularLinkedList);
	}
}
