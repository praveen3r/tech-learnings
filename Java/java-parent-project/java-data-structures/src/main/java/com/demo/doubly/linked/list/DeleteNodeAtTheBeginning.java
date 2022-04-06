package com.demo.doubly.linked.list;

public class DeleteNodeAtTheBeginning {

	static DoublyLinkedList<Integer> doublyLinkedList = new DoublyLinkedList<>();

	public static void main(String[] args) {
		populateData();

		deleteNodeAtTheBeginning();

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

	static void deleteNodeAtTheBeginning() {
		DoublyLinkedList.ListNode<Integer> head = doublyLinkedList.getHead();

		head = head.getNext();
		head.setPrev(null);
		doublyLinkedList.setHead(head);
		

		System.out.println(doublyLinkedList);
	}
}
