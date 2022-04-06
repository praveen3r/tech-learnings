package com.demo.doubly.linked.list;

public class RemoveDuplicate {

	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();

		findDuplicate();

	}

	static void populateData() {

		DoublyLinkedList.ListNode<Integer> headNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> secondNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> thirdNode = new DoublyLinkedList.ListNode<>(10);
		DoublyLinkedList.ListNode<Integer> fourthNode = new DoublyLinkedList.ListNode<>(11);
		DoublyLinkedList.ListNode<Integer> fifthNode = new DoublyLinkedList.ListNode<>(12);
		DoublyLinkedList.ListNode<Integer> sixthNode = new DoublyLinkedList.ListNode<>(12);

		doublyLinkedList.setHead(headNode);

		headNode.setNext(secondNode);

		secondNode.setPrev(headNode);
		secondNode.setNext(thirdNode);

		thirdNode.setNext(fourthNode);
		thirdNode.setPrev(secondNode);

		fourthNode.setNext(fifthNode);
		fourthNode.setPrev(thirdNode);

		fifthNode.setNext(sixthNode);
		fifthNode.setPrev(fourthNode);

	}

	static void findDuplicate() {
		DoublyLinkedList.ListNode<Integer> head = doublyLinkedList.getHead();
		DoublyLinkedList.ListNode<Integer> current = head;
		while (current != null && current.getNext() != null) {
			if (current.getData() == current.getNext().getData()) {
				DoublyLinkedList.ListNode<Integer> next = current.getNext().getNext();
				current.setNext(next);
				if (next != null)
					next.setPrev(current);
			} else {
				current = current.getNext();
			}
		}
		doublyLinkedList.setTail(current);
		System.out.println(doublyLinkedList);
	}
}
