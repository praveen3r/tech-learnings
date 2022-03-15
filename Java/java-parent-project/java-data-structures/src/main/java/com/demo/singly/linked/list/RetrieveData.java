package com.demo.singly.linked.list;

public class RetrieveData {
	
	static SinglyLinkedList<Integer> singlyLinkedList = new SinglyLinkedList<>();

	public static void main(String[] args) {
		populateData();
		displayData();

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
		
		System.out.println(singlyLinkedList);
	}

	static void displayData() {
		SinglyLinkedList.ListNode<Integer> current = singlyLinkedList.getHead();
		while(current != null) {
			System.out.println("value is "+ current.getData());
			current = current.getNext();
		}
	}
}
